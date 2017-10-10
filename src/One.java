import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class One {

	public static void main(String args[])
	{
//		HashMapExample();
//		System.exit(0);
//		int i=3;
//		System.out.println("hello");
//		System.out.println(".//*[@id='UN_PRG_RULE_VW_SCC_RULE_NAME$"+i+"']");
//		
//		String str2 = "1-7 of 7";
		
		String year = "M_4YR_4S";
		String stage = "Stage 4";
		
		int k = Integer.parseInt(year.substring(year.indexOf("_")+1,year.indexOf("_")+2).trim());
		System.out.println(k);
		
		int s = Integer.parseInt(stage.substring(stage.length()-2).trim());
		System.out.println(s);
		
		if(k==s) {
			System.out.println("FinalYear");
		}
		else {
			System.out.println("FinalYearNo");
		}
		
//		String str = "SSR_APT_RSLT_SSR_RSLT_TYPE$51";
//		
//		int k = Integer.parseInt(str.substring(str.indexOf("$")+1).trim());
//		
//		System.out.println(k);
		
		//HiHemant();
		//mylist();
		
	}

	public static void HashMapExample(){
		System.out.println("HashMap Example");
		
		HashMap<Integer, String> hm = new HashMap<>();
		
		hm.put(10, "ten");
		hm.put(11, "Eleven");
		hm.put(12, "twelve");
		
		System.out.println(hm.size());
		System.out.println(hm.keySet());
		System.out.println(hm.values());
		
		System.out.println(hm.containsKey(13));
		System.out.println(hm.containsValue("ten"));
		
		for(Map.Entry m:hm.entrySet()) {
			System.out.println(m);
			System.out.println(m.getKey());
			System.out.println(m.getValue());
		}
		
	}
	
	
	public static void HiHemant() {
		System.out.println("This is Hi for Hemant");
	}

	public static void mylist(){
		

		String[] myStrings = new String[] {"Elem1","Elem2","Elem3","Elem4","Elem5"};
		
		List mylist = Arrays.asList(myStrings );
		
		//getting an iterator object to browse list items
		
		Iterator itr= mylist.iterator();
		
		System.out.println("Displaying List Elements,");
		
		while(itr.hasNext())
		  System.out.println(itr.next());
		
		
		List<String> list = new ArrayList<>();
		
		list.add("a");
		list.add("h");
		list.add("f");
		list.add("s");
		System.out.println("size : " + list.size());		
		
		int length = list.size();
		for(int i = 0; i < length; i++) {
		   System.out.println("items : " + list.get(i));
		}
		
		
		for (String s : list)     
		{
			System.out.println("items again : " + s);
		}
		
	}

}