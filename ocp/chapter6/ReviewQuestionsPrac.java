/*

answer to 3:

<div class="answerContent"><p class="AnswerTxt"><b> Answer: E </b></p><div class="ansText">Options B, D, and F are incorrect because only one variable name is allowed in a multi-catch block. Option A is incorrect because <span class="dCode dNoWrap">FileNotFoundException</span> is a subclass of <span class="dCode dNoWrap">IOException</span>. A multi-catch statement does not allow redundancy, and just catching <span class="dCode dNoWrap">IOException</span> would have been equivalent. Option C is incorrect because the <span class="dCode dNoWrap">IOException</span> that is thrown is not handled.</div></div>

answer to 5:

<div class="answerContent"><p class="AnswerTxt"><b> Answer: C </b></p><div class="ansText">After opening both resources in the try-with-resources statement, <span class="dCode dNoWrap">T</span> is printed. Then the try-with-resource completes and closes the resources in reverse order from which they were opened. After <span class="dCode dNoWrap">W</span> is printed, an exception is thrown. However, the remaining resource is still closed and <span class="dCode dNoWrap">D</span> is printed. The exception thrown is then caught and <span class="dCode dNoWrap">E</span> is printed. Last, the <span class="dCode dNoWrap">finally</span> block is run, printing <span class="dCode dNoWrap">F</span>. Therefore the answer is <span class="dCode dNoWrap">TWDEF</span>.</div></div>


answer to 6:

<div class="answerContent"><p class="AnswerTxt"><b> Answer: G </b></p><div class="ansText">A try-with-resources statement uses parentheses rather than brackets for the <span class="dCode dNoWrap">try</span> section. This is likely subtler than a question that you'll get on the exam, but it is still important to be on alert for details.</div></div>

code question 7, 16

*/
import java.io.*;
public class ReviewQuestionsPrac {
	
	public static void main(String... args) {
		System.out.println("==== Question 3 =====");

		/*
		uncomment the try and place the options below, which one should work?

		A. FileNotFoundException | IOException e -- inheritance problem
		B. FileNotFoundException e | IOException e -- bad syntax
		C. FileNotFoundException | RuntimeException e -- FileNotFound is a subclass of IOException therefore IOException is not handled
		D. FileNotFoundException e | RuntimeException e  -- bad syntax
		E. IOException | RuntimeException e
		F. IOException e | RuntimeException e -- bad syntax
		

		try {
			throw new IOException();
		} catch (IOException | RuntimeException e) { }

		*/

		System.out.println("==== Question 5 =====");

		/*
		what is printed below
		A. TWF
		B. TWDF
		C. TWDEF
		D. TWF followed by an exception		
		E. TWDF followed by an exception
		F. TWEF followed by an exception
		G. The code does not compile.

		*/
		int suppressedExceptionsLength = 0;
		Exception caughtException = null;
		try (AutocloseableFlow.Door d = new AutocloseableFlow.Door(); 
			 AutocloseableFlow.Window w = new AutocloseableFlow.Window()) {
				System.out.print("T"); 
		} catch (Exception e) {
				System.out.print("E"); 
				suppressedExceptionsLength = e.getSuppressed().length;
				caughtException = e;
		} finally {
				System.out.print("F"); 
		}
		System.out.println("\nnumber of suppressed exceptions: " + suppressedExceptionsLength);
		System.out.println("\ncaught exception: " + caughtException.getClass());

		System.out.println("==== Question 7 =====");

		/*
		What is the result of running java ReviewQuestionsPrac hi there with the following code?
		A. hithere
		B. The assert statement throws an AssertionError.
		C. The code throws an ArrayIndexOutOfBoundsException.
		D. The code compiles and runs successfully, but there is no output.
		E. The code does not compile.
		*/

		try {
			if(args.length <= 3) assert false;
				System.out.println(args[0] + args[1] + args[2]);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("==== Question 16 =====");

		/*
		What is the output of the following?
		A. rain 0
		B. rain 1
		C. rain 2
		D. show 0
		E. snow 1
		F. snow 2
		G. The code does not compile.

		Answer C: The exception inside the try block becomes the primary exception since it is thrown first. 
		Then two suppressed exceptions are added to it when trying to close the AutoCloseable resources.
		*/

		try (SnowStorm.Walk walk1 = new SnowStorm.Walk(); 
			SnowStorm.Walk walk2 = new SnowStorm.Walk();) { 
			throw new RuntimeException("rain");
		} catch(Exception e) { 
			System.out.println(e.getMessage()
								+ " " + e.getSuppressed().length); 
		}

	}

} 

class AutocloseableFlow {
	static class Door implements AutoCloseable {
	 	public void close() {
			System.out.print("D");
		}
	}
	static class Window implements Closeable { 
		public void close() {
			System.out.print("W");
			throw new RuntimeException(); 
		}
	}
	/*public static void main(String[] args) {
		try (Door d = new Door(); Window w = new Window()) {
			System.out.print("T"); } catch (Exception e) {
			System.out.print("E"); } finally {
			System.out.print("F"); 
		}
	} */
}

class SnowStorm {
	static class Walk implements AutoCloseable { 
		public void close() {
			throw new RuntimeException("snow"); 
		}
	}
}