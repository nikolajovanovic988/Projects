package FirstProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.*;


public class Test extends JPanel implements ActionListener, KeyListener{

	public static void main(String[] args) {
		JFrame window = new JFrame("Sub Killer Game");
		Test content = new Test();
        window.setContentPane(content);
        window.setSize(600, 480);
        window.setLocation(100,100);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setResizable(false);  // User can't change the window's size.
        window.setVisible(true);

	}
	
	public Timer tm = new Timer(5, this);
	
	public int x = 0;
	public int y = 0;
	public int VELx = 0;
	public int VELy = 0;
	
	public Test() {
		
		setBackground( new Color(0,200,0) ); 
		
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		
	}
	
	public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		g.fillRect(x, y, 50, 50);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		 int code = e.getKeyCode();
         if (code == KeyEvent.VK_LEFT) {
               VELx = - 1;
               VELy= 0;
               System.out.println("SSSS");
         }
         else if (code == KeyEvent.VK_RIGHT) {  
        	 VELx = 1;
        	 VELy= 0;
         }
         else if (code == KeyEvent.VK_DOWN) {
        	 VELy= 1;
        	 VELx = 0;
         }
         else if (code == KeyEvent.VK_UP) {
        	 VELy= - 1;
        	 VELx = 0;
         }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		 VELy= 0;
    	 VELx = 0;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		x = x + VELx;
		y = y + VELy;
		repaint();
		
	}

}
