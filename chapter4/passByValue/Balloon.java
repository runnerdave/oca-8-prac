import java.util.*;

public class Balloon {
 
    private String color;
 
    public Balloon(){}
     
    public Balloon(String c){
        this.color=c;
    }
     
    public String getColor() {
        return color;
    }
 
    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
    	return "Balloon of color:" + getColor();
    }
}

class Test {
 
    public static void main(String[] args) {
 
        Balloon red = new Balloon("Red"); //memory reference 50
        Balloon blue = new Balloon("Blue"); //memory reference 100
         
        swap(red, blue);
        System.out.println("red color="+red.getColor());
        System.out.println("blue color="+blue.getColor());
         
        foo(blue);
        System.out.println("blue color="+blue.getColor());

        Balloon[] b = new Balloon[3];
        b[0] = new Balloon("Black");
        b[1] = new Balloon("White");
        b[2] = new Balloon("Gray");
        System.out.println("before arrayFoo:" + Arrays.asList(b));
        arrayFoo(b);
        System.out.println("after arrayFoo:" + Arrays.asList(b)); 
        swapArrayFoo(b);
        System.out.println("after swap array:" + Arrays.asList(b)); 
    }
 
    private static void foo(Balloon balloon) { //baloon=100
        balloon.setColor("Red"); //baloon=100
        balloon = new Balloon("Green"); //baloon=200
        balloon.setColor("Blue"); //baloon = 200
    }

    private static void arrayFoo(Balloon[] balloons) {
    	if (balloons.length > 1) {
    		balloons[0].setColor("Pink");
    		balloons[1] = new Balloon("Gold");
    		System.out.println("inside of arrayFoo:" + Arrays.asList(balloons)); 		
    	}    	
    }

    private static void swapArrayFoo(Balloon[] balloons) {
    	if (balloons.length > 2) {
    		Balloon temp = balloons[0];    		
    		balloons[0] = balloons[2];
    		balloons[2] = temp;
    		System.out.println("inside of swapArrayFoo:" + Arrays.asList(balloons)); 		
    	}
    }
 
    //Generic swap method
    public static void swap(Object o1, Object o2){
        Object temp = o1;
        o1=o2;
        o2=temp;
    }
}