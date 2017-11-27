package com.assignment3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assignment3.dao.QuestionDAO;
import com.assignment3.dao.McqDAO;
import com.assignment3.dao.QuizDAO;
import com.assignment3.model.Question;
import com.assignment3.dao.TruefalseDAO;
import com.assignment3.model.MCQ;
import com.assignment3.model.Quiz;
import com.assignment3.model.TrueFalse;

@Controller
@RequestMapping(value = "/questions")
public class QuestionController {
	@Autowired
	private McqDAO mcqDao;

	@Autowired
	private TruefalseDAO truefalseDao;

	@Autowired
	private QuestionDAO questionDao;

    @RequestMapping(value = "/addmcq" ,method = RequestMethod.POST )
    @ResponseBody
    public String addMCQ(@RequestBody MCQ mcq) {
			 System.out.println("Option A: "+mcq.getOptionA());
			 System.out.println("Option B: "+mcq.getOptionB());
			 System.out.println("Option C: "+mcq.getOptionC());
			 System.out.println("Option D: "+mcq.getOptionD()); 
			 System.out.println("Marks: "+mcq.getMarks());
			 System.out.println("Question: "+mcq.getQuestion());
			 
			 String message = mcqDao.addMcq(mcq);
        return message;
    }
    
    @RequestMapping(value = "/addtruefalse" ,method = RequestMethod.POST )
    @ResponseBody
    public String addTrueFalse(@RequestBody TrueFalse truefalse) {
        String message = truefalseDao.addtruefalse(truefalse);
        return message;
    }

	@RequestMapping(value = "/addnumeric" ,method = RequestMethod.POST )
    @ResponseBody
    public String addNumeric(@RequestBody Question question) {
		System.out.println(question.getQuiz());
        String message = questionDao.addNumeric(question);
        return message;
    }
}
