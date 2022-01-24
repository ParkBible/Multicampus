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
	tail = temp;  // temp를 tail->next
	
	temp = (Node*)malloc(sizeof(Node));
	temp->name = 20;
	temp->next = NULL;
	
	tail->next = temp;
	tail = temp;
	
	//목록 출력
	for(temp=head; temp!=NULL; temp=temp->next){
		//printf("%d\n", temp->name); // 0 10 20 -> 10부터 나오게 하고싶다면 temp=head->next에서 시작
	}
	
	// 2개의 포인터로 이동하면서 각 노드의 name을 출력하기
	post = head;
	pre = head->next;
	for( ; pre!=NULL ; ){
		printf("%d\n", pre->name);
		post = pre;  // post가 pre의 포지션을 차지
		pre = pre->next;  // pre는 다음 노드로 넘어감
		// free(post); 	// 10 20 순으로 지우는 코드. (일단 pre가 다음으로 넘어간 상태에서 post를 지워야 한다.)
	}
	
	free(head->next->next);
	free(head->next);
	free(head);
	return 0;
}

/*

struct node* 라고 쓰려니까 너무 길다. -> 자료형을 typedef라고 하고 맨뒤에 Node(지정 이름) 라고 붙인다.
모든 포인터 변수에는 NULL이 대입 가능하다.(아무것도 가리키지 않을 때)

이런 구조는 크기가 정해져 있는 배열과는 달리, 기억용량 한도 안에서 계속 늘어나거나 줄어들 수 있다.(링크드 리스트)
더미 노드가 하나 더 필요한 이유 : 두 개의 포인터를 순차적으로 이동할 수 있기 때문

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