import java.awt.*;
import java.awt.Button;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

// java는 클래스 중복 상속이 안되므로 thread를 상속받는 건 안 된다.
// Runnable을 Thread 생성자에 넣을 수 있으므로 이 방법을 이용한다.
// 이렇게 하면 TCanvas 인스턴스를 Thread에 넣을 수 있다.
class TCanvas extends Canvas implements Runnable{
	
	// 버튼을 눌렀을때 아래의 run()이 UI 쓰레드가 아닌 생성된 쓰레드로 돌아가게 하려면 어떻게 해야 할까?
	public void run(){
		boolean alive = true;
		while(alive){
			increase();   // 멤버함수 추가. 버튼 누를때마다 increase를 호출한다.
			repaint();    // 업데이트를 호출한다
					
			try{
				Thread.sleep(250);
			}
			catch(InterruptedException e2){}
		}
	}
	
	
	private Image img = null;
	private Image[] man = null;    // 이미지 배열을 만들어본다

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
			이 프로그램은 지금 하나의 쓰레드에 의해서 동작하고 있다.
			그 유일한 쓰레드가 버튼 이벤트를 받아들이는 코드도 호출하고
			UI에 대한 업데이트도 처리하고 있다.
			UI 쓰레드라고 부른다.
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