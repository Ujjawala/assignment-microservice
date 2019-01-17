package com.stackroute.service;

import com.stackroute.Exceptions.UserDuplicationException;
import com.stackroute.Exceptions.UserNullFieldException;
import com.stackroute.Exceptions.UserNotFoundException;
import com.stackroute.Exceptions.WrongPasswordException;
import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Primary
@Service
public class UserDBService implements UserService {
    @Autowired
    private UserRepository userRepository;
    public UserDBService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) throws UserDuplicationException, UserNullFieldException {

        if(user.getUserName()==null){
            throw new UserNullFieldException();
        }
        if(userRepository.findByUserName(user.getUserName())!=null){
            throw new UserDuplicationException();
        }
        User user1 = userRepository.save(user);
        return user1;
    }
    public User deleteUser(Integer id) throws UserNotFoundException {
        if(userRepository.findById(id).get()==null){
            throw new UserNotFoundException();
        }

        userRepository.deleteById(id);
        return null;
    }
    public User updatePassword(int id, String oldPassword,String newPassword) throws UserNotFoundException, WrongPasswordException {
        if(userRepository.findById(id).get()==null){
            throw new UserNotFoundException();
        }
        User m= userRepository.findById(id).get();
         if(m.getPassword().equals(oldPassword)){
        m.setPassword(newPassword);
        userRepository.save(m);
        return m;  }
         else{
             throw new WrongPasswordException();
         }
    }
    public List<User> getAllUsers() {
        List<User> userList = (List<User>) userRepository.findAll();
        return userList;
    }
    public User authenticate(User user) throws UserNotFoundException, UserNullFieldException {

        if(user.getName()==null||user.getPassword()==null){
            throw new UserNullFieldException();
        }
        if(userRepository.findByUserName(user.getUserName())!=null&&userRepository.findByUserName(user.getName()).getPassword().equals(user.getPassword())){
           return user;
        }
        else{
            throw new UserNotFoundException();
        }

    }
}
