package shultz.algorithms.maze;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		String file = ui.getFile();
		FileHandler handle = new FileHandler(file);
		
		for(ArrayList<String> list: handle.getAllMazes()){
			for(String s: list){
				System.out.println(s);
			}
			System.out.println("\nNEXT LIST\n");
		}

	}

}
