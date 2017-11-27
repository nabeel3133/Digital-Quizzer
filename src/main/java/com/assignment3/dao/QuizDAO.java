package com.assignment3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment3.model.Quiz;

@Repository
@Transactional
public class QuizDAO {
	private UserDAO userDao;
	@Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public int createQuiz(Quiz quiz) {
        Long isSuccess = (Long)getSession().save(quiz);
        if(isSuccess >= 1){
            return (int) quiz.getId();
        }else{
            return 0;
        }        
    }
    
    public List<Quiz> retrieveAllQuizzes()
    {
    	Criteria criteria = getSession().createCriteria(Quiz.class);
    	return (List<Quiz>)criteria.list();
    }
}
