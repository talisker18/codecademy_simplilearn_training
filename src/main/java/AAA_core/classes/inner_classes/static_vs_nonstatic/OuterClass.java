package AAA_core.classes.inner_classes.static_vs_nonstatic;

//Java program to Demonstrate How to

//Implement Static and Non-static Classes



//Class 1

//Helepr class

class OuterClass {



 // Input string

 private static String msg = "GeeksForGeeks";

 private String msg2 = "test";



 // Static nested class

 public static class NestedStaticClass {



     // Only static members of Outer class

     // is directly accessible in nested

     // static class

     public void printMessage()

     {



         // Try making 'message' a non-static

         // variable, there will be compiler error

         System.out.println(

                 "Message from nested static class: " + msg);

     }

 }



 // Non-static nested class -

 // also called Inner class

 public class NestedNonStaticClass {



     // Both static and non-static members

     // of Outer class are accessible in

     // this Inner class

     public void display()

     {



         // Print statement whenever this method is

         // called

         System.out.println(

                 "Message from non-static nested class: "

                         + msg+"; "+msg2);

     }

 }

}



//Class 2

//Main class

class GFG {



 // Main driver method

 public static void main(String args[])

 {



     // Creating instance of nested Static class

     // inside main() method

     OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();



     System.out.println(printer instanceof OuterClass.NestedStaticClass);

    

     OuterClass outerObj = new OuterClass();



     System.out.println(outerObj instanceof OuterClass);



     //following does not work. we cannot create instance of static nested class

     /*NestedStaticClass nested = new NestedStaticClass();

     OuterClass.NestedStaticClass printer2

             = new OuterClass.new NestedStaticClass();*/



     // Calling non-static method of nested

     // static class

     printer.printMessage();



     // Note: In order to create instance of Inner class

     //  we need an Outer class instance



     // Creating Outer class instance for creating

     // non-static nested class

     OuterClass outer = new OuterClass();

     OuterClass.NestedNonStaticClass inner = outer.new NestedNonStaticClass();



     // Calling non-static method of Inner class

     inner.display();



     // We can also combine above steps in one

     // step to create instance of Inner class

     OuterClass.NestedNonStaticClass innerObject = new OuterClass().new NestedNonStaticClass();



     // Similarly calling inner class defined method

     innerObject.display();



     //we cannot directly create new instances of NestedNonStaticClass. NestedNonStaticClass needs its OuterClass

     /*NestedNonStaticClass nested = new NestedNonStaticClass();*/

    

     //

 }

}
