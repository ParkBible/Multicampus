#include <stdio.h>

typedef struct node{
	int name;
	struct node* next;
} Node;

int main(){
	Node* head;
	Node* tail;
	Node* temp;
	Node* post;
	Node* pre;
	
	head = (Node*)malloc(sizeof(Node));
	tail = head;
	
	head->name = 0;
	head->next = NULL;
	
	temp = (Node*)malloc(sizeof(Node));
	temp->name = 10;
	temp->next = NULL;
	
	tail->next = temp;
	tail = temp;  // temp�� tail->next
	
	temp = (Node*)malloc(sizeof(Node));
	temp->name = 20;
	temp->next = NULL;
	
	tail->next = temp;
	tail = temp;
	
	//��� ���
	for(temp=head; temp!=NULL; temp=temp->next){
		//printf("%d\n", temp->name); // 0 10 20 -> 10���� ������ �ϰ�ʹٸ� temp=head->next���� ����
	}
	
	// 2���� �����ͷ� �̵��ϸ鼭 �� ����� name�� ����ϱ�
	post = head;
	pre = head->next;
	for( ; pre!=NULL ; ){
		printf("%d\n", pre->name);
		post = pre;  // post�� pre�� �������� ����
		pre = pre->next;  // pre�� ���� ���� �Ѿ
		// free(post); 	// 10 20 ������ ����� �ڵ�. (�ϴ� pre�� �������� �Ѿ ���¿��� post�� ������ �Ѵ�.)
	}
	
	free(head->next->next);
	free(head->next);
	free(head);
	return 0;
}

/*

struct node* ��� �����ϱ� �ʹ� ���. -> �ڷ����� typedef��� �ϰ� �ǵڿ� Node(���� �̸�) ��� ���δ�.
��� ������ �������� NULL�� ���� �����ϴ�.(�ƹ��͵� ����Ű�� ���� ��)

�̷� ������ ũ�Ⱑ ������ �ִ� �迭���� �޸�, ���뷮 �ѵ� �ȿ��� ��� �þ�ų� �پ�� �� �ִ�.(��ũ�� ����Ʈ)
���� ��尡 �ϳ� �� �ʿ��� ���� : �� ���� �����͸� ���������� �̵��� �� �ֱ� ����

struct node{
	int name;
	struct node* next;
};

int main(){
	struct node* head;
	head = (struct node*)malloc(sizeof(struct node));
	
	head->name = 0;
	head->next = head;
	return 0;
}

*/