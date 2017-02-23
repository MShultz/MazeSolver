package shultz.algorithms.maze;

import java.util.Scanner;

public class UserInterface {
	private Scanner scan = new Scanner(System.in);

	public String getFile() {
		System.out.print("Greetings!\nPlease enter your file: ");
		String file = scan.nextLine();
		boolean validFile = FileHandler.fileExists(file);
		while (!validFile) {
			System.out.println("That file is not valid.");
			System.out.print("Please enter your file:");
			file = scan.nextLine();
			validFile = FileHandler.fileExists(file);
		}
		return file;
	}
}
