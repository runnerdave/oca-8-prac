
public class BundlePrac {
	
	public static void main(String... args) {

		//Consider the following piece of code:

        Locale.setDefault(new Locale("fr", "CA")); //Set default to French Canada
        Locale l = new Locale("jp", "JP");
        ResourceBundle rb = ResourceBundle.getBundle("appmessages", l);
        String msg = rb.getString("greetings");
        System.out.println(msg);

        /*
		You have created two resource bundle files with the following contents:

		#In appmessages.properties:
		greetings=Hello

		#In appmessages_fr_FR.properties:
		greetings=bonjour

		Given that this code is run on machines all over the world. Which of the following statements are correct?

		a. It will throw an exception when the default locale of the machine where it is run is different from fr/FR and fr/CA

		b. It will throw an exception where ever it is run.

		c. It will throw an exception when the default locale of the machine is fr/CA.

		d. It will throw an exception when the default locale of the machine is jp/JP.

		e. It will run without any exception all over the world.

		answer:

		e.

		explanation:

		While retrieving a message bundle, you are passing a locale explicitly (jp/JP). Therefore, it 
		will first try to load appmessages_jp_JP.properties. Since this file is not present, it will look
		 for a resource bundle for default locale. Since you are changing the default locale to "fr",
		  "CA", it will look for appmessages_fr_CA.properties, which is also not present. 

		Remember that when a resource bundle is not found for a given locale, the default locale is used
		 to load the resource bundle.  Every effort is made to load a resource bundle if one is not found 
		 and there are several fall back options (in absence of appmessages_fr_CA.properties, it will 
		 look for appmessages_fr.properties). As a last resort, it will try to load a resource bundle 
		 with no locale information i.e. appmessages.properties in this case. (An exception is thrown 
		 when even this resource bundle is not found.)

		Since appmessages.properties is available, the code will never throw an exception in any locale.

		You need to understand this aspect for the purpose of the exam. Please go through 
		http://docs.oracle.com/javase/7/docs/api/java/util/ResourceBundle.html#getBundle(java.lang.String,%20java.util.Locale,%20java.lang.ClassLoader) 
		for further details.



		*/
	}
}