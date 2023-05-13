package br.com.amigoscode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amigoscode.models.Student;
import br.com.amigoscode.repositories.StudentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void insert(Student student) {
		studentRepository.insert(student);
	}

	public Student findByEmail(String email) {
		List<Student> students = studentRepository.findStudentByEmail(email);
		if (students.isEmpty()) {
			return null;
		}
		else {
			return students.get(0);
		}
	}

	public void deleteStudentByEmail(String email) {
		studentRepository.deleteStudentByEmail(email);
	}

	public void save(Student student) {
		studentRepository.save(student);
	}

}
