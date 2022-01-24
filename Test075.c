#include <stdio.h>

typedef struct node{
	int name;
	struct node* next;
} Node;
/*
*/

Node* init(){
	Node* tmp;
	tmp = (Node*)malloc(sizeof(Node));
	tmp->name = 0;
	tmp->next = NULL;
	return tmp;
}

Node* init_v2(Node** a, Node** b){
	//a = init(); 
	//b = a;
	
	*a = (Node*)malloc(sizeof(Node));
	(*a)->name = 0;
	(*a)->next = NULL;
	(*b) = (*a);
}

// 어설프게 짜지말고 와꾸부터 짜라.
int add(Node* i, int k){
	Node* tmp;
	tmp = (Node*)malloc(sizeof(Node));
	tmp->name = k;
	tmp->next = NULL;
	i->next = tmp; // 원래 끝이었던 tail에 tmp를 연결해준다.
	return tmp;
}

/*
	이걸 함수로.
	for(temp=head->next; temp!=NULL; temp=temp->next){ 
		printf("%d\n", temp->name);
	}
*/

void printAll(Node* a){
	Node* temp;
	for(temp=a->next; temp!=NULL; temp=temp->next){
		printf("%d\n", temp->name);
	}
}

Node* delete_all(Node* a){
	Node* post;
	Node* pre;
	
	post = a;
	pre = a->next;
	while(pre!=NULL){
		post = pre;
		pre = pre->next;
		
		free(post);
	}

	return a;
}

int main(){
	Node* head;
	Node* tail;
	Node* temp;
	Node* post;
	Node* pre;
	// head = (Node*)malloc(sizeof(Node)); 라고 하는 대신 함수에 넣기
	//head = init();  // 이거는 리턴하면서 head의 값이 변경되었기에 가능.
	
	//head = init_v2(head, tail);    // 하지만 이건 리턴값이 2개가 될 수 없기에 불가능.
	init_v2(&head, &tail); 	// a는 head가 가리키고자 하는 대상을 만들고자 한다.
	// 하지만 head가 가리키는 것은 지금 비어있는 상태... 결국, a는 head가 가리키는 것을 가리키는 포인터여야 한다.
	// 그래야 head가 가리키는 것을 만들 수 있으니까.
	
	tail = add(tail, 10);
	tail = add(tail, 20);
	
	
	printAll(head);
	
	
	tail = delete_all(head);
	// 앞에서부터 차례로 삭제하고 초기상황으로 돌림
	/*
	post = head;
	pre = head->next;
	while(pre!=NULL){
		post = pre;
		pre = pre->next;
		
		free(post);
	}
	tail = head;
	free(head);
	*/
	tail = head;
	free(head);
	
	
	return 0;
}

/*
	//10이 생기고 붙음, 필요한건 tail, 10, 변경하는게 tail
	temp = (Node*)malloc(sizeof(Node));
	temp->name = 10;
	temp->next = NULL;
	
	tail->next = temp;
	tail = temp;
	
	
	//20이 생기고 붙음
	temp = (Node*)malloc(sizeof(Node));
	temp->name = 10;
	temp->next = NULL;
	
	tail->next = temp;
	tail = temp;
*/