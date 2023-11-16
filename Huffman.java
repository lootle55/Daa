package DAA_Lab;
import java.util.Arrays;
public class Hufman{

        static int MAX_CHAR = 256;

        // Node class to represent the Huffman tree nodes
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

        // Function to perform Huffman encoding
        static void huffmanEncode(char[] data, int[] frequency) {
            int n = data.length;
            Node[] nodes = new Node[n];

            // Create initial nodes for each character
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(data[i], frequency[i]);
            }

            // Build Huffman tree
            buildHuffmanTree(nodes, n);

            // Print Huffman codes
            printHuffmanCodes(nodes[0], "");
        }

        // Build Huffman tree
        static void buildHuffmanTree(Node[] nodes, int n) {
            while (n > 1) {
                int firstMin = 0, secondMin = 1;

                // Find two minimum frequency nodes
                for (int i = 2; i < n; i++) {
                    if (nodes[i].frequency < nodes[firstMin].frequency) {
                        secondMin = firstMin;
                        firstMin = i;
                    } else if (nodes[i].frequency < nodes[secondMin].frequency) {
                        secondMin = i;
                    }
                }

                // Create a new internal node with the sum of the frequencies of the two minimum nodes
                Node newNode = new Node('$', nodes[firstMin].frequency + nodes[secondMin].frequency);
                newNode.left = nodes[firstMin];
                newNode.right = nodes[secondMin];

                // Remove the two minimum nodes and add the new internal node
                nodes[secondMin] = newNode;
                nodes[firstMin] = nodes[n - 1];
                n--;
            }
        }

        // Print Huffman codes
        static void printHuffmanCodes(Node root, String code) {
            if (root == null) {
                return;
            }

            // If the node is a leaf node, print the character and its code
            if (root.left == null && root.right == null) {
                System.out.println(root.data + ": " + code);
            }

            // Recur for the left and right subtrees
            printHuffmanCodes(root.left, code + "0");
            printHuffmanCodes(root.right, code + "1");
        }

        public static void main(String[] args) {
            char[] data = {'a', 'b', 'c', 'd', 'e', 'f'};
            int[] frequency = {5, 9, 12, 13, 16, 45};

            huffmanEncode(data, frequency);
        }
    }
