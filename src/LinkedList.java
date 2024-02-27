public class LinkedList<E>{
    private Node<E> front = new Node<E>();
    private Node<E> tail;
    private int length;

    LinkedList(){
        tail = findTail();
    }

    LinkedList(E[] array){//creates linked list from an array (array cannot be primative type ex int and Integer)
        tail = findTail();
        for(int i = 0; i < array.length; i++){
            this.append(array[i]);
        }
    }

    public void append(E x){//adds a new node with data x on the end of the list
        Node<E> n = new Node<E>(x);
        tail.next = n;
        tail = n;
        length++;
    }

    public void insert(int index, E x){//inserts a new node with data x at the specified index n
        Node<E> n = new Node<E>(x);
        Node<E> beforeN;
        if(index == 0){
            beforeN = front;
        }
        else{
            beforeN = getNode(index-1);
        }
        Node<E> afterN = beforeN.next;
        beforeN.next = n;
        n.next = afterN;
        if(afterN == null){
            tail = n;
        }
        length++;
    }

    public void delete(int index){//deletes the node at the index and "fixes" the list
        Node<E> beforeN;
        if(index == 0){
            beforeN = front;
        }
        else{
            beforeN = getNode(index-1);
        }
        Node<E> n = beforeN.next;
        Node<E> afterN = n.next;
        beforeN.next = afterN;
        n = null;
        if(afterN == null){
            tail = beforeN;
        }
        length--;
    }

    public E get(int index){//returns the data at node n
        Node<E> node = getNode(index);
        return node.data;
    }

    public int length(){//returns the length of the list
        return length;
    }

    private Node<E> getNode(int n){//returns the node at index n
        Node<E> curr = front;
        if(n < 0 || n > length-1){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for(int i = 0; i <= n; i++){
            curr = curr.next;
        }
        return curr;
    }

    private Node<E> findTail(){//returns the last node in the list
        Node<E> curr = front;
        length = 0;
        while(curr.next != null){
            curr = curr.next;
            length++;
        }
        if(curr != front){
            length++;
        }
        return curr;
    }

    public void showList(){//prints the list
        Node<E> curr = front;
        while(curr.next != null){
            curr = curr.next;
            System.out.println(curr.data);
        }
    }
}