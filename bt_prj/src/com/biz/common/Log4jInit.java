package com.biz.common;

//import org.apache.log4j.PropertyConfigurator;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;



//core.log.jdbc.driver.OracleDriver

public class Log4jInit extends HttpServlet {
	public void init(){

//		org.apache.ibatis.logging.LogFactory.useSlf4jLogging();
//		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
//		org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
//		org.apache.ibatis.logging.LogFactory.useJdkLogging();
//		org.apache.ibatis.logging.LogFactory.useCommonsLogging();
//		org.apache.ibatis.logging.LogFactory.useStdOutLogging();
		
		String prefix =  getServletContext().getRealPath("/");
		String file = getInitParameter("log4j-properties-file");

		if(file != null){
			PropertyConfigurator.configure(prefix+file);
			System.out.println("Log4J Logging started: " + prefix+file);
		}
		else{
			System.out.println("Log4J Is not configured for your Application: " + prefix + file);
		}     
	}
}
