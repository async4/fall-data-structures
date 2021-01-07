package Common;

import java.util.Arrays;

public class HashTable {
   FinalPerson[] table;

   public HashTable(final int size) {
      this.table = new FinalPerson[size];
   }

   public void put(final Person other) {
      FinalPerson temp = new FinalPerson(hash(other), other);

      if (table[temp.key] != null) {
         table[temp.key] = temp;
      } else {
         int index = temp.key;
         while (table[temp.key++] != null);
         table[index] = temp;
      }
   }


   private int hash(final Person other) {
      String _sub1 = "", _sub2 = "";

      char[] charlist = other.getId().toCharArray();

      for (int i = 0; i < 11; i+=2)
         _sub1 += charlist[i];

      for (int i = 1; i < 11; i+=2)
         _sub2 += charlist[i];

      String _sub1_temp = "";
      for (int i = 0; i < _sub1.length(); i++) {
         if (_sub1.charAt(0) == 0)
            continue;
         if (!_sub1_temp.contains(String.valueOf(_sub1.charAt(i))))
            _sub1_temp += String.valueOf(_sub1.charAt(i));
      }

      String _sub2_temp = "";
      for (int i = 0; i < _sub2.length(); i++) {
         if (_sub2.charAt(0) == 0)
            continue;
         if (!_sub2_temp.contains(String.valueOf(_sub2.charAt(i))))
            _sub2_temp += String.valueOf(_sub2.charAt(i));
      }

      int _sub1_final = Integer.parseInt(_sub1_temp);
      int _sub2_final = Integer.parseInt(_sub2_temp);

      int hash_result = Math.abs(_sub1_final - _sub2_final);

      return 1;
   }

   @Override
   public String toString() {
      return Arrays.toString(table);
   }
}
