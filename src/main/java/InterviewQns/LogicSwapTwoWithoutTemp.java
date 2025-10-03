package InterviewQns;

public class LogicSwapTwoWithoutTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 15;
		int b = 9;
		a = a+b;
		b = a-b;
		a= a-b;
		System.out.println(a);
		System.out.println(b);
	}

}
