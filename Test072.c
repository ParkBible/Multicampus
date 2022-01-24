#include <stdio.h>

typedef struct temp{
	int data;
}Temp;

/*
	�ڹٿ��� new �ϸ� �������� ��
	1. �޸� Ȯ��(malloc)
	2. ����Լ� �����͸� ��ü�� ����
	3. ������ ȣ��
	
	Ư¡
	- �����ڴ� �ܺο��� �����ͷ� ���� �Ұ�. t->TempConstructor(...);
	- new ... �ϴ� �������� ȣ��ȴ�.
	- �ַ� ������� �ʱ�ȭ �뵵�� ���
	- this�� ��밡��.
	- �Ű����� ������ ���� ���
*/

//this = tmp;

void TempConstructor(Temp* this, int i){
	this->data = i;
}

Temp* new_Temp(int i){
	Temp* tmp;
	tmp = (Temp*)malloc(sizeof(Temp));
	TempConstructor(tmp, i);
	return tmp;
}

int main(){
	Temp* t;
	t = new_Temp(100);
	printf("%d\n",t->data);
	free(t);
	return 0;
}