package com.assignment3.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Questions")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)   
@DiscriminatorColumn(name="ques_type",discriminatorType=DiscriminatorType.STRING)   
@DiscriminatorValue(value="Numeric")
public class Question {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)		
		private long id;
		private String question;
		private int marks;
		private String correct;
		
	    @ManyToOne
	    @JoinColumn(name="quiz_id", nullable=false)
	    private Quiz quiz;

		public void setId(long ID)
		{
			this.id = ID;
		}
		
		
	    public void setQuestion(String str) {
	        this.question=str;
	    }
	    
	    public void setCorrectAnswer(String str) {
	        this.correct=str;
	    }
	    
	    public void setMarks(int str) {
	        this.marks=str;
	    }
	    
	    public void setQuiz(Quiz quiz)
	    {
	    	this.quiz = quiz;
	    }
	    
	    public Quiz getQuiz()
	    {
	    	return quiz;
	    }
	    
	    public String getQuestion(){
	        return question;
	    }
	    
	    public String getCorrectAnswer() {
	        return correct;
	    }
	    
	    public int getMarks() {
	        return marks;
	    }
	    
	    public long getId()
	    {
	    	return id;
	    }
}
