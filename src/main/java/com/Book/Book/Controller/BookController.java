package com.Book.Book.Controller;
import com.Book.Book.Model.Book;
import com.Book.Book.Service.BookService;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.Book.User.Model.User;
import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public Integer getNumberOfBorrowedBooks() {
        return bookService.getBorrowedBooks().size();
    }

    public Integer getNumberOfAvaliableBooks() {
        return bookService.getAvaliableBooks().size();
    }

    public void borrowBook(Book book, User user, int days) {
        if(book.isBorrowed()) {
           System.out.println("Is borrowed");
        }
        book.setBorrowed(Boolean.TRUE);
        book.setUser(user);
        book.setRetDate(Date.from(LocalDateTime.now().plusDays(days).atZone(ZoneId.systemDefault()).toInstant()));
        bookService.update(book);
    }

    public void returnBook(Book book) {
        book.setBorrowed(Boolean.FALSE);
        book.setUser(null);
        book.setRetDate(null);
        bookService.update(book);
    }

    public Double calculateFine(Long bookId) {
        Optional<Book> optionalBook = bookService.findById(bookId);
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            long between = DAYS.between(LocalDateTime.now(), LocalDateTime.ofInstant(book.getRetDate().toInstant(), ZoneId.systemDefault()));
            if(between < 0) {
                return -between*0.5; //pay for delay
            }
        }
            return 0.0;
    }

    public void addNewBook(Book book) {
        bookService.add(book);
    }

    public void removeBook(Book book) {
        bookService.remove(book);
    }

    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

}
