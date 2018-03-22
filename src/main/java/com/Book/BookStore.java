package com.Book;

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

    public BookStore(UserControler userControler) {
        this.userControler = userControler;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStore.class, args);
    }


    public void run(String... args) throws Exception {
        Logger logger = LoggerFactory.getLogger(BookStore.class);
         logger.error("ale ze mnie Dupa");


        User user= new User("Jan","Kowalski");
        User user1= new User("Anna","Nowak");
        User user2= new User("Mamed","Hlidow");
        userControler.addNewUser(user);
        userControler.addNewUser(user1);
        userControler.addNewUser(user2);
        userControler.readUser(1);

    }
}
