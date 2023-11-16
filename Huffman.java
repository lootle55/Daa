import java.util.Arrays;

public class HuffmanEncoding {

    static class Node {
        char data;
        int frequency;
        Node left, right;

        Node(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            left = right = null;
        }
    }

    static Node buildHuffmanTree(char[] data, int[] frequency) {
        int n = data.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(data[i], frequency[i]);
        }

        while (n > 1) {
            Arrays.sort(nodes, 0, n, (a, b) -> Integer.compare(a.frequency, b.frequency));

            Node newNode = new Node('$', nodes[0].frequency + nodes[1].frequency);
            newNode.left = nodes[0];
            newNode.right = nodes[1];

            nodes[0] = newNode;
            nodes[1] = null;
            n--;
        }

        return nodes[0];
    }

    static void printHuffmanCodes(Node root, String code) {
        if (root == null) {
            return;
        }

        if (root.data != '$') {
            System.out.println(root.data + ": " + code);
        }

        printHuffmanCodes(root.left, code + "0");
        printHuffmanCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        char[] data = {'a', 'b', 'c', 'd', 'e'};
        int[] frequency = {5, 9, 12, 13, 16};

        Node root = buildHuffmanTree(data, frequency);

        System.out.println("Huffman Codes:");
        printHuffmanCodes(root, "");
    }
}
