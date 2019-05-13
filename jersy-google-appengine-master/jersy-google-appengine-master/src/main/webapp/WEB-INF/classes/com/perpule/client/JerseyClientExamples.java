package com.perpule.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.filter.LoggingFilter;

import com.perpule.model.Student;
import com.perpule.model.Students;

public class JerseyClientExamples {
	
	public static void main(String[] args) throws IOException 
	{
		httpGETCollectionExample();
		httpGETEntityExample();
		httpPOSTMethodExample();
	}
	
	private static void httpGETCollectionExample() 
	{
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
																    .nonPreemptive()
																    .credentials("user", "password")
																    .build();

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(feature) ;

		Client client = ClientBuilder.newClient( clientConfig );
		WebTarget webTarget = client.target("http://localhost:8080/JerseyDemos/rest").path("student/");
		
		Invocation.Builder invocationBuilder =	webTarget.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.get();
		
		Students students = response.readEntity(Students.class);
		List<Student> listOfStudents = students.getStudentList();
			
		System.out.println(response.getStatus());
		System.out.println(Arrays.toString( listOfStudents.toArray(new Student[listOfStudents.size()]) ));
	}
	
	private static void httpGETEntityExample() 
	{
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = client.target("http://localhost:8080/JerseyDemos/rest").path("students").path("1");
		
		Invocation.Builder invocationBuilder =	webTarget.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.get();
		
		Student student = response.readEntity(Student.class);
			
		System.out.println(response.getStatus());
		System.out.println(student);
	}

	private static void httpPOSTMethodExample() 
	{
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = client.target("http://localhost:8080/JerseyDemos/rest").path("students");
		
		Student emp = new Student();
		
		emp.setId(21l);
		emp.setName("Anish P");
		emp.setEmail("anish@perpule.com");
		
		Invocation.Builder invocationBuilder =	webTarget.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.post(Entity.entity(emp, MediaType.APPLICATION_XML));
		
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

}
