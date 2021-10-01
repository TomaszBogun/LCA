import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LCATest {

    //Test for empty tree
    @Test
    void emptyTree(){
        LCA tree = new LCA();
        assertEquals(-1, tree.findLCA(0,0));
        assertEquals(-1, tree.findLCA(0,1));
        assertEquals(-1, tree.findLCA(1,0));
    }

    //Test for root node only
    @Test
    void oneRootNode(){
        LCA tree = new LCA();
        tree.root = new Node(1);
        assertEquals(1, tree.findLCA(1,1));
    }

    //Tests for invalid input
    @Test
    void nodesMissing(){
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        assertEquals(-1, tree.findLCA(4,5));    //both missing
        assertEquals(-1, tree.findLCA(1,5));    //second one missing
        assertEquals(-1, tree.findLCA(4,1));    //first one missing
    }

    //Test for same node
    @Test
    void sameNode(){
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        assertEquals(1, tree.findLCA(1, 1));
        assertEquals(2, tree.findLCA(2, 2));
        assertEquals(3, tree.findLCA(3, 3));
    }

    //Tests for same branch
    @Test
    void sameBranchOneLevel() {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(3);
        assertEquals(1, tree.findLCA(1, 3));
    }

    @Test
    void sameBranchMultipleLevels() {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.left = new Node(5);
        tree.root.left.right.left.right = new Node(6);
        assertEquals(3, tree.findLCA(3, 6));
    }

    //Tests for different branches
    @Test
    void differentBranchOneLevel(){
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        assertEquals(1, tree.findLCA(2,3));
    }

    @Test
    void differentBranchesMultipleLevels(){
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(4);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(5);
        tree.root.right.right.right = new Node(6);
        assertEquals(1, tree.findLCA(4,5));
        assertEquals(1, tree.findLCA(4,6));
    }

    //Test for full tree
    void fullTreeTest(){
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        assertEquals(tree.findLCA(4,5), 2);
        assertEquals(tree.findLCA(4,6), 1);
        assertEquals(tree.findLCA(3,4), 1);
        assertEquals(tree.findLCA(2,4), 2);
    }

}