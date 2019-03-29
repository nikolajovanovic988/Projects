package com.jdbc.sql.main;

import javax.swing.SwingUtilities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.sql.controller.Controller;
import com.jdbc.sql.view.Frame;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				runApp();
			}

		});
	}
	
	public static void runApp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("/bean.xml");
		
		Frame frame = (Frame) context.getBean("frame");
		Controller controller = (Controller) context.getBean("controller");
		frame.getView().setController(controller);
		((ClassPathXmlApplicationContext)context).close();
	}
}
