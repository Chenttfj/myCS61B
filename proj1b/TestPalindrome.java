import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    OffByOne obo = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);

    }
    
    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("cac"));
        assertFalse(palindrome.isPalindrome("ca"));
        assertTrue(palindrome.isPalindrome("A"));
        assertTrue(palindrome.isPalindrome(null));
        assertTrue(palindrome.isPalindrome("plkhelloollehklp"));
        assertTrue(palindrome.isPalindrome("plkhellollehklp"));
        assertFalse(palindrome.isPalindrome("plkhellollexklp"));
        assertFalse(palindrome.isPalindrome("plkhelloollexklp"));
        assertFalse(palindrome.isPalindrome("plkhelloollexklp", obo));
        assertTrue(palindrome.isPalindrome("flake", obo));
    }
}
