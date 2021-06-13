package AAG_threads.different_implementations;

public class Ex2_ThreadSafetyWithImmutableClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageService msg = new MessageService("test");

	}

}

class MessageService {
    
    private final String message;

    public MessageService(String message) {
        this.message = message;
    }
    
    // standard getter
    //no setter
    // variable message and therefore all MessageService objects is immutable
    
}
