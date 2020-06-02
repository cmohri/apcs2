public class DequeTester {

    public static void main(String[] args) {
	QQKachoo<String> clyde = new QQKachoo<String>();
	for (int i = 0; i < 3; i++) {
	    clyde.addFirst("" + i);
	    clyde.addLast("" + i);
	}
	System.out.println(clyde);

	System.out.println("peeklast" + clyde.peekLast());
	System.out.println(clyde.removeLast());
	System.out.println(clyde);
	System.out.println(clyde.peekLast());

    }
}
