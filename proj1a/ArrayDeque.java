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
        arr[head] = item;
        head--;
        if (head == -1) {
            head = size - 1;
        }
        if (itemNum > size) {
            resize(size * 2);
        }
    }
    
    public void addLast(T item) {
        itemNum++;
        arr[tail] = item;
        tail++;
        if (tail == size) {
            tail = 0;
        }
        if (itemNum > size) {
            resize(size * 2);
        }
    }
    
    public void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        int newIndex = 0;
        for (int oldIndex = head + 1; oldIndex < size; oldIndex++) {
            temp[newIndex] = arr[oldIndex];
            newIndex++;
        }
        for (int oldIndex = 0; oldIndex < head + 1; oldIndex++) {
            temp[newIndex] = arr[oldIndex];
            newIndex++;
        }
        arr = temp;
        size = newSize;
        head = size - 1;
        tail = newIndex;
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
        T returnValue;
        itemNum--;
        if (isEmpty()) {
            return null;
        }
        if (head == size - 1) {
            returnValue = arr[0];
            arr[0] = null;
            head = 0;
        } else {
            returnValue = arr[head + 1];
            arr[head + 1] = null;
            head++;
        }
        return returnValue;
    }
    
    public T removeLast() {
        T returnValue;
        itemNum--;
        if (isEmpty()) {
            return null;
        }
        if (tail == 0) {
            returnValue = arr[size - 1];
            arr[size - 1] = null;
            tail = size - 1;
        } else {
            returnValue = arr[tail - 1];
            arr[tail - 1] = null;
            head--;
        }
        return returnValue;
    }
    
    public T get(int index) {
        if (isEmpty() || index + 1 > itemNum) {
            return null;
        }
        if (index > size - 1 - head) {
            index = index - (size - 1 - head);
            return arr[index];
        } else {
            return arr[head + 1 + index];
        }
    }
    
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<Integer>();
        System.out.println("size is " + arrayDeque1.size());
        arrayDeque1.addFirst(2);
        System.out.println("size is " + arrayDeque1.size());
        arrayDeque1.addFirst(1);
        arrayDeque1.addFirst(0);
        arrayDeque1.addLast(3);
        arrayDeque1.addLast(4);
        arrayDeque1.addLast(5);
        arrayDeque1.addLast(6);
        arrayDeque1.addLast(7);
        arrayDeque1.addLast(8);
        arrayDeque1.removeFirst();
        arrayDeque1.removeFirst();
        //System.out.println("size is " + arrayDeque1.size());
        arrayDeque1.printDeque();
        System.out.println(arrayDeque1.get(5));
    }
}
