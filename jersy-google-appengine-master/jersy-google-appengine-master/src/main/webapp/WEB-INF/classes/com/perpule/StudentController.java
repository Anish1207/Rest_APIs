package com.perpule;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.perpule.model.Student;

import dao.StudentDao;
 
@Path("/student")
public class StudentController {
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveStudent(Student student) {  
		StudentDao  sdao = new StudentDao();
		Long id = sdao.saveStudent(student);
		return Response.status(200).entity("hey got "+id).build(); 
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent(@PathParam("id") Long studentId) {  
		StudentDao  sdao = new StudentDao();
		Student student = sdao.getStudent(studentId);
		return Response.status(200).entity("hello").build(); 
	
	}

}