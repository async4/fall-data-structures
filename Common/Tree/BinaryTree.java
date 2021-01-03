package Tree;

import com.async.common.Node;

public class BinaryTree<T extends Comparable<T>> {
   Node<T> root;

   public Node<T> getRoot() {
      return this.root;
   }

   private Node<T> findMinimumNode(Node<T> rref) {
      while (rref != null && rref.getLeft() != null)
         rref = rref.getLeft();

      return rref;
   }

   private Node<T> add(Node<T> rref, Node<T> other) {
      if (rref == null)
         return other;

      if (rref.compareTo(other) > 0)
         rref.setLeft(add(rref.getLeft(), other));
      else if (rref.compareTo(other) < 0)
         rref.setRight(add(rref.getRight(), other));

      return rref;
   }

   public void add(T other) {
      this.root = add(this.root, new Node(other));
   }

   private Node delete(Node rref, T other) {
      if (rref == null)
         return rref;

      if (rref.getKey().compareTo(other) > 0)
         rref.setLeft(delete(rref.getLeft(), other));
      else if (rref.getKey().compareTo(other) < 0)
         rref.setRight(delete(rref.getRight(), other));
      else {
         if (rref.getLeft() == null) {
            Node temp = rref.getRight();
            rref = null;
            return temp;
         } else if (rref.getRight() == null) {
            Node temp = rref.getLeft();
            rref = null;
            return temp;
         }

         Node temp = findMinimumNode(rref.getRight());
         rref.setKey(temp.getKey());
         rref.setRight(delete(rref.getRight(), (T) temp.getKey()));
      }

      return rref;
   }

   public void delete(T other) {
      this.root = delete(this.root, other);
   }

   private void print(StringBuilder sb, Node rref, String padding, String ptr) {
      if (rref != null) {
         sb.append(padding);
         sb.append(ptr);
         sb.append(rref.getKey());
         sb.append("\n");

         StringBuilder pb = new StringBuilder(padding);
         pb.append("│   ");

         String paddingForBoth = pb.toString();
         String ptrForRight = "└── ";
         String ptrForLeft = (rref.getRight() != null) ? "├── " : "└── ";

         print(sb, rref.getLeft(), paddingForBoth, ptrForLeft);
         print(sb, rref.getRight(), paddingForBoth, ptrForRight);
      }
   }

   public void print() {
      StringBuilder sb = new StringBuilder();
      print(sb, this.root, "", "");
      System.out.println(sb.toString());
   }

   private void traverse(Node rref) {
      if (rref != null) {
         traverse(rref.getLeft());
         System.out.print(" " + rref.getKey() + "");
         traverse(rref.getRight());
      }
   }

   public void traverse() {
      System.out.print("[ ");
      traverse(this.root);
      System.out.println(" ]");
   }
}