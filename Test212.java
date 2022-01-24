import java.io.File;

public class Test212 {
	public static void main( String[] args ) {
		File f = new File("C:\\MP3\\01.mp3");
		System.out.println(f.exists());     // 저 경로에 있으면 true, 없으면 false 출력
		
		File d = new File("C:\\MP3\\");
		System.out.println(d.exists());
		
		String[] lst = d.list();    // 폴더에 존재하는 작업목록
		for(String l : lst){
			System.out.println(l);
		}
		
		File f2 = new File("C:\\MP3\\17.mp3");
		if(f2.exists()){
			f2.delete();    // 삭제
		}
		
		File f3 = new File("C:\\MP3\\16.mp3");
		if(f3.exists()){
			f3.renameTo(new File("C:\\MP3\\16x.mp3"));    // 이름을 16x.mp3로 변경
		}
		
		File f4 = new File("C:\\MP3\\15.mp3");
		long size = f4.length();    // 파일의 바이트 수
		System.out.println(size);
		System.out.println(f4.getParent());    // 상위폴더명
	}
}

/*
	java.io.File
	: 파일/폴더의 정보를 추출하는 용도로 주로 사용된다.
*/