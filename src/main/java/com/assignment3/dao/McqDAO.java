package com.assignment3.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment3.model.MCQ;

@Repository
@Transactional
public class McqDAO {
	@Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public String addMcq(MCQ mcq) {
		 System.out.println("Before Option A: "+mcq.getOptionA());
		 System.out.println("Before Option B: "+mcq.getOptionB());
		 System.out.println("Before Option C: "+mcq.getOptionC());
		 System.out.println("Before Option D: "+mcq.getOptionD());    
		 Long isSuccess = (Long)getSession().save(mcq);
		 System.out.println("After Option A: "+mcq.getOptionA());
		 System.out.println("After Option B: "+mcq.getOptionB());
		 System.out.println("After Option C: "+mcq.getOptionC());
		 System.out.println("After Option D: "+mcq.getOptionD());    
        if(isSuccess >= 1){
            return "MCQ Question is added!";
        }else{
            return "There was an error adding the MCQ!";
        }        
    }
}
