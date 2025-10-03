package HackerRankQns;

import java.util.Scanner;

public class ScannerNextLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);  // Set up scanner for input
        int lineNumber = 1;                   // Start line count at 1

        while (sc.hasNextLine()) {            // While there's another line
            String line = sc.nextLine();      // Read the entire line
            if(line.equals("exit")) break;
            System.out.println(lineNumber + " " + line); // Print line number and content
            lineNumber++;                     // Increase line count
        }

        sc.close();

	}

}
