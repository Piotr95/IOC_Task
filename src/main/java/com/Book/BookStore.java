package com.Book;

import com.Book.Book.Controller.BookController;
import com.Book.Book.Model.Book;
import com.Book.User.Controller.UserControler;
import com.Book.User.Model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@SpringBootApplication
public class BookStore  implements CommandLineRunner
{
    private UserControler userControler;
    private BookController bookController;

    public BookStore(UserControler userControler, BookController bookController) {
        this.userControler = userControler;
        this.bookController = bookController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStore.class, args);
    }


    public void run(String... args) throws Exception {
        Logger logger = LoggerFactory.getLogger(BookStore.class);


        User user= new User("Jan","Kowalski");
        User user1= new User("Anna","Nowak");
        User user2= new User("Mamed","Hlidow");
        userControler.addNewUser(user);
        userControler.addNewUser(user1);
        userControler.addNewUser(user2);
        userControler.readUser(1);
        userControler.update(1,"lola","obo");
        userControler.readUser(1);
        Book book = new Book("Lama","Sam loong");
        Book book1 = new Book("Cobra","Jane Smith");


        bookController.addNewBook(book);

        bookController.addNewBook(book1);

        bookController.borrowBook(book, user1, 10);

        List<Book> allBooks = bookController.getAllBooks();
       for (Book b: allBooks)
       {
           System.out.println(b);
           System.out.println();
       }

        System.out.println("Avaliable books: " + bookController.getNumberOfAvaliableBooks());
        System.out.println();
        System.out.println("Borrowed books: " + bookController.getNumberOfBorrowedBooks());
        System.out.println();
        System.out.println("Fine 1: " + bookController.calculateFine(book.getId()));
        System.out.println();
        bookController.borrowBook(book1, user2, -10);
        System.out.println();
        System.out.println("Fine 2: " + bookController.calculateFine(book1.getId()));

    }
}
