#include <stdio.h>

int add(int i, int j){
	return 100;
}

int add_v2(int i, int j){
	return 102;
}

int main(){
	int (*fp)(int, int); // �Լ�������. ����Ÿ���� int, �Ű������� (int, int)�� add��� �Լ��� ����Ű�� �����̴�.
	fp = add;
	fp = add_v2;  // ���ĸ� �´ٸ� ����Ű�� �Լ��� ���浵 �����Ӵ�!(��ºκ� ���� ���ʿ�)
	printf("%d\n", fp(10, 20));
	return 0;
}

/*
	�������忡�� ���ϱ� ����� �η��� �� �ΰ����� �Ⱑ ������ ������...
	1. void ������
	2. �Լ�(function) ������
	
	�̰� �𸣸� js �� ����...
*/