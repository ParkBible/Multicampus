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
	
	/*	ó�� �׸��� ũ�� �����
		-- App �� ĵ������ �ٽ� �׷��� �ʿ䰡 �ִٰ� �ǴܵǴ� �������� ȣ��ȴ�.
	*/
	public void paint( Graphics g ) {
		System.out.println("paint");
		//�ٵ���
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
	
	/*	����ڿ� ���ؼ� �׸��� �ٽ� �׷��� �ʿ䰡 ������ ȣ��Ǵ� �Լ���.
		�����׸��� �ٵ��� > ��ư������ > repaint > update > �ٵ��� �׸��� > ������!!!
		
		��ư�� �����ų� Ŭ���� �Ͼ���� �׸��� �ٽ� �׷����� �� �ʿ䰡 ��������
		update ���� �׸��� �׸��� ����� paint ������ update �� ȣ���ϴ� ���·� �������̵� �� �ش�.
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
			anonymous Ŭ������ �̿��� ��ư�� ���ۿ� ���� �ڵ�
			��ü������������ ������ �ڵ尡 ����� ���ٴ� �� ������ ���� �Ұ����ϴ�...
			
			GUI ���õ� �̺�Ʈó�� , �� XXX ��Ȳ�� �������� �� �����ϴ� �ڵ忡 ���ؼ���
			������ ���� + ��ʴϸӽ� Ŭ���� ... �� ������ ���� ���� �� ����.
			
			- ���ſ��� annoymous Ŭ���������� final �� ����� ���ú����� ��� �����ߴ� ������ �־���
			
			0 0 �Է��Ŀ� ��ư������ ...
			���� 1 : �����⸸ �ϸ� �ȴ�.
			���� 2 : �����Ǿ�� �Ѵ�
			
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