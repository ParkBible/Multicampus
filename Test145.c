#include <stdio.h>

typedef struct temp {
	int data;
	void (*print)( void* );
}Temp;

void Temp_print( void* self ) {
	Temp* this;
	this = (Temp*)self;

	printf("print %d\n", this->data );
}

void Temp_Constructor( void* self, int i ) {
	Temp* this;
	this = (Temp*)self;

	this->data = i;
}

Temp* new_Temp( int i ) {
	Temp* tmp;
	tmp = (Temp*)malloc( sizeof(Temp) );
	tmp->print = Temp_print;
	
	Temp_Constructor( tmp, i );
	
	return tmp;
}

int main() {
	Temp* t;
	t = new_Temp( 100 );
	t->print( t );
	
	/*
		만일 Temp_print에 접근할수만 있다면 함수포인터와 객체에 대한 포인터를 이용해서 호출할 수 있다.
		
		Class<?> cls = Class.forName("banana.Temp");
		Method mtd = cls.getMethod("print");
		// 위의 코드가 만일 Temp에서 선언된 print함수에 대한 함수포인터를 제공한다면?
		
		mtd.invoke(obj);
		// 함수포인터를 이용해서 호출할 수 있다. 단 멤버함수이니만큼 객체에 대한 포인터가 필요.
	*/
	
	mtd = Temp_print;
	mtd(t);
	
	free( t );
	return 0;
}


//	Test145.c
