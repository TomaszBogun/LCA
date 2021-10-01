import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    //Test for no child nodes
    @Test
    void noChildNodes(){
        Node node = new Node(1);
        assertNull(node.left);
        assertNull(node.right);
    }

    //Test for one child node
    @Test
    void oneChildNode(){
        Node node = new Node(1);
        node.left = new Node(2);
        assertNull(node.right);
        assertEquals(2, node.left.data);
        assertNull(node.left.right);
        assertNull(node.left.left);
    }

    //Test for two child nodes
    @Test
    void twoChildNode(){
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        assertEquals(1, node.data);
        assertEquals(2, node.left.data);
        assertEquals(3, node.right.data);
        assertNull(node.left.right);
        assertNull(node.left.left);
        assertNull(node.right.right);
        assertNull(node.right.left);
    }

    //Test for multiple layers
    void multiLayerNode(){
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        assertEquals(1, node.data);
        assertEquals(2, node.left.data);
        assertEquals(3, node.right.data);
        assertEquals(4, node.left.left.data);
        assertEquals(5, node.left.right.data);
        assertEquals(6, node.right.left.data);
        assertEquals(6, node.right.right.data);
        assertNull(node.left.left.left);
        assertNull(node.left.left.right);
        assertNull(node.left.right.left);
        assertNull(node.left.right.right);
        assertNull(node.right.left.left);
        assertNull(node.right.left.right);
        assertNull(node.right.right.left);
        assertNull(node.right.right.right);
    }
}