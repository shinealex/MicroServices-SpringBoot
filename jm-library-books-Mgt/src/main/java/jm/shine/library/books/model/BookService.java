package jm.shine.library.books.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	private List<Book> books = new ArrayList<>(Arrays.asList(
			new Book("1", "Bible", "Religious"),
			new Book("2", "Harry Porter", "Fiction"),
			new Book("3", "Long Walk to Freedom", "AutoBiography")
			));
	
	public List<Book> getAllBooks() {
		return books;
	}
	
	public List<Book> getBooks(List<String> booksIds) {

		return books.stream()
				.distinct()
				.filter(b -> booksIds.contains(b.getBookId()))
				.collect(Collectors.toList());
	}
	
	public Book getBook(String id) {
		return books.stream().filter(t -> t.getBookId().equals(id)).findFirst().get();
	}
	
	public void addBook(Book Book) {
		books.add(Book);
	}

	public void removeBook(int id) {
		books.removeIf(t -> t.getBookId().equals(id));
	}
}
