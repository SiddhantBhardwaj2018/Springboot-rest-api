package com.springboot;

import java.util.HashMap;
import java.util.List;

public class Student {
	private String id;
	private String name;
	private List<String> subjects;
	private String stream;
	private double tenthMarks;
	private HashMap<String,Double> tenthSubjectMarks;
	private double twelfthMarks;
	private HashMap<String,Double> twelfthSubjectMarks;
	
	public Student(String id , String name, List<String> subjects, String stream,HashMap<String,Double> tenthSubjectMarks,  HashMap<String, Double> twelfthSubjectMarks) {
		this.id = id;
		this.name = name;
		this.subjects = subjects;
		this.stream = stream;
		this.tenthMarks = 0;
		this.tenthSubjectMarks = tenthSubjectMarks;
		this.twelfthMarks = 0;
		this.twelfthSubjectMarks = twelfthSubjectMarks;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<String> getSubjects() {
		return this.subjects;
	}
	
	public String getStream() {
		return this.stream;
	}
	
	public double getTenthMarks() {
		this.updateTenthScore();
		return this.tenthMarks;
	}
	
	public HashMap<String,Double> getTenthSubjectMarks(){
		return this.tenthSubjectMarks;
	}
	
	public double getTwelfthMarks() {
		this.updateTwelfthScore();
		return this.twelfthMarks;
	}
	
	public HashMap<String, Double> getTwelfthSubjectMarks(){
		return this.twelfthSubjectMarks;
	}
	
	public void setName(String firstName, String lastName) {
		this.name = firstName + " " + lastName;
	}
	
	public void setSubjects(List<String> newSubjects) {
		this.subjects = newSubjects;
	}
	
	public void setStream(String newStream) {
		this.stream = newStream;
	}
	
	public void updateTenthScore() {
		double total = 0;
		for(double score: this.tenthSubjectMarks.values()) {
			total += score;
		}
		total /= (double)this.tenthSubjectMarks.size();
		this.tenthMarks =  Math.round(total * 100.0) / 100.0;
	}
	
	public void updateTwelfthScore() {
		double total = 0;
		for(double score: this.twelfthSubjectMarks.values()) {
			total += score;
		}
		total /= (double)this.twelfthSubjectMarks.size();
		this.twelfthMarks = Math.round(total * 100.0) / 100.0;
	}
	
	public void setTenthSubjectMarks(HashMap<String, Double> hashMap) {
		this.tenthSubjectMarks = hashMap;
		this.updateTenthScore();
	}
	
	public void setTwelfthSubjectMarks(HashMap<String, Double> hashMap) {
		this.twelfthSubjectMarks = hashMap;
		this.updateTwelfthScore();
	}
	
	public void setSpecificSubject(int grade, String subjectName, double subjectScore) {
		if(grade == 10) {
			this.tenthSubjectMarks.put(subjectName,subjectScore);
			this.updateTenthScore();
		}else if(grade == 12) {
			this.twelfthSubjectMarks.put(subjectName, subjectScore);
			this.updateTwelfthScore();
		}else {
			System.out.println("Incorrect grade entered");
		}
	}
}