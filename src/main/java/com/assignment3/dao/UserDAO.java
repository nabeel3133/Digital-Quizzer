package com.assignment3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment3.model.User;

@Repository
@Transactional
public class UserDAO {
	private UserDAO userDao;
	@Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public String signupUser(User user) {
        Long isSuccess = (Long)getSession().save(user);
        if(isSuccess >= 1){
            return "Thank you for signing up "+user.getUsername();
        }else{
            return "There was an error signing you up!";
        }        
    }
    
    public boolean signinUser(User user)
    {
    	Criteria c=sessionFactory.getCurrentSession().createCriteria(User.class);   
    	c.add(Restrictions.like("username",user.getUsername()));  
    	c.add(Restrictions.like("password",user.getPassword())); 
    	List list=c.list();
    	//User signedin=(User)c.uniqueResult();
    	//System.out.println(signedin);
    	System.out.println(list);
    	if(list.isEmpty())
    		return false;
    	else
    		return true;
    }
}
