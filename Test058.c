#include <stdio.h>

struct node{
	int value;
	struct node* next;
};

int main{
	struct node* head;   // struct node �� ����ų �� �ִ� �����͸� ����
	struct node* tail;
	
	head = (struct node*)malloc(sizeof(struct node));
	tail = head;
	
	tail->next = (struct node*)malloc(sizeof(struct node));
	tail->next->name = 10;
	tail = tail->next;
	
	tail->next = (struct node*)malloc(sizeof(struct node));
	tail->next->name = 20;
	tail = tail->next;
	
	free(head->next->next);
	free(head->next);
	free(head);    // �� ������θ� free ���־�� �Ѵ�. �ݴ�� �ϸ� head��� ������� ��� ����������
	
	printf(head);
	
	free(head);
	
	return 0;
}