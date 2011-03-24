import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class POSAnalyser {

	public void readFile(String fileName) throws IOException {

		String strLine;
		int count = 0;

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName)));

			while ((strLine = br.readLine()) != null) {
				count++;

				String[] parts = new String[strLine.length()];

				parts = strLine.trim().split("\\s");

				for (int i = 0; i < parts.length; i++) {
					if (!parts[i].contains("_")) {
						System.out.println(parts[i]);
					}
				}

			}

			br.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			throw e;
		}
	}

	public static void main(String[] args) throws IOException {
		POSAnalyser pos = new POSAnalyser();
		pos.readFile("/Users/svitlanavolkova/Documents/workspace/POS/hindiTaggingOut.txt");
	}

}
