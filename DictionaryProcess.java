import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This class has methods that control the Dictionary
 * 
 * @author Dhruv Bipin Patel
 *
 */
public class DictionaryProcess {

	/**
	 * This method is used to read file without considering the definite and
	 * indefinite articles
	 * 
	 * @param treeMap Inputs main Tree Map into the function so that the data can be
	 *                store inside it
	 * @return Total number of words that are been read from the file are returned
	 */
	public int createTreeMapWithoutIgnore(TreeMap<String, Integer> treeMap) {
		Scanner input = null;
		int count = 0;
		try {
			input = new Scanner(Paths.get("assignment/assignment3/Raven.txt"));

		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		while (input.hasNext()) {
			String word = input.next();
			word = word.toLowerCase();

			if (treeMap.containsKey(word)) {
				int counter = treeMap.get(word);
				treeMap.put(word, counter + 1);
			} else {
				treeMap.put(word, 1);
			}
			count++;
		}
		return count;
	}

	/**
	 * 
	 * @param treeMap Inputs main Tree Map into the function so that the data can be
	 *                store inside it
	 * @return Total number of words that are been read from the file are returned
	 */
	public int createTreeMapWithIgnore(TreeMap<String, Integer> treeMap) {
		Scanner input = null;
		int count = 0;
		try {
			input = new Scanner(Paths.get("assignment/assignment3/Raven.txt"));

		} catch (IOException ioe) {
			System.out.println(ioe);
		}

		while (input.hasNext()) {
			String word = input.next();
			word = word.toLowerCase();

			if (!word.equals("the") && !word.equals("a") && !word.equals("an")) {
				if (treeMap.containsKey(word)) {
					int counter = treeMap.get(word);
					treeMap.put(word, counter + 1);
				} else {
					treeMap.put(word, 1);
				}
				count++;
			}
		}
		return count;
	}

	/**
	 * This method will print out menu and controls that the application is mode for
	 * Ignoring articles
	 * 
	 * @param isValid Inputs validity for the ignoring articles to show user about
	 *                the mode they are currently using
	 */
	public void displayMenu(boolean isValid) {
		System.out.println("****************************************************");
		System.out.println("DICTIONARY");
		System.out.println("****************************************************");
		System.out.println("1. Add words to the Dictionary from file");
		System.out.println("2. Search a word in the Dictionary");
		System.out.println("3. Display number of unique words in the Dictionary");
		System.out.println("4. Display number of all words in the");
		System.out.println("5. Reset Dictionary");
		System.out.println("6. Ignore definite and indefinite articles (" + isValid + ")");
		System.out.println("7. Exit");
		System.out.print("Enter your option: ");
	}
}
