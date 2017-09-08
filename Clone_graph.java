/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<Integer, UndirectedGraphNode> map=new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode res=new UndirectedGraphNode(node.label);
        map.put(node.label, res);
        for (int i=0; i<node.neighbors.size(); i++) res.neighbors.add( cloneGraph(node.neighbors.get(i)) );
        return res;
    }
}
