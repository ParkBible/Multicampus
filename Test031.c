#include <stdio.h>

int main(){
	int l[4];
	int i;
	int max;
	l[0] = 3;
	l[1] = 15;
	l[2] = 9;
	l[3] = 10;
	max = l[0];
	
	for(i=0; i<4; i++){
		if(l[i] > max){
			max = l[i];
		}
	}
	
	printf("%d\n", max);
	return 0;
}

/*
	gcc Test031.c -o test.exe
	int l[4] = {3, 7, 9, 10}; //�� ������ ���� ������. ���� ������ ��� ���Ѵ�.
	Q. �迭�� ����ִ� ���� �� �ִ밪�� ���ϴ� �ڵ�
*/