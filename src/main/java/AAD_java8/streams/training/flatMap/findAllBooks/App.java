package AAD_java8.streams.training.flatMap.findAllBooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
	
	public static void main(String[] args) {
		Developer o1 = new Developer();
        o1.setName("mkyong");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        // hmm....List of Sets...how to process?

        Set<String> set = list.stream() //return Stream<Developer> ---> is equal to: Stream.of(list.toArray(new Developer[list.size()]))
                        .map(dev -> dev.getBooks())   //  Stream<Set<String>> --->for each dev get his books as Set<String>  --> we have to use map before flatMap because we need Set<String> at the end
                        .flatMap(booksOfDev -> booksOfDev.stream())                           //  Stream<String> --->after map we got a Stream containing Set<String> sets...we flaten this stream by picking all Strings from each single Set
                        .filter(book -> !book.toLowerCase().contains("python"))   //  filter books NOT containing python
                        .collect(Collectors.toSet());                       //  remove duplicated

        set.forEach(System.out::println); 
        
        System.out.println("-------------------------");
        
        //we can do it like this as well
        
        Stream<Developer> streamOfDevelopers = list.stream();
        
        Stream<Set<String>> streamOfSets = streamOfDevelopers.map(dev -> dev.getBooks()); //--> getBooks() returns a Set<String>
        
        Stream<String> streamOfStrings =  streamOfSets.flatMap(booksOfDev -> booksOfDev.stream());
        
        streamOfStrings = streamOfStrings.filter(book -> !book.toLowerCase().contains("python"));
        
        set = streamOfStrings.collect(Collectors.toSet());
        
        set.forEach(System.out::println); 
	}

}
