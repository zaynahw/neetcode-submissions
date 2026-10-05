/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> copies = new HashMap<>();
    public Node cloneGraph(Node node) {
        // Node n = new Node(node.val);
        if (node == null) {
            return null;
        }
        
        return dfs(node);
    }

    public Node dfs (Node node) {
        // if already have a copy, return copy
        if (copies.containsKey(node)) {
            return copies.get(node);
        }

        // create copy
        Node copy = new Node(node.val);

        // mark as copy created before recursion
        copies.put(node, copy);

        // clone each neighbor
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor));
        }
        return copy;
    }
}

