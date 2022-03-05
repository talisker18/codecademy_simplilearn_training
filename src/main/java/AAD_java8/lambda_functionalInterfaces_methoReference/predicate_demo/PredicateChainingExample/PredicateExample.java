package AAD_java8.lambda_functionalInterfaces_methoReference.predicate_demo.PredicateChainingExample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		Child child1 = new Child(3);
		Child child2 = new Child(2);
		Child child3 = new Child(7);
		Child child4 = new Child(10);
		Child child5 = new Child(6);
		Child child6 = new Child(9);
		Child child7 = new Child(8);
		Child child8 = new Child(16);
		
		List<Child> childs = Arrays.asList(new Child[] { child1, child2, child3, child4, child5, child6, child7, child8 });
		
		Predicate [] filters = {
				ChildPredicates.filterByAgeGreaterThanSpecifiedParam(8),
				ChildPredicates.filterByAgeLessThanSpecifiedParam(15)
				}
		;
		
		List<Child> filtered = ChildPredicates.chainedFilter(childs,filters);
		
		for (Child child: filtered) {
			System.out.println(child.getAge());
		}
	}
}
