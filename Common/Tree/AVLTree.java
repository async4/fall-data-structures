package Tree;

import com.async.common.Node;

import java.util.Objects;

public class AVLTree<Key extends Comparable<Key>> {
   public Node<Key> root;

   private Node<Key> insert(Node<Key> rootReference, Node<Key> other) {
      if (Objects.isNull(rootReference))
         return other;
      else if (rootReference.compareTo(other) > 0) // this.key is greater than other
         rootReference.setLeft(insert(rootReference.getLeft(), other));
      else if (rootReference.compareTo(other) < 0) // this.key is lower than other
         rootReference.setRight(insert(rootReference.getRight(), other));

      int balanceStatus = rootReference.balanced(rootReference);

      if (balanceStatus > 1 && rootReference.getLeft().compareTo(other) > 0) {
         // left-left -> rotate right
         return rootReference.rotateRight();
      } else if (balanceStatus > 1 && rootReference.getLeft().compareTo(other) < 0) {
         // left-right -> rotate left, rotate right
         rootReference.setLeft(rootReference.getLeft().rotateLeft());
         return rootReference.rotateRight();
      } else if (balanceStatus < -1 && rootReference.getRight().compareTo(other) < 0) {
         // right-right -> rotate left
         return rootReference.rotateLeft();
      } else if (balanceStatus < -1 && rootReference.getRight().compareTo(other) > 0) {
         // right-left -> rotate right, rotate left
         rootReference.setRight(rootReference.getRight().rotateRight());
         return rootReference.rotateLeft();
      }

      return rootReference;
   }

   public void insert(Key other) {
      this.root = insert(this.root,
                         new Node<Key>(other));
   }

   private Node<Key> remove(Node<Key> rootReference, Key other) {


      return rootReference;
   }

   public void remove(Key other) {
      this.root = remove(this.root, other);
   }

   private Boolean search(Node<Key> rootReference, Key other) {
      return true;
   }

   public Boolean search(Key other) {
      return search(this.root, other);
   }

   private void toString(StringBuilder stringBuilder, Node<Key> rootReference, String padding, String ptr) {
      if (rootReference != null) {
         stringBuilder.append(padding);
         stringBuilder.append(ptr);
         stringBuilder.append(rootReference.getKey());
         stringBuilder.append("\n");

         StringBuilder pb = new StringBuilder(padding);
         pb.append("│   ");

         String paddingForBoth = pb.toString();
         String ptrForRight = "└── ";
         String ptrForLeft = (rootReference.getRight() != null) ? "├── " : "└── ";

         toString(stringBuilder, rootReference.getLeft(), paddingForBoth, ptrForLeft);
         toString(stringBuilder, rootReference.getRight(), paddingForBoth, ptrForRight);
      }
   }

   @Override
   public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      toString(stringBuilder, this.root, "", "");
      return stringBuilder.toString();
   }
}