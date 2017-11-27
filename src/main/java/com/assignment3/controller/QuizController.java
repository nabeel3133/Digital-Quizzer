package com.assignment3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assignment3.dao.QuizDAO;
import com.assignment3.model.Quiz;

@Controller
@RequestMapping(value = "/quizzes")
public class QuizController {
	@Autowired
    private QuizDAO quizDao;

   
    @RequestMapping(value = "/makequiz" ,method = RequestMethod.POST )
    @ResponseBody
    public int create(@RequestBody Quiz quiz) {
        int quiz_id = quizDao.createQuiz(quiz);
        if(quiz_id>0)
        	return quiz_id;
        else
        	return 0;
    }
    
    @ResponseBody
    @RequestMapping(value = "/allquizzes")
    public List<Quiz> getAllQuizzes()
    {
    	List<Quiz> quizList = quizDao.retrieveAllQuizzes();
    	return quizList;
    }
}
