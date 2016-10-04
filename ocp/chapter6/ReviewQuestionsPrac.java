/*

answer to 3:

<div class="answerContent"><p class="AnswerTxt"><b> Answer: E </b></p><div class="ansText">Options B, D, and F are incorrect because only one variable name is allowed in a multi-catch block. Option A is incorrect because <span class="dCode dNoWrap">FileNotFoundException</span> is a subclass of <span class="dCode dNoWrap">IOException</span>. A multi-catch statement does not allow redundancy, and just catching <span class="dCode dNoWrap">IOException</span> would have been equivalent. Option C is incorrect because the <span class="dCode dNoWrap">IOException</span> that is thrown is not handled.</div></div>

answer to 5:

<div class="answerContent"><p class="AnswerTxt"><b> Answer: C </b></p><div class="ansText">After opening both resources in the try-with-resources statement, <span class="dCode dNoWrap">T</span> is printed. Then the try-with-resource completes and closes the resources in reverse order from which they were opened. After <span class="dCode dNoWrap">W</span> is printed, an exception is thrown. However, the remaining resource is still closed and <span class="dCode dNoWrap">D</span> is printed. The exception thrown is then caught and <span class="dCode dNoWrap">E</span> is printed. Last, the <span class="dCode dNoWrap">finally</span> block is run, printing <span class="dCode dNoWrap">F</span>. Therefore the answer is <span class="dCode dNoWrap">TWDEF</span>.</div></div>


answer to 6:

<div class="answerContent"><p class="AnswerTxt"><b> Answer: G </b></p><div class="ansText">A try-with-resources statement uses parentheses rather than brackets for the <span class="dCode dNoWrap">try</span> section. This is likely subtler than a question that you'll get on the exam, but it is still important to be on alert for details.</div></div>

code question 7, 16

*/
public class ReviewQuestionsPrac {
	
	public static void main(String... a) {
		System.out.println("here goes the question");
	}

}