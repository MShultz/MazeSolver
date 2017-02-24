package shultz.algorithms.maze;

import java.util.ArrayList;

import algo.data.structures.Graph;

public class Main {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		String file = ui.getFile();
		FileHandler handle = new FileHandler(file);
		Maze mazeSolver = new Maze();
		for(ArrayList<String> maze: handle.getAllMazes()){
				Graph<String> currentMaze = mazeSolver.solve(maze);
				ui.printShortestPathOfMaze(currentMaze.getShortestDistance());
			}

	}

}
