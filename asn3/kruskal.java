import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class kruskal {
	
	// MAin Method
	// Reads the input graph from a file called "input.tx" and prints the MST
	public static void main(String[] args) throws NumberFormatException, IOException {
		int vertices;
		Edge[] tarrEdges;
		String line = "";
		int edges = 0;
	    String delims = "[ ]+";
		
	    //File IO
			FileReader file = new FileReader("input.txt");
		    BufferedReader reader = new BufferedReader(file);
		    
		    // Get number of vertices
		    vertices = Integer.parseInt(reader.readLine());
		    vertices+=1;
		    tarrEdges = new Edge[vertices*vertices];
		    
		    //Read Lines
		    while ((line = reader.readLine()) != null) {
		    	String[] tokens = line.split(delims);
		    	tarrEdges[edges] = new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
		    	edges++;
		    }
		    
		    // Put edges into array
		    Edge[] arrEdges = new Edge[edges];
		    for(int i=0;i<edges;i++){
				arrEdges[i] = tarrEdges[i];
			}
		
		
		    //Call the kruskal algorithm
		    arrEdges = kruskal(arrEdges, vertices);
		    
		    // Prints the MST
		    for(int i=0;i<arrEdges.length;i++){
		    	if (arrEdges[i].getMark() == true)
		    		System.out.println(arrEdges[i].getV1() +" "+ arrEdges[i].getV2() +" "+ arrEdges[i].getWeight());
			}
	}
	
	// 	Kruskal algorithm: Parameters: 
	//	arrEdges = the array of edges to find the minimum spanning tree
	//	vertices = number of vertices
	//	return value: returns the array of edges with sorted, marked edges that are in the MST
	private static Edge[] kruskal(Edge[] arrEdges, int vertices){
		
		// Put each vertex in a separate set
		uf A = new uf(vertices+1);
		for(int i = 1; i<= vertices; i++){
			A.makeSet(i);
		}
		//Sort the edges by weight
		arrEdges = bubbleSort(arrEdges, arrEdges.length);
		
		//Kruskall algorithm
		for(int i = 0; i<arrEdges.length;i++){ 	// For each edge
	
			if(A.findSet(arrEdges[i].getV1()) != A.findSet(arrEdges[i].getV2())){ // If vertex 1 and vertex 2 do not make a cycle
				arrEdges[i].mark(); //Mark this edge
				A.unionSet(arrEdges[i].getV1(), A.findSet(arrEdges[i].getV2())); // Unify these vertices
			}
		}
		
		return arrEdges;
	}

	
	//Bubble sort method: Sorts an array of edges by weight using bubble sort
	// Parameters:
	// numArray = array to sort
	// vertices = number of vertices
	public static Edge[] bubbleSort(Edge[] numArray, int vertices) {

	    int n = vertices;
	    Edge temp;

	    for (int i = 0; i < n; i++) {
	        for (int j = 1; j < (n - i); j++) {

	            if (numArray[j - 1].getWeight() > numArray[j].getWeight()) {
	                temp = numArray[j - 1];
	                numArray[j - 1] = numArray[j];
	                numArray[j] = temp;
	            }

	        }
	    }
		return numArray;
	}
}
