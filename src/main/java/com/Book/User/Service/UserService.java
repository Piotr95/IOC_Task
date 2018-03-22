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
        System.out.println(user1.toString());
    }
    //CRUD 'U'
    public void updateUser(int id,String first_name,String last_name)
    {
        Object user = userRepository.findById((long) id);
        User updateUser=(User) user;
        updateUser.setFirstName(first_name);
        updateUser.setLastName(last_name);
        //works like update
        userRepository.save(updateUser);
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
