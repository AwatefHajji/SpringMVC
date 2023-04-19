package com.awatef.codingdojo.booksmvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.awatef.codingdojo.booksmvc.repositories.BookRepository;
import com.awatef.codingdojo.booksmvc.models.BookModel;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<BookModel> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public BookModel createBook(BookModel b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public BookModel findBook(Long id) {
        Optional<BookModel> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // Delete Book 
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	// Edit Book
	public BookModel updateBook(BookModel book) {
        return bookRepository.save(book);
		
	}
	

}
