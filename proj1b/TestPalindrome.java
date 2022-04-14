import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
        Deque d1 = palindrome.wordToDeque("");
        actual = "";
        for (int i = 0; i < "".length(); i++) {
            actual += d1.removeFirst();
        }
        assertEquals("", actual);
    }
    
    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("cac"));
        assertFalse(palindrome.isPalindrome("ca"));
        assertTrue(palindrome.isPalindrome("A"));
        assertTrue(palindrome.isPalindrome(null));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("plkhelloollehklp"));
        assertTrue(palindrome.isPalindrome("plkhellollehklp"));
        assertFalse(palindrome.isPalindrome("plkhellollexklp"));
        assertFalse(palindrome.isPalindrome("plkhelloollexklp"));
        assertTrue(palindrome.isPalindrome("t"));
        assertTrue(palindrome.isPalindrome("noon"));
    }
    
    public void testIsPalindromecc() {
        OffByOne obo = new OffByOne();
        assertFalse(palindrome.isPalindrome("plkhelloollexklp", obo));
        assertTrue(palindrome.isPalindrome("fdbflakeacg", obo));
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertTrue(palindrome.isPalindrome("hi", obo));
        assertTrue(palindrome.isPalindrome("hig", obo));
        assertFalse(palindrome.isPalindrome("hiz", obo));
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome(null, obo));
        assertTrue(palindrome.isPalindrome("a", obo));
        assertTrue(palindrome.isPalindrome("abcb", obo));
        assertFalse(palindrome.isPalindrome("abcbd", obo));
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome("a", obo));
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertTrue(palindrome.isPalindrome("zyzy", obo));
        assertTrue(palindrome.isPalindrome("yyxz", obo));
        assertTrue(palindrome.isPalindrome("yyyxz", obo));
        assertFalse(palindrome.isPalindrome("aa", obo));
        assertFalse(palindrome.isPalindrome("xyz", obo));
        assertFalse(palindrome.isPalindrome("aa", obo));
        assertFalse(palindrome.isPalindrome("zxzx", obo));
    }
}
