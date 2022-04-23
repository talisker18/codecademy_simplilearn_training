package AAD_java8.optional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 
 * Mit der Version 8 wird die Klasse java.util.Optional<T> eingeführt und mit Java 9 ergänzt. 
 * Sie stellt Methoden bereit, um den oft lästigen und aufgeblähten Code produzierenden Umgang mit 
 * null-Werten deutlich zu vereinfachen. 
 * 
 * Ein Optional ist eine Objekt, das man sich als Datenbehälter vorstellen kann, der entweder einen 
 * Wert enthält oder leer (empty) ist. Leer ist hier auch nicht gleichbedeutend mit null!
 * 
 * */

public class OptionalDemo {
	public static void main(String[] args) {
		Optional<String> oe = Optional.empty();                // leeres Optional
		//System.out.println(oe.get());                          // NoSuchElementException
		Optional<String> os = Optional.of("Hallo Welt!");      // enthält den String "Hallo Welt!"
		System.out.println(os.get());    // Hallo Welt
		
		//Optional<String> on = Optional.of(null);             // NullPointerException
		Optional<String> onb = Optional.ofNullable(null);    // leeres Optional (null)
		//System.out.println(onb.get());    // NoSuchElementException
		
		/**
		 * verhindern der exceptions:
		 * 
		 * es kann durch isPresent() überprüft werden, ob ein Optional leer ist.
			Ab Java 11 kann dies auch durch isEmpty() erfolgen. Die Methode funktioniert umgekehrt. 
			Sie liefert true, wenn das Optional leer ist.
		 * 
		 * 
		 * */
		
		System.out.println(onb.isPresent());    // false
		System.out.println(onb.isEmpty());      // true ab Java 11
		
		//if we dont use ofNullable()
		Optional<String> onb2 = Optional.of(null); 
		
		//it will throw an NPE
		//System.out.println("using of instead of ofNullable: "+onb2.isEmpty());
		
		/**
		 * Allerdings bieten sich zur Überprüfung hier oft andere Vorgehensweisen an, da der boolsche Rückgabewert 
		 * ggf. wieder umständlich validiert werden muss.
		 * 
			Stattdessen könnte z.B. vielmehr ein Default-Wert angegeben werden, der bei leerem Objekt greift. 
			Die Methoden or(), orElse() und orElseGet() ermöglichen das.
			Die Unterschiede zwischen den Methoden sind klein aber fein und müssen besonders bei zeitkritischen 
			Anwendungen berücksichtigt werden. orElse() erwartet ein Objekt als Parameter und gibt dies zurück, 
			falls das Optional leer sein sollte. Das Objekt wird somit in jedem Falle gebildet und erst danach 
			entscheidet sich, ob es weiter verarbeitet wird oder nicht. 
		 * 
		 * 
		 * */
		
		System.out.println(onb.orElse("Hallo Paul!"));    // Hallo Paul!
		
		/**
		 * orElseGet() erwartet einen Supplier als Parameter, dessen Methode einen Wert liefert. D.h., dass im Falle 
		 * eines nicht leeren Optional, die Methode des Suppliers nicht aufgerufen wird. Ein ggf. zurückzugebendes 
		 * Objekt muss somit gar nicht erst gebildet werden.
		 * 
		Eine Ergänzung in Java 9 ist die Methode or(), die ebenfalls einen Supplier erwartet. Die Rückgabe besteht 
		jedoch wiederum in einem Optional. 
		 * 
		 * */
		
		//for Supplier functional interface see: src/main/java/AAD_java8/lambda_functionalInterfaces_methoReference/supplier_demo/SupplierDemo.java
		Supplier<String> s = () -> returnSomeString();
		System.out.println("with supplier object: "+onb.orElseGet(s));
		//or do it directly
		System.out.println("with lambda directly: "+onb.orElseGet(() -> returnSomeString()));
		//or use method ref
		System.out.println("with method ref directly: "+onb.orElseGet(OptionalDemo::returnSomeString));
		
		//then, using or
		System.out.println("using or(), supplier returns Optional instance: "+onb.or(OptionalDemo::returnSomeOptionalOfString).get());
		
		
		/**
		 * Eine weitere Möglichkeit des Umgangs mit einem ggf. leeren Optional-Objekt bietet die Methode 
		 * ifPresent() (nicht isPresent!), die ein Consumer-Interface als Parameter erwartet und dies ausführt 
		 * falls das Optional nicht leer ist. Im anderen Fall geschieht nichts. 
		 * 
		 * 
		 * */
		//for consumer see also: src/main/java/AAD_java8/lambda_functionalInterfaces_methoReference/consumer_demo/ConsumerDemo.java
		Consumer<String> cons = str -> System.out.println("Inhalt vorhanden!");
		onb.ifPresent(cons);    // keine Ausgabe ---> ifPresent == true, exec the consumer function
		
		/**
		 * Seit Java 9 kann für den Fall eines leeren Optional auch eine Alternative erzeugt werden. 
		 * Die Methode ifPresentOrElse() erwartet zwei Interfaces als Parameter: einen Consumer und ein Runnable.
		 * 
		 * */
		
		onb.ifPresentOrElse(cons,getWarning()); //since ifPresent is false --> exec runnable, in this case print once "Warning!"
		
		/**
		 * Die Eigenschaften eines Optional-Objektes lassen sich mit der Methode filter() prüfen. Es erwartet ein 
		 * Predicate Functional Interface als Parameter und liefert seinerseits wiederum ein Optional, welches 
		 * entweder dem Wert des Predicate entspricht oder leer ist. Mit isPresent() kann dies dann nachgeprüft werden. 
		 * 
		 * */
		
		boolean b = os.filter(string -> string.equals("Hallo Welt!")).isPresent(); //if optional contains this string, return true
		System.out.println(b);    // true
		
		/**
		 * 
		 * Möchte man den Wert eines Optional bearbeiten, so können dazu die Methoden map() und flatMap() verwendet werden. 
		 * 
		 * */
		String stringOfOptionalModified = os.map(String::toUpperCase).orElse("String leer");
		System.out.println(stringOfOptionalModified);    // HALLO WELT!
		
		//if optional is empty or null...
		stringOfOptionalModified = onb.map(String::toUpperCase).orElse("Optional leer");
		System.out.println(stringOfOptionalModified);    // Optional leer
		
		/**
		 * Im Gegensatz zu map() verwendet flatMap() als Parameter wiederum einen gekapselten Wert in Form eines Optional. 
		 * 
		 * */
		
		//add some mopeds with motor and hubraum
		Moped moped2 = new Moped();
		Motor motor2 = new Motor();
		motor2.setHubraum(500);
		moped2.setMotor(motor2);
		
		Moped moped3 = new Moped();
		Motor motor3 = new Motor();
		motor3.setHubraum(1000);
		moped3.setMotor(motor3);
		
		List<Moped> listWithMopeds = Arrays.asList(new Moped[]{moped2,moped3});
		Stream<Moped> streamWithMopdes = listWithMopeds.stream();
		
		Optional<Moped> optionalMoped = Optional.of(moped2);
		
		int hubraumOfMoped2 = optionalMoped.flatMap(Moped::getMotor).flatMap(Motor::getHubraum).orElse(0);
		
		System.out.println(hubraumOfMoped2);
		
		//without flatmap we would have to do...
		hubraumOfMoped2 = optionalMoped.get().getMotor().get().getHubraum().get();
		System.out.println(hubraumOfMoped2);
		
	}
	
	public static String returnSomeString() {
		return "hello from supplier";
	}
	
	public static Optional<String> returnSomeOptionalOfString(){
		return Optional.of("hello from supplier using return type optional");
	}
	
	public static Runnable getWarning() {
		return new Runnable() {
			
			@Override
			public void run() {
				System.out.println("warning!!!");
				
			}
		};
	}
	
	
}

class Moped {
    Motor motor;
    //...
    public Optional<Motor> getMotor() {
        return Optional.ofNullable(motor); //return motor if not null...or return empty optional if null
    }
    
    public void setMotor(Motor motor) {
    	this.motor = motor;
    }
}

class Motor {
    int hubraum;	
    
    public Optional<Integer> getHubraum() {
        return Optional.ofNullable(hubraum); //return hubraum if not null...or return empty optional if null
    }
    
    public void setHubraum(int hubraum) {
    	this.hubraum = hubraum;
    }
}
