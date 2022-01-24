#include <stdio.h>

//	class A 에 해당 
typedef struct a {
	int data;
	void (*print)( void* );
} A;

// class B extends A 에 해당
typedef struct b {
	int data;
	void (*print)( void* );		//  오버라이딩이 일어난 경우에는 조상의 포인터를 쓴다.
	void (*print2)( void* );	//	자손에서 추가된 함수
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
	
	//	멤버변수의 초기화문제
	/*
		만일 멤버변수의 이름이 겹치고 , 상속이 일어났을때는 조상의 멤버변수는 조상의 생성자에서
		자손의 멤버변수는 자손의 생성자에서 각각 초기화 시킬 수 밖에 없다.
		
		해서 자손의 인스턴스를 생성하면 조상 -> 자손 순으로 생성자가 호출된다!! ( 이렇게 될 수 밖에 없다 )
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