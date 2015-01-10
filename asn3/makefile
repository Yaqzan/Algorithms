all: asn3
asn3: kruskal.class Edge.class uf.class
	javac kruskal.java Edge.java uf.java
kruskal.class: kruskal.java
	javac kruskal.java Edge.java uf.java
Edge.class: Edge.java
	javac Edge.java
uf.class: uf.java
	javac uf.java
clean:
	rm -f *.class 
