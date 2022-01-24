#include <stdio.h>

typedef struct node {
	int name;
	struct node* next;
}Node;

typedef struct xlist {
	Node* head;
	Node* tail;
	void (*add)( void*, int );
	void (*print_all)( void* );
	void (*delete_all)( void* );
}XList;

void XList_add( void* self, int i ) {
	XList* this;
	Node* tmp;
	this = (XList*)self;
	
	tmp = (Node*)malloc(sizeof(Node));
	tmp->name = i;
	tmp->next = NULL;
	
	this->tail->next = tmp;
	this->tail = tmp;
}

void XList_print_all( void* self ) {
	XList* this;
	Node* t;
	
	this = (XList*)self;
	for( t = this->head->next ; t != NULL ; t = t->next ) {
		printf("%d\n", t->name );
	}
}

void XList_delete_all( void* self ) {
	XList* this;
	Node* pre;
	Node* post;
	this = (XList*)self;
	
	post = this->head;
	pre = this->head->next;
	while( pre != NULL ) {
		post = pre;
		pre = pre->next;
		
		printf("delete : %d\n", post->name );
		free( post );
	}
	this->tail = this->head;
}

void XList_Constructor( void* self ) {
	XList* this;
	this = (XList*)self;
	
	this->head = (Node*)malloc(sizeof(Node));
	
	this->head->name = 0;
	this->head->next = NULL;
	
	this->tail = this->head;
}

XList* new_XList() {
	XList* tmp;
	tmp = (XList*)malloc( sizeof(XList) );
	
	tmp->add        = XList_add;
	tmp->print_all  = XList_print_all;
	tmp->delete_all = XList_delete_all;
	
	XList_Constructor( tmp );
	
	return tmp;
}

int main() {
	XList* l;
	l = new_XList();
	
	l->add( l, 10 );
	l->add( l, 20 );
	l->add( l, 30 );
	l->add( l, 40 );
	
	l->print_all( l );
	
	l->delete_all( l );
	
	free( l->head );
	free( l );
	
	return 0;
}
/*	Test077.c

	head tail
	init(생성자로 대신) add print_all delete_all

*/