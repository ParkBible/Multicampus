#include <stdio.h>

int main(){
	int a[4];
	int i, len;
	a[0] = 3;
	a[1] = 6;
	a[2] = 5;
	a[3] = 8;
	
	len = sizeof(a) / sizeof(int); //�迭�� ���� ��� ��
	
	for(i=0; i<4; i++){
		printf("%d\n",a[i]);
	}
	return 0;
}


//3 6 5 8 ��Ҹ� ���� �迭�� �����ϰ� for �ݺ������� ���ô�.

/*
	�迭�� �����ʹ�. '�迭�� ������ ������ ������ ���� �����ϴ�.'
*/