#include <stdio.h>

struct apple{
	int value;
	int name;
};

int main(){
	struct apple i;
	struct apple* t;
	
	t = &i;
	i.value = 123;
	t->name = 456;
	
	printf("%d\n", t->value);    // 123
								// t�� �������̹Ƿ� t.value�� �ƴ϶� t->value�� �ؾ� �Ѵ�.
	printf("%d\n", i.name); 
	return 0;
}

/*
	i.value
	t->value
	
	�����Ϳ� �������� ���� ����� ���̰� �ִ°��� ��ư ���� �Ȱ���.
	�����ͷ� �����ؼ� i�� 100���ִ°Ŷ� ���������� �����ؼ� i�� 100�� �ִ°Ŷ� ���� ��.
	
	gcc Test056.c -o test.exe
*/