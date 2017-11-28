package com.assignment3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment3.model.Quiz;
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
        int user_id = (int)getSession().save(user);
        if(user_id >= 1){
        	System.out.println(user_id);
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
    	System.out.println(list);
    	if(list.isEmpty())
    		return false;
    	else
    		return true;
    }
    
    public String addStudentMarks(User student) {
    	String query = "UPDATE users SET marks = '"+ student.getMarks() +"' WHERE username = '"+student.getUsername()+ "'";
    	SQLQuery sqlQuery = getSession().createSQLQuery(query);
    	sqlQuery.executeUpdate();
    	return "You have scored "+student.getMarks()+"!";       
    }
}
