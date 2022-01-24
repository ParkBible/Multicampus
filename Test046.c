#include <stdio.h>
#include <string.h>

int main(){
	char l[7] = "Apple\0";
	char* t = "Hello\0";
	int len;
	
	
	printf("%s\n", l);
	printf("%d\n", strlen(l));
	printf("%s\n", t);
	printf("%d\n", strlen(t));
	
	return 0;
}

/*
	java에서는 문자열을 String으로 사용했음
	int[] i = {1,2};
	Apple�@u??P�@?@  // char l[5] = "Apple"; 쓰레기값이 출력.
	
	char l[5] = "Apple\0"; 이라고 적어줘야한다.(마지막에 \0으로 끝나게 한다.)
	
	배열형 변수는 포인터에 대입 가능하니까 위와 같이 포인터로 문자열을 운용해도 배열과 같은 개념이다.
	
	문자열의 길이를 잴 때는 \0은 고려하지 않아야 하기 때문에 sizeof보다는 strlen 함수를 씀.
	c에는 boolean 자료형이 없다.
	정수형을 쓰는데 0은 false, 0이 아닌것들은 true
*/