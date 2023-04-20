package com.awatef.codingdojo.booksmvc.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.awatef.codingdojo.booksmvc.models.BookModel;
import com.awatef.codingdojo.booksmvc.services.BookService;

@Controller
public class BookController {
	 //==dependency injection to make bookService available in our controller
	@Autowired 
	BookService bookService;
	
	//===display route to show book 
	@GetMapping("/books/{bookId}")
	public String showBook(@PathVariable("bookId") Long bookId, Model model) {
		System.out.println(bookId);
		BookModel book = bookService.findBook(bookId);
		System.out.println(book.getTitle());
		model.addAttribute("book",book);
		return "show.jsp";
	}
    //=== display route to show all books
	@GetMapping("/books")
	public String books(Model model) {
		ArrayList<BookModel> allBooks = (ArrayList<BookModel>) bookService.allBooks();
		model.addAttribute("allBooks", allBooks);
		return "index.jsp";
	}
}
