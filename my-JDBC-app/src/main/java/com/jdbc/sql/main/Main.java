package com.jdbc.sql.main;

import javax.swing.SwingUtilities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		((ClassPathXmlApplicationContext)context).close();
	}
}
