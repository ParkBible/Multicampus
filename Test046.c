#include <stdio.h>
#include <string.h>

int main(){
	char l[7] = "Apple\0";
	char* t = "Hello\0";
	int len;
	
	
	printf("%s\n", l);
	printf("%d\n", strlen(l));
	printf("%s\n", t);
	printf("%d\n", strlen(t));
	
	return 0;
}

/*
	java������ ���ڿ��� String���� �������
	int[] i = {1,2};
	Apple�@u??P�@?@  // char l[5] = "Apple"; �����Ⱚ�� ���.
	
	char l[5] = "Apple\0"; �̶�� ��������Ѵ�.(�������� \0���� ������ �Ѵ�.)
	
	�迭�� ������ �����Ϳ� ���� �����ϴϱ� ���� ���� �����ͷ� ���ڿ��� ����ص� �迭�� ���� �����̴�.
	
	���ڿ��� ���̸� �� ���� \0�� ������� �ʾƾ� �ϱ� ������ sizeof���ٴ� strlen �Լ��� ��.
	c���� boolean �ڷ����� ����.
	�������� ���µ� 0�� false, 0�� �ƴѰ͵��� true
*/