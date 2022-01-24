import java.io.File;

public class Test212 {
	public static void main( String[] args ) {
		File f = new File("C:\\MP3\\01.mp3");
		System.out.println(f.exists());     // �� ��ο� ������ true, ������ false ���
		
		File d = new File("C:\\MP3\\");
		System.out.println(d.exists());
		
		String[] lst = d.list();    // ������ �����ϴ� �۾����
		for(String l : lst){
			System.out.println(l);
		}
		
		File f2 = new File("C:\\MP3\\17.mp3");
		if(f2.exists()){
			f2.delete();    // ����
		}
		
		File f3 = new File("C:\\MP3\\16.mp3");
		if(f3.exists()){
			f3.renameTo(new File("C:\\MP3\\16x.mp3"));    // �̸��� 16x.mp3�� ����
		}
		
		File f4 = new File("C:\\MP3\\15.mp3");
		long size = f4.length();    // ������ ����Ʈ ��
		System.out.println(size);
		System.out.println(f4.getParent());    // ����������
	}
}

/*
	java.io.File
	: ����/������ ������ �����ϴ� �뵵�� �ַ� ���ȴ�.
*/