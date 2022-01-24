#include <stdio.h>

struct node{
	int value;
	struct node* next;
};

int main{
	struct node* head;   // struct node 를 가리킬 수 있는 포인터를 생성
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
	free(head);    // 이 순서대로만 free 해주어야 한다. 반대로 하면 head라는 연결고리가 없어서 삭제를못함
	
	printf(head);
	
	free(head);
	
	return 0;
}