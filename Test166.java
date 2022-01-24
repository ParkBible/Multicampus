import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

class XCanvas extends Canvas{
	public XCanvas(){
		setSize(500,200);
		setBackground(Color.YELLOW);
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		
		//g2.setColor(Color.BLACK);
		//g2.drawRect(10, 10, 50, 50);    // 내 생각엔... (시작점위치 x, y, 가로길이, 세로길이)
		
		//나중에 그린게 이전에 그린거 덮어버린다.
		g2.setColor(Color.GREEN);
		/*
		for(int i=0; i<6; i++){
			g2.fillRect(100*i, 0, 50, 50);
			g2.fillRect(50+100*i, 50, 50, 50);
			g2.fillRect(100*i, 100, 50, 50);
			g2.fillRect(50+100*i, 150, 50, 50);
			g2.fillRect(100*i, 200, 50, 50);
		}
		*/
		
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

public class Test166{
	public static void main( String[] args ){
		Frame f = new XFrame();    // 인스턴스 만들면 창이 나온다. f에 대입안해도, 해도 나옴.
	}
}

/*
	상속과 생성자를 이용해서 같은 코드.
	Frame을 상속받은 클래스로 열어도 창이 뜬다.
	
	내가 너무나도 바라던 걸 채워주고 내가 너무 두려워하던 그걸 막아주겠다는 사람을 조심해라.
	나를 의존적으로 만들려는 사람은 무조건 멀리해라. --> 소시오패스.
	--> 너의 인간관계를 다 끊어버리려는 사람을 조심해라.
	당신 옆의 소시오패스, 이미테이션 게임
*/