package Tree;

import java.util.Objects;

public class Node<T extends Comparable<? super T>> implements Comparable<Node<T>> {
   T key;
   Node<T> left, right;

   public Node(T key) {
      this.key = key;
      this.left = this.right = null;
   }

   public T getKey() {
      return key;
   }

   public void setKey(T key) {
      this.key = key;
   }

   public Node<T> getLeft() {
      return left;
   }

   public void setLeft(Node<T> left) {
      this.left = left;
   }

   public Node<T> getRight() {
      return right;
   }

   public void setRight(Node<T> right) {
      this.right = right;
   }

   public int height(Node<T> other) {
      if (Objects.isNull(other))
         return 0;

      int leftHeight =  Objects.isNull(other.getLeft())
              ? 0 : other.getLeft().height(other.getLeft());
      int rightHeight = Objects.isNull(other.getRight())
              ? 0 : other.getRight().height(other.getRight());

      return Math.max(leftHeight, rightHeight) + 1;
   }

   public int balanced(Node<T> other) {
      return Objects.isNull(other) ? 0 : height(other.getLeft()) - height(other.getRight());
   }

   public Node<T> rotateLeft() {
      Node temp = this.getRight();
      Node displaced = temp.getLeft();

      temp.setLeft(this);
      this.setRight(displaced);

      return temp;
   }

   public Node<T> rotateRight() {
      Node temp = this.getLeft();
      Node displaced = temp.getRight();

      temp.setRight(this);
      this.setLeft(displaced);

      return temp;
   }

   @Override
   public int compareTo(final Node<T> other) {
      // < 0,  this greater than other
      // = 0,  this equals other
      // > 0,  this lower than other
      return this.getKey().compareTo(other.getKey());
   }
}