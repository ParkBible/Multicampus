#include <stdio.h>
#include <string.h>

int starts_with(char* i, char* j){
	int k;
	int res = 1;
	for(k=0; k<strlen(j); k++){   // strlen ��� *(j+k) �� j[k]�� �Է��ص� �ȴ�.
		if(i[k] != j[k]){
			res = 0;
			break;  // break ��� �׳� return 0;�� �ص� ��. return�� ������ �Լ��� ������.
		}
	}
	return res;
}

int main(){
	int a;
	a = starts_with("HelloWorld\0", "Hella\0");
	printf("%d\n", a);
	
	return 0;
}

//gcc Test059.c -o test.exe

/*
	�־��� ������ �־��� ���ξ�� �����ϸ� 1, �ƴϸ� 0�� �����ϴ� �Լ��� �����ϼ���
	¥�ٺ��� �ݺ��Ǵ� �κ��� �ִ�. �ܿ��. ��Ծ ����.
*/