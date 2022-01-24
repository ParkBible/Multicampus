#include <stdio.h>
#include <string.h>

int strlen2(char* a){
	printf("%s\n", a);
	return strlen(a);
}

int main(){
	char* str;
	int res;
	str = "HelloWorld\0";
	
	res = strlen2(str);
	printf("%d\n", res);
	
	return 0;
}

/*
	문자열의 길이를 재는 함수 strlen2 를 만들자.
	
	내용을 복사해서 넘기는 것과 포인터를 넘기는 것을 확실히 하자.
	int i,j;
	int* t;
	
	i = 100;
	t = &i;
	j = i;
	
	// j++;
	(*t)++;
	printf("%d\n", i);
	
	일반변수에 값을 대입할때 : i가 가지고 있는 값을 복사해서 j에 대입한다. j++; 이 있지만 i는 100.
	  >> A에게 종이가 하나 있을때 이걸 복사해서 B에게 나눠줌.
	포인터를 넘길 때 : &i - i의 기억공간을 t로 가리키고 있다. (*t)++; 를 하면 i는 101이 됨.
	  >> A에게 종이가 하나 있을때 종이의 위치를 가르쳐줘서 A와 B가 함께 봄.
		 B가 종이의 내용을 바꾸면 A에게도 피해가 간다.
	
	
*/
