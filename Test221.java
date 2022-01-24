import java.awt.*;
import java.awt.Button;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

class TCanvas extends Canvas {
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

public class Test221 extends Frame 
{
	public Test221() {
		Button btn = new Button("Click");
		final TCanvas canvas = new TCanvas();
		setLayout( new FlowLayout() );
		add( btn );
		add( canvas );
		
		/*
			이 프로그램은 지금 하나의 쓰레드에 의해서 동작하고 있다.
			그 유일한 쓰레드가 버튼 이벤트를 받아들이는 코드도 호출하고
			UI에 대한 업데이트도 처리하고 있다.
			UI 쓰레드라고 부른다.
		*/

		btn.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				System.out.println("Click");
				
				canvas.increase();   // 멤버함수 추가. 버튼 누를때마다 increase를 호출한다.
				canvas.repaint();    // 업데이트를 호출한다
				
				/*
					흔히 GUI 응용프로그램을 만들면 UI를 최신반영하는 쓰레드를 UI 쓰레드라고 한다.
					그리고 별도의 쓰레드를 만들지 않으면 프로그램은 UI 쓰레드가 된다.
					그런데 아래 코드는 UI 쓰레드를 최소 50초간 독점하고 있다. (250ms * 200)
					그 시간동안 UI는 먹통이 되고 그림을 반영하지 않고, 버튼 입력을 처리하지도 못한다.
					
					안드로이드 프로그래밍에서는 UI를 변경하는 작업은 반드시 UI 쓰레드에서 하도록 해야 하고
					그것을 위해서는 UI 쓰레드쪽에 '의뢰'하는 형태로 UI를 변경하도록 해야 한다는 원칙이 있다.
					(별도의 생성된 쓰레드에서 직접 UI를 변경하지 않는다. - 안드로이드에선)
					
				*/
				/*
				for(int i=0; i<200; i++){
					canvas.increase();   // 멤버함수 추가. 버튼 누를때마다 increase를 호출한다.
					canvas.repaint();    // 업데이트를 호출한다
					
					try{
						Thread.sleep(250);
					}
					catch(InterruptedException e2){}
				}
				*/
				
			}
		});
		
		setBackground( Color.yellow );
		pack();
	}

	public static void main( String[] args ) {
		new Test221().setVisible( true );
	}
}