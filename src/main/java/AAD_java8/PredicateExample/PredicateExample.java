package AAD_java8.PredicateExample;

import java.util.Arrays;
import java.util.List;

public class PredicateExample {
	public static void main(String[] args) {
		Child child1 = new Child(3);
		Child child2 = new Child(2);
		Child child3 = new Child(7);
		Child child4 = new Child(10);
		Child child5 = new Child(6);
		Child child6 = new Child(9);
		Child child7 = new Child(8);
		
		List<Child> childs = Arrays.asList(new Child[] { child1, child2, child3, child4, child5, child6, child7 });
		
		List<Child> filtered = ChildPredicates.filterChilds(childs,ChildPredicates.filterByAgeGreaterThanSpecifiedParam(8)); //8 = argument
		
		for (Child child: filtered) {
			System.out.println(child.getAge());
		}
	}
}
