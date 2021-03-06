package edu.mum.waa.lab03.prob1.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mum.waa.lab03.prob1.entities.Book;

public class BookDao implements IBookDao {
	private static int idCount = 1;
	private Map<Integer, Book> books = new HashMap<Integer, Book>();

	public BookDao() {
		add(new Book("JSP", "ISBN","book1", 20.5));
		add(new Book("Spring MVC", "ISBN","book2", 30.5));
	}

	//@Override
	public List<Book> getAll() {
		return new ArrayList<Book>(books.values());
	}

	//@Override
	public void add(Book book) {
		book.setId(idCount);
		books.put(idCount, book);
		idCount++;
	}

	//@Override
	public Book get(int id) {
		Book result = books.get(id);

		if (result == null) {
			throw new NoSuchResourceException("Book", id);
		}

		return result;
	}

	//@Override
	public void update(int bookId, Book book) {
		books.put(bookId, book);
	}

	//@Override
	public void delete(int bookId) {
		Book removed = books.remove(bookId);
		if (removed == null) {
			throw new NoSuchResourceException("Book", bookId);
		}
	}

}
