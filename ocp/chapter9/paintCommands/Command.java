

/**
 * Command class, used to process commands over a given Canvas.
 *
 * Created by davidajimenez on 2/02/2017.
 */
class Command {
    private final int x;
    private final int y;
    private final Colour colour;
    private final CommandMode mode;
    private String canvas;

    /**
     * Constructor for the Command.
     * @param x x coordinate.
     * @param y y coordinate.
     * @param mode CommandMode value.
     * @param colour Colour value.
     * @param canvas canvas to paint on.
     */
    public Command(int x, int y, CommandMode mode, Colour colour, String canvas) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.mode = mode;
        this.canvas = canvas;
    }

    /**
     * Executes the method for the command.
     */
    public void execute() {
        switch (mode) {
            case PAINT:
                canvas = canvas + "-Painted";
                break;
            case FLOOD:
                canvas = canvas + "-Flooded";
                break;
        }
        System.out.println(canvas + " at " + x + "," + y);
        try {
            Thread.sleep(1_00);
        } catch (InterruptedException e) {
            //suppress this exception
        }
    }
}