import org.junit.Assert;
import org.junit.Test;

public class Tests {

    private static Node exampleTree(){
        var root1 = new Node(5);
        root1.child_left = new Node(3);
        root1.child_right = new Node(7);
        root1.child_left.child_left = new Node(2);
        root1.child_left.child_right = new Node(5);
        root1.child_right.child_left = new Node(1);
        root1.child_right.child_right = new Node(0);
        root1.child_right.child_right.child_left = new Node(2);
        root1.child_right.child_right.child_right = new Node(8);
        root1.child_right.child_right.child_right.child_right = new Node(5);

        return root1;
    }


    // Task 1.1 & 1.2 tests
    @Test
    public void leavesNumberOnExample(){

        Node tree = exampleTree();

        int numberOfLeaves = tree.howManyLeaves();
        int expected = 5;

        Assert.assertEquals(expected, numberOfLeaves);
    }

    @Test
    public void leavesNumber(){

        Node tree = new Node(4);

        int numberOfLeaves = tree.howManyLeaves();
        int expected = 1;

        Assert.assertEquals(expected, numberOfLeaves);
    }

    @Test
    public void pathLength(){
        Node tree = exampleTree();

        Assert.assertEquals(4, tree.longestPath());
    }

    //Task1.3 tests
    @Test
    public void sameTrees(){
        Node tree1 = exampleTree();
        Node tree2 = exampleTree();

        Assert.assertTrue(Node.areIdentical(tree1, tree2));
    }

    @Test
    public void differentTrees(){
        var root = new Node(5);
        root.child_left = new Node(4);
        root.child_right = new Node(3);

        Node tree1 = exampleTree();
        Node tree2 = root;

        Assert.assertFalse(Node.areIdentical(tree1, tree2));
    }

    @Test
    public void twoNulls(){
        Assert.assertTrue(Node.areIdentical(null, null));
    }

}
