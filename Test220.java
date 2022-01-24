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

public class Test220 extends Frame 
{
	public Test220() {
		Button btn = new Button("Click");
		final TCanvas canvas = new TCanvas();
		setLayout( new FlowLayout() );
		add( btn );
		add( canvas );

		btn.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				canvas.increase();   // 멤버함수 추가. 버튼 누를때마다 increase를 호출한다.
				canvas.repaint();    // 업데이트를 호출한다
			}
		});
		
		setBackground( Color.yellow );
		pack();
	}

	public static void main( String[] args ) {
		new Test220().setVisible( true );
	}
}