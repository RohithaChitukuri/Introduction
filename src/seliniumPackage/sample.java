package seliniumPackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class sample {

	public static void main(String[] args) {
		/*
		 * HashMap<String,List<String>> map1=new HashMap<String,List<String>>();
		 * List<String> veggies1= Arrays.asList("Brocolli","Cucumber"); List<String>
		 * veggies2= Arrays.asList("Carrot","Cucumber");
		 * map1.put("veggiesList1",veggies1); map1.put("veggiesList2", veggies2);
		 * map1.get("veggiesList1").stream().forEach(s->System.out.println(s));
		 * System.out.println("---------------------------------------------");
		 * map1.values().stream().flatMap(List::stream).forEach(s->System.out.println(s)
		 * );
		 */
		String s= "$23";
		System.out.println((s.split("\\$"))[1]); 
		
		
		
		

	}
	public static Object[][] getData(){
		HashMap<String,List<String>> map1=new HashMap<String,List<String>>();
		map1.put("veggeisList",Arrays.asList("Brocolli","Cucumber"));
	
		
//		HashMap<String,List<String>> map2=new HashMap<String,List<String>>();
//		map2.put("veggiesList", new ArrayList<String>(Arrays.asList("Cucumber","Walnuts")));
		
		return new Object[][] {{map1}};
		
	}

}
