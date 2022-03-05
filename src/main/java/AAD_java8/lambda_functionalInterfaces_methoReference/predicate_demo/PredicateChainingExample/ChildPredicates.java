package AAD_java8.lambda_functionalInterfaces_methoReference.predicate_demo.PredicateChainingExample;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChildPredicates {
	//Predicate is a function in java 8. we can pass this function in list.stream().filter(predicate)...
	static Predicate<Child> filterByAgeGreaterThanSpecifiedParam(int x) { //param = x
		return a -> a.getAge() > x; //lambda expression
	}
	
	static Predicate<Child> filterByAgeLessThanSpecifiedParam(int x) { //param = x
		return a -> a.getAge() < x; //lambda expression
	}
	
	//single filter
	static List<Child> filterChilds(List<Child> childs, Predicate<Child> predicate) {
		return childs.stream().filter(predicate)
				.collect(Collectors.<Child> toList());
	}
	
	//chained filter
	static List<Child> chainedFilter(List<Child> childs, Predicate<Child> [] predicates) {
		Stream<Child> stream = childs.stream();
		
		for(Predicate<Child> pred: predicates) {
			stream = stream.filter(pred);
		}
		
		return stream
				.collect(Collectors.<Child> toList());
	}
}
