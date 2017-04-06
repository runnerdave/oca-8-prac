//Which are true about the following code? (Choose all that apply.)
public enum Suit {
        SPADE(Color.BLACK), HEART(Color.RED), 
        DIAMOND(Color.RED), CLUB(Color.BLACK);
        private enum Color { RED, BLACK; }
        private Suit(Color c) { color = c; }
        public Color color;
}

/*what can and cannot be done to break the compiling of this file:
    - don't use static
    - the private in line 6 is ok to remove
*/