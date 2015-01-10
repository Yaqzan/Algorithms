
public class Edge {

	private int v1;
	private int v2;
	private int weight;
	private boolean marked;
	public Edge(int i, int j, int w){
		v1 = i;
		v2 = j;
		weight = w;
		marked = false;
	}
	
	public int getV1(){
		return v1;
	}
	public int getV2(){
		return v2;
	}
	public int getWeight(){
		return weight;
	}
	public void setWeight(int x){
		weight =x;
	}
	public void mark(){
		marked = true;
	}
	public boolean getMark(){
		return marked;
	}
}
