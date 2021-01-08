package Common.Heap;

import Common.Person.FinalPerson;

public class Heap {
   private FinalPerson[] array;
   public int size;

   public Heap(int length) {
      this.array = new FinalPerson[length];
      this.size = 0;
   }

   public void add(FinalPerson other) {
      array[++size] = other;
      int index = size-1;

      while (index > 1 &&
             array[index].compareTo(array[parent(index)]) < 0) {
         int pind = parent(index);
         FinalPerson tmp = array[pind];
         array[pind] = array[index];
         array[index] = tmp;
         index /= 2;
      }
   }

   public FinalPerson extract() {
      FinalPerson extracted_element = array[1];

      array[1] = array[size];
      size--;
      heapify(1);

      // Arrays.fill(null);
      if (size == 0)
         for (int i = 0; i < array.length; i++)
            array[i] = null;

      return extracted_element;
   }

   private void heapify(int index) {
      int leftChild = getLeft(index);
      int rightChild = getRight(index);

      int min = index;

      if ((leftChild <= size) && (leftChild > 0))
         if (array[leftChild].compareTo(array[min]) < 0)
            min = leftChild;


      if ((rightChild <= size) && (rightChild > 0))
         if (array[rightChild].compareTo(array[min]) < 0)
            min = rightChild;

      if (min != index) {
         FinalPerson temp = array[min];
         array[min] = array[index];
         array[index] = temp;
         heapify(min);
      }
   }

   public FinalPerson getHead() {
      return array[1];
   }

   public int getLeft(int index) {
      return switch (((2*index < array.length) && (index >= 1)) ? 1 : 0) {
         case 1 -> 2*index;
         default -> -1;
      };
   }

   public int getRight(int index) {
      return switch (((2*index+1 < array.length-1) && (index >= 1)) ? 1 : 0) {
         case 1 -> 2*index+1;
         default -> -1;
      };
   }

   private int parent(int index) {
      return (index)/2;
   }

   // SADECE DEBUG ICIN YAPILMISTIR MENUDE 5 VE 6 YA BASARAK HEAPI GOREBILIRSINIZ.
   private void print(StringBuilder sb, int index, String padding, String ptr) {
      if (index <= size && index > 0) {
         sb.append(padding);
         sb.append(ptr);
         sb.append(array[index].key + " " + array[index].data.getId());
         sb.append("\n");

         StringBuilder pb = new StringBuilder(padding);
         pb.append("│   ");

         String paddingForBoth = pb.toString();
         String ptrForRight = "└── ";
         String ptrForLeft = (getLeft(index) != -1) ? "├── " : "└── ";

         print(sb, getLeft(index), paddingForBoth, ptrForLeft);
         print(sb, getRight(index), paddingForBoth, ptrForRight);
      }
   }

   public void print() {
      StringBuilder sb = new StringBuilder();
      print(sb, 1, "", "");
      System.out.println(sb.toString() != "" ? sb.toString() : "\n\tHEAP EMPTY\n\n");
   }

   @Override
   public String toString() {
      String pack = "";

      for (FinalPerson el : array)
         if (el != null)
            pack += el.key + " ";

      return pack.length() > 0 ? pack : "empty";
   }
}
