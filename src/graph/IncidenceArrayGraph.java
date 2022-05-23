package graph;

import java.util.Arrays;

public class IncidenceArrayGraph implements Graph {
    private Vertex[] vertexArray;
    private int maxVertex;
    private int nbVertex = 0;
    private Edge[] edgesArray;
    private int nbEdge = 0;
    private Edge[][] incidenceArray;

    /**
     * Constructor of an IncidenceArrayGraph
     *
     * @param maxVertex the max number of Vertex
     */
    public IncidenceArrayGraph(int maxVertex) {
        this.vertexArray = new Vertex[maxVertex];
        this.maxVertex = maxVertex;
        this.edgesArray = new Edge[maxVertex * maxVertex];
        this.incidenceArray = new Edge[maxVertex][maxVertex * maxVertex];

    }

    /**
     * @return the number of vertices of the graph
     */
    @Override
    public int nbOfVertices() {
        return nbVertex;
    }

    /**
     * @return the number of edges in the graph
     */
    @Override
    public int nbOfEdges() {
        return nbEdge;
    }

    /**
     * Add a vertex to the graph
     *
     * @param vertex the vertex to be added
     */
    @Override
    public void addVertex(Vertex vertex) {
        if (nbVertex < this.maxVertex) {
            this.vertexArray[nbVertex] = vertex;
            nbVertex++;
        } else {
            System.out.println("Maximum number of vertices reach");
        }
    }

    /**
     * Add an undirected edge to the graph
     *
     * @param vertex1 extremity one of the edge
     * @param vertex2 extremity two of the edge
     */
    @Override
    public void addEdge(Vertex vertex1, Vertex vertex2) {
        if (nbEdge < this.maxVertex * this.maxVertex) {
            this.edgesArray[nbEdge] = new Edge(vertex1, vertex2, 1, Color.Bleu);
            this.incidenceArray[vertex1.id % maxVertex][nbEdge] = this.edgesArray[nbEdge];
            this.incidenceArray[vertex2.id % maxVertex][nbEdge] = this.edgesArray[nbEdge];
            nbEdge++;
        } else {
            System.out.println("Maximum number of edges reach");
        }

    }

    /**
     * @param vertex1 the first vertex to be checked
     * @param vertex2 the second vertex to be checked
     * @return True whether there is a path between the two vertices (without accounting for the edge directions)
     */
    @Override
    public boolean isConnected(Vertex vertex1, Vertex vertex2) {
        for (int i = 0; i <= maxVertex * maxVertex; i++) {
            if (incidenceArray[vertex1.id % maxVertex][i] != null) {
                return incidenceArray[vertex2.id % maxVertex][i] != null;
            }
        }
        return false;
    }

    /**
     * @return True whether all vertices are interconnected
     */
    @Override
    public boolean isConnected() {
        //TODO: write this function code
        return false;
    }

    /**
     * @param vertex1 the first vertex to be checked
     * @param vertex2 the second vertex to be checked
     * @return all edges connecting these vertices
     */
    @Override
    public Edge[] getEdges(Vertex vertex1, Vertex vertex2) {
        Edge[] res = new Edge[1];
        for (Edge e : this.edgesArray) {
            if ((e.getEnds()[0] == vertex1 && e.getEnds()[1] == vertex2) || (e.getEnds()[0] == vertex2 && e.getEnds()[1] == vertex1)) {
                res[0] = e;
            }
        }
        return res;
    }

    /**
     * @return all edges of the graph
     */
    @Override
    public Edge[] getEdges() {
        return this.edgesArray;
    }

    /**
     * @return all vertices of the graph
     */
    @Override
    public Vertex[] getVertices() {
        return this.vertexArray;
    }

    /**
     * give edges connected to this vertex
     *
     * @param vertex : graph.Vertex
     * @return Edge[]
     */
    @Override
    public Edge[] getNeighborEdges(Vertex vertex) {
        int tabSize = 0;
        for (Edge e : this.edgesArray) {
            if (e != null) {
                if (e.getEnds()[0] == vertex || e.getEnds()[1] == vertex) {
                    tabSize++;
                }
            }
        }
        Edge[] resTab = new Edge[tabSize];
        int j = 0;
        for (Edge e : this.edgesArray) {
            if (e != null) {
                if (e.getEnds()[0] == vertex || e.getEnds()[1] == vertex) {
                    resTab[j] = e;
                    j += 1;
                }
            }
        }
        return resTab;
    }

    public String toString() {
        return "- array : " + Arrays.toString(this.getVertices());
    }
}