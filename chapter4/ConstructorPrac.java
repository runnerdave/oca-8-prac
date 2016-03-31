import java.util.*;
public class ConstructorPrac {
	
	public void fly(int... i){
		System.out.println(Arrays.toString(i));
	} 

//	public void fly(int[] i){
//		System.out.println(Arrays.toString(i));
//	} 

	public static void main(String[] args){
		ConstructorPrac cp = new ConstructorPrac();
//		cp.fly(1,2,3);
		int[] i = {1,2,3};
//		cp.fly(i);
		cp.fly(new int[]{1,2});
		Rope.swing();
          System.out.println(Rope.LENGTH);//15
		Rope.swing(2);
          System.out.println(Rope.LENGTH);//16
		Rope.swing(2);
          System.out.println(Rope.LENGTH);//17
		Rope rope = null;
		rope.swing();
          rope = new Rope();
          rope.Rope();

          System.out.println("=================");
          System.out.println("Time for slings:");
          Sling s = new Sling("oo");
          System.out.println("s width:" + s.width);
          System.out.println("s length:" + s.length);
          System.out.println("s width with method:" + s.getWidth());
          System.out.println("s length with method:" + s.getLength());
          Sling sl = new SlingShot();
          System.out.println("sl width:" + sl.width);
          System.out.println("sl length:" + sl.length);
          System.out.println("sl width with method:" + sl.getWidth());
          System.out.println("sl length with method:" + sl.getLength());
          System.out.println("sl length with method (cast):" + ((SlingShot)sl).getLength());
          SlingShot sls = new SlingShot();
          System.out.println("sls width:" + sls.width);         
          System.out.println("sls length:" + sls.length);
          System.out.println("sls width with method:" + sls.getWidth());
          System.out.println("sls length with method:" + sls.getLength());
          Sling msl = new MudSling();
          System.out.println("msl width:" + msl.width);
          System.out.println("msl length:" + msl.length);
          System.out.println("msl width with cast to Mudsling:" + ((MudSling)msl).width);
          System.out.println("msl length with cast to Mudsling:" + ((MudSling)msl).length);
          System.out.println("msl width with cast to slingshot:" + ((SlingShot)msl).width);
          System.out.println("msl length with cast to slingshot:" + ((SlingShot)msl).length);
          System.out.println("msl width with method:" + msl.getWidth());
          System.out.println("msl length with method:" + msl.getLength());
          SlingShot mslshot = new MudSling();
          System.out.println("mslshot width:" + mslshot.width);
          System.out.println("mslshot length:" + mslshot.length);
          System.out.println("mslshot width with method:" + mslshot.getWidth());
          System.out.println("mslshot length with method:" + mslshot.getLength());
          MudSling mudslshot = new MudSling();
          System.out.println("mudslshot width:" + mudslshot.width);
          System.out.println("mudslshot length:" + mudslshot.length);
          System.out.println("mudslshot width with method:" + mudslshot.getWidth());
          System.out.println("mudslshot length with method:" + mudslshot.getLength());
          mudslshot.getJewels();
          ((SlingShot)mudslshot).getJewels();
	}
}
