import java.awt.*;
import java.awt.Button;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

class TCanvas extends Canvas implements Runnable {
	private MonitorCtrl MC = null;
	private boolean sign = false;
	public void setSign( boolean b ) {
		sign = b;
	}
	
	public void run() {
		boolean alive = true;
		while ( alive ) {
			while ( sign ) {
				MC.letMeWait();
			}
			increase();
			repaint();
			
			try {
				Thread.sleep( 250 );
			}
			catch ( InterruptedException e ) { e.printStackTrace(); }
		}
	}
	
	public void setNotify() {
		sign = false;
		MC.letMeNotify();
	}
	
	private Image img = null;
	private Image[] man = null;
	public TCanvas() {
		try {
			img = ImageIO.read( new File("C:\\JavaWork\\back.gif") );
			man = new Image[2];
			man[0] = ImageIO.read( new File("C:\\JavaWork\\man1.png") );
			man[1] = ImageIO.read( new File("C:\\JavaWork\\man2.png") );
		}
		catch( IOException e ) { e.printStackTrace(); }
		setSize( 320, 480 );
		MC = new MonitorCtrl();
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage( img, 0, 0, this );
		g2.drawImage( man[count % 2], 50, 180, this );
		
		g2.dispose();	// �� ������ ȣ��, ȣ�� �� �ص� �ڵ�ȣ�� �Ǳ� �Ԥ���~
	}
	
	private int count = 0;
	public void increase() {
		count++;
	}
}

class MonitorCtrl {
	public synchronized void letMeWait() {
		try {
			wait();
		}
		catch( InterruptedException e ) {}
	}
	
	public synchronized void letMeNotify() {
		notify();
	}
}

public class Test223_sol extends Frame 
{
	public Test223_sol() {
		Button btn = new Button("Click");
		Button btnWait = new Button("Wait");
		Button btnNotify = new Button("Notify");
		
		final TCanvas canvas = new TCanvas();
		setLayout( new FlowLayout() );
		add( btn );
		add( btnWait );
		add( btnNotify );
		
		add( canvas );
		
		/*
			btnWait �� ������ ���� �������� �ִϸ��̼��� ������Ѵ�.
			btnNotify �� ������ ���� �ִϸ��̼��� �ٽ� �����ϴ� �� ������ �Ѵ�.
			
			wait() �� notify() �� �̿��ؼ� ������ �ϴµ�,,,
		*/
		
		btn.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ){
				System.out.println(">> Click");
				new Thread( canvas ).start();
			}
		});
		
		btnWait.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ){
				System.out.println(">> Wait");
				canvas.setSign( true );
			}
		});
		
		btnNotify.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ){
				System.out.println(">> Notify");
				canvas.setNotify();
			}
		});
		
		setBackground( Color.yellow );
		pack();
	}

	public static void main( String[] args ) {
		new Test223_sol().setVisible( true );
	}
}