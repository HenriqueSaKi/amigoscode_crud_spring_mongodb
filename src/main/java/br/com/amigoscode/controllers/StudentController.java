package br.com.amigoscode.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigoscode.models.Student;
import br.com.amigoscode.services.StudentService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<Object> fetchAllStudents() {
		List<Student> listStudent = studentService.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(listStudent);
	}
	
	@PostMapping
	public ResponseEntity<Object> registerStudent(@RequestBody Student newStudent) {
		try {
			String email = newStudent.getEmail();
			Student student = null;
			student = studentService.findByEmail(email);
			if (student == null) {
				newStudent.setCreated(LocalDateTime.now());
				studentService.insert(newStudent);
				return ResponseEntity.status(HttpStatus.OK).body("Student inserted successfully.");
			}
			else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Student already exists.");
			}
		}
		catch (ErrorResponseException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> updateStudent(@RequestBody Student studentUpdate) {
		try {
			Student student = studentService.findByEmail(studentUpdate.getEmail());
			if (student != null) {
				String studentId = student.getId();
				BeanUtils.copyProperties(studentUpdate, student);
				student.setId(studentId);
				student.setCreated(LocalDateTime.now());
				studentService.save(student);
				return ResponseEntity.status(HttpStatus.OK).body("Student updated successfully.");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
			}
		}
		catch (ErrorResponseException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Object> deleteStudent(@RequestBody Map<String, String> email) {
		try {
			Student student = null;
			student = studentService.findByEmail(email.get("email"));
			if (student != null) {
				String firstName = student.getFirstName();
				String lastName = student.getLastName();
				studentService.deleteStudentByEmail(email.get("email"));
				return ResponseEntity.status(HttpStatus.OK).body("Student " + firstName + " " + lastName + " deleted successfully.");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
			}
		}
		catch (ErrorResponseException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
