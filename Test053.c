#include <stdio.h>

int* temp(){
	int i;
	i = 100;
	return &i;
}

int main(){
	int *t;
	
	t = temp();
	printf("%d\n", *t);
	return 0;
}

/*
	warning이 뜨는 이유는? : temp()의 로컬변수인 i는 함수가 끝나면 사라지므로,
	i의 기억공간을 가리키는 리턴값에 경고가 뜨는 것.
	저렇게 짜면 안되는데 저렇게 짜는 사람들이 많아서 허용하자는 의견이 대두되었다.
	(다른 곳에서 포인터로 가리키는 로컬변수는 살려라)
	
int strlen2(char* a){
	return strlen(*a);
	}

int main(){
	char* str;
	int res;
	str = "HelloWorld\0";
	
	res = strlen(str);
	printf("%d\n", res);
	
	return 0;
}

	아까 내가 짠 코드에서 warning이 뜬 이유도... *a 값을 넘겼기 때문. a를 넘기면 워닝안뜸
*/