#include <stdio.h>

/*
	����ü �ȿ� ����� ��� �Լ��� ù��° �Ű����� ���´� void*�� �Ѵ�.
	Temp* this;
	this = (Temp*)self;
	�� �ڵ带 �� ���κп� ���ֵ��� �Ѵ�.
	
	�̷��� ���� �Լ� ȣ��ÿ� t->add(t, 20); �� ���� ��.
	-> ���ʿ��� ����� ������ �Ű������� ù��°�� �־��ش�.
	
	add���忡���� �ڽ��� ���Ͽ� �ִ� �޸𸮰����� this�� ����Ű�� �ִ�.
	��, this �����ʹ� �ڱ� �ڽ��� �����ִ� ����ü�� ����Ű�� �ǰ�, ����ü ���� ������ �Լ��� ���� �����ϴ�.
	
	
	
*/

typedef struct temp{
	int data;
	int (*add)(void*, int);
}Temp;

int Temp_add(void* self, int i){
	Temp* this;
	this = (Temp*)self;
	return i * 10 + this->data;
}

Temp* new_Temp(){
	Temp* tmp;
	tmp = (Temp*)malloc(sizeof(Temp));
	tmp->data = 100;
	tmp->add = Temp_add;
	return tmp;
}

int main(){
	Temp* t;
	t->data = t->add(t,20);
	new_Temp(10);
	printf("sdf");
	free(t);
	return 0;
}

/*
	Q. ��� �ν��Ͻ����� ���� ����ü�� ����Ű�µ�, �׷� ���� �ν��Ͻ��� �� �ʿ䰡 �ֽ��ϱ�?
	A. ����ü �ν��Ͻ����� ����Ű�� this ������ ������ ����� ���ô�. �ν��Ͻ����� �׸� �����Ͱ� �ٸ���, this��
		�ν��Ͻ��� ���� �׸� ���� ���� �ٸ� ���� ����մϴ�. ���� ��� �� �ν��Ͻ��� data ���� ���� 1,2,3�� ��� 
		���� 1,2,3�� tmp->data ���� ��������ٴ� �ǹ��̰�, �Լ��� ȣ��Ǹ�, �Լ� �ȿ� �ִ� this�� �ش� �ν��Ͻ��� ����ŵ�ϴ�.
		�ֳ��ϸ� this = (Temp*)self; �� �����Ǿ��� �����Դϴ�.
		tmp->data�� 2�� �ν��Ͻ��� �Լ��� ȣ���ߴٸ�, this�� �� �ν��Ͻ��� ����Ű��, �ᱹ this->data�� 2�� �ش��մϴ�.
		�ᱹ return i * 10 + this->data�� ������ t->add(t,20)��� �ڵ带 ���� ��, 200+2 �� 202�� ���ϵ˴ϴ�.
		�װ� t->data�� ���ԵǾ����Ƿ�, �� �ν��Ͻ��� data���� 202�� ���Եǰ� �ǰ�����.
	

typedef struct temp{
	int data;
	int (*add)(int);
}Temp;

int Temp_add(int i){
	return i * 10;
}

Temp* new_Temp(){
	Temp* tmp;
	tmp = (Temp*)malloc(sizeof(Temp));
	tmp->data = 100;
	tmp->add = Temp_add;
	return tmp;
}

int main(){
	Temp* t;
	t = new_Temp();
	free(t);
	return 0;
}
	
*/