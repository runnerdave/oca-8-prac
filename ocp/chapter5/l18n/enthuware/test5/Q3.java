import java.util.*;

public class Q3 {
	public static void main(String... args) {
		Locale myloc = new Locale.Builder().setLanguage("en").setRegion("UK").build(); //L1 
		ResourceBundle msgs = ResourceBundle.getBundle("mymsgs", myloc);  
		Enumeration<String> en = msgs.getKeys(); 
		while(en.hasMoreElements()){
		 	String key = en.nextElement();
		  	String val = msgs.getString(key);
		   	System.out.println(key+" : "+val); 
		}
	}
}

/*

Assume that only the following two properties files (contents of the file is shown below the name of the file) are accessible to the code.  

1. mymsgs.properties
 okLabel=OK
 cancelLabel=Cancel   

2. mymsgs_en_UK.properties
 okLabel=YES
 noLabel=NO

a. It will not compile due to line L1.

b. It will not print anything.

c. okLabel=OK 
   cancelLabel=Cancel

d. noLabel : NO
   okLabel : YES 
   cancelLabel : Cancel

e. noLabel : NO 
   okLabel : OK 
   cancelLabel : Cancel

explanation:

mymsgs.properties is the base file for this resource bundle. Therefore, it will be loaded first. 
Since the language and region specific file is also present (_en_UK), it will also be loaded and the values in this file will
 be superimposed on the values of the base file.

Remember that if there were another properties file named mymsgs_en.properties also present, then that file would have been 
loaded before mymsgs_en_UK.properties.
*/
