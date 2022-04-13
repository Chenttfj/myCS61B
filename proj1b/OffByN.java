public class OffByN implements CharacterComparator{
    int N;
    @Override
    public boolean equalChars(char x, char y) {
        if (x + N == y || x - N == y) {
            return true;
        } else {
            return false;
        }
    }
    
    OffByN(int N) {
        this.N = N;
    }
}
