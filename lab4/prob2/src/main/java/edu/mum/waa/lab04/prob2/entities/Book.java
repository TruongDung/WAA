package edu.mum.waa.lab04.prob2.entities;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

public class Book {
	private int id;
	private String title;
	
	@Pattern(regexp="\\d{3}-\\d{10}")
	private String ISBN;
	private String author;
	private double price;
	
	@Past
	private Date publishedDate;

	/**
	 * @return the publishedDate
	 */
	public Date getPublishedDate() {
		return publishedDate;
	}

	/**
	 * @param publishedDate the publishedDate to set
	 */
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Book() {
		super();
	}

	public Book(String title, String iSBN, String author, double price, Date publishedDate) {
		super();
		this.title = title;
		ISBN = iSBN;
		this.author = author;
		this.price = price;
		this.publishedDate = publishedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
