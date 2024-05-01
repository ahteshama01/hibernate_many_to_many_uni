package remove;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import EntityClasses.Student;
import EntityClasses.Subject;

public class Remove {
public static void main(String[] args) {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate_many_to_many_uni");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	//remove subjects
	
	Subject sub=em.find(Subject.class,102);
	Query query=em.createQuery("select s from Student s");
	List<Student> students=query.getResultList();
	
	for(Student s:students) {
		Iterator<Subject> itr=s.getSubjects().iterator();
		
		while(itr.hasNext()) {
			Subject temp=itr.next();
			if(temp.getId()==102) {
				itr.remove();
			}
		}
	}// end of for
	
	//remove student
	//Student stud=em.find(Student.class,2);
	
	et.begin();
	for(Student s:students) {
		em.merge(s);
	}
	em.remove(sub);
	///student remove
	//em.remove(stud);
	et.commit();
	
	}
}
