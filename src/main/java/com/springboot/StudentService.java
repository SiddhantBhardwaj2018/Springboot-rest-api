package com.springboot;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	HashMap<String, Double> siddTenth = new HashMap<>(Map.of("English",92.0,"Math",99.0,"Physics",97.0,"Chemistry",95.0,"Computer Science",97.0,"Hindi",94.0,"Sanskrit",95.0));
	HashMap<String, Double> siddTwelfth = new HashMap<>(Map.of("English",93.0,"Math",99.0,"Physics",94.0,"Chemistry",98.0,"Computer Science",100.0,"Hindi",97.0,"Sanskrit",95.0));
	HashMap<String, Double> vibhorTenth = new HashMap<>(Map.of("English",91.0,"Math",95.0,"Commerce",100.0,"Economics",98.0,"Accounts",98.0,"Hindi",92.0,"Sanskrit",96.0));
	HashMap<String, Double> vibhorTwelfth = new HashMap<>(Map.of("English",98.0,"Math",97.0,"Commerce",100.0,"Economics",98.0,"Accounts",93.0,"Hindi",94.0,"Sanskrit",100.0));
	HashMap<String, Double> abhishekTenth = new HashMap<>(Map.of("English",93.0,"Psychology",97.0,"History",93.0,"Sociology",89.0,"Political Science",100.0,"Hindi",97.0,"Sanskrit",100.0));
	HashMap<String, Double> abhishekTwelfth = new HashMap<>(Map.of("English",96.0,"Psychology",96.0,"History",92.0,"Sociology",90.0,"Political Science",100.0,"Hindi",93.0,"Sanskrit",99.0));
	Student[] students = {
			new Student("siddhant","Siddhant Bhardwaj", Arrays.asList("English","Math","Physics","Chemistry","Hindi","Computer Science","Sanskrit"),"Science" , siddTenth,siddTwelfth),
			new Student("vibhor","Vibhor Mehta", Arrays.asList("English","Math","Commerce","Economics","Accounts","Hindi","Sanskrit"),"Commerce",vibhorTenth,vibhorTwelfth),
			new Student("abhishek","Abhishek Agarwal",Arrays.asList("English","Hindi","Sanskrit","Psychology","Sociology","Political Science","History"),"Arts",abhishekTenth,abhishekTwelfth)
	};
	private List<Student> studentList = Arrays.asList(students);
	
	public List<Student> getAllStudents(){
		return studentList;
	}
	
	public Student getStudentByName(String name) {
		return studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get();
	}
	
	public String getStudentStream(String name) {
		return studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().getStream();
	}
	
	public String[] getStudentSubjects(String name) {
		return studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().getSubjects().toArray(new String[0]);
	}
	
	public List<Student> getAllStudentByStream(String stream) {
		return studentList.stream().filter(i -> i.getStream().equals(stream)).toList();
	}
	
	public double getStudentPercentage(int grade, String name) {
		if(grade == 10) {
			return studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().getTenthMarks();
		}else{
			return studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().getTwelfthMarks();
		}
	}
	
	public HashMap<String,Double> getStudentGradeSubjectScores(int grade,String name){
		if(grade == 10) {
			return studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().getTenthSubjectMarks();
		}else {
			return studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().getTwelfthSubjectMarks();
		}
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	public void rename(String name,String firstName,String lastName) {
		studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().setName(firstName, lastName);
	}
	
	public void changeSubjects(String name, List<String> newSubjects) {
		studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().setSubjects(newSubjects);
	}
	
	public void changeStream(String name, String stream) {
		studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().setStream(stream);
	}
	
	public void changeTenthSubjectMarks(String name,HashMap<String, Double> hashMap) {
		studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().setTenthSubjectMarks(hashMap);
	}
	
	public void changeTwelfthSubjectMarks(String name,HashMap<String, Double> hashMap) {
		studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().setTwelfthSubjectMarks(hashMap);
	}
	
	public void changeSpecificSubject(String name,int grade, String subjectname, double subjectscore) {
		studentList.stream().filter(i -> i.getId().equals(name)).findFirst().get().setSpecificSubject(grade, subjectname, subjectscore);
	}

	public void delete(String studentName) {
		studentList = studentList.stream().filter(i -> !i.getId().equals(studentName)).collect(Collectors.toList());
	}
}
