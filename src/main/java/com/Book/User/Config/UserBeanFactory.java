package com.Book.User.Config;

import com.Book.User.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanFactory
{
    @Bean
    public UserServiceFactory userServiceFactory() {
        return new UserServiceFactory();
    }

    @Bean
    public UserService userService() throws Exception {
        return userServiceFactory().getObject();
    }
}
