#include <stdio.h>

typedef struct temp{
	int data;
}Temp;

/*
	자바에서 new 하면 벌어지는 일
	1. 메모리 확보(malloc)
	2. 멤버함수 포인터를 실체와 연결
	3. 생성자 호출
	
	특징
	- 생성자는 외부에서 포인터로 접근 불가. t->TempConstructor(...);
	- new ... 하는 시점에서 호출된다.
	- 주로 멤버변수 초기화 용도로 사용
	- this를 사용가능.
	- 매개변수 적당히 만들어서 사용
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