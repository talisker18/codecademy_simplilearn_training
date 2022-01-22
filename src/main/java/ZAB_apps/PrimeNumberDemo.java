package ZAB_apps;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberDemo {
	
	public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        list.add(1);

        list.add(2);

        boolean isPrime = true;

        for (int i = 3; i<=100; i++){
            for(int j = 2; j<i; j++){
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
            }

            if (isPrime){
                list.add(i);
            }

            isPrime = true; //do not forget to reset this var!!!
        }

        System.out.println(list);

    }

}
