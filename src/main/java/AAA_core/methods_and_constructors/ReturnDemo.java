package AAA_core.methods_and_constructors;

public class ReturnDemo {

	 

    public static void main(String[] args) {

        ReturnDemo r = new ReturnDemo();

        r.doSomethin(1);

        r.doSomethin(0);
    }

 

    public void doSomethin(int i){

        if(i == 0){

            return;
        }

        //will not be executed if i = 0

        System.out.println("test");
    }

}
