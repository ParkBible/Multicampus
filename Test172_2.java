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

class XCanvas extends Canvas {
	private String tf2 = null;
	
	public XCanvas() {
		setSize( 500, 200 );
		setBackground( Color.YELLOW );
	}
	
	/*	처음 그리고 크기 변경시
		-- App 이 캔버스가 다시 그려질 필요가 있다고 판단되는 시점에서 호출된다.
	*/
	public void paint( Graphics g ) {
		System.out.println("paint");
		//바둑판
		Graphics2D g2 = (Graphics2D)g;
		for(int i=0; i<10; i++){
			for(int j=0; j<4; j++){
				if((i+j)%2 == 0){
					g2.setColor(Color.WHITE);
				}
				else{
					g2.setColor(Color.BLACK);
				}
				g2.fillRect(i*50, j*50, 50, 50);
			}
		}
		update(g);
		
	}
	
	/*	사용자에 의해서 그림이 다시 그려질 필요가 있을때 호출되는 함수다.
		기존그림은 바둑판 > 버튼눌렀다 > repaint > update > 바둑판 그리고 > 점찍자!!!
		
		버튼을 누르거나 클릭이 일어났을때 그림이 다시 그려져야 할 필요가 있을때는
		update 에서 그림을 그리게 만들고 paint 에서는 update 를 호출하는 형태로 오버라이딩 해 준다.
	*/
	public void update( Graphics g ) {
		System.out.println("update");
		if(tf2 == "0 0"){
			System.out.println("dd");
		}
	}	
}

class XFrame extends Frame {
	public XFrame() {
		Panel p1 = new Panel();
		final XCanvas xc = new XCanvas();
		p1.add( xc );
		
		Button btn = new Button("Click");
		/*
			anonymous 클래스를 이용한 버튼의 동작에 따른 코드
			객체지향적이지는 않지만 코드가 깔끔해 진다는 건 도저히 부정 불가능하다...
			
			GUI 관련된 이벤트처리 , 즉 XXX 상황이 벌어졌을 때 동작하는 코드에 대해서는
			관찰자 패턴 + 어너니머스 클래스 ... 의 조합은 거의 피할 수 없다.
			
			- 과거에는 annoymous 클래스에서는 final 로 선언된 로컬변수를 사용 가능했던 시절이 있었음
			
			0 0 입력후에 버튼누르면 ...
			과제 1 : 찍히기만 하면 된다.
			과제 2 : 누적되어야 한다
			
		*/
		final TextField tf = new TextField( 24 );
		btn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println( tf.getText() );
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

public class Test172_2 {
	public static void main( String[] args ) {
		new XFrame();
	}
}
/*
public void addActionListener(ActionListener l)

java.awt.event
Interface ActionListener
	void actionPerformed(ActionEvent e)
*/