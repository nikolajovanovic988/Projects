package com.jdbc.sql.view;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private View view;

	public Frame(View view) {
		this.view = view;
		
		
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

}
