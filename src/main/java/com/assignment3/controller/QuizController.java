package com.assignment3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assignment3.dao.QuizDAO;
import com.assignment3.model.Question;
import com.assignment3.model.Quiz;

@Controller
@RequestMapping(value = "/quizzes")
public class QuizController {
	@Autowired
    private QuizDAO quizDao;

	
	//Make Quiz Request Received here 
    @RequestMapping(value = "/makequiz" ,method = RequestMethod.POST )
    @ResponseBody
    public int create(@RequestBody Quiz quiz) {
    	System.out.println("Entering create quiz");
        int quiz_id = quizDao.createQuiz(quiz);
        if(quiz_id>0)
        	return quiz_id;
        else
        	return 0;
    }
    
	//Add Quiz Marks to Database Request Received here
    @RequestMapping(value = "/addmarks" ,method = RequestMethod.POST )
    @ResponseBody
    public String addQuizMarks(@RequestBody Quiz quiz) {
        String marks_message = quizDao.addMarks(quiz);
        return marks_message;
    }
    
    
	//Get All Quizzes request received here
    @ResponseBody
    @RequestMapping(value = "/allquizzes")
    public List<Quiz> getAllQuizzes()
    {
    	List<Quiz> quizList = quizDao.retrieveAllQuizzes();
    	return quizList;
    }
    
    
    //Get specific quiz questions request received here
    @ResponseBody
    @RequestMapping(value = "allquizzes/{id}", method = RequestMethod.GET)
	public List<Question> getQuizQuestions(@PathVariable("id") int id) 
    {
		List<Question> quiz_questions = quizDao.retrieveQuizQuestions(id);
		return quiz_questions;
    }
}
