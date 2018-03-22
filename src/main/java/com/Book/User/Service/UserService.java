package com.Book.User.Service;

import com.Book.User.Model.User;
import com.Book.User.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //CRUD 'C'
    public void createUser(User user) {
        userRepository.save(user);

    }

    //CRUD 'R'
    public void readUser(int id) {
        Object user = userRepository.findById((long) id);
        User user1=(User)user;
        System.out.println(user1);
    }
    //CRUD 'U'
    public void updateUser(int id,String first_name,String last_name)
    {
        User user = userRepository.findById((long) id).get();
        user.setFirstName(first_name);
        user.setLastName(last_name);
        //works like update
        userRepository.save(user);
    }
    //CRUD 'D'
    public void deleteUser(User user)
    {
        this.userRepository.delete(user);

    }
    public void countUsers()
    {
        userRepository.count();
    }

}
