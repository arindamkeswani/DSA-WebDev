int p1=head1
int p2=head2

while(p1==null && p2==null){
    tp1=p1.next;
    tp2=p2.next;

    if(p1.data<=p2.data){
        p1.next=p1;
        
    }else{
        p2.next=p1;
    }


}
