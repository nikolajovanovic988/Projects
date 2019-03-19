package com.jdbc.sql.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private View view;

	public Frame(View view) {
		this.view = view;
		JFrame window = new JFrame("JDBC and SQL Application");
		window.setContentPane(view);

		window.setSize(900, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation((screenSize.width - window.getWidth()) / 2, (screenSize.height - window.getHeight()) / 2);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

}
