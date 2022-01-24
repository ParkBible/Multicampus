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
		���� Temp_print�� �����Ҽ��� �ִٸ� �Լ������Ϳ� ��ü�� ���� �����͸� �̿��ؼ� ȣ���� �� �ִ�.
		
		Class<?> cls = Class.forName("banana.Temp");
		Method mtd = cls.getMethod("print");
		// ���� �ڵ尡 ���� Temp���� ����� print�Լ��� ���� �Լ������͸� �����Ѵٸ�?
		
		mtd.invoke(obj);
		// �Լ������͸� �̿��ؼ� ȣ���� �� �ִ�. �� ����Լ��̴ϸ�ŭ ��ü�� ���� �����Ͱ� �ʿ�.
	*/
	
	mtd = Temp_print;
	mtd(t);
	
	free( t );
	return 0;
}


//	Test145.c
