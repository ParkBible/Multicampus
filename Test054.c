#include <stdio.h>

int* temp(){
	int* i;
	i = (int*)malloc(sizeof(int));
	*i = 100;
	return i;
}

int main(){
	int *t;
	
	t = temp();
	printf("%d\n", *t);
	
	free(t);  // t를 소거해주고 i는 temp()가 끝나면서 자동으로 없어진다. temp를 호출하고 이거 안해주면 메모리 누수가 일어남.(블루스크린 원인)
	
	return 0;
}

/*
	Test053.c의 대안 코드.
	malloc으로 공간 확보를 하여 함수가 끝나도 i가 사라지지 않게 한다.
	
	함수이름의 맨 뒤에 _N을 붙여서 내부에서 malloc된 메모리의 포인터를 돌려주는 형태의 코드라는 의미를 알려주기도 했다. (free를 해줘야된다는 의미)
*/