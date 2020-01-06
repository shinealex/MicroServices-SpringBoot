package jm.shine.library.activities.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import jm.shine.library.activities.model.ActivityService;
import jm.shine.library.activities.model.Book;
import jm.shine.library.activities.model.Member;
import jm.shine.library.activities.resilience4j.ResilientBookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/activites")
public class ActivityController {
	
	@Autowired
	private WebClient.Builder webclinetBuilder;
	
	@Autowired
	ActivityService activityService;
	
	@Autowired
	ResilientBookService resilientBookService;
	

    private static final Logger logger = LoggerFactory.getLogger(ActivityController.class);
	
	
	@RequestMapping("/issueBook/{memberId}/{bookId}")
	public Book issueBook(@PathVariable String memberId, @PathVariable String bookId){
		
		activityService.issueBook(memberId, bookId);
		logger.info("Issue Book is invoked and Webclient call the getBook Service!");
		
		return  resilientBookService.getBook(bookId);

	}
	

	@RequestMapping("/getListOfBooks/{memberId}")
	public List<Book> getListOfBooks(@PathVariable String memberId){
		
		List<String> listOfBooks = activityService.getListOfBooks(memberId);
		logger.info("getListOfBooks is invoked with Memember : " + memberId);
		
		return  webclinetBuilder.build()
				  .get()
				  .uri("http://LIBRARY-BOOK/books/getBooks/" + listOfBooks)
				  .retrieve()
				  .bodyToFlux(Book.class)
				  .collectList()
				  .block();
				  
	}
	
	@RequestMapping("/getAllMembers")
	public List<Member> getAllMembers(){
		
		return  webclinetBuilder.build()
				  .get()
				  .uri("http://LIBRARY-MEMBERSHIP/membership/getAllMembers/")
				  .retrieve()
				  .bodyToFlux(Member.class)
				  .collectList()
				  .block();
				  
	}
		
	@RequestMapping("/returnBook/{memberId}/{bookId}")
	public Book returnBook(@PathVariable String memberId, @PathVariable String bookId){
		//TODO
		return null;
	}

}
