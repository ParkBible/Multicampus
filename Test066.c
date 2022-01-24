#include <stdio.h>

/*
	구조체 안에 선언된 모든 함수의 첫번째 매개변수 형태는 void*로 한다.
	Temp* this;
	this = (Temp*)self;
	이 코드를 맨 윗부분에 써주도록 한다.
	
	이러면 실제 함수 호출시에 t->add(t, 20); 와 같이 함.
	-> 왼쪽에서 사용한 변수를 매개변수의 첫번째에 넣어준다.
	
	add입장에서는 자신이 속하여 있는 메모리공간을 this가 가리키고 있다.
	즉, this 포인터는 자기 자신이 속해있는 구조체를 가리키게 되고, 구조체 안의 변수와 함수에 접근 가능하다.
	
	
	
*/

typedef struct temp{
	int data;
	int (*add)(void*, int);
}Temp;

int Temp_add(void* self, int i){
	Temp* this;
	this = (Temp*)self;
	return i * 10 + this->data;
}

Temp* new_Temp(){
	Temp* tmp;
	tmp = (Temp*)malloc(sizeof(Temp));
	tmp->data = 100;
	tmp->add = Temp_add;
	return tmp;
}

int main(){
	Temp* t;
	t->data = t->add(t,20);
	new_Temp(10);
	printf("sdf");
	free(t);
	return 0;
}

/*
	Q. 모든 인스턴스들이 같은 구조체를 가리키는데, 그럼 여러 인스턴스를 쓸 필요가 있습니까?
	A. 구조체 인스턴스들을 가리키는 this 포인터 변수를 사용해 봅시다. 인스턴스마다 항목별 데이터가 다르고, this는
		인스턴스의 개별 항목 값에 따라 다른 값을 출력합니다. 예를 들어 세 인스턴스의 data 값이 각각 1,2,3일 경우 
		각각 1,2,3의 tmp->data 값이 만들어졌다는 의미이고, 함수가 호출되면, 함수 안에 있는 this는 해당 인스턴스를 가리킵니다.
		왜냐하면 this = (Temp*)self; 로 설정되었기 때문입니다.
		tmp->data가 2인 인스턴스가 함수를 호출했다면, this는 이 인스턴스를 가리키고, 결국 this->data는 2에 해당합니다.
		결국 return i * 10 + this->data는 메인의 t->add(t,20)라는 코드를 봤을 때, 200+2 즉 202가 리턴됩니다.
		그게 t->data에 대입되었으므로, 이 인스턴스의 data에는 202가 대입되게 되겠지요.
	

typedef struct temp{
	int data;
	int (*add)(int);
}Temp;

int Temp_add(int i){
	return i * 10;
}

Temp* new_Temp(){
	Temp* tmp;
	tmp = (Temp*)malloc(sizeof(Temp));
	tmp->data = 100;
	tmp->add = Temp_add;
	return tmp;
}

int main(){
	Temp* t;
	t = new_Temp();
	free(t);
	return 0;
}
	
*/