package jm.shine.library.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jm.shine.library.books.model.Book;
import jm.shine.library.books.model.BookService;

@RestController
@RequestMapping("/books")
public class LibraryController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/getAllbooks")
	public List<Book> getAllMembers() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping(value="/getBooks/{booksIds}")
	public List<Book> getBooks(@PathVariable List<String> booksIds) {
		return bookService.getBooks(booksIds);
	}

	@RequestMapping(value="/getBook/{id}")
	public Book getMember(@PathVariable String id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addBook")
	public void addMember(@RequestBody Book book) {
		bookService.addBook(book);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/remove/{id}")
	public void removeMember(@PathVariable int id) {
		bookService.removeBook(id);
	}

}
