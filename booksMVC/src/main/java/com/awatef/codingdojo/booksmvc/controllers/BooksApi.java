package com.awatef.codingdojo.booksmvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.awatef.codingdojo.booksmvc.models.BookModel;
import com.awatef.codingdojo.booksmvc.services.BookService;

@RestController
public class BooksApi {
	// adding the book services as a dependency
    private final BookService bookService;
    //================dependency injection to make bookService available in our controller
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    //=========CRUD==============
    // Read All=======================
    @RequestMapping("/api/books")
    public List<BookModel> index() {
        return bookService.allBooks();
    }
    // Create ==================
    //=============Action route to create a book=================
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public BookModel create(
    		@RequestParam(value="title") String title,
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) 
    {
    //create an instance of BookModel with the value of the form 
    	BookModel book = new BookModel(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    // Read One By Id===========================
    
    @RequestMapping("/api/books/{id}")
    public BookModel show(@PathVariable("id") Long id) {
    	BookModel book = bookService.findBook(id);
        return book;
    }
    
    // Edit Book===========================
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public BookModel update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
    	
        BookModel book = new BookModel(title, desc, lang, numOfPages);
        book.setId(id);
        book = bookService.updateBook(book);
        return book;
        
    }
    
    // Delete Book ========================
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
