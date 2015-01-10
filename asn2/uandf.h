
class uandf
{
public:
	uandf(int n);
	void make_set(int i);
	void union_set(int i, int j);
	int find_set(int i);
	int final_sets();
	int get_sets();
	int get_size(int i);
private:
	int *parent, *rank, numSets, count, *size;
	bool final;
	void link(int x, int y);
};

uandf::uandf(int n){
	final = false;
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


void uandf::make_set(int i){
	if (final)
		return;
	parent[i] = i;
	rank[i] = 0;
	size[i]=1;
	numSets++;
}
void uandf::link(int x, int y){

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
void uandf::union_set(int i, int j){
	if (final)
		return;
	if (find_set(i) != find_set(j))
		link(find_set(i), find_set(j));
}
int uandf::find_set(int i){
	if (parent[i] != i)
		parent[i] = find_set(parent[i]);

	return parent[i];
}
int uandf::final_sets(){
	parent = new int[count];
	rank = new int[count];
	final = true;
	for (int i = 0; i < count; i++){
		parent[i] = i;
		rank[i] = 0;
	}
	return numSets;
}
int uandf::get_sets(){
	return numSets;
}
int uandf::get_size(int i){
	return size[i];
}

