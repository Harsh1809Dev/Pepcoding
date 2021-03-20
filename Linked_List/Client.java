public class Client{
	public static void main(String[] args) throws Exception{
		LinkedList ll = new LinkedList();
		for(int i = 0 ; i < 10 ; i++){
			ll.set_at_last(i);
		}
		ll.display();
	}
}