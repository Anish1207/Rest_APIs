package com.perpule;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.perpule.model.Student;
import com.perpule.model.Students;

import dao.StudentDao;
 
@Path("/student")
public class StudentController {
	
	@Path("/save")
	@RolesAllowed("ADMIN")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveStudent(Student student) {  
		StudentDao  sdao = new StudentDao();
		Long id = sdao.saveStudent(student);
		return Response.status(200).entity("Saved "+id).build(); 
	}
	
	@Path("/{id}")
	@RolesAllowed("ADMIN")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent(@PathParam("id") Long studentId) {  
		StudentDao  sdao = new StudentDao();
		Student student = sdao.getStudent(studentId);
		return Response.status(200).entity(student).build(); 
	}

}