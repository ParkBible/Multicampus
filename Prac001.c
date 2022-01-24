#include <stdio.h>
#include <string.h>

int strlen2(char* st){
	return strlen(st);
}

int main(){
	char* str;
	str = "Hello";
	printf("%d\n",strlen2(str));
	
	return 0;
}