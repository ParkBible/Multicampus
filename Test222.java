import java.awt.*;
import java.awt.Button;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

// java�� Ŭ���� �ߺ� ����� �ȵǹǷ� thread�� ��ӹ޴� �� �� �ȴ�.
// Runnable�� Thread �����ڿ� ���� �� �����Ƿ� �� ����� �̿��Ѵ�.
// �̷��� �ϸ� TCanvas �ν��Ͻ��� Thread�� ���� �� �ִ�.
class TCanvas extends Canvas implements Runnable{
	
	// ��ư�� �������� �Ʒ��� run()�� UI �����尡 �ƴ� ������ ������� ���ư��� �Ϸ��� ��� �ؾ� �ұ�?
	public void run(){
		boolean alive = true;
		while(alive){
			increase();   // ����Լ� �߰�. ��ư ���������� increase�� ȣ���Ѵ�.
			repaint();    // ������Ʈ�� ȣ���Ѵ�
					
			try{
				Thread.sleep(250);
			}
			catch(InterruptedException e2){}
		}
	}
	
	
	private Image img = null;
	private Image[] man = null;    // �̹��� �迭�� ������

	public TCanvas() {
		try{
			man = new Image[2];
			man[0] = ImageIO.read(new File("C:\\JavaWork\\man1.png"));
			man[1] =ImageIO.read(new File("C:\\JavaWork\\man2.png"));
			img = ImageIO.read(new File("C:\\JavaWork\\back.gif"));
		}
		catch(IOException e){e.printStackTrace();}    // printStackTrace ���ָ� ���� ã�Ⱑ �� ����.
		setSize( 320, 480 );    // ���
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(img, 0, 0, this);    // �̹��� ������. img�� ������ش�.
		g2.drawImage(man[count%2], 20, 20, this);
		g2.dispose();    // �پ����� ȣ��, ȣ����ص� �ڵ�ȣ��
	}
	
	private int count = 0;
	public void increase(){
		count++;
	}
}

public class Test222 extends Frame 
{
	public Test222() {
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
			�� ���α׷��� ���� �ϳ��� �����忡 ���ؼ� �����ϰ� �ִ�.
			�� ������ �����尡 ��ư �̺�Ʈ�� �޾Ƶ��̴� �ڵ嵵 ȣ���ϰ�
			UI�� ���� ������Ʈ�� ó���ϰ� �ִ�.
			UI �������� �θ���.
		*/

		btn.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				//canvas.start();
				Thread t = new Thread(canvas);    // !!
				t.start();
			}
		});
		
		btnWait.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				System.out.println("apple");
			}
		});
		
		btnNotify.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				System.out.println("banana");
			}
		});
		
		setBackground( Color.yellow );
		pack();
	}

	public static void main( String[] args ) {
		new Test222().setVisible( true );
	}
}