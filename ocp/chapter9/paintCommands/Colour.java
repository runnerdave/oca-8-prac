
/**
 * Enumeration to represent colours in the application.
 *
 * Created by davidajimenez on 1/02/2017.
 */
enum Colour {
    WHITE(" "), BLACK("#");

    private final String representation;

    /**
     * @param text string representation of the colour for use in the command line printing.
     */
    Colour(final String text) {
        this.representation = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return representation;
    }

    /**
     * Parses a string into a Colour.
     * @param colour the string representing the colour.
     * @return the Colour parsed, null if nothing matches.
     */
    public static Colour parseColour(String colour) {
        Colour o = null;
        switch (colour.toUpperCase()) {
            case "WHITE":
                o = WHITE;
                break;
            case "BLACK":
                o = BLACK;
                break;
        }
        return o;
    }
}