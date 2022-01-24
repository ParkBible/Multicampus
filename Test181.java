import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

class XCanvas extends Canvas {
	private String tf = null;
	public XCanvas() {
		setSize( 500, 400 );
	}
	
	public void paint( Graphics g ) {
		update( g );
	}
	
	public void update( Graphics g ) {
		Graphics2D g2 = (Graphics2D)g;
		setBackground( Color.YELLOW );		
		
		g2.setColor(Color.BLACK);
		//g2.drawLine(100,100,200,200);    // 시작지점 x,y / 도착지점 x,y
		//g2.fillOval(100,100,100,100);    // 왼쪽 꼭지점 위치 / 반지름
		
		g2.drawLine(0, 100, 400, 100);
		g2.drawLine(0, 0, 0, 200);
		//g2.fillOval(200,200,5,5);
		
		double y = 0;
		
		/*
			종이에 그려가면서 하는게 더 쉽다.
		*/
		
		if(tf != null){
			if(tf.equals("sin")){
				for(double x=0; x<400; x=x+0.5){
				y = 100 + Math.sin(-Math.toRadians(x))*100;
				g2.fillOval((int)x, (int)y ,5,5);
				}
			}
			else if(tf.equals("cos")){
				for(double x=0; x<400; x=x+0.5){
				y = 100 + Math.cos(-Math.toRadians(x))*100;
				g2.fillOval((int)x, (int)y ,5,5);
				}
			}
		}
		
	}
	
	
	public void select(String t){
		tf = t;
		System.out.println(tf);

	}
	
}

class XFrame extends Frame {
	public XFrame() {
		Panel p1 = new Panel();
		final XCanvas xc = new XCanvas();
		p1.add( xc );
		
		Button btn = new Button("Click");

		final TextField tf = new TextField( 24 );
		btn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String data = tf.getText();
				xc.select(data);
				xc.repaint();
			}
		} );
		
		Panel p2 = new Panel();
		p2.add( tf );
		p2.add( btn );
		
		add( p1 , BorderLayout.CENTER );
		add( p2 , BorderLayout.SOUTH );
		
		setSize( 600, 360 );
		setVisible( true );
	}
}

public class Test181 {
	public static void main( String[] args ) {
		new XFrame();
	}
}

/*

*/