package br.com.amigoscode.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.amigoscode.models.Student;

@Repository
public interface StudentRepository extends MongoRepository <Student, String> {
	
	List<Student> findStudentByEmail(String email);
	
	void deleteStudentByEmail(String email);
	
}
