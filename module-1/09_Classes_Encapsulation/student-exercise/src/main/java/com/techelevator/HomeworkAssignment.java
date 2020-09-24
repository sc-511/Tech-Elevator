package com.techelevator;

public class HomeworkAssignment {
	
	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;
	
	
	public HomeworkAssignment(int possibleMarks, String submitterName){
		this.possibleMarks = possibleMarks;
		this.submitterName = submitterName;
	}
	
	public int getEarnedMarks() {
		
		return earnedMarks;
	}
	
	public void setEarnedMarks(int earnedMarks) {
		
		this.earnedMarks = earnedMarks;
	}
	
	public int getPossibleMarks() {
		
		return possibleMarks;
	}
	
	public String getSubmitterName() {
		
		return submitterName;
	}
	
	public String getLetterGrade() {
		
		if ( ((this.earnedMarks * 100) / this.possibleMarks) != 0) {
			
			if (((this.earnedMarks * 100) / this.possibleMarks)  >= 90) {
				return  "A";
			}
			
			else if (((this.earnedMarks * 100) / this.possibleMarks)  >= 80 && ((this.earnedMarks * 100) / this.possibleMarks)  <= 89 ) {
				
				return  "B";
			}
			
			else if (((this.earnedMarks * 100) / this.possibleMarks)  >= 70 && ((this.earnedMarks * 100) / this.possibleMarks)  <= 79 ) {
				
				return  "C";
			}
			
			else if (((this.earnedMarks * 100 ) / this.possibleMarks) >= 60 && ((this.earnedMarks  *100) / this.possibleMarks)  <= 69 ) {
				
				return "D";
			}
			else {
				
				return "F";
			}
			
			
		}
		return "F";
		
	}
	
	
	
}
