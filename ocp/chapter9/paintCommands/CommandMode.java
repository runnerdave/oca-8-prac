/**
 * Enumeration that represents a command mode to be used on a Canvas.
 *
 * Created by davidajimenez on 2/02/2017.
 */
enum CommandMode {
    FLOOD, PAINT;

    /**
     * Parses a string into a CommandMode.
     * @param mode the string representing the command mode.
     * @return the CommandMode parsed, null if nothing matches.
     */
    public static CommandMode parseCommandMode(String mode) {
        CommandMode o = null;
        switch (mode.toUpperCase()) {
            case "FLOOD":
                o = FLOOD;
                break;
            case "PAINT":
                o = PAINT;
                break;
        }
        return o;
    }
}