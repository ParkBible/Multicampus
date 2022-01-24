#include <stdio.h>

//	class A �� �ش� 
typedef struct a {
	int data;
	void (*print)( void* );
} A;

// class B extends A �� �ش�
typedef struct b {
	int data;
	void (*print)( void* );		//  �������̵��� �Ͼ ��쿡�� ������ �����͸� ����.
	void (*print2)( void* );	//	�ڼտ��� �߰��� �Լ�
} B;

void A_print( void* self ) {
	A* this;
	this = (A*)self;
	
	printf("print");	
}

void B_print( void* self ) {
	B* this;
	this = (B*)self;	
	
	printf("printXX");	
}

void B_print2( void* self ) {
	B* this;
	this = (B*)self;
	
	printf("print2");	
}

void* new_B( ) {
	B* tmp;
	tmp = (B*)malloc( sizeof(B) );
	
	tmp->print = A_print;
	tmp->print = B_print;
	tmp->print2 = B_print2;
	
	//	��������� �ʱ�ȭ����
	/*
		���� ��������� �̸��� ��ġ�� , ����� �Ͼ������ ������ ��������� ������ �����ڿ���
		�ڼ��� ��������� �ڼ��� �����ڿ��� ���� �ʱ�ȭ ��ų �� �ۿ� ����.
		
		�ؼ� �ڼ��� �ν��Ͻ��� �����ϸ� ���� -> �ڼ� ������ �����ڰ� ȣ��ȴ�!! ( �̷��� �� �� �ۿ� ���� )
	*/
	//	A_Constructor( tmp );
	//	B_Constructor( tmp );
	
	return tmp;
}

int main() {
	void* vp;
	A* t;
	B* t2;

	vp = new_B();

	t = (A*)vp;
	t->print( t );
	//	t->print2( t );
	
	t2 = (B*)vp;
	t2->print( t2 );
	t2->print2( t2 );
	
	free( (B*)vp );
	return 0;
}

//	Test090.c