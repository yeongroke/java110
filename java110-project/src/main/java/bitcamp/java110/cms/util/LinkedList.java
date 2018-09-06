package bitcamp.java110.cms.util;

public class LinkedList<T> implements List<T>{
    
    private Node<T> first;
    private Node<T> last;
    private int length;
    
    public LinkedList() {
        first = last = new Node<>(); //디폴트생성자를 써주었기 때문에 가로안에 아무것도 안써도됨
    }
    
    public void add(T obj) {
        last.value = obj;
        Node<T> node = new Node<>();
        node.prev = last; //last의 주소값
        last.next = node; //새로생성되는 node의 주소값 하지만 마지막에는 null이다 이유는 다음 node가 있어야 값이 생성 되기때문이다
        last = node;
        length++;
    }
    public T get(int index) {
        if(index < 0 || index >= length)
            return null;
        Node<T> cursor = first;
        
        for(int count=0; count<index; count++) {
            cursor =cursor.next;
        }
        return cursor.value;
    }
    public T remove(int index) {
        if(index < 0 || index >= length)
            return null;
        
        length--;
        
        Node<T> cursor=first;
        for(int count = 0; count<index; count++) {
            cursor = cursor.next;
        }
        
        if(cursor == first) {
            first = first.next;
            first.prev = null;
            return cursor.value;
        }
        
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        
        return cursor.value;
    }
    public void insert(int index, T obj) {
        if(index < 0 || index >= length)
            return;
        
        length++;
        
        Node<T> node = new Node<>();
        node.value = obj;
        
        Node<T> cursor=first;
        for(int count = 0; count<index; count++) {
            cursor = cursor.next;
        }
        if(cursor !=first) { // 이전 노드가 있어야만 이전 노드를 새 노드를 연결할 수 있다.
        cursor.prev.next = node; //새노드가 만들어지기 전의 이전 노드가 새로 만든 노드를 가리킴.
        node.prev = cursor.prev; //새노드는 현재 노드의 이전 노드를 가리킨다.
        }
        
        cursor.prev = node; // 현재 노드는 새 노드를 가리킨다.
        node.next = cursor; //새 노드의 다음은 현재 노드를 가리킨다.
    }
    public int size() {
        return this.length;
    }
    
    class Node<T2>{ //여기서 T2는 여기서만 쓴다 실제로 들어간 값은 T이다
        T2 value;
        Node<T2> next;
        Node<T2> prev;
        
        public Node() { } //디폴트 생성자
        
        public Node(T2 value, Node<T2> prev) {
            this.value=value;
            this.prev=prev;
        }
    }
}
