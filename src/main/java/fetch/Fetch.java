package fetch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import EntityClasses.Student;
import EntityClasses.Subject;

public class Fetch {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate_many_to_many_uni");
		EntityManager em=emf.createEntityManager();
		
		
		Student stud=em.find(Student.class, 1);
		System.out.println(stud);
		List<Subject> subjects=stud.getSubjects();
		
		for(Subject s:subjects) {
			System.out.println(s);
		}
	}
}
