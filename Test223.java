import java.awt.*;
import java.awt.Button;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

// java�� Ŭ���� �ߺ� ����� �ȵǹǷ� thread�� ��ӹ޴� �� �� �ȴ�.
// Runnable�� Thread �����ڿ� ���� �� �����Ƿ� �� ����� �̿��Ѵ�.
// �̷��� �ϸ� TCanvas �ν��Ͻ��� Thread�� ���� �� �ִ�.
class TCanvas extends Canvas implements Runnable{    // ��׶��� ������
	
	// ��ư�� �������� �Ʒ��� run()�� UI �����尡 �ƴ� ������ ������� ���ư��� �Ϸ��� ��� �ؾ� �ұ�?
	public void run(){
		boolean alive = true;
		while(alive){
			if(cont == false){    // stop���� false�� ����� letMeWait ����Լ��� ȣ���Ѵ�. 
				ctrl.letMeWait();
				cont = true;
			}
			
			//ctrl.letMeWait();    // �׳� ȣ���� �� �ƴ϶� ��ư�� ���������� ȣ���ؾ� �Ѵ�.
			
			increase();   // ����Լ� �߰�. ��ư ���������� increase�� ȣ���Ѵ�.
			repaint();    // ������Ʈ�� ȣ���Ѵ�
					
			try{
				Thread.sleep(250);
			}
			catch(InterruptedException e2){}
		}

	}
	
	private boolean cont = true;
	public void stop(){
		cont = false;
	}
	
	
	private Image img = null;
	private Image[] man = null;    // �̹��� �迭�� ������
	private MonitorCtrl ctrl = null;

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

class MonitorCtrl{    // �� �Լ��� ��׶��� �����尡 ȣ���ϰ� ������ �Ѵ�.
	public synchronized void letMeWait(){
		try{
			wait();
		}catch(InterruptedException e2){}
		
	}
	
	public synchronized void letMeNotify(){
		notify();
	}
}

public class Test223 extends Frame 
{
	public Test223() {
		Button btn = new Button("Click");
		Button btnWait = new Button("Wait");
		Button btnNotify = new Button("Notify");
		
		MonitorCtrl c2 = new MonitorCtrl();
		
		final TCanvas canvas = new TCanvas();
		setLayout( new FlowLayout() );
		add( btn );
		add( btnWait );
		add( btnNotify );
		
		add( canvas );
		
		/*
			btnWait�� ������ ���� �������� �ִϸ��̼��� ����� �Ѵ�.
			btnNotify�� ������ ���� �ִϸ��̼��� �ٽ� �����ϴ� �� ������ �Ѵ�.
			
			wait()�� notify()�� �̿��ؼ� ������ �Ѵ�.
			
			wait()�� ��׶��� �����带 ���߰� �ؾ��Ѵ�.
			������ Object�� ����� �� ��ü�� �Լ��� ȣ���ϸ� ������ ���� wait()�Ǵ� �ڵ带 ���� ���߰� �� �� �ִ�.
			��׶��� �����尡 ȣ���ϰ� ���� ���ϰ� �ϸ� �ȴ�.
			
			UI �������ؼ� ������ ���� ��ü�� notify�� ȣ���ϵ��� �Լ��� ����� ȣ���ϸ�?
			�ش� ��ü�� ���缼���� ��׶��� �����尡 �ٽ� �����ϰ� �ȴ�.
		*/

		btn.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				//canvas.start();
				Thread t = new Thread(canvas);    // UI������. ������ �����带 ������ ������ �����ϰ� ����
				t.start();
			}
		});
		
		btnWait.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				canvas.stop();
			}
		});
		
		btnNotify.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				c2.letMeNotify();
			}
		});
		
		setBackground( Color.yellow );
		pack();
	}

	public static void main( String[] args ) {
		new Test223().setVisible( true );
	}
}