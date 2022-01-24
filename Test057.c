#include <stdio.h>

struct apple{
	int value;
	int name;
};

int main(){
	struct apple* t;
	
	t = (struct apple*)malloc(sizeof(struct apple));
	
	t->value = 100;
	t->name = 200;
	
	printf("%d\n", t->value);
	printf("%d\n", t->name);
	
	free(t);
	
	return 0;
}