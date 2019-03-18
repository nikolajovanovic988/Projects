package com.jdbc.sql.controller;

import com.jdbc.sql.model.Model;
import com.jdbc.sql.view.Frame;

public class Controller {

	private Model model;
	private Frame frame;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

}
