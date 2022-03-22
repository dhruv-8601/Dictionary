import java.io.IOException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This is the main class that controls the menu and calls function when
 * required
 * 
 * @author Dhruv Bipin Patel
 *
 */
public class Dictionary {

	public static void main(String[] args) {
		int choice = 0;
		int count = 0;
		int totalWord = 0;
		boolean isValid = false;
		Scanner input = new Scanner(System.in);
		DictionaryProcess main = new DictionaryProcess();
		TreeMap<String, Integer> dictionary = new TreeMap<String, Integer>();

		do {
			try {
				System.out.println();
				main.displayMenu(isValid);
				choice = input.nextInt();
			} catch (InputMismatchException ioe) {
				System.out.println("Input Mismatch Exception while reading user's option from main menu");
				input.next();
			}
			
			switch (choice) {
			case 1:
				if (!isValid) {
					totalWord = main.createTreeMapWithoutIgnore(dictionary);
					System.out.println("Program has read the file");
				} else {
					dictionary.clear();
					totalWord = main.createTreeMapWithIgnore(dictionary);
					System.out.println("Program has read the file");
				}
				break;

			case 2:
				System.out.print("Enter the word you want to search: ");
				String search = input.next();
				if (dictionary.containsKey(search)) {
					System.out.println(search + " occurs " + dictionary.get(search) + " times");
				} else {
					System.out.println(search + " occurs 0 times");
				}
				break;

			case 3:
				System.out.println("Dictionary has " + dictionary.size() + " unique words");
				break;

			case 4:
				System.out.println("Dictionary has " + totalWord + " words");
				break;

			case 5:
				dictionary.clear();
				totalWord = 0;
				System.out.println("Program has removed all the words");
				break;

			case 6:
				if (count % 2 == 0) {
					isValid = true;
					count++;
				} else {
					isValid = false;
					count++;
				}
				System.out.println("Ignore definite and indefinite articles has been set to " + isValid);
				break;

			case 7:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid Entry… Option should be a number between 1 and 7");
				break;

			}
		} while (choice != 7);
	}
}