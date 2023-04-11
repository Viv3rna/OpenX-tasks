public class Node {

    Node(int value){
        this.value = value;
    }
    public int value;
    public Node child_left;
    public Node child_right;
    
    public int howManyLeaves() {
        if (child_left == null && child_right == null)
            return 1;
        else if (child_left != null && child_right != null)
            return child_left.howManyLeaves() + child_right.howManyLeaves();
        else if (child_right != null)
            return child_right.howManyLeaves();
        else 
            return child_left.howManyLeaves();
    }

    public int longestPath() {

        int amount_left_nodes = 0;
        int amount_right_nodes = 0;

        if (child_left == null && child_right == null)
            return 0;
        if (child_left != null)
            amount_left_nodes = child_left.longestPath() + 1;
        if (child_right != null)
            amount_right_nodes = child_right.longestPath() + 1;

        return Math.max(amount_left_nodes, amount_right_nodes);

        }

    public static boolean areIdentical(Node firstRoot, Node secondRoot){

        if (firstRoot == null && secondRoot == null)
            return true;

        if (firstRoot != null && secondRoot != null)
            return (firstRoot.value == secondRoot.value
                    && areIdentical(firstRoot.child_left, secondRoot.child_left)
                    && areIdentical(firstRoot.child_right, secondRoot.child_right));

        return false;
    }
    

}
