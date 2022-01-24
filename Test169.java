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

class XCanvas extends Canvas{
	public XCanvas(){
		setSize(500,200);
		setBackground(Color.YELLOW);
	}
	
}

class XFrame extends Frame{
	public XFrame(){    // 생성자
		Panel p1 = new Panel();
		p1.add(new XCanvas());
	
		Panel p2 = new Panel();
		//p2.add(new TextField(24));
		
		Button btn = new Button("Click");
		
		TextField tf = new TextField(24);
		tf.setText("apple banana...");
		btn.addActionListener(new Apple(tf));    // 생성자 함수를 만들어야한다. 생성자는 보통 멤버변수를 초기화하므로.
		
		p2.add(tf);
		p2.add(btn);
		//btn.addActionListener(new Apple());    // Button의 메소드, addActionListener를 호출.
												// addActionListener의 매개변수는 ActionListener이므로
												// ActionListener를 상속받은 클래스 Apple의 인스턴스를 넣는다.
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		this.setSize(600,360);
		this.setVisible(true);
	}
}

// 관찰자. 관찰 대상인 버튼에서 액션이 발생하면 동작 수행
class Apple implements ActionListener{
	// 버튼이 눌러졌을때 텍스트창의 내용을 뿌리게 하려면
	private TextField tf2 = null;
	public Apple(TextField t){
		this.tf2 = t;
	}
	
	public void actionPerformed(ActionEvent e){    // 오버라이딩.
		System.out.println("Apple::actionPerformed");    // 버튼 누르면 이 문장 출력됨.
		System.out.println(tf2.getText());
	}
}

public class Test169{
	public static void main( String[] args ){
		Frame f = new XFrame();    // 인스턴스 만들면 창이 나온다. f에 대입안해도, 해도 나옴.
	}
}

/*
public void addActionListener(ActionListener l)
ActionListener 를 눌러봤더니
actionPerformed 라는 멤버함수가 있다.

앞서 배운 관찰자 패턴이 그대로 적용되는 케이스이다.
Button : 관찰대상
Apple : 관찰자
이 둘 사이는 ActionListener라는 인터페이스로 느슨하게 연결되어 있고,
Button의 Action 상황이 벌어지면 addActionListener로 등록된 관찰자가 오버라이딩하는
actionPerformed가 호출되게 되는 설계.
*/