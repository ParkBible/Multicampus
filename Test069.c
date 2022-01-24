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

// Constructor의 역할 : 변수의 초기화
// new_Temp 호출할때 호출된다.
// 주 용도는 구조체 안의 함수포인터 아닌 변수들의 초기값을 준다. 포인터를 통해서 호출할 수 없다.
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
	// t->Temp_Constructor(...); 포인터를 통해 호출 불가능
	t->data = t->add(t,20);
	printf("%d\n", t->data);  // 210
	free(t);
	return 0;
}