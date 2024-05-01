package EntityClasses;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Student {
		@Id
		int id;
		String name;
		int age;
		
		@ManyToMany
		private List<Subject> subjects;

		public Student() {
			
		}

		public Student(int id, String name, int age, List<Subject> subjects) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.subjects = subjects;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public List<Subject> getSubjects() {
			return subjects;
		}

		public void setSubjects(List<Subject> subjects) {
			this.subjects = subjects;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", age=" + age + ", subjects=" + subjects + "]";
		}
		
		
}
