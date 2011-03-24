

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * The converter takes .txt file with translated sentences and creates .cvs file with 
 * the same sentences but in mturk acceptable format. 
 * @author svitlanavolkova
 *
 */


public class Converter {

	ArrayList<String> arr1 = new ArrayList<String>();
	ArrayList<String> arr2 = new ArrayList<String>();
	ArrayList<String> arr3 = new ArrayList<String>();
	ArrayList<String> arr4 = new ArrayList<String>();
	ArrayList<String> arr5 = new ArrayList<String>();
//	ArrayList<String> arr6 = new ArrayList<String>();
//	ArrayList<String> arr7 = new ArrayList<String>();
//	ArrayList<String> arr8 = new ArrayList<String>();
//	ArrayList<String> arr9 = new ArrayList<String>();
//	ArrayList<String> arr10 = new ArrayList<String>();
	
	public void readFile(String fileName) throws IOException {

		String strLine;
		int count = 0;

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName)));

			while ((strLine = br.readLine()) != null) {
				count++;

//				if (count % 10 == 1) {
//					arr1.add(strLine);
//				} else if (count % 10 == 2) {
//					arr2.add(strLine);
//				} else if (count % 10 == 3) {
//					arr3.add(strLine);
//				} else if (count % 10 == 4) {
//					arr4.add(strLine);
//				} else if (count % 10 == 5) {
//					arr5.add(strLine);
//				} else if (count % 10 == 6) {
//					arr6.add(strLine);
//				} else if (count % 10 == 7) {
//					arr7.add(strLine);
//				} else if (count % 10 == 8) {
//					arr8.add(strLine);
//				} else if (count % 10 == 9) {
//					arr9.add(strLine);
//				} else if (count % 10 == 0) {
//					arr10.add(strLine);
//				}
				
				if (count % n == 1) {
					arr1.add(strLine);
				} else if (count % n == 2) {
					arr2.add(strLine);
				} else if (count % n == 3) {
					arr3.add(strLine);
				} else if (count % n == 4) {
					arr4.add(strLine);
				} else if (count % n == 0) {
					arr5.add(strLine);
				}
			}

			br.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			throw e;
		}
	}

	
	public void printToFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName + n + ".csv");
		PrintStream printStream = new PrintStream(new FileOutputStream(file));
		System.setOut(printStream);
		
//		for (int i = 0; i < arr1.size(); i++) {
//			System.out.println(arr1.get(i) + "\t" + arr2.get(i) + "\t"
//					+ arr3.get(i) + "\t" + arr4.get(i) + "\t" + arr5.get(i) + "\t"
//					+ arr6.get(i) + "\t" + arr7.get(i) + "\t" + arr8.get(i) + "\t"
//					+ arr9.get(i) + "\t" + arr10.get(i));
//
//		}
		
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i) + "\t" + arr2.get(i) + "\t"
					+ arr3.get(i) + "\t" + arr4.get(i) + "\t" + arr5.get(i));

		}
	}
	
	public static void main(String args[]) throws IOException {

		Converter d = new Converter();
		d.readFile(args[0]);
		String fileName = args[0].substring(0, args[0].indexOf('.'));
		d.printToFile(fileName);

	}
	
	int n = 5;

}
