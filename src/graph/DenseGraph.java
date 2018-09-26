package graph;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-21 14:11
 **/
public class DenseGraph {
    private int numOfNode;
    private int numOfEdge;
    private boolean directed;
    private int[][] g;

    public DenseGraph(int numOfNode, int numOfEdge, boolean directed) {
        this.numOfNode = numOfNode;
        this.numOfEdge = numOfEdge;
        this.directed = directed;
        g = new int[numOfNode][numOfNode];
        for (int i = 0; i < numOfNode; i++)
            for (int j = 0; j < numOfNode; j++){
            }
    }
}
