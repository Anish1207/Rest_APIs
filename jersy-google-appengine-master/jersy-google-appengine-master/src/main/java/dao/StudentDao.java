package dao;
import static com.googlecode.objectify.ObjectifyService.ofy;

import com.perpule.model.Student;



public class StudentDao {
	
	public Long saveStudent(Student student) {		
		 return ofy().save().entity(student).now().getId();
	}
	
	public Student getStudent(Long id) {		
		 return ofy().load().type(Student.class).id(id).now();
	}

}
