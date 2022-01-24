#include <stdio.h>
/*
	Temp 구조체 - class Temp - 명시적인 개념
	new_Temp() 호출시 - 메모리 확보, add 함수포인터와 실체를 연결한다.
	Temp* t; - 이것은 포인터, 구조체의 실체를 가리키는데, 그 안의 변수는 이미 대입되었다.
	
	암튼 함수를 바로 구조체에 넣을 수 없으니까 new_Temp() 이런 연결작업이 필요하다 이말이야
*/

typedef struct temp{  // class와 거의 같음. 구조를 나타냄
	int data;
	int (*add)(int);
} Temp;

int Temp_add(int i){  // 걍 함수
	return 20 * i;
};


Temp* new_Temp(){  // 구조체의 함수포인터와 함수를 연결해줌. tmp라는 구조체 변수를 만들고, 그 변수 안의 요소들에 대입함.(객체)
	Temp* tmp;
	tmp = (Temp*)malloc(sizeof(Temp));
	tmp->add = Temp_add;
	tmp->data = 100;
	return tmp;
}

int main(){
	Temp* t;
	t = new_Temp();  // new_Temp()의 과정을 통해 전부 대입되어 있는 변수 tmp를 리턴받아서 t에 대입함. 
	
	t->data = t->add(20);
	printf("%d\n", t->data);
	free(t);
	
	return 0;
}

/*
	구조체 안에 함수는 선언 불가능하지만 함수 포인터는 선언 가능하다!!!
	마치 like 쯔꾸르의 "커먼 이벤트" 와 흡사.
*/