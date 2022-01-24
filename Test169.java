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
	public XFrame(){    // ������
		Panel p1 = new Panel();
		p1.add(new XCanvas());
	
		Panel p2 = new Panel();
		//p2.add(new TextField(24));
		
		Button btn = new Button("Click");
		
		TextField tf = new TextField(24);
		tf.setText("apple banana...");
		btn.addActionListener(new Apple(tf));    // ������ �Լ��� �������Ѵ�. �����ڴ� ���� ��������� �ʱ�ȭ�ϹǷ�.
		
		p2.add(tf);
		p2.add(btn);
		//btn.addActionListener(new Apple());    // Button�� �޼ҵ�, addActionListener�� ȣ��.
												// addActionListener�� �Ű������� ActionListener�̹Ƿ�
												// ActionListener�� ��ӹ��� Ŭ���� Apple�� �ν��Ͻ��� �ִ´�.
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		this.setSize(600,360);
		this.setVisible(true);
	}
}

// ������. ���� ����� ��ư���� �׼��� �߻��ϸ� ���� ����
class Apple implements ActionListener{
	// ��ư�� ���������� �ؽ�Ʈâ�� ������ �Ѹ��� �Ϸ���
	private TextField tf2 = null;
	public Apple(TextField t){
		this.tf2 = t;
	}
	
	public void actionPerformed(ActionEvent e){    // �������̵�.
		System.out.println("Apple::actionPerformed");    // ��ư ������ �� ���� ��µ�.
		System.out.println(tf2.getText());
	}
}

public class Test169{
	public static void main( String[] args ){
		Frame f = new XFrame();    // �ν��Ͻ� ����� â�� ���´�. f�� ���Ծ��ص�, �ص� ����.
	}
}

/*
public void addActionListener(ActionListener l)
ActionListener �� �����ô���
actionPerformed ��� ����Լ��� �ִ�.

�ռ� ��� ������ ������ �״�� ����Ǵ� ���̽��̴�.
Button : �������
Apple : ������
�� �� ���̴� ActionListener��� �������̽��� �����ϰ� ����Ǿ� �ְ�,
Button�� Action ��Ȳ�� �������� addActionListener�� ��ϵ� �����ڰ� �������̵��ϴ�
actionPerformed�� ȣ��ǰ� �Ǵ� ����.
*/