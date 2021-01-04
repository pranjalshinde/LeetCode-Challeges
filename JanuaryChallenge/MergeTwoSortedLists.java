package JanuaryChallenge;

class Node {
    int val;
    Node next;
    Node(){
        
    }
    Node(int val){
        this.val = val;
        next = null;
    }
    Node(int x, Node next){
        this.next = next;
    }
}

public class MergeTwoSortedLists {

    //Recursive Solution

    private static Node recursiveMerge(Node l1, Node l2){
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else if(l1.val <= l2.val){
            l1.next = recursiveMerge(l1.next, l2);
            return l1;
        }
        else{
            l2.next = recursiveMerge(l1, l2.next);
            return l2;
        }
        
    }

    //Non recursive Solution

    private static Node merge(Node l1, Node l2){
        Node dummyhead = new Node(0);
        Node ptr = dummyhead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ptr.next = new Node(l1.val);
                ptr = ptr.next;
                l1 = l1.next;
            }
            else{
                ptr.next = new Node(l2.val);
                ptr = ptr.next;
                l2 = l2.next;
            }
        }
        if(l1 != null){
            ptr.next = l1;
        }
        if(l2 != null){
            ptr.next = l2;
        }
        return dummyhead.next;
    }
    private static void display(Node head){
        Node ptr = head;
        while(ptr != null){
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        Node head = recursiveMerge(head1, head2);
       // Node head = merge(head1, head2);
        display(head);
    }
}
