package com.epam.libraryManager.logic;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.epam.libraryManager.dao.BookDAO;
import com.epam.libraryManager.dao.DaoException;
import com.epam.libraryManager.entity.Book;

public class ShowAllBooksLogic {

	private final static Logger LOG = Logger.getLogger(ShowAllBooksLogic.class);
	public static ArrayList<Book> getAllBooks() throws LogicException {
		BookDAO bookDAO = new BookDAO();
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			books = bookDAO.getAllBooks();
			//if(books != null) {
				//return books;
			//}
			return books;
		} catch (DaoException e) {
			throw new LogicException("bla bla", e);
		}
	}

}
