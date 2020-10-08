package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {
		
		List<QuizQuestion> questions = new ArrayList<>();

		File quizFile = new File("test_quiz.txt");
		try (Scanner quizFileStreamer = new Scanner(quizFile)) {


			while(quizFileStreamer.hasNextLine()) {
				String line = quizFileStreamer.nextLine();
				String[] pieces = line.split("\\|");

				String question = pieces[0];
				String[] allAnswers = new String[4];
				String correctAnswer = null;
				
				for(int i = 1; i < pieces.length; i++) {
					String piece = pieces[i];
					if(piece.endsWith("*")) {
						piece = piece.substring(0, piece.length() - 1);
						correctAnswer = piece;
					}
					
					allAnswers[i - 1] = piece;
				}
				
				QuizQuestion q = new QuizQuestion(question, allAnswers, correctAnswer);
				questions.add(q);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find file!");
			System.exit(1);
		}
		
		
		int questionNum = 0;
		int correctAnswers = 0;
	
		Scanner keyboard = new Scanner(System.in);
		
		for(QuizQuestion q : questions) {
			questionNum++;
			System.out.println(q.getQuizQuestion());
			
			for(String answer : q.getAnswers()) {
				System.out.println("\t" + answer);
			}
			
			String guess = keyboard.nextLine();						
			if(q.isCorrectAnswer(guess)) {
				correctAnswers++;
			}
			
		}
		
		System.out.println("===========");		
		System.out.println("GAME OVER, MAN! GAME OVER!");
		System.out.println("===========");

		System.out.println("You got " + correctAnswers + " out of " + questionNum + " correct!");
		System.out.println((((double)correctAnswers / questionNum) * 100) + "%");
		

	}

}
