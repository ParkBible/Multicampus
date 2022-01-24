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
	public XCanvas() {
		setSize( 500, 200 );
		setBackground( Color.YELLOW );
	}
}


class XFrame extends Frame implements ActionListener {
	public XFrame() {    // 생성자
		Panel p1 = new Panel();
		p1.add( new XCanvas() );
		
		Button btn = new Button("Click");
		//TextField tf = new TextField( 24 );
		tf2 = new TextField( 24 );
		
		btn.addActionListener( this ); // Q1. 버튼 누르면 아무거나 찍게. 20줄에 implements ActionListener가 필요함...
		
		Panel p2 = new Panel();
		p2.add( tf2 );
		p2.add( btn );
		
		add( p1 , BorderLayout.CENTER );
		add( p2 , BorderLayout.SOUTH );
		
		setSize( 600, 360 );
		setVisible( true );
	}
	
	private TextField tf2 = null;    // 멤버변수
	/*
		actionPerformed에서 if(tf2 != null) 이 반드시 필요한가?
		이 코드에서는 생성자가 실행된 다음 actionPerformed가 실행되므로 tf2가 null일 수가 없다.
	*/
	
	public void actionPerformed(ActionEvent e){
		System.out.println("....");
		System.out.println( tf2.getText() );    //Q2. 버튼을 누르면 텍스트창에 친 문자가 출력되게 한다.
												// t2가 생성자의 로컬변수일 때는 이쪽(actionPerformed)으로 전달이 안된다.
												// 고로 tf2를 멤버변수로 한다. 생성자 밖에서 선언하고 생성자에서 값 넣어주면 됨
	}
}

public class Test171 {
	public static void main( String[] args ) {
		Frame f = new XFrame();
	}
}
/*
public void addActionListener(ActionListener l)

java.awt.event
Interface ActionListener
	void actionPerformed(ActionEvent e)
	
	앞서 배운 관찰자 패턴이 그대로 적용되는 케이스다.
	Button : 관찰대상
	Apple : 관찰자 
	이 둘사이는 ActionListener 라는 인터페이스로 느슨하게 연결되어 있고 
	
	Button 의 Action 상황이 벌어지면 addActionListener 로 등록된 관찰자가 오버라이딩하는 
		actionPerformed 가 호출되게 되는 설계.
*/