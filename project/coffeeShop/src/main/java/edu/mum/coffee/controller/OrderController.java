package edu.mum.coffee.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.coffee.domain.CartItem;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	PersonService personService;
	
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

		Optional<Orderline> orderLine = order.getOrderLines().stream().filter(orderline -> orderline.getProduct().getId() == productId).findFirst();
		if (orderLine.isPresent()) {
			Orderline orderline = orderLine.get();
			orderline.setQuantity(orderline.getQuantity() + 1);
		} else {
			Product product = productService.findById(productId);
			Orderline orderline  = new Orderline();
			orderline.setProduct(product);
			orderline.setQuantity(1);
			order.addOrderLine(orderline);
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
	
}
