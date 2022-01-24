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
	public XCanvas() {
		setSize( 500, 200 );
		setBackground( Color.YELLOW );
		
		list = new ArrayList<PT>();
	}
	
	public void paint( Graphics g ) {
		update( g );
	}
	
	public void update( Graphics g ) {
		Graphics2D g2 = (Graphics2D)g;
		
		for( int i = 0 ; i < 10 ; i++ ) {
			for( int j = 0 ; j < 4 ; j++ ) {
				if( ( i + j ) % 2 == 0 ) {
					g2.setColor( Color.BLACK );
				} else {
					g2.setColor( Color.WHITE );
				}
				g2.fillRect( i*50, j*50, 50, 50 );
			}
		}
		
		for( PT pt : list ) {
			int i = pt.i;
			int j = pt.j;
			
			g2.setColor( Color.GREEN );
			g2.fillRect( (i*50+10), (j*50+10), 30, 30 );
		}
	}

	private List<PT> list = null;
	
	public void setPoint( int i2, int j2 ) {
		list.add( new PT( i2, j2 ) );
	}
}

class PT {
	int i = 0;
	int j = 0;
	
	public PT( int i2, int j2 ) {
		this.i = i2;
		this.j = j2;
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
				int idx = data.indexOf(' ');
				
				String ix = data.substring(0,idx);
				String jx = data.substring(idx+1);
				
				xc.setPoint( Integer.parseInt(ix), Integer.parseInt(jx) );
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

public class Test173 {
	public static void main( String[] args ) {
		new XFrame();
	}
}

/*
	1. 일단 점을 찍자
	2. 숫자를 넘기고 숫자를 찍자
	3. 숫자에 해당하는 사각형을 그리자
	4. List에 쌓이는거 확인하자
	5. 반복하여 List에 쌓인 정보대로 사각형 그리자
*/