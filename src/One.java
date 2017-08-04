
public class One {

public static void main(String args[])
{
	int i=3;
	System.out.println("hello");
	System.out.println(".//*[@id='UN_PRG_RULE_VW_SCC_RULE_NAME$"+i+"']");
	
	String str = "1-7 of 7";
	
	int k = Integer.parseInt(str.substring(str.indexOf("of")+2).trim());
	
	System.out.println(k);
	
	HiHemant();
	
}

public static void HiHemant() {
	System.out.println("This is Hi for Hemant");
}

}


