#include <stdio.h>

int add(int i, int *j){
	i = i + 1;
	*j = *j + 1;
	
	return 100;
}

int main(){
	int a;
	int i2, j2;
	
	i2 = 100;
	j2 = 100;
	
	a = add(i2, &j2);
	
	printf("%d\n", i2);
	printf("%d\n", j2);
	
	return 0;
}

/*
	i2에 직접적으로 대입한게 아닌, add에서만 사용되는 매개변수 i(로컬)에 101이라는 값을 넣었기에 i2는 그대로 100이다.
	함수가 끝나면 i라는 변수는 사라진다.
	반면 &j2는 j2의 기억공간을 가리키고 있다. *j라는 매개변수를 통해 직접적으로 j2의 기억공간에 접근하여 대입하였으므로, 101이 출력.
*/