package com.springboot;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@RequestMapping("/students")
	public List<Student> getAllStudents(){
		return studentservice.getAllStudents();
	}
	
	@RequestMapping("/students/student/{studentName}")
	public Student getStudentName(@PathVariable String studentName) {
		return studentservice.getStudentByName(studentName);
	}
	
	@RequestMapping("/students/stream/{studentName}")
	public String getStudentStream(@PathVariable String studentName) {
		return studentservice.getStudentStream(studentName);
	}
	
	@RequestMapping("/students/subjects/{studentName}")
	public String[] getStudentSubjects(@PathVariable String studentName) {
		return studentservice.getStudentSubjects(studentName);
	}
	
	@RequestMapping("/students/getStudents/{stream}")
	public Student[] getAllStudentsByStream(@PathVariable String stream) {
		return studentservice.getAllStudentByStream(stream).toArray(new Student[0]);
	}
	
	@RequestMapping("/students/percentage/{grade}/{name}")
	public double getStudentPercentage(@PathVariable int grade, @PathVariable String name) {
		return studentservice.getStudentPercentage(grade, name);
	}
	
	@RequestMapping("/students/subjectmarks/{grade}/{name}")
	public HashMap<String, Double> getStudentSubjectScores(@PathVariable int grade, @PathVariable String name){
		return studentservice.getStudentGradeSubjectScores(grade,name);
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/addStudent")
	public void addStudent(@RequestBody Student student){
		studentservice.addStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/rename/{studentName}")
	public void renameStudent(@RequestBody HashMap<String, String> name, @PathVariable String studentName) {
		String firstName = name.get("firstName");
		String lastName = name.get("lastName");
		studentservice.rename(studentName, firstName, lastName);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/changeStream/{studentName}")
	public void changeStream(@RequestBody HashMap<String,String> stream, @PathVariable String studentName) {
		studentservice.changeStream(studentName, stream.get("stream"));
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/changeSubjects/{studentName}")
	public void changeSubjects(@RequestBody List<String> subjects, @PathVariable String studentName) {
		studentservice.changeSubjects(studentName, subjects);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/changeTenthMarks/{studentName}")
	public void changeTenthMarks(@RequestBody HashMap<String, Double> tenthMarks, @PathVariable String studentName) {
		studentservice.changeTenthSubjectMarks(studentName, tenthMarks);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/changeTwelfthMarks/{studentName}")
	public void changeTwelfthMarks(@RequestBody HashMap<String, Double> twelfth, @PathVariable String studentName) {
		studentservice.changeTwelfthSubjectMarks(studentName, twelfth);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/changeSubjectScore/{grade}/{studentName}")
	public void changeSubjectScore(@RequestBody HashMap<String, String> hashmap, @PathVariable int grade, @PathVariable String studentName) {
		studentservice.changeSpecificSubject(studentName, grade, hashmap.get("subject"), Double.parseDouble(hashmap.get("marks")));
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteStudent/{studentName}")
	public void deleteStudent(@PathVariable String studentName) {
		studentservice.delete(studentName);
	}
}
