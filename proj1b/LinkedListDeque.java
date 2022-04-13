public class LinkedListDeque<T> implements Deque<T> {
    private int size = 0;
    private Node sentinel;
    
    private class Node {
        private T item;
        private Node rest;
        private Node previous;
        
        private Node(T i) {
            item = i;
        }
    }
    
    public LinkedListDeque() {
        sentinel = new Node(null);
        //看看这两句可不可以删
        sentinel.rest = null;
        sentinel.previous = null;
    }
    
    public boolean isEmpty() {
        return sentinel.rest == null;
    }
    
    public void addFirst(T item) {
        Node temp = new Node(null);
        temp.item = item;
        temp.previous = sentinel;
        if (isEmpty()) {
            sentinel.previous = temp;
            sentinel.rest = temp;
            temp.rest = sentinel;
        } else {
            temp.rest = sentinel.rest;
            sentinel.rest.previous = temp;
            sentinel.rest = temp;
        }
        size += 1;
    }
    
    public void addLast(T item) {
        Node temp = new Node(null);
        temp.item = item;
        temp.rest = sentinel;
        if (isEmpty()) {
            sentinel.previous = temp;
            temp.previous = sentinel;
            sentinel.rest = temp;
        } else {
            temp.previous = sentinel.previous;
            sentinel.previous.rest = temp;
            sentinel.previous = temp;
        }
        size += 1;
    }
    
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        T temp = (T) sentinel.rest.item;
        if (sentinel.previous == sentinel.rest) {
            sentinel.previous = null;
            sentinel.rest = null;
        } else {
            sentinel.rest.rest.previous = sentinel;
            sentinel.rest = sentinel.rest.rest;
        }
        return temp;
    }
    
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        T temp = (T) sentinel.previous.item;
        if (sentinel.previous == sentinel.rest) {
            sentinel.previous = null;
            sentinel.rest = null;
        } else {
            sentinel.previous.previous.rest = sentinel;
            sentinel.previous = sentinel.previous.previous;
        }
        return temp;
    }
    
    public T get(int index) {
        if (isEmpty() || index > size - 1) {
            return null;
        } else {
            Node temp = sentinel.rest;
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
        temp.sentinel.rest = this.sentinel.rest;
        temp.size = this.size;
        if (index == 0) {
            return (T) temp.sentinel.rest.item;
        } else {
            temp.sentinel.rest = this.sentinel.rest.rest;
            return (T) temp.getRecursive(index - 1);
        }
    }
    
    public int size() {
        return size;
    }
    
    public void printDeque() {
        System.out.println("==============");
        Node temp = sentinel.rest;
        while (temp != sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.rest;
        }
        System.out.println("==============");
    }
    
    //public static void main(String[] args) {
    //    LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<Integer>();
    //    LinkedListDeque.addLast(0);
    //    LinkedListDeque.addLast(1);
    //    LinkedListDeque.addLast(2);
    //    LinkedListDeque.addLast(3);
    //    System.out.println(LinkedListDeque.removeFirst());
    //    LinkedListDeque.addFirst(5);
    //    LinkedListDeque.addLast(6);
    //    System.out.println(LinkedListDeque.getRecursive(2));
    //}

}
