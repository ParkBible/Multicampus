#include <stdio.h>

int sum(int* a, int b){
	int i;
	int res;
	res = 0;
	for(i=0; i<b; i++){
		res = res + *(a + i); 
	}
	printf("%d\n", a);
	return res;
}

int main(){
	int l[4] = {3,6,5,8};
	int res, len;
	int i;
	
	len = sizeof(l) / sizeof(int);
	
	res = sum(l, len);
	
	printf("%d\n", res);
	return 0;
}

/*
	gcc Test042.c -o test.exe
*/