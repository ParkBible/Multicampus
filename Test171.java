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
	public XFrame() {    // ������
		Panel p1 = new Panel();
		p1.add( new XCanvas() );
		
		Button btn = new Button("Click");
		//TextField tf = new TextField( 24 );
		tf2 = new TextField( 24 );
		
		btn.addActionListener( this ); // Q1. ��ư ������ �ƹ��ų� ���. 20�ٿ� implements ActionListener�� �ʿ���...
		
		Panel p2 = new Panel();
		p2.add( tf2 );
		p2.add( btn );
		
		add( p1 , BorderLayout.CENTER );
		add( p2 , BorderLayout.SOUTH );
		
		setSize( 600, 360 );
		setVisible( true );
	}
	
	private TextField tf2 = null;    // �������
	/*
		actionPerformed���� if(tf2 != null) �� �ݵ�� �ʿ��Ѱ�?
		�� �ڵ忡���� �����ڰ� ����� ���� actionPerformed�� ����ǹǷ� tf2�� null�� ���� ����.
	*/
	
	public void actionPerformed(ActionEvent e){
		System.out.println("....");
		System.out.println( tf2.getText() );    //Q2. ��ư�� ������ �ؽ�Ʈâ�� ģ ���ڰ� ��µǰ� �Ѵ�.
												// t2�� �������� ���ú����� ���� ����(actionPerformed)���� ������ �ȵȴ�.
												// ��� tf2�� ��������� �Ѵ�. ������ �ۿ��� �����ϰ� �����ڿ��� �� �־��ָ� ��
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
	
	�ռ� ��� ������ ������ �״�� ����Ǵ� ���̽���.
	Button : �������
	Apple : ������ 
	�� �ѻ��̴� ActionListener ��� �������̽��� �����ϰ� ����Ǿ� �ְ� 
	
	Button �� Action ��Ȳ�� �������� addActionListener �� ��ϵ� �����ڰ� �������̵��ϴ� 
		actionPerformed �� ȣ��ǰ� �Ǵ� ����.
*/