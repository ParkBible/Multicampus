import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;

class TCanvas extends Canvas {
	private Image img = null;
	public TCanvas() {
		try{
			img = ImageIO.read(new File("C:\\JavaWork\\man1.png")); 			
		}
		catch( IOException e ){}

		setSize( 200, 200 );
		setBackground(Color.WHITE);
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor( Color.WHITE );
		g2.fillRect( 0,0, 200, 200 );

		g2.drawImage(img, img_x, img_y, this);
		g2.dispose();
	}
	
	private int img_x = 0;
	private int img_y = 0;

	public void move() {
		img_x = img_x + 3;
		img_y = img_y + 3;
	}
}

public class Test166참고 extends Frame {
	public Test166참고() {
		Button btn = new Button("Click");
		final TCanvas canvas = new TCanvas();
		setLayout( new FlowLayout() );
		add( btn );
		add( canvas );

		btn.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				System.out.println("Click!");
				canvas.move();
				canvas.repaint();
			}
		});
	}
	public static void main( String[] args ) {
		Test166참고 t = new Test166참고();
		t.setBackground( Color.yellow );
		t.setSize( 300, 300 );
		t.setVisible( true );
	}
}