#include <stdio.h>

int main(){
	int i;
	float j;
	i = 100;
	i = i + 1;
	printf("%d\n", i);
	j = i;
	printf("%f\n", j);
	i = 3.14;
	printf("%d\n", i); // 3
	
	return 0;
}

/*
	�����Ϸ����� ���̰� ������ gcc�� �Ǽ������� float �ֿ�.
	�������� �Ǽ��� ������ �����ϸ� �ڵ� ����ȯ�Ǿ� ���Եȴ�.
	�Ǽ����� ������ ������ �־ �ڵ� ����ȯ�ȴ�.
*/