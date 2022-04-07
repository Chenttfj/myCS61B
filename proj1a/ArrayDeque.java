public class ArrayDeque<T> {
    public T[] arr;
    public int size = 8;
    public int head = size - 1;
    public int tail = 0;
    public int itemNum = 0;
    
    
    public ArrayDeque() {
        arr = (T[]) new Object[size];
    }
    
    public void addFirst(T item) {
        itemNum++;
        if (itemNum > size) {
            resize(size * 2);
        }
        arr[head] = item;
        head--;
        if (head == -1) {
            head = size - 1;
        }
    }
    
    public void addLast(T item) {
        itemNum++;
        if (itemNum > size) {
            resize(size * 2);
        }
        arr[tail] = item;
        tail++;
        if (tail == size) {
            tail = 0;
        }
    }
    
    public void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        int newIndex = 0;
        for (int oldIndex = head + 1; oldIndex < size && newIndex < newSize; oldIndex++) {
            temp[newIndex] = arr[oldIndex];
            newIndex++;
        }
        for (int oldIndex = 0; oldIndex < head + 1 && newIndex < newSize; oldIndex++) {
            temp[newIndex] = arr[oldIndex];
            newIndex++;
        }
        arr = temp;
        size = newSize;
        head = size - 1;
        if (newIndex == size) {
            tail = 0;
        } else {
            tail = newIndex;
        }
        //System.out.println(tail);
        //printDeque();
    }
    
    public void printDeque() {
        System.out.println("=============");
        for (int Index = head + 1; Index < size; Index++) {
            System.out.println(arr[Index] + " ");
        }
        for (int Index = 0; Index < head + 1; Index++) {
            System.out.println(arr[Index] + " ");
        }
        System.out.println("=============");
    }
    
    public boolean isEmpty() {
        if (itemNum == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int size() {
        return itemNum;
    }
    
    public T removeFirst() {
        if (isEmpty() == true) {
            return null;
        }
        T temp;
        itemNum--;
        if (head == size - 1) {
            temp = arr[0];
            arr[0] = null;
            head = 0;
        } else {
            temp = arr[head + 1];
            arr[head + 1] = null;
            head++;
        }
        if (itemNum <= size / 2 && itemNum > 4) {
            resize(size / 2);
        }
        return temp;
    }
    
    public T removeLast() {
        if (isEmpty() == true) {
            return null;
        }
        itemNum--;
        T temp;
        if (tail == 0) {
            temp = arr[size - 1];
            arr[size - 1] = null;
            tail = size - 1;
        } else {
            temp = arr[tail - 1];
            arr[tail - 1] = null;
            tail--;
        }
        if (itemNum <= size / 2 && itemNum > 4) {
            resize(size / 2);
        }
        return temp;
    }
    
    public T get(int index) {
        if (isEmpty() == true || index + 1 > itemNum) {
            return null;
        }
        if (index >= size - 1 - head) {
            index = index - (size - 1 - head);
            return arr[index];
        } else {
            return arr[head + 1 + index];
        }
    }
    
    public static void main(String[] args) {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addFirst(0);
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(2);
        ArrayDeque.removeFirst();
        
        ArrayDeque.addFirst(4);
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(6);
        ArrayDeque.isEmpty();
        ArrayDeque.removeFirst();
        ArrayDeque.isEmpty();
        ArrayDeque.isEmpty();
        ArrayDeque.addFirst(11);
    }
}
