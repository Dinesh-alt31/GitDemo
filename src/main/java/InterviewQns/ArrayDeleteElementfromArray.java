package InterviewQns;

import java.util.*;

public class ArrayDeleteElementfromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 10, 20, 30, 40, 50 };
		int pos = -1;
		int num = 30;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == num) {
				pos = i;
				break;
			}
		}
		if (pos >= 0) {
			for (int i = pos; i < a.length - 1; i++) {
				a[i] = a[i + 1];
			}
			a[a.length - 1] = 0;
		}
		List<Integer> li = new ArrayList<Integer>();
		for (int x : a) {
			if (x != 0) {
				li.add(x);
				System.out.print(x + " ");
			}
		}
		System.out.println();
		System.out.println(li);
	}

}

