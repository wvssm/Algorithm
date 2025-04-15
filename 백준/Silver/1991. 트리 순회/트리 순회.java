import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static Node[] nodes;

    static class Node{
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) throws Exception {
        sb = new StringBuilder();
        input();

        preorder(nodes[0]);
        sb.append("\n");
        inorder(nodes[0]);
        sb.append("\n");
        postorder(nodes[0]);

        System.out.print(sb.toString());
    }
    public static void preorder(Node node){
        if(node == null){
            return;
        }

        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);

    }

    public static void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }

    public static void postorder(Node node){
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }

    public static void input() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        nodes = new Node[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine().trim());
            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            // 부모 노드
            if(nodes[value - 'A'] == null){
                nodes[value - 'A'] = new Node(value);
            }

            // 왼쪽
            if(left != '.'){
                if(nodes[left - 'A'] == null){
                    nodes[left - 'A'] = new Node(left);
                }
                nodes[value - 'A'].left = nodes[left - 'A'];
            }

            // 오른쪽
            if(right != '.'){
                if(nodes[right - 'A'] == null){
                    nodes[right - 'A'] = new Node(right);
                }
                nodes[value - 'A'].right = nodes[right - 'A'];
            }
        }
    }
}