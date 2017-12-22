package com.assignment3.dao;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//
import com.assignment3.model.Question;

@Repository
@Transactional
public class QuestionDAO {
	@Autowired
  private SessionFactory sessionFactory;

  private Session getSession() {
      return sessionFactory.getCurrentSession();
  }

  public String addNumeric(Question numeric) {
	  System.out.println("Before saving");
      int numeric_id = (int)getSession().save(numeric);
	  System.out.println("After saving");
      if(numeric_id >= 1){
          return "Numeric Question is added!";
      }else{
          return "There was an error adding the Numeric Question!";
      }        
  }
}
