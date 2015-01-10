
public class uf {
	private int parent[], rank[], numSets, count, size[];
	
	public uf(int n){
		count = n;
		parent = new int[n];
		rank = new int[n];
		size = new int[n];
		numSets = 0;
		for (int i = 0; i < n; i++){
			parent[i] = i;
			rank[i] = 0;
			size[i] = 0;
		}
	}
	
	public void makeSet(int i){
		parent[i] = i;
		rank[i]=0;
		size[i]=1;
		numSets++;
	}
	
	private void link(int x, int y){

		if (rank[x] > rank[y])
			parent[y] = x;
		
		else if (rank[x] < rank[y])
			parent[x] = y;
		else if (x != y){
			parent[y] = x;
			rank[x]++;
		}
		numSets--;
		int sizeX = size[x];
		int sizeY = size[y];
		size[x] += sizeY;
		size[y] += sizeX;
	}
	public void unionSet(int i, int j){
		if (findSet(i) != findSet(j))
			link(findSet(i), findSet(j));
	}
	public int findSet(int i){
		if (parent[i] != i)
			parent[i] = findSet(parent[i]);

		return parent[i];
	}
	public int getSets(int i){
		return numSets;
	}
	public int getSize(int i){
		return size[i];
	}
}
