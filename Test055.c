#include <stdio.h>

// ����ü : ���ο� Ÿ��(������)�� �ڷ����� ������ ������ �ϴ� ���� ��
// �ڷ����� �ϳ��� ���� ���� ���������� ����ü�� ����� ������ �������� ���� ���� �� �ִ�.

struct apple{
	int name;
	int value;
};

int main(){
	struct apple i;
	i.name = 100;
	i.value = 200;
	
	printf("%d %d\n", i.name, i.value);  // �ϳ��� ������ �ΰ� �� ����
	return 0;
}