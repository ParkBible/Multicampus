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

// ����� ¥������ �Ͳٺ��� ¥��.
int add(Node* i, int k){
	Node* tmp;
	tmp = (Node*)malloc(sizeof(Node));
	tmp->name = k;
	tmp->next = NULL;
	i->next = tmp; // ���� ���̾��� tail�� tmp�� �������ش�.
	return tmp;
}

/*
	�̰� �Լ���.
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
	// head = (Node*)malloc(sizeof(Node)); ��� �ϴ� ��� �Լ��� �ֱ�
	//head = init();  // �̰Ŵ� �����ϸ鼭 head�� ���� ����Ǿ��⿡ ����.
	
	//head = init_v2(head, tail);    // ������ �̰� ���ϰ��� 2���� �� �� ���⿡ �Ұ���.
	init_v2(&head, &tail); 	// a�� head�� ����Ű���� �ϴ� ����� ������� �Ѵ�.
	// ������ head�� ����Ű�� ���� ���� ����ִ� ����... �ᱹ, a�� head�� ����Ű�� ���� ����Ű�� �����Ϳ��� �Ѵ�.
	// �׷��� head�� ����Ű�� ���� ���� �� �����ϱ�.
	
	tail = add(tail, 10);
	tail = add(tail, 20);
	
	
	printAll(head);
	
	
	tail = delete_all(head);
	// �տ������� ���ʷ� �����ϰ� �ʱ��Ȳ���� ����
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
	//10�� ����� ����, �ʿ��Ѱ� tail, 10, �����ϴ°� tail
	temp = (Node*)malloc(sizeof(Node));
	temp->name = 10;
	temp->next = NULL;
	
	tail->next = temp;
	tail = temp;
	
	
	//20�� ����� ����
	temp = (Node*)malloc(sizeof(Node));
	temp->name = 10;
	temp->next = NULL;
	
	tail->next = temp;
	tail = temp;
*/