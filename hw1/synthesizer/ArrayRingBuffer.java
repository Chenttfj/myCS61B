// Make sure to make this class a part of the synthesizer package
package synthesizer;

import synthesizer.AbstractBoundedQueue;

import java.util.Iterator;

//Make sure to make this class and all of its methods public
//Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;
    
    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        //       Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }
    
    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    
    public void enqueue(T x) {
        // Enqueue the item. Don't forget to increase fillCount and update last.
        if (fillCount >= capacity) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last++;
        if (last == capacity) {
            last = 0;
        }
        fillCount++;
    }
    
    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // Dequeue the first item. Don't forget to decrease fillCount and update
        if (fillCount == 0) {
            throw new RuntimeException("Ring buffer overflow");
        }
        T temp = rb[first];
        rb[first] = null;
        first++;
        if (first == capacity) {
            first = 0;
        }
        fillCount--;
        return temp;
    }
    
    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // Return the first item. None of your instance variables should change.
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer overflow");
            //return null;
        } else {
            return rb[first];
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }
    
    protected class ArrayRingBufferIterator implements Iterator<T> {
        int count = 0;
        int position = first - 1;
        @Override
        public boolean hasNext() {
            if (isEmpty() || count > fillCount) {
                return false;
            }
            count++;
            position++;
            if (position == capacity) {
                position = 0;
            }
            return true;
        }
    
        @Override
        public T next() {
            return rb[position];
        }
    }
    
   
}
