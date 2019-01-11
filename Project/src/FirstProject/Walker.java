package FirstProject;

import java.awt.Color;
import java.awt.Graphics;

public class Walker {

	public int height;
	public int width;
	
	public boolean legPosition = true;
	public int startPosition =  20;
	public int kneeX;
	public int kneeY;
	public int firstLegPosition = 0; // it start whit 0 (the start position), and by adding or removing 1 it move left or right.
	public int secondLegPosition = 0;// it start whit 0 (the start position), and by adding or removing 1 it move left or right.
	public boolean start = true; 
	public int raisingLeg = 0;
	public int rightArmSwing = 0;
	public int leftArmSwing = 0;
	public int turning = 0;
	public int sitting = 0;
	
	public Walker() {
		
	}
	
	public void  paintComponent(Graphics g) {
		
		leftArm(g);
		
		head(g);
		body(g);
		
		legs(g);
		rightArm(g);
		
	}
	
	private void head(Graphics g) {
		
		int headTurning = 0;
		if (turning < 20) {
			headTurning = turning;
		} else if (turning >= 20){
			headTurning = 20;
		}
		
		int headSitting = 0;
		if ( sitting < 20) {
			headSitting = sitting;
		} else if (sitting >= 20) {
			headSitting = 20;
		}
		
		// hair
		int [] i = new int [23];
		int [] o = new int [23];
				
		i[0] = startPosition + 24 - headTurning / 2 + headTurning / 10;
		o[0] = height/2 - 90 - headTurning / 20 + headSitting;
		i[1] = i[0] - 1;
		o[1] = o[0] - 2;
		i[2] = i[1] - 1;
		o[2] = o[1] - 1 - headTurning / 20;
		i[3] = i[2] - 4;
		o[3] = o[2] - 1;
		i[4] = i[3] - 3 - headTurning / 5;
		o[4] = o[3] - 1 + headTurning / 20 ;
		i[5] = i[4] - 5;
		o[5] = o[4];
		i[6] = i[5] - 3;
		o[6] = o[5] + 1;
		i[7] = i[6] - 3;
		o[7] = o[6] + 4;
		i[8] = i[7];
		o[8] = o[7] + 3;
		i[9] = i[8];
		o[9] = o[8] + 4;
		i[10] = i[9] + 1;
		o[10] = o[9] + 4;
		i[11] = i[10] + 2;
		o[11] = o[10] + 4;
		i[12] = i[11] + 1;
		o[12] = o[11] + 4;
		i[13] = i[12] + 2;
		o[13] = o[12] + 4;
		i[14] = i[13] + 3;
		o[14] = o[13] + 4;
		i[15] = startPosition + 12 - headTurning / 2 - headTurning / 20;
		o[15] = height/2 - 58 + headSitting;
		i[16] = i[15] + 8;
		o[16] = o[15];
		i[17] = i[16];
		o[17] = o[16] - 3;
		i[18] = i[17] + headTurning / 5;
		o[18] = o[17] - 5;
		i[19] = i[18];
		o[19] = o[18] - 5;
		i[20] = i[19] ;
		o[20] = o[19] - 5;
		i[21] = i[20] + headTurning / 8 + headTurning / 20;
		o[21] = o[20] - 5;
		i[22] = i[21] ;
		o[22] = o[21] - 10;
		
		g.setColor(new Color(167, 133, 106));
		g.fillPolygon(i, o, 23);
		g.setColor(new Color(151, 121, 97));
		g.drawPolygon(i, o, 23);
		
		
		// face
		
		int [] x = new int [31];
		int [] y = new int [31];
		
		x[0] = startPosition + 12 - headTurning / 2 - headTurning / 10;
		y[0] = height/2 - 58 + headSitting;
		x[1] = x[0] + 8 ;
		y[1] = y[0];
		x[2] = x[1];
		y[2] = y[1] - 3;
		
		x[3] = x[2] + 4 - headTurning / 20; // chin
		y[3] = y[2] - headTurning / 5;
		x[4] = x[3] + 1 + headTurning / 20;
		y[4] = y[3] - 1;
		x[5] = x[4];
		y[5] = y[4] - 3 ;
		x[6] = x[5] - 1 + headTurning / 20;
		y[6] = y[5] - 1;
		x[7] = x[6]  + headTurning / 20;
		y[7] = y[6] -3 + headTurning /5;
		
		x[8] = x[7] + 1 - headTurning / 20; // mouth
		y[8] = y[7];
		x[9] = x[8];
		y[9] = y[8] - 1;
		x[10] = x[9] - 4 + headTurning / 5;
		y[10] = y[9];
		x[11] = x[10] + 4 - headTurning / 5;
		y[11] = y[10];
		x[12] = x[11];
		y[12] = y[11] - 1;
		x[13] = x[12] - 1 + headTurning /20;
		y[13] = y[12];
		
		x[14] = x[13]; // nose
		y[14] = y[13] - 3 - headTurning / 10;
		x[15] = x[14] + 4 - headTurning / 10;
		y[15] = y[14] - headTurning / 5;
		x[16] = x[15];
		y[16] = y[15]- 2;
		x[17] = x[16] - 4 + headTurning / 10;
		y[17] = y[16] - 6 + headTurning / 5 + headTurning / 10;
		
		x[18] = x[17]; // forhead
		y[18] = y[17] - 8;
		x[19] = x[18] - 1;
		y[19] = y[18] - 1;
		x[20] = x[18] - 7 - headTurning / 3 - headTurning / 5;
		y[20] = y[19];
		x[21] = x[20] - 2;
		y[21] = y[20] + 6 - headTurning / 2 + headTurning / 5 + headTurning / 20;
		x[22] = x[21] - 3 + headTurning / 10 + headTurning / 20;
		y[22] = y[21] + headTurning /2 - headTurning / 10;
		
		x[23] = x[22] - 2; // ear
		y[23] = y[22] - 1  + headTurning / 20;
		x[24] = x[23] - 1 + headTurning / 20;
		y[24] = y[23];
		x[25] = x[24] - 2 + headTurning / 10;
		y[25] = y[24] + 2 - headTurning / 20;
		x[26] = x[25] + headTurning / 10;
		y[26] = y[25] + 1 + headTurning / 10;
		x[27] = x[26] + 1 - headTurning / 20;
		y[27] = y[26] + 1 + headTurning / 10;
		x[28] = x[27] + 1 - headTurning / 20;
		y[28] = y[27] + 3;
		x[29] = x[28] + 1 + headTurning / 10;
		y[29] = y[28] + 2 + headTurning / 10;
		x[30] = x[29] + 1;
		y[30] = y[29] + headTurning / 10;
				
		g.setColor(new Color (255, 220, 177));
		g.fillPolygon(x, y, 31);
		g.setColor(new Color (229, 194, 152));
		g.drawPolygon(x, y, 31);
		
		g.setColor(Color.BLACK);
		leftEye(startPosition + 23, height/2 - 82 + headSitting, g, headTurning);
		
		g.setColor(Color.BLACK);
		rightEye(x[17], y[17], g, headTurning);
		
		// nose
		int[] n = new int [4];
		int[] m = new int [4];
		if (headTurning > 2) {
			n[0] = startPosition + 12 - headTurning + 12;
			m[0] = height/2 - 74 + headSitting;// ;
			n[1] = n[0] + 4 - headTurning / 20;
			m[1] = m[0];
			n[2] = n[1] - headTurning / 5 + headTurning / 20;
			m[2] = m[1] - 2 + headTurning / 10;
			n[3] = n[2] - 4 + headTurning / 5;
			m[3] = m[2] - 6 - headTurning/ 10 ;
			g.setColor(new Color(255, 173, 96));
			g.drawPolygon(n, m, 4);
		}
		// mouth
		n[0] = startPosition + 12 - headTurning/2 + 12 - headTurning / 6 - headTurning / 10 ;
		m[0] = height/2 - 69 - headTurning / 20 + headSitting;
		n[1] = n[0] - 1 - headTurning / 10;
		m[1] = m[0] + headTurning / 20;
		n[2] = n[1] - 1 - headTurning / 10;
		m[2] = m[1];
		n[3] = n[2] - 1 - headTurning / 10;
		m[3] = m[2] - headTurning / 20;
		g.setColor(new Color(227, 93, 106));
		g.drawPolygon(n, m, 4);
		
	}
	
	private void leftEye(int startX, int startY, Graphics g, int headTurning) {
		
		g.drawLine(startX - headTurning / 2 - headTurning / 10, startY-3, startX - 4 - headTurning / 2 - headTurning / 10, startY-3);
		
		g.drawOval(startX - 4 - headTurning / 2 - headTurning / 10, startY - 2, 3, 2); 
	}
	
	private void rightEye(int startX, int startY, Graphics g, int headTurning) {
		
		g.drawLine(startX - headTurning / 2 - headTurning / 10, startY-3, startX - 4 - headTurning / 2 - headTurning / 10, startY-3);
		
		g.drawOval(startX - 4 - headTurning / 2 - headTurning / 10, startY - 2, 3, 2); 
	}
	
	private void body(Graphics g) {
		
		int bodyTurning = 0;
		if (turning < 20) {
			bodyTurning = turning;
		} else if (turning >= 20){
			bodyTurning = 20;
		}
		
		int bodySitting = 0;
		if ( sitting < 20) {
			bodySitting = sitting;
		} else if (sitting >= 20) {
			bodySitting = 20;
		}
		
		int [] x = new int [14];
		int [] y = new int [14];
		
		x[0] = startPosition - bodyTurning + bodyTurning / 10;
		y[0] = height/2 - 43 + bodySitting;
		x[1] = x[0] + 2 - bodyTurning / 10; // 1
		y[1] = y[0] - 5;
		x[2] = x[1] + 2 - bodyTurning / 10; //2
		y[2] = y[1] - 5;
		x[3] = x[2] + 5 + bodyTurning / 2 + (bodyTurning / 20) * 2; // start neck
		y[3] = y[2] - 5;
		x[4] = x[3] + 12; // end neck
		y[4] = y[3];
		x[5] = x[4] + 5 + bodyTurning/2 + bodyTurning/5; // 1
		y[5] = y[4] + 5;
		x[6] = x[5] + 2 - bodyTurning / 10 - bodyTurning / 20 ; // 2
		y[6] = y[5] + 5;
		x[7] = x[6] + 2  - bodyTurning / 10 - bodyTurning / 20 ; //startPosition
		y[7] = y[6] + 5;
		x[8] = x[7] ;
		y[8] = y[0] + 25;
		x[9] = x[8] - 1 + bodyTurning/20;
		y[9] = y[8] + 2;
		x[10] = x[9];
		y[10] = y[9] + 40;
		x[11] = x[10] - 1;
		y[11] = y[10] + 1;
		x[12] = x[11] - 27 - bodyTurning + bodyTurning / 10 + bodyTurning / 20;
		y[12] = y[11];
		x[13] = x[12] - 1;
		y[13] = y[12] - 1;
		
		g.setColor(new Color (0, 76, 151));
		g.fillPolygon(x, y, 14);
		g.setColor(new Color (0, 51, 102));
		g.drawPolygon(x, y, 14);
		
	}
	
	private void leftHand (int firstX, int firstY, Graphics g) {
		
		int fingerTurning = 0;
		if (turning < 20) {
			fingerTurning = turning;
		} else if (turning >= 20){
			fingerTurning = 20;
		}
		
		int [] x = new int [19];
		int [] y = new int [19];
		
		x[0] = firstX + 3;
		y[0] = firstY;
		x[1] = x[0] + 8;
		y[1] = y[0];
		x[2] = x[1];
		y[2] = y[1] + 2;
		x[3] = x[2] + 3 - fingerTurning / 7; //first finger
		y[3] = y[2] + 1;
		x[4] = x[3] - 1;
		y[4] = y[3] + 1;
		x[5] = x[4] - 2 + fingerTurning / 7;
		y[5] = y[1] +2;
		x[6] = x[5];
		y[6] = y[5] + 4;
		x[7] = x[6] + 1; // second finger
		y[7] = y[6] + 3;
		x[8] = x[7] - 3;
		y[8] = y[7];
		x[9] = x[8];
		y[9] = y[8] - 3;
		x[10] = x[9]; // third finger
		y[10] = y[9] + 3;
		x[11] = x[10] - 2;
		y[11] = y[10];
		x[12] = x[11];
		y[12] = y[11] - 3;
		x[13] = x[12]; // forth finger
		y[13] = y[12] +3;
		x[14] = x[13] - 2;
		y[14] = y[13];
		x[15] = x[14];
		y[15] = y[14] - 3;
		x[16] = x[15]; // fifth finger;
		y[16] = y[15] + 3;
		x[17] = x[16] - 2;
		y[17] = y[16];
		x[18] = x[17];
		y[18] = y[17] - 3;
		
		g.setColor(new Color (255, 220, 177));
		g.fillPolygon(x,y,19);
		g.setColor(new Color (222, 171, 127));
		g.drawPolygon(x,y,19);
	}
	
	private void rightHand (int firstX, int firstY, Graphics g) {
		
		int fingerTurning = 0;
		if (turning < 20) {
			fingerTurning = turning;
		} else if (turning >= 20){
			fingerTurning = 20;
		}
		
		int [] x = new int [19];
		int [] y = new int [19];
		
		x[0] = firstX + 3;
		y[0] = firstY;
		x[1] = x[0] + 8;
		y[1] = y[0];
		x[2] = x[1];
		y[2] = y[1] + 2;
		x[3] = x[2] + 3 - fingerTurning / 6; //first finger
		y[3] = y[2] + 1;
		x[4] = x[3] - 1;
		y[4] = y[3] + 1;
		x[5] = x[4] - 2 + fingerTurning / 6;
		y[5] = y[1] +2;
		x[6] = x[5];
		y[6] = y[5] + 4;
		x[7] = x[6] + 1; // second finger
		y[7] = y[6] + 3;
		x[8] = x[7] - 3;
		y[8] = y[7];
		x[9] = x[8];
		y[9] = y[8] - 3;
		x[10] = x[9]; // third finger
		y[10] = y[9] + 3;
		x[11] = x[10] - 2;
		y[11] = y[10];
		x[12] = x[11];
		y[12] = y[11] - 3;
		x[13] = x[12]; // forth finger
		y[13] = y[12] +3;
		x[14] = x[13] - 2;
		y[14] = y[13];
		x[15] = x[14];
		y[15] = y[14] - 3;
		x[16] = x[15]; // fifth finger;
		y[16] = y[15] + 3;
		x[17] = x[16] - 2;
		y[17] = y[16];
		x[18] = x[17];
		y[18] = y[17] - 3;
		
		
		g.setColor(new Color (255, 220, 177));
		g.fillPolygon(x,y,19);
		g.setColor(new Color (222, 171, 127));
		g.drawPolygon(x,y,19);
		
		
	}
	
	private void leftArm(Graphics g) {
		
		int armTurning = 0;
		if (turning < 20) {
			armTurning = turning;
		} else if (turning >= 20){
			armTurning = 20;
		}
		
		int armSitting = 0;
		if ( sitting < 20) {
			armSitting = sitting;
		} else if (sitting >= 20) {
			armSitting = 20;
		}
		
		int [] x = new int [10];
		int [] y = new int [10];
		
		x[0] = startPosition + 5 + armTurning + armTurning/4;
		y[0] = height/2 -30 + armTurning / 10 + armSitting;
		x[1] = x[0] + 3 - armTurning / 5;
		y[1] = y[0] - 22;
		x[2] = x[1] + 3;
		y[2] = y[1] -3;
		x[3] = x[2] + 3;
		y[3] = y[2];
		x[4] = x[3] + 3;
		y[4] = y[3] + 3;
		x[5] = x[4] + 3;
		y[5] = y[4] + 5;
		 x[6] = x[5] + -3 + rightArmSwing;
		 y[6] = y[5] + 30;
		 x[7] = x[6] + 3 + rightArmSwing - armTurning / 2;
		 y[7] = y[6] + 40;
		 x[8] = x[7] - 12;
		 y[8] = y[7];
		 x[9] = x[8] - 5 - rightArmSwing + armTurning / 2 ;
		 y[9] = y[8] -40;
		
		
		g.setColor(new Color (0, 76, 151));
		g.fillPolygon(x, y, 10);
		g.setColor(new Color (0, 51, 102));
		g.drawPolygon(x, y, 10);
		
		rightHand (x[8], y[8] ,g);
	}
	
	private void rightArm(Graphics g) {
		
		int armTurning = 0;
		if (turning < 20) {
			armTurning = turning;
		} else if (turning >= 20){
			armTurning = 20;
		}
		
		int armSitting = 0;
		if ( sitting < 20) {
			armSitting = sitting;
		} else if (sitting >= 20) {
			armSitting = 20;
		}
		
		int [] x = new int [10];
		int [] y = new int [10];
		
		x[0] = startPosition + 5 - armTurning * 2 + armTurning / 10;
		y[0] = height/2 -48 + armTurning / 10 + armSitting;
		x[1] = x[0] + 3;
		y[1] = y[0] - 5;
		x[2] = x[1] + 3 + armTurning / 5;
		y[2] = y[1] -3;
		x[3] = x[2] + 3;
		y[3] = y[2];
		x[4] = x[3] + 3;
		y[4] = y[3] + 3;
		x[5] = x[4] + 3 - armTurning / 5;
		y[5] = y[4] + 5;
		 x[6] = x[5] + -3 + leftArmSwing + armTurning / 4;
		 y[6] = y[5] + 30;
		 x[7] = x[6] + 3 + leftArmSwing + armTurning / 5;
		 y[7] = y[6] + 40;
		 x[8] = x[7] - 12;
		 y[8] = y[7];
		 x[9] = x[8] - 5 - leftArmSwing - armTurning / 5;
		 y[9] = y[8] -40;
		 
		g.setColor(new Color (0, 76, 151));
		g.fillPolygon(x, y, 10);
		g.setColor(new Color (0, 51, 102));
		g.drawPolygon(x, y, 10);
		
		leftHand(x[8], y[8], g);
	}
	
	private void legs(Graphics g) {
		int legTurning = 0;
		if (turning < 20) {
			legTurning = turning;
		} else if (turning >= 20){
			legTurning = 20;
		}
		
		int legSitting = 0;
		if ( sitting < 20) {
			legSitting = sitting;
		} else if (sitting >= 20) {
			legSitting = 20;
		}
		
		if (legPosition) {
			
			int [] x = new int [6];
			int [] y = new int [6];
			
			// first leg is negative
			x[0] = startPosition;
			y[0] = height/2 + 25 + legSitting;
			x[1] = x[0] + 20;
			y[1] = y[0];
			x[2] = kneeX - legTurning + legTurning / 2;
			y[2] = kneeY;
			x[3] = x[1] + firstLegPosition - legTurning;
			y[3] = y[1] + 90 - legSitting;
			x[4] = x[0] + firstLegPosition - legTurning;
			y[4] = y[3];
			x[5] = kneeX - 17 - legTurning/2;
			y[5] = kneeY;
			
			g.setColor(new Color (0, 76, 151));
			g.fillPolygon(x, y , 6);
			g.setColor(new Color (0, 51, 102));
			g.drawPolygon(x, y , 6);
			
			feet(x[4], y[4], g, legTurning);
			
			// second leg is negative
			x[0] = startPosition + 8 - legTurning;
			y[0] = height/2 + 25 + legSitting;
			x[1] = x[0] + 20;
			y[1] = y[0];
			 x[2] = kneeX + secondLegPosition + raisingLeg - legTurning / 2;
			y[2] = kneeY - raisingLeg;
			x[3] = x[1] + secondLegPosition + legTurning;
			y[3] = y[1] + 90 - raisingLeg - legSitting;
			x[4] = x[0] + secondLegPosition + legTurning;
			y[4] = y[3];
			 x[5] = kneeX - 17 + secondLegPosition + raisingLeg - legTurning / 2;
			y[5] = kneeY - raisingLeg;
			
			g.setColor(new Color (0, 76, 151));
			g.fillPolygon(x, y , 6);
			g.setColor(new Color (0, 51, 102));
			g.drawPolygon(x, y , 6);
			
			feet (x[4], y[4], g, legTurning);
			
		} else if (!legPosition) {
			
			int [] x = new int [6];
			int [] y = new int [6];
			
			// first leg is positive 
			x[0] = startPosition + 5;
			y[0] = height/2 + 25 + legSitting;
			x[1] = x[0] + 20;
			y[1] = y[0];
			 x[2] = kneeX + firstLegPosition + raisingLeg - legTurning / 2;
			y[2] = kneeY - raisingLeg;
			x[3] = x[1] + firstLegPosition - legTurning ;
			y[3] = y[1] + 90 - raisingLeg - legSitting;
			x[4] = x[0] + firstLegPosition - legTurning ;
			y[4] = y[3];
			 x[5] = kneeX - 17 + firstLegPosition + raisingLeg - legTurning / 2;
			y[5] = kneeY - raisingLeg;
			
			g.setColor(new Color (0, 76, 151));
			g.fillPolygon(x, y , 6);
			g.setColor(new Color (0, 51, 102));
			g.drawPolygon(x, y , 6);
			
			feet (x[4], y[4], g, legTurning);
			
			// second leg is negative 
			x[0] = startPosition + 5 - legTurning;
			y[0] = height/2 + 25 + legSitting;
			x[1] = x[0] + 20;
			y[1] = y[0];
			x[2] = kneeX - legTurning  / 2;
			y[2] = kneeY;
			x[3] = x[1] + secondLegPosition + legTurning;
			y[3] = y[1] + 90 - legSitting;
			x[4] = x[0] + secondLegPosition + legTurning;
			y[4] = y[3];
			x[5] = kneeX - 17 - legTurning / 2;
			y[5] = kneeY;
			
			g.setColor(new Color (0, 76, 151));
			g.fillPolygon(x, y , 6);
			g.setColor(new Color (0, 51, 102));
			g.drawPolygon(x, y , 6);
			
			feet (x[4], y[4], g, legTurning);
		}
	}
	
	private void feet(int firstX, int firstY, Graphics g, int legTurning) {
		int [] x = new int [10];
		int [] y = new int [10];
		
		x[0] = firstX + 5;
		y[0] = firstY;
		x[1] = x[0] + 10;
		y[1] = y[0];
		x[2] = x[1] + 3 - legTurning / 10;
		y[2] = y[1] + 3;
		x[3] = x[2] + 2 - legTurning / 10;
		y[3] = y[2] + 2;
		x[4] = x[3] + 10 - legTurning / 2;
		y[4] = y[3] + 1;
		x[5] = x[3] + 10 - legTurning / 2 - legTurning / 5;
		y[5] = y[3] + 1;
		x[6] = x[3] + 10 - legTurning / 2;
		y[6] = y[3] + 1;
		x[7] = x[6] + 1;
		y[7] = y[6] + 2;
		x[8] = x[7] - 1;
		y[8] = y[7] + 2;
		x[9] = x[0]- legTurning / 10;
		y[9] = y[8];
		
		g.setColor(new Color (186, 163, 120));
		g.fillPolygon(x, y , 10);
		g.setColor(new Color (69, 54, 35));
		g.drawPolygon(x, y , 10);
	}
	
	public boolean checkIfInMiddle() {
		if(startPosition == width/2 - 20) {
			return true;
		} else {
			return false;
		}
	}
}
