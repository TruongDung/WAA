package edu.mum.coffee.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.coffee.domain.CartItem;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PersonService personService;
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "index";
	}

	@GetMapping({"/login"})
	public String securePage() {
		return "login";
	}
	
	@GetMapping("/register") 
	public String register(Model model) {
		model.addAttribute("person", new Person());
		return "register";
	}
	
	@PostMapping("/register")
	public String signup(@ModelAttribute Person person) {
		personService.register(person);
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	/// add product with id to cart
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addProductToCart(@RequestBody Long productId, HttpSession session) {
		Object currentOrder = session.getAttribute("order");
		if (currentOrder == null) {
			currentOrder = new Order();
			session.setAttribute("order", currentOrder);
		}
		Order order = (Order) currentOrder;

		Optional<Orderline> orderDetail = order.getOrderLines().stream().filter(item -> item.getProduct().getId() == productId).findFirst();
		if (orderDetail.isPresent()) {
			Orderline orderline = orderDetail.get();
			orderline.setQuantity(orderline.getQuantity() + 1);
		} else {
			Product product = productService.findById(productId);
			Orderline orderDetail1  = new Orderline();
			orderDetail1.setProduct(product);
			orderDetail1.setQuantity(1);
			order.addOrderLine(orderDetail1);
		}
	}
	
	@GetMapping("/shoppingCart")
	public String shoppingCart(Model model, HttpSession session) {
		Object currentOrder = session.getAttribute("order");
		double total = 0;
		if (currentOrder != null) {
			 Order order = (Order) currentOrder;
			model.addAttribute("order", order);
			for (Orderline orderline : order.getOrderLines()) {
				total += orderline.getSubtotal();
			}
		}
		model.addAttribute("total", total);
		return "shoppingCart";
	}
	
	@RequestMapping(value = "/shopping-cart/{productId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteItemInShoppingCart(@PathVariable("productId") Long productId, HttpSession session) {
		Object orderObj = session.getAttribute("order");
		if (orderObj == null) {
			orderObj = new Order();
			session.setAttribute("order", orderObj);
		}
		Order order = (Order) orderObj;

		Optional<Orderline> orderLine = order.getOrderLines().stream().filter(orderline
				-> orderline.getProduct().getId() == productId).findFirst();
		if (orderLine.isPresent()) {
			order.removeOrderLine(orderLine.get());
		}
	}
	
	@RequestMapping(value = "/shopping-cart", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void updateItemInShoppingCart(@RequestBody CartItem item, HttpSession session) {
		Object orderObj = session.getAttribute("order");
		if (orderObj == null) {
			orderObj = new Order();
			session.setAttribute("order", orderObj);
		}
		Order order = (Order) orderObj;

		Optional<Orderline> orderLine = order.getOrderLines().stream().filter(orderline
				-> orderline.getProduct().getId() == item.getProductId()).findFirst();
		if (orderLine.isPresent()) {
			if (item.getQuantity() <= 0) {
				order.removeOrderLine(orderLine.get());
			} else {
				orderLine.get().setQuantity(item.getQuantity());
			}
		}
	}
}


