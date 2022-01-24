#include <stdio.h>

struct apple{
	int value;
	int name;
};

int main(){
	struct apple i;
	struct apple* t;
	
	t = &i;
	i.value = 123;
	t->name = 456;
	
	printf("%d\n", t->value);    // 123
								// t는 포인터이므로 t.value가 아니라 t->value로 해야 한다.
	printf("%d\n", i.name); 
	return 0;
}

/*
	i.value
	t->value
	
	포인터와 변수명은 접근 방법의 차이가 있는거지 암튼 값은 똑같다.
	포인터로 접근해서 i에 100을넣는거랑 변수명으로 접근해서 i에 100을 넣는거랑 같단 거.
	
	gcc Test056.c -o test.exe
*/