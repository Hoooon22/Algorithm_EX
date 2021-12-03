using System;

namespace _17_BTree
{
    class Node
    {
        public int data;
        public Node left;
        public Node right;
    }

    class MainClass
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }

        // functions of Node
        public Node CreateNode(int data)
        {
            var node = new Node();
            node.data = data;
            node.left = null;
            node.right = null;
            return node;
        }

        public void AppendNode(ref Node head, Node newNode)
        {

        }
    }
}
