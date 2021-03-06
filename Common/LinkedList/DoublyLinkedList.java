public class DoublyLinkedList {

   class Node {
      public int data;
      public Node next;
      public Node prev;

      public Node(int data) {
         this.data = data;
         this.next = null;
         this.prev = null;
      }
   }

   private Node head;
   private Node tail;

   private int size;

   public DoublyLinkedList() {
      this.head = this.tail = null;
      this.size = 0;
   }

   public void push(int data) {
      Node node = new Node(data);

      if (this.empty() == true) {
         this.head = this.tail = node;
      } else {
         Node save = this.tail;
         save.next= node;
         node.prev = save;
         this.tail = node;
      }
      this.size++;
   }

   public void pop() {
      if (this.empty() == true) {
         System.out.println("empty list");
      } else {
         Node walk = this.head;

         while (walk.next != this.tail)
            walk = walk.next;
         walk.next = null;
         this.tail = walk;
         this.size--;
      }
   }

   public void add(int data) {
      Node node = new Node(data);
      if (this.empty() == true)
         this.head = this.tail = node;
      else {
         Node save = this.head;
         this.head = node;
         node.next = save;
         save.prev = node;
      }

      this.size++;
   }

   public void insert(int data, int index) {
      if (index >= this.size)
         System.out.printf("index out of bound: %d", index);
      else if (index == 0)
         System.out.println("index couldn't be head");
      else if (index == this.size-1)
         System.out.println("index couldn't be tail");
      else {
         Node node = new Node(data);
         Node walk = this.head;
         int i = 0;

         while (i < index-1 && walk.next != null) {
            walk = walk.next;
            i++;
         }

         Node save = walk.next;
         node.next = save;
         node.prev = walk;
         save.prev = node;
         walk.next = node;
         this.size++;
      }
   }

   public boolean search(int data) {
      if (this.head == null)
         return false;

      Node walk = this.head;
      while (walk != null && walk.data != data)
         walk = walk.next;

      if (walk != null)
         return true;

      return false;
   }

   public boolean empty() {
      return this.size == 0;
   }

   public int size() {
      return this.size;
   }

   @Override
   public String toString() {
      String pack = new String();

      if (this.empty())
         return "empty";

      pack += String.format("Head: %d, Tail: %d\nSize: %d\nList: ", this.head.data, this.tail.data, this.size);

      Node walk = this.head;
      while (walk != null) {
         pack += walk.data + " ";
         walk = walk.next;
      }
      
      pack += "\nReverse List: ";
      walk = this.tail;
      while (walk != null) {
         pack += walk.data + " ";
         walk = walk.prev;
      }

      return pack;
   }

}
