#include <stdio.h>

int main(){
	int i;
	float j;
	void* vp;
	int* t;
	
	i = 100;
	vp = &i;
	printf("%d\n", *((int*)vp));
	
	t = (int*)vp;
	printf("%d\n", t); // ����11�� �Ȱ��� ���.
	
	j = 3.14;
	vp = &j;
	printf("%f\n", *((float*)vp));
	
	return 0;
}

/*
	void* �� ��� �����Ҹ� ����ų �� �ִ� �������̴�.(������ �Ǽ��� ����ü ����ü...)
	��, �ش� ������ �ȿ� ����� ���뿡 ������ ���� �ش� Ÿ������ ĳ���� ���־�� �Ѵ�.
*/