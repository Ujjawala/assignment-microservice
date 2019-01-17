package com.stackroute.service;

import com.stackroute.Exceptions.UserDuplicationException;
import com.stackroute.Exceptions.UserNotFoundException;
import com.stackroute.Exceptions.UserNullFieldException;
import com.stackroute.Exceptions.WrongPasswordException;
import com.stackroute.domain.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user) throws UserDuplicationException, UserNullFieldException;

    public List<User> getAllUsers();

    public User deleteUser(Integer id) throws UserNotFoundException;

    public User updatePassword(int id, String oldPassword,String newPassword) throws UserNotFoundException, WrongPasswordException;


}