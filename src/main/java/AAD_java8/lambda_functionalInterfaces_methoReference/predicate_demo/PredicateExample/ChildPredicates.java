package AAD_java8.lambda_functionalInterfaces_methoReference.predicate_demo.PredicateExample;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChildPredicates {
	//Predicate is a function in java 8. we can pass this function in list.stream().filter(predicate)...
	static Predicate<Child> filterByAgeGreaterThanSpecifiedParam(int x) { //param = x
		return a -> a.getAge() > x; //lambda expression
	}
	
	static List<Child> filterChilds(List<Child> childs, Predicate<Child> predicate) {
		return childs.stream().filter(predicate)
				.collect(Collectors.<Child> toList());
	}
}
