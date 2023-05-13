package br.com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmigosCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmigosCodeApplication.class, args);
	}
	
	
//	@Bean
//	CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
//		return args -> {
//			String email = "satoshikisaki@hotmail.com";
//			Student student = new Student(
//				"Henrique",
//				"Kisaki",
//				email,
//				Gender.MALE,
//				new Address("Brazil", "São Paulo", "00000-000"),
//				List.of("Computer Science", "Maths"),
//				BigDecimal.TEN,
//				LocalDateTime.now()
//			);
//			
//			//usingMongoTemplateAndQuery (studentRepository, mongoTemplate, email, student);
//			studentRepository.findStudentByEmail(email)
//				.ifPresentOrElse(s -> {
//					System.out.println(s + " already exists");
//				}, () -> {
//					System.out.println("Inserting student " + student);
//					studentRepository.insert(student);
//				});
//			
//		};
//	}
//	
//	private void usingMongoTemplateAndQuery (StudentRepository studentRepository, MongoTemplate mongoTemplate,
//			String email, Student student) {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("email").is(email));
//		
//		List<Student> students = mongoTemplate.find(query, Student.class);
//		
//		if (students.size() > 1) {
//			throw new IllegalStateException ("found many students with email " + email);
//		} 
//		
//		if (students.isEmpty()) {
//			System.out.println("Inserting student " + student);
//			studentRepository.insert(student);
//		}
//		else {
//			System.out.println(student.toString() + " already exists");
//		}
//	}
		

}
