package synthesizer;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(2);
        try {
            arb.dequeue();
        } catch (Exception e) {
            System.out.println("dequeue Overflow");
        }
        arb.enqueue(10);
        arb.enqueue(15);
        try {
            arb.enqueue(20);
        } catch (Exception e) {
            System.out.println("enqueue overflow");
        }
        assertTrue(arb.peek() == 10);
        arb.dequeue();
        assertTrue(arb.peek() == 15);
        arb.dequeue();
        try {
            arb.dequeue();
        } catch (Exception e) {
            System.out.println("dequeue Overflow");
        }
    }
    
    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}

