// --== CS400 Project One File Header ==--
//// Name: Sangho Jeon
// CSL Username: <sangho>
// Email: <sjeon36@wisc.edu>
// Lecture #: <002 @1:00pm>
// Notes to Grader: <any optional extra notes to your grader>

import java.util.List;

public class AlgorithmEngineerTest {
	
// to test if it put values with same key into List
	public static boolean test1() {
		
		HashTableSortedSets<Integer, Integer> g = new HashTableSortedSets<>();
		
		g.add(4, 15);
		g.add(4, 5);
		List<Integer> values = g.get(4);
		if (values.contains(13)) {
			return false;
		}
		if(values.size()!=2 || !values.contains(15)) {
			return false;
		}
		return true;
	}

	// to test the generic type works well 
	public static boolean test2() {
		HashTableSortedSets<String, String> g = new HashTableSortedSets<>();
		g.add("Cafe", "IcedAmericano");
		g.add("Cafe", "CafeMocha");
		g.add("Cafe", "Latte");
		g.add("Restaurant", "Ramen");
		List<String> coffees = g.get("Cafe");
		List<String> foods = g.get("Restaurant");
		if (!coffees.contains("IcedAmericano") || !coffees.contains("CafeMocha") || !coffees.contains("Latte")) {
			return false;
		}
		if (coffees.contains("Ramen")) {
			return false;
		}
		if (!foods.contains("Ramen")) {
			return false;
		}
		return true;
	}

	// to test if the values in the list sorted properly 
	public static boolean test3() {
		HashTableSortedSets<Integer, String> g = new HashTableSortedSets<>();
		g.add(1, "C");
		g.add(1, "A");
		g.add(1, "F");
		g.add(1, "Z");
		g.add(1, "B");
		
		List<String> values = g.get(1);
		String prv = "";
		for(String s: values) {
			if(prv ==  "") {
				prv = s;
				continue;
			}
			if(prv.compareTo(s) < 0) {
				return false;
			}
			prv = s;
		}
		return true;
		/* test code here */
	}
	// to test clear function can handle add function 
	public static boolean test4() {
		HashTableSortedSets<Integer, Integer> g = new HashTableSortedSets<>();
		g.add(2, 3);
		g.add(6, 1);
		g.add(6, 3);
		g.add(2, 5);
		g.clear();
		if (g.containsKey(2)) {
			return false;
		}
		if (g.containsKey(6)) {
			return false;
		}
		if (g.size() != 0) {
			return false;
		}
		return true;

		/* test code here */
	}
	// to test remove fucntion and size function works properly with add funciton 
	public static boolean test5() {
		HashTableSortedSets<Integer, Integer> g = new HashTableSortedSets<>();
		g.add(2, 4);
		g.add(2, 3);
		g.add(4, 8);
		g.add(4, 18);
		try {
			g.remove(2);
			if (g.size() != 1) {
				return false;
			} 
			
		}	catch (Exception e) {
				return false;
			}

		try {
			g.remove(3);
			if (g.size() == 0) {
				return false;
			}
		
		} 	catch (Exception e) {
				return false;
		}
		return true;

	}
	public static void main(String args[]) {
	
	if(test1()) {
		System.out.println("test1 Passes");
	}
	else {
		System.out.println("test1 Failed!");
	}
	
	if(test2()) {
		System.out.println("test2 Passes");
	}
	else {
		System.out.println("test2 Failed!");
	}
	
	if(test3()) {
		System.out.println("test3 Passes");
	}
	else {
		System.out.println("test3 Failed!");
	}
	
	if(test4()) {
		System.out.println("test4 Passes");
	}
	else {
		System.out.println("test4 Failed!");
	}
	
	if(test5()) {
		System.out.println("test5 Passes");
	}
	else {
		System.out.println("test5 Failed!");
	}
}
	
}

