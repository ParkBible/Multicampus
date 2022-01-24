#include <stdio.h>

typedef struct temp{
	int data;
	int (*add)(void*, int);
}Temp;

int Temp_add(void* self, int i){
	//Temp* this;
	//this = (Temp*)self;
	return i * 10 + this->data;
}

// Constructor�� ���� : ������ �ʱ�ȭ
// new_Temp ȣ���Ҷ� ȣ��ȴ�.
// �� �뵵�� ����ü ���� �Լ������� �ƴ� �������� �ʱⰪ�� �ش�. �����͸� ���ؼ� ȣ���� �� ����.
void Temp_Constructor(void* self, int i){
	Temp* this;
	this = (Temp*)self;
	
	this->data = i;
}

Temp* new_Temp(int d){
	Temp* tmp;
	tmp = (Temp*)malloc(sizeof(Temp));
	tmp->add = Temp_add;
	Temp_Constructor(tmp, d);
	return tmp;
}

int main(){
	Temp* t;
	t = new_Temp(10);
	// t->Temp_Constructor(...); �����͸� ���� ȣ�� �Ұ���
	t->data = t->add(t,20);
	printf("%d\n", t->data);  // 210
	free(t);
	return 0;
}