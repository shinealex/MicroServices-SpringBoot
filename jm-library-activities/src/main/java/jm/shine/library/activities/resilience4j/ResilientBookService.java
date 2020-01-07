package jm.shine.library.activities.resilience4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jm.shine.library.activities.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ResilientBookService {
	
	@Autowired
	private WebClient.Builder webclinetBuilder;
	
	@Autowired
	private RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(ResilientBookService.class);

	@CircuitBreaker(name="bookService", fallbackMethod="fallBackgetBook")
    @RateLimiter(name = "bookService", fallbackMethod = "fallBackRateLimitergetBook")
	public Book getBook(String bookId) {
		
	//
	/*	return  webclinetBuilder.build()
				  .get()
				  .uri("http://LIBRARY-BOOK/books/getBook/" + bookId)
				  .retrieve()
				  .bodyToMono(Book.class)
				  .block();*/
		
		return restTemplate.getForEntity("http://LIBRARY-BOOK/books/getBook/" + bookId, Book.class).getBody();
	}
	
	public Book fallBackgetBook(String bookId, Throwable error) {
		logger.error("Circute is OPEN and Error Occured on getBook : " + error);
		logger.info("Returned the default Book response ");
		return new Book("00", "DefaultBookName", "DefaultType");
	}
	
	public Book fallBackRateLimitergetBook(String bookId, Throwable error) {
		logger.error("Circute is OPEN and Error Occured on fallBackRateLimitergetBook : " + error);
		logger.info("Returned the default Book response ");
		return new Book("00", "DefaultBookName", "DefaultType");
	}
}
