package com.Book.User.Controller;

import com.Book.User.Model.User;
import com.Book.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class UserControler {
    @Autowired
    private UserService userService;
    
    public void addNewUser(User user)
    {
        userService.createUser(user);
    }
    public void readUser(int id)
    {
     userService.readUser(id);
    }
    public void update(int id,String first_name,String last_name )
    {
        userService.updateUser(id,first_name,last_name);
    }

    public void removeUser(User user)
    {
        userService.deleteUser(user);
    }
}
