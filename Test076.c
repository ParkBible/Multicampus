#include <stdio.h>

typedef struct abcd {
	int name;
	struct abcd* next;
} Node;

/*
	보통 함수로 쪼갤때는 '동작' 하나를 함수로 구현하는것이 일반적이다 
*/

Node* init() {
	Node *t;
	t = (Node*)malloc(sizeof(Node));
	t->name = 0;
	t->next = NULL;
	return t;
}

void init_v2( Node** a, Node** b ) {
	*a = (Node*)malloc(sizeof(Node));
	(*a)->name = 0;
	(*a)->next = NULL;
	(*b) = (*a);
}

//	어설프게 실력믿지 말고, 와꾸부터 짜라 쫌!!! ^^*
Node* add( Node* t, int name2 ) {
	Node* temp;	
	temp = (Node*)malloc(sizeof(Node));
	temp->name = name2;
	temp->next = NULL;
	
	t->next = temp;
	return temp;
}

void print_all( Node* hd ) {
	Node* temp;
	for( temp = hd->next ; temp != NULL ; temp = temp->next ) {
		printf("%d\n", temp->name );
	}
}

Node* delete_all( Node* hd ) {
	Node* pre;
	Node* post;
	
	post = hd;
	pre = hd->next;
	while( pre != NULL ) {
		post = pre;
		pre = pre->next;
		
		free( post );
	}
	return hd;
}

int main() {
	Node* head;
	Node* tail;
	Node* temp;
	Node* post;
	Node* pre;


	head = init();
	
	init_v2(&head, &tail);
	tail = add(tail, 10);
	tail = add(tail, 20);

	print_all(head);

	
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
	
	free(head);
	
	
	return 0;
}


/*
Node* init() {
	Node *t;
	t = (Node*)malloc(sizeof(Node));
	t->name = 0;
	t->next = NULL;
	return t;
}

void init_v2( Node** a, Node** b ) {
	*a = (Node*)malloc(sizeof(Node));
	(*a)->name = 0;
	(*a)->next = NULL;
	(*b) = (*a);
}

//	어설프게 실력믿지 말고, 와꾸부터 짜라 쫌!!! ^^*
Node* add( Node* t, int name2 ) {
	Node* temp;	
	temp = (Node*)malloc(sizeof(Node));
	temp->name = name2;
	temp->next = NULL;
	
	t->next = temp;
	return temp;
}

void print_all( Node* hd ) {
	Node* temp;
	for( temp = hd->next ; temp != NULL ; temp = temp->next ) {
		printf("%d\n", temp->name );
	}
}

Node* delete_all( Node* hd ) {
	Node* pre;
	Node* post;
	
	post = hd;
	pre = hd->next;
	while( pre != NULL ) {
		post = pre;
		pre = pre->next;
		
		free( post );
	}
	return hd;
}
*/