package com.assignment3.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment3.model.TrueFalse;

@Repository
@Transactional
public class TruefalseDAO {
	@Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public String addtruefalse(TrueFalse truefalse) {
    	truefalse.setOptions("True", "False");
        int truefalse_id = (int)getSession().save(truefalse);
        if(truefalse_id >= 1){
            return "True/False Question is added!";
        }else{
            return "There was an error adding the True/False Question!";
        }        
    }
}
