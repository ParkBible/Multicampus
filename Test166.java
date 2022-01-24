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
		//g2.drawRect(10, 10, 50, 50);    // �� ������... (��������ġ x, y, ���α���, ���α���)
		
		//���߿� �׸��� ������ �׸��� ���������.
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

public class Test166{
	public static void main( String[] args ){
		Frame f = new XFrame();    // �ν��Ͻ� ����� â�� ���´�. f�� ���Ծ��ص�, �ص� ����.
	}
}

/*
	��Ӱ� �����ڸ� �̿��ؼ� ���� �ڵ�.
	Frame�� ��ӹ��� Ŭ������ ��� â�� ���.
	
	���� �ʹ����� �ٶ�� �� ä���ְ� ���� �ʹ� �η����ϴ� �װ� �����ְڴٴ� ����� �����ض�.
	���� ���������� ������� ����� ������ �ָ��ض�. --> �ҽÿ��н�.
	--> ���� �ΰ����踦 �� ����������� ����� �����ض�.
	��� ���� �ҽÿ��н�, �̹����̼� ����
*/