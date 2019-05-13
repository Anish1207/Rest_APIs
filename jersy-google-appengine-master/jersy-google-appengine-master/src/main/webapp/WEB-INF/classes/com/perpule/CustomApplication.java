package com.perpule;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import com.perpule.provider.AuthenticationFilter;
import com.perpule.provider.GsonMessageBodyHandler;

public class CustomApplication extends ResourceConfig{
	
	public CustomApplication() {
		packages("com.perpule");	
		register(LoggingFilter.class);
		register(GsonMessageBodyHandler.class);
		register(AuthenticationFilter.class);
	}

}
