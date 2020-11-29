public class Main {
	public static void main(String[] args) {
      int[] array = {5, 2, 3, 1, 6, 0, 12, 7, 88};
      int size = 9;
      
      String[] infix = {
         "a+b*(c^d-e)^(f+g*h)-i",
         "2+2*(2-1)",
         "(2/3)*3-3*2/2",
         "(1+2*3-2/2*3*(10-2))",
         "2*2*2/2-1+123*(123-120)+1"
      };
      
      DoublyLinkedList ll = new DoublyLinkedList();
      ll.push(3);
      ll.push(4);
      ll.push(5);
      ll.pop();
      ll.add(2);
      ll.add(1);
      ll.insert(9, 2);
      System.out.println(ll);
	}
}
