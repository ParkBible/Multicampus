
// �ð����� �غ���. ����

public class Test135{
	public static void main(String[] args){
		int minidx = 0;
		int tmp = 0;
		int[] l = {5,2,4,8,1};
		
		minidx = 0;
		
		for(int i=0;i<l.length-1;i++){
			idx = l[i];
			if(minidx > l[i+1]){
				minidx = i+1;
				tmp = l[i+1];
				l[i+1] = idx;
				l[i] = tmp;
			}
		}

		for(int i=0;i<l.length;i++){
			System.out.println(l[i]);
		}
		
		if(minidx > l[1]){
			minidx = 1;
			l[0] = l[minidx];
			
		}
		
	}
}

/*
	������ġ : 0
	1 ������ �ּҰ� ��ġ : 4
	
	�ٸ��� ��ȯ�ϰ�
	��ü�� ����ϼ���.
*/