import java.awt.*;
import java.awt.Button;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

// java는 클래스 중복 상속이 안되므로 thread를 상속받는 건 안 된다.
// Runnable을 Thread 생성자에 넣을 수 있으므로 이 방법을 이용한다.
// 이렇게 하면 TCanvas 인스턴스를 Thread에 넣을 수 있다.
class TCanvas extends Canvas implements Runnable{    // 백그라운드 쓰레드
	
	// 버튼을 눌렀을때 아래의 run()이 UI 쓰레드가 아닌 생성된 쓰레드로 돌아가게 하려면 어떻게 해야 할까?
	public void run(){
		boolean alive = true;
		while(alive){
			if(cont == false){    // stop에서 false로 만들면 letMeWait 멤버함수를 호출한다. 
				ctrl.letMeWait();
				cont = true;
			}
			
			//ctrl.letMeWait();    // 그냥 호출할 게 아니라 버튼이 눌러졌을때 호출해야 한다.
			
			increase();   // 멤버함수 추가. 버튼 누를때마다 increase를 호출한다.
			repaint();    // 업데이트를 호출한다
					
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
	private Image[] man = null;    // 이미지 배열을 만들어본다
	private MonitorCtrl ctrl = null;

	public TCanvas() {
		try{
			man = new Image[2];
			man[0] = ImageIO.read(new File("C:\\JavaWork\\man1.png"));
			man[1] =ImageIO.read(new File("C:\\JavaWork\\man2.png"));
			img = ImageIO.read(new File("C:\\JavaWork\\back.gif"));
		}
		catch(IOException e){e.printStackTrace();}    // printStackTrace 해주면 에러 찾기가 더 쉽다.
		setSize( 320, 480 );    // 배경
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(img, 0, 0, this);    // 이미지 옵저버. img를 출력해준다.
		g2.drawImage(man[count%2], 20, 20, this);
		g2.dispose();    // 다쓰고나면 호출, 호출안해도 자동호출
	}
	
	private int count = 0;
	public void increase(){
		count++;
	}
}

class MonitorCtrl{    // 이 함수는 백그라운드 쓰레드가 호출하게 만들어야 한다.
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
			btnWait를 누르면 현재 동작중인 애니메이션이 멈춰야 한다.
			btnNotify를 누르면 멈춘 애니메이션이 다시 동작하는 걸 만들어야 한다.
			
			wait()와 notify()를 이용해서 만들어야 한다.
			
			wait()로 백그라운드 쓰레드를 멈추게 해야한다.
			별도의 Object를 만들고 그 객체의 함수를 호출하면 역으로 내가 wait()되는 코드를 통해 멈추게 할 수 있다.
			백그라운드 쓰레드가 호출하고 멈춤 당하게 하면 된다.
			
			UI 쓰레드해서 별도로 만든 객체가 notify를 호출하도록 함수를 만들고 호출하면?
			해당 객체가 멈춰세웠던 백그라운드 쓰레드가 다시 동작하게 된다.
		*/

		btn.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				//canvas.start();
				Thread t = new Thread(canvas);    // UI쓰레드. 별도의 쓰레드를 만들지 않으면 유일하게 존재
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