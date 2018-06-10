package edu.mum.coffee.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.coffee.custom.UserDetailsCustom;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
@RequestMapping(path="/order")
public class OrderController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	PersonService personService;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/list")
	public String orderList(Model model, HttpSession session, Authentication authentication) {
		UserDetailsCustom currentUser = (UserDetailsCustom) authentication.getPrincipal();
		if(currentUser.getAuthorities().stream().anyMatch(ga->ga.getAuthority().equals("ROLE_ADMIN"))) {
			model.addAttribute("orders", orderService.findAll());
		} else {
			model.addAttribute("orders", orderService.findByPerson(personService.findById(currentUser.getId())));
		}
		return "orderList";
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
	

	
	@PostMapping("/placeOrder")
	public String placeOrder(HttpSession session, Authentication authentication) {
	   Order currentOrder = (Order)	session.getAttribute("order");
	   if(currentOrder != null) {
		   currentOrder.setOrderDate(new Date());
		   UserDetailsCustom currentUser = (UserDetailsCustom) authentication.getPrincipal();
		   currentOrder.setPerson(personService.findById(currentUser.getId()));
		   orderService.save(currentOrder);
		   session.removeAttribute("order");
	   }
		return "redirect:/";
	}
}
