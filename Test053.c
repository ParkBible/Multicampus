#include <stdio.h>

int* temp(){
	int i;
	i = 100;
	return &i;
}

int main(){
	int *t;
	
	t = temp();
	printf("%d\n", *t);
	return 0;
}

/*
	warning�� �ߴ� ������? : temp()�� ���ú����� i�� �Լ��� ������ ������Ƿ�,
	i�� �������� ����Ű�� ���ϰ��� ��� �ߴ� ��.
	������ ¥�� �ȵǴµ� ������ ¥�� ������� ���Ƽ� ������ڴ� �ǰ��� ��εǾ���.
	(�ٸ� ������ �����ͷ� ����Ű�� ���ú����� �����)
	
int strlen2(char* a){
	return strlen(*a);
	}

int main(){
	char* str;
	int res;
	str = "HelloWorld\0";
	
	res = strlen(str);
	printf("%d\n", res);
	
	return 0;
}

	�Ʊ� ���� § �ڵ忡�� warning�� �� ������... *a ���� �Ѱ�� ����. a�� �ѱ�� ���׾ȶ�
*/