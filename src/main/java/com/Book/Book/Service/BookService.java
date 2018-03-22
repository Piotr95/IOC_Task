package com.Book.Book.Service;

import com.Book.Book.Model.Book;
import com.Book.Book.Repository.BookRepository;
import com.google.common.collect.Lists;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.google.common.collect.Lists;
@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public void update(Book book)
    {
        bookRepository.save(book);
    }

    public Optional<Book> findById(Long bookId)
    {
        return bookRepository.findById(bookId);
    }

    public void add(Book book)
    {
        bookRepository.save(book);
    }

    public void remove(Book book)
    {
        bookRepository.delete(book);
    }

    public List<Book> getAll()
    {
        return Lists.newArrayList(bookRepository.findAll());
    }

    public List<Book> getBorrowedBooks()
    {
        return bookRepository.findBooksByBorrowed(Boolean.TRUE);
    }

    public List<Book> getAvaliableBooks()
    {
        return bookRepository.findBooksByBorrowedOrBorrowedIsNull(Boolean.FALSE);
    }
}
