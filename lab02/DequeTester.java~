public class DequeTester {

	public static void main(String[] args) {
		Deque<String> clyde = new QQKachoo<String>();
		for (int i = 0; i < 3; i++) {
			clyde.addFirst("" + i);
			clyde.addLast("" + i);
		}
		System.out.println(clyde);
		for (int a = 0; a < 3; a++) {
		    System.out.println(clyde.pollFirst());
		    System.out.println(clyde.pollLast()); //returns NullPointerException --> Why?
		}
		System.out.println(clyde);
		System.out.println(clyde.peekFirst() + "\n" + clyde.peekLast());
	}
}
