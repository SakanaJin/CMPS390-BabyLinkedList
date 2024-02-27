public class Node<T>{
    T data;
    Node<T> next;

    Node(T x){
        data = x;
        next = null;
    }
    
    Node(){
        next = null;
    }
}
