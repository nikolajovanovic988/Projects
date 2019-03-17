package com.videogame.invasion.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private Menu container;

	public Frame(Menu container) {
		this.container = container;
		JFrame window = new JFrame("Invasion");
		window.setContentPane(container);

		window.setSize(820, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation((screenSize.width - window.getWidth()) / 2, (screenSize.height - window.getHeight()) / 2);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public Menu getContainer() {
		return container;
	}

	public void setContainer(Menu container) {
		this.container = container;
	}
	
}
