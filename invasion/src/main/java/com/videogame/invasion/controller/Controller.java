package com.videogame.invasion.controller;

import com.videogame.invasion.model.Model;
import com.videogame.invasion.view.Frame;

public class Controller {

	private Frame frame;
	private Model model;
	
	public Controller() {
		
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
}
