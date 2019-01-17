package com.stackroute.controller;

import com.stackroute.Exceptions.UserDuplicationException;
import com.stackroute.Exceptions.UserNotFoundException;
import com.stackroute.Exceptions.UserNullFieldException;
import com.stackroute.domain.User;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(
//
//)
//Use an interface that can be implemented by UserService and UserAWSService
@RequestMapping("api/v1/")
public class UserController {
    @Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "usersignup", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        User user1 =null;
        try{
            user1 = userService.saveUser(user);
        }
         catch (UserNullFieldException tk){
            return new ResponseEntity<String>("User have userName value null", HttpStatus.OK);
        }
        catch (UserDuplicationException tk){
            return new ResponseEntity<String>("User is already present", HttpStatus.OK);
        }
        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listOfUsers() {
        List<User> allUsers = userService.getAllUsers();

        return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
    }

    @RequestMapping(value = "deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable(value="id")int id) {
        User user =null;
        try{
          userService.deleteUser(id);
            }
        catch (UserNotFoundException tk){
            return new ResponseEntity<String>("User is not available", HttpStatus.OK);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "userupdate/{id}/{oldPassword}/{newPassword}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable(value="id")int id,@PathVariable(value="oldPassword")String oldPassword,@PathVariable(value="newPassword")String newPassword) {
        User user1;
        try{
        user1 = userService.updatePassword(id,oldPassword,newPassword);  }
        catch(Exception e){
            return new ResponseEntity<String>("User is not available", HttpStatus.OK);
        }

        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }




}
