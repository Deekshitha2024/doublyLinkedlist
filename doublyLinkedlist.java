#include <stdio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node *prev;
    struct node *next;
};
struct node *head=0;
struct node *tail;

void create(){
    int ele;
    struct node* newnode;
    newnode=(struct node*)malloc(sizeof(struct node));
    newnode->prev=0;
    newnode->next=0;
    printf("ENter data");
    scanf("%d",&ele);
    newnode->data=ele;
    if(head==0){
        head=tail=newnode;
    }
    else{
        tail->next=newnode;
        newnode->prev=tail;
        tail=newnode;
    }
    
} 

void insertAtBeggining(){
    int ele;
    struct node* newnode;
    newnode=(struct node*)malloc(sizeof(struct node));
    newnode->prev=0;
    newnode->next=0;
    printf("ENter data");
    scanf("%d",&ele);
    newnode->data=ele;
    newnode->next=head;
    head->prev=newnode;
    head=newnode;
}
void insertAtEnding(){
    int ele;
    struct node* newnode;
    newnode=(struct node*)malloc(sizeof(struct node));
    newnode->prev=0;
    newnode->next=0;
    printf("ENter data");
    scanf("%d",&ele);
    newnode->data=ele;
    tail->next=newnode;
    newnode->prev=tail;
    tail=newnode;
    
}
void insertAtPosition(){
    int ele;
     struct node* newnode,*temp;
    newnode=(struct node*)malloc(sizeof(struct node));
    newnode->prev=0;
    newnode->next=0;
    printf("ENter data");
    scanf("%d",&ele);
    newnode->data=ele;
    temp=head;
    int i=1,pos;
    printf("Enter position");
    scanf("%d",&pos);
    while(i<pos-1){
        temp=temp->next;
        i++;
        
        
    }
    newnode->next=temp->next;
    temp->next=newnode;
    newnode->prev=temp;
    newnode->next->prev=newnode;
    
}
void deleteFromBeggining(){
    struct node* temp;
    temp=head;
    head=head->next;
    head->prev=0;
    free(temp);
}
void deleteAtEnding(){
    struct node* temp;
    temp=tail;
   tail= tail->prev;
    tail->next=0;
    free(temp);
    
}
void deleteAtPosition(){
    int i=1,pos;
    struct node * temp;
    printf("Enter position");
    scanf("%d",&pos);
    while(i<pos){
        temp=temp->next;
        i++;
        
    }
    temp->prev->next = temp->next;
    temp->next->prev=temp->prev;
    free(temp);
}
void display(){
    struct node * temp;
    temp=head;
    while(temp!=0){
        printf("%d",temp->data); 
        temp=temp->next;
    }
    
}


int main()
{
   int ch,choice;
   while(1){
       printf("Enter choice");
       scanf("%d",&choice);
       switch(choice){
           case 1:
                create();
                break;
            case 2:
                insertAtBeggining();
                break;
            case 3:
                insertAtEnding();
                break;
            case 4:
                insertAtPosition();
                break;
            case 5:
                deleteFromBeggining();
                break;
                
            case 6:
                deleteAtEnding();
                break;
            case 7:
                deleteAtPosition();
                break;
            case 8:
                display();
                break;
            case 9:
                printf("Invalid choice");
                break;
            case 10:
                exit(0);
                break;
        
       }
       
   }

    return 0;
}
