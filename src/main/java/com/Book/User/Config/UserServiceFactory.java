package com.Book.User.Config;

import com.Book.User.Repository.UserRepository;
import com.Book.User.Service.UserService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceFactory implements FactoryBean
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserService getObject() throws Exception {
        return new UserService(userRepository);
    }

    @Override
    public Class<?> getObjectType() {
        return UserService.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
