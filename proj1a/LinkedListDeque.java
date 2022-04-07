public class LinkedListDeque<T> {
    public int size = 0;
    public Node Sentinel;
    
    public class Node {
        public T item;
        public Node rest;
        public Node previous;
        
        public Node(T i) {
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
        }
        size -= 1;
        T temp = (T) Sentinel.rest.item;
        if (Sentinel.previous == Sentinel.rest) {
            Sentinel.previous = null;
            Sentinel.rest = null;
        } else {
            Sentinel.rest.rest.previous = Sentinel;
            Sentinel.rest = Sentinel.rest.rest;
        }
        return temp;
    }
    
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        T temp = (T) Sentinel.previous.item;
        if (Sentinel.previous == Sentinel.rest) {
            Sentinel.previous = null;
            Sentinel.rest = null;
        } else {
            Sentinel.previous.previous.rest = Sentinel;
            Sentinel.previous = Sentinel.previous.previous;
        }
        return temp;
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
        temp.size = this.size;
        if (index == 0) {
            return (T) temp.Sentinel.rest.item;
        } else {
            temp.Sentinel.rest = this.Sentinel.rest.rest;
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
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<Integer>();
        LinkedListDeque.addLast(0);
        LinkedListDeque.addLast(1);
        LinkedListDeque.addLast(2);
        LinkedListDeque.addLast(3);
        System.out.println(LinkedListDeque.removeFirst());
        LinkedListDeque.addFirst(5);
        LinkedListDeque.addLast(6);
        System.out.println(LinkedListDeque.getRecursive(2));
    }
}
