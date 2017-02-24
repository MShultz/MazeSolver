package shultz.algorithms.maze;

import java.util.ArrayList;

import algo.data.structures.Graph;
import algo.data.structures.GraphNode;
public class Maze {
	private ArrayList<String> currentMaze = new ArrayList<String>();
	private GraphNode<String> head, tail;
	private Graph<String> maze;
	
	public Graph<String> solve(ArrayList<String> currentMaze){
		maze = null;
		head = tail = null;
		this.setCurrentMaze(currentMaze);
		generateGraph();
		return maze;
	}
	
	private void generateGraph(){
		String[] allNodeString = currentMaze.get(0).split(",");
		ArrayList<GraphNode<String>> allNodes = getAllNodes(allNodeString);
		setHeadAndTail(allNodes);
		populateNodes(allNodes);
		maze =  new Graph<String>(head, tail);
	}

	private ArrayList<GraphNode<String>> getAllNodes(String[] allNodeString){
		ArrayList<GraphNode<String>> allNodes = new ArrayList<GraphNode<String>>();
		for(int i = 0; i < allNodeString.length; ++i){
			allNodes.add(new GraphNode<String>(allNodeString[i]));
		}
		return allNodes;
	}
	
	private void setHeadAndTail(ArrayList<GraphNode<String>> allNodes){
		String [] headAndTail = currentMaze.get(1).split(",");
		head = getNode(headAndTail[0], allNodes);
		tail = getNode(headAndTail[1], allNodes);
	}
	private void populateNodes(ArrayList<GraphNode<String>> allNodes){
		for(int i = 2; i < currentMaze.size(); ++i){
			String[] nodeInformation = currentMaze.get(i).split(",");
			GraphNode<String> nodeToEdit = getNode(nodeInformation[0], allNodes);
			for(int j = 1; j < nodeInformation.length; ++j){
				nodeToEdit.add(getNode(nodeInformation[j], allNodes));
			}
		}
	}
	public void setCurrentMaze(ArrayList<String> currentMaze) {
		this.currentMaze = currentMaze;
	}
	
	private GraphNode<String> getNode(String value, ArrayList<GraphNode<String>> allNodes){
		GraphNode<String> nodeFound = null;
		int count = 0;
		while(nodeFound == null){
			if(allNodes.get(count).getValue().equals(value))
				nodeFound = allNodes.get(count);
			++count;
		}
		return nodeFound;
	}
	
}
