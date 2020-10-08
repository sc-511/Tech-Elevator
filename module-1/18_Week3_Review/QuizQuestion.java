package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestion {

	private String quizQuestion;
	private List<String> answers;
	private String correctAnswer;
	
	public QuizQuestion(String quizQuestion, String[] answers, String correctAnswer) {
		this.quizQuestion = quizQuestion;
		this.correctAnswer = correctAnswer;
		
		this.answers = new ArrayList<String>();
		for(String answer: answers) {
			this.answers.add(answer);
		}
	}


	public String getQuizQuestion() {
		return this.quizQuestion;
	}
	
	public List<String> getAnswers() {
		return answers;
	}
	
	public boolean isCorrectAnswer(String guess) {
		return guess.equals(this.correctAnswer);
	}

}
