package graph;

import java.util.Arrays;

public class TestGraphImpl {
    public static void main(String[] args) {
        IncidenceArrayGraph myGraph = new IncidenceArrayGraph(3);
        Vertex myVertex1 = new Vertex(Color.Bleu,"a first info");
        Vertex myVertex2 = new Vertex(Color.Rouge,"a second info" );
        Vertex myVertex3 = new Vertex(Color.Vert,"a third info" );
        myGraph.addVertex(myVertex1);
        myGraph.addVertex(myVertex2);
        myGraph.addVertex(myVertex3);
        myGraph.addEdge(myVertex1,myVertex2);
        myGraph.addEdge(myVertex2,myVertex3);
        System.out.println(Arrays.toString(myGraph.getVertices()));
        System.out.println("Is connected myVertex1 and myVertex2: " + myGraph.isConnected(myVertex1,myVertex2));
        System.out.println("Is connected myVertex1  and myVertex3: " +  myGraph.isConnected(myVertex1,myVertex3));

    }
}