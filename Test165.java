import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*
	Canvas : 선을 긋고 그림을 그리고 이미지를 보여주는 역할 수행.
	paint 함수를 오버라이딩해서 그림을 그려준다.(뻥. 지금은 그리 생각하자)
	
	HTML5에서 쓰이는 Canvas 등에 많이 영향을 미쳤고 안드로이드 등에도 비슷하게 사용되는 것이 있다.
	공부는 이걸로 하고 다른 GUI 프로그래밍 시에는 거의 비슷.
*/

class XCanvas extends Canvas{
	public XCanvas(){
		setSize(500,200);
		setBackground(Color.YELLOW);
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.BLACK);
		g2.drawRect(10, 10, 50, 50);
		
		//나중에 그린게 이전에 그린거 덮어버린다.
		g2.setColor(Color.GREEN);
		g2.fillRect(40, 40, 100, 50);
	}
}

class XFrame extends Frame{
	public XFrame(){    // 생성자
		Panel p1 = new Panel();
		p1.add(new XCanvas());
	
		Panel p2 = new Panel();
		p2.add(new TextField(24));
		p2.add(new Button("Click"));
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		this.setSize(600,360);
		this.setVisible(true);
	}
}

public class Test165{
	public static void main( String[] args ){
		Frame f = new XFrame();    // 인스턴스 만들면 창이 나온다. f에 대입안해도, 해도 나옴.
	}
}

/*
	상속과 생성자를 이용해서 같은 코드.
	Frame을 상속받은 클래스로 열어도 창이 뜬다.
*/