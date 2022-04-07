public class LinkedListDeque<T> {
    public int size = 0;
    public Node Sentinel;
    public class Node {
        public T item;
        public Node rest;
        public Node previous;
        public Node(T i){
            item = i;
        }
    }
    
    public LinkedListDeque() {
        Sentinel = new Node(null);
        //看看这两句可不可以删
        Sentinel.rest = null;
        Sentinel.previous = null;
    }
    
    public boolean isEmpty() {
        if (Sentinel.rest == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void addFirst(T item) {
        Node temp = new Node(null);
        temp.item = item;
        temp.previous = Sentinel;
        if (isEmpty()) {
            Sentinel.previous = temp;
            Sentinel.rest = temp;
            temp.rest = Sentinel;
        } else {
            temp.rest = Sentinel.rest;
            Sentinel.rest.previous = temp;
            Sentinel.rest = temp;
        }
        size += 1;
    }
    
    public void addLast(T item) {
        Node temp = new Node(null);
        temp.item = item;
        temp.rest = Sentinel;
        if (isEmpty()) {
            Sentinel.previous = temp;
            temp.previous = Sentinel;
            Sentinel.rest = temp;
        } else {
            temp.previous = Sentinel.previous;
            Sentinel.previous.rest = temp;
            Sentinel.previous = temp;
        }
        size += 1;
    }
    
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else if (Sentinel.previous == Sentinel.rest) {
            size -= 1;
            Sentinel.previous = null;
            Sentinel.rest = null;
            return (T) Sentinel.item;
        } else {
            T temp = (T) Sentinel.rest.item;
            size -= 1;
            Sentinel.rest.rest.previous = Sentinel;
            Sentinel.rest = Sentinel.rest.rest;
            return temp;
        }
    }
    
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else if (Sentinel.previous == Sentinel.rest) {
            size -= 1;
            Sentinel.previous = null;
            Sentinel.rest = null;
            return (T) Sentinel.item;
        } else {
            T temp = (T) Sentinel.previous.item;
            size -= 1;
            Sentinel.previous.previous.rest = Sentinel;
            Sentinel.previous = Sentinel.previous.previous;
            return temp;
        }
    }
    
    public T get(int index) {
        if (isEmpty() || index > size - 1) {
            return null;
        } else {
            Node temp = Sentinel.rest;
            while (index != 0) {
                    temp = temp.rest;
                    index--;
            }
            return (T) temp.item;
        }
    }
    
    public T getRecursive(int index) {
        if (isEmpty() || index > size - 1) {
            return null;
        }
        LinkedListDeque temp = new LinkedListDeque();
        temp.Sentinel.rest = this.Sentinel.rest;
        if(index == 0) {
            return (T) temp.Sentinel.rest.item;
        } else {
            temp.Sentinel.rest = Sentinel.rest.rest;
            return (T) temp.getRecursive(index - 1);
        }
    }
    
    public int size() {
        return size;
    }
    
    public void printDeque() {
        System.out.println("==============");
        Node temp = Sentinel.rest;
        while (temp != Sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.rest;
        }
        System.out.println("==============");
    }
    
    public static void main(String[] args) {
        //LinkedListDeque<Integer> linkedListDeque1 = new LinkedListDeque<Integer>();
        //linkedListDeque1.addFirst(5);
        //linkedListDeque1.addFirst(4);
        //linkedListDeque1.addFirst(3);
        //linkedListDeque1.addFirst(2);
        //linkedListDeque1.addFirst(1);
        //linkedListDeque1.printDeque();
        //System.out.println("size is " + linkedListDeque1.size());
        //linkedListDeque1.removeFirst();
        //linkedListDeque1.printDeque();
        //linkedListDeque1.removeLast();
        //linkedListDeque1.printDeque();
        //System.out.println("size is " + linkedListDeque1.size());
        //System.out.println(linkedListDeque1.getRecursive(3));
        //linkedListDeque1.printDeque();
    }
}
