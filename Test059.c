#include <stdio.h>
#include <string.h>

int starts_with(char* i, char* j){
	int k;
	int res = 1;
	for(k=0; k<strlen(j); k++){   // strlen 대신 *(j+k) 즉 j[k]를 입력해도 된다.
		if(i[k] != j[k]){
			res = 0;
			break;  // break 대신 그냥 return 0;을 해도 됨. return이 나오면 함수가 끝난다.
		}
	}
	return res;
}

int main(){
	int a;
	a = starts_with("HelloWorld\0", "Hella\0");
	printf("%d\n", a);
	
	return 0;
}

//gcc Test059.c -o test.exe

/*
	주어진 문장이 주어진 접두어로 시작하면 1, 아니면 0을 리턴하는 함수를 구현하세요
	짜다보면 반복되는 부분이 있다. 외운다. 까먹어도 괜찮.
*/