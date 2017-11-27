package com.assignment3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assignment3.dao.UserDAO;
import com.assignment3.model.User;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
    private UserDAO userDao;

   
    @RequestMapping(value = "/signup" ,method = RequestMethod.POST )
    @ResponseBody
    public String create(@RequestBody User user) {
        String message = userDao.signupUser(user);
        return message;
    }
    
    
    @RequestMapping(value = "/signin",method = RequestMethod.POST )
    @ResponseBody
    public boolean signinUser(@RequestBody User user) {
    	boolean check = userDao.signinUser(user);
    	if(check==true)
    		return true;
    	else
    		return false;
    }
	
}
