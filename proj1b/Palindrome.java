public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (word == null) {
            return new LinkedListDeque<>();
        }
        int max = word.length();
        Deque<Character> characterDeque = new LinkedListDeque<Character>();
        for (int i = 0; i < max; i++) {
            characterDeque.addLast(word.charAt(i));
        }
        return  characterDeque;
    }
    
    public boolean isPalindrome(String word) {
        if (word == null || word.length() == 1 || word.length() == 0) {
            return true;
        }
        
        Deque d = wordToDeque(word);
        return remainDeque(d);
    }
    
    private boolean remainDeque (Deque d) {
        if (d == null || d.size() == 1 || d.size() == 0) {
            return true;
        }
        if (d.removeFirst() != d.removeLast()) {
            return false;
        } else {
            return remainDeque(d);
        }
    }
    
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.length() == 1 || word.length() == 0) {
            return true;
        }
        for (int i = 0; i < word.length() / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(word.length() - 1 - i))){
                return false;
            }
        }
        return true;
    }

}
