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
	Canvas : ���� �߰� �׸��� �׸��� �̹����� �����ִ� ���� ����.
	paint �Լ��� �������̵��ؼ� �׸��� �׷��ش�.(��. ������ �׸� ��������)
	
	HTML5���� ���̴� Canvas � ���� ������ ���ư� �ȵ���̵� ��� ����ϰ� ���Ǵ� ���� �ִ�.
	���δ� �̰ɷ� �ϰ� �ٸ� GUI ���α׷��� �ÿ��� ���� ���.
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
		
		//���߿� �׸��� ������ �׸��� ���������.
		g2.setColor(Color.GREEN);
		g2.fillRect(40, 40, 100, 50);
	}
}

class XFrame extends Frame{
	public XFrame(){    // ������
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
		Frame f = new XFrame();    // �ν��Ͻ� ����� â�� ���´�. f�� ���Ծ��ص�, �ص� ����.
	}
}

/*
	��Ӱ� �����ڸ� �̿��ؼ� ���� �ڵ�.
	Frame�� ��ӹ��� Ŭ������ ��� â�� ���.
*/