package FirstProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Animation extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Walker walker;
	private Setup setup;
	private Timer timer;
	private TextShow frame;
	private int move  = 0;
	private boolean clickToStart = true; // for Label "Click to start"
	private String clickToStartString = "Click to start";
	
	public Animation() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beansTwo.xml");
		walker = (Walker)context.getBean("walker");
		setup = (Setup)context.getBean("setup");
		((ClassPathXmlApplicationContext) context).close();
		
		// when mouse is pressed focus is gained.
		addMouseListener( new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				requestFocus();
			}
		});
	
		// when mouse is pressed in canvas it gain focus, otherwise it lose focus and animation stop.
		addFocusListener( new FocusListener() {
			public void focusGained(FocusEvent e) {
				timer.start();
				clickToStart = false; // remove label
				repaint();
			}
			public void focusLost(FocusEvent e) {
				timer.stop();
				clickToStart = true; // show label
				repaint();
			}
		} );
	}
	
	public void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		if (timer == null || frame == null) {
			
			timer = new Timer(12, this);
			frame = new TextShow("Propratno pismo.txt");
			
			walker.raisingLeg = 15;
			walker.height = getHeight();
			walker.width = getWidth();	
			setup.height = getHeight();
			setup.width = getWidth();
			frame.height = getHeight();
			frame.width = getWidth();
			frame.setCords(getWidth()/2 + 80, getHeight()/2 + 10, getHeight()/2 - 170, 16, Color.BLACK);
			repaint();
		}
		
		frame.paintComponent(g);
		setup.paintComponent(g);
		walker.paintComponent(g);
		
		
		
		if ( clickToStart == true) {
			g.setColor(Color.BLACK);
			g.drawString(clickToStartString, getWidth()/2 - 45, getHeight() - 20);
		}
		
		if (walker.start){
			walker.kneeX = walker.startPosition + 25;
			walker.kneeY = walker.height/2 + 65;
			
			walker.start = false;
		}
		
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (!walker.checkIfInMiddle()) { // If walker is in middle (chair spot) then its false and it skip to else
			walker.startPosition ++;
			
			if ((walker.startPosition + walker.firstLegPosition + 5) == (walker.startPosition + 30) 
					|| (walker.startPosition + walker.secondLegPosition + 5) == (walker.startPosition + 30)) {
				if (walker.legPosition == true) {
					walker.legPosition = false;
					walker.kneeX = walker.startPosition + 25 + walker.secondLegPosition/2;
					walker.kneeY = walker.height/2 + 65;
				} else {
					walker.legPosition = true;
					walker.kneeX = walker.startPosition + 25 + walker.firstLegPosition/2;
					walker.kneeY = walker.height/2 + 65;
				}
				walker.raisingLeg = 0;
			}
			
			if (walker.legPosition) { // check if leg is ready to go other way (back or forward)
				walker.firstLegPosition --;
				walker.secondLegPosition ++;
				if (walker.secondLegPosition % 2 == 0) {
					walker.kneeX++;
					if (walker.secondLegPosition >= 0) {
						walker.raisingLeg--;
					} else {
						walker.raisingLeg++;
					}
				}
				if (walker.secondLegPosition % 4 == 0) {
					walker.rightArmSwing--;
					walker.leftArmSwing++;
				}
			} else {
				walker.firstLegPosition ++;
				walker.secondLegPosition --;
				if (walker.firstLegPosition % 2 == 0) {
					walker.kneeX++;
					if (walker.firstLegPosition >= 0) {
						walker.raisingLeg--;
					} else {
						walker.raisingLeg++;
					}
				}
				if (walker.firstLegPosition % 4 == 0) {
					walker.rightArmSwing++;
					walker.leftArmSwing--;
				}
			}
			
		} else { // walker is in middle
			if (walker.turning <= 20) {
				walker.turning++;
			} else {
				walker.sitting++;
			}
			
			if (walker.sitting >= 25) {
				move++;
				if (move % 4 == 0) {
					frame.move++; // start sliding cover letter
				}
			}
		}
		
		
		repaint();
	}
	
}
