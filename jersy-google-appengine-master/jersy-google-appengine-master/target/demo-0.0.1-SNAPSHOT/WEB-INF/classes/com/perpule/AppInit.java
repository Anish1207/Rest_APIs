package com.perpule;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.VoidWork;
import com.perpule.model.Student;


public class AppInit implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		//ObjectifyService.init();
        ObjectifyService.register(Student.class);
        
        ObjectifyService.run(new VoidWork() {
        public void vrun() {
           
        }
    });
	
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}