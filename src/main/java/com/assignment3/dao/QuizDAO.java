package com.assignment3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment3.model.MCQ;
import com.assignment3.model.Question;
import com.assignment3.model.Quiz;
import com.assignment3.model.TrueFalse;

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
        int quiz_id = (int) getSession().save(quiz);
        if(quiz_id >= 1){
            return quiz_id;
        }else{
            return 0;
        }        
    }

    public String addMarks(Quiz quiz) {
    	
    	String query = "UPDATE quizzes SET marks = '"+ quiz.getMarks() +"' WHERE id = '"+quiz.getId()+ "'";
    	SQLQuery sqlQuery = getSession().createSQLQuery(query);
    	sqlQuery.executeUpdate();
    	return "Quiz Created Successfully and Total Marks are Added";       
    }
    
    
    public List<Quiz> retrieveAllQuizzes()
    {
    	Criteria criteria = getSession().createCriteria(Quiz.class);
    	return (List<Quiz>)criteria.list();
    }
    
    public List<Question> retrieveQuizQuestions(int id)
    {
    	Criteria criteria = getSession().createCriteria(Quiz.class);
    	criteria.add(Restrictions.like("id",id));  
    	Quiz quiz = (Quiz) criteria.uniqueResult();
    	criteria = getSession().createCriteria(Question.class);
    	criteria.add(Restrictions.like("quiz",quiz));  
    	List<Question> quiz_questions = (List<Question>)criteria.list();
    		return quiz_questions;
    }
}
