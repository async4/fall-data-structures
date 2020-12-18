package Util;

import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;


public class Cat {

   private static int max_length (ArrayList<String> array) {
      int max = array.get(0).length();
      int temp;

      for (String item: array) {
         temp = item.length();
         if (temp > max)
            max = temp;
      }

      return max;
   }

   // STRING TO DECIMAL
   private static ArrayList<ArrayList<Integer>> str2dec (String[] array) {
      ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> decimal;

      for (String item: array) {
         decimal = new ArrayList<Integer>();
         for (String ch: item.split(""))
            decimal.add((int)((char)ch.charAt(0)));

         temp.add(decimal);
      }

      return temp;
   }

   // DECIMAL TO STRING
   private static String dec2str (ArrayList<Integer> data) {
      String pack = new String();

      for (int item: data)
         pack += (char) item + "";

      return pack;
   }

   // DECIMAL TO HEXADECIMAL
   private static ArrayList<ArrayList<String>> dec2hex (ArrayList<ArrayList<Integer>> data) {
      ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
      ArrayList<String> d;

      for (ArrayList<Integer> item: data) {
         d = new ArrayList<String>();
         for (int dec: item)
            d.add(Integer.toHexString(dec));
         temp.add(d);
      }

      return temp;
   }

   private static ArrayList<String> pack (ArrayList<ArrayList<String>> base16) {
      ArrayList<String> temp = new ArrayList<String>();
      String res;

      for (ArrayList<String> hexlist: base16) {
         res = new String();
         for (String hex: hexlist)
            res += hex;
         temp.add(res);
      }

      return temp;
   }

   private static ArrayList<ArrayList<Integer>> unpack (ArrayList<String> base16) {
      ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

      ArrayList<Integer> res;
      int index = 0;

      for (String hex: base16) {
         res = new ArrayList<Integer>();
         for (int i = 0; i < hex.length(); i+=2) {
            res.add(Integer.parseInt(hex.substring(i, i+2), 16));
         }
         temp.add(res);
      }
      return temp;
   }

   private static ArrayList<String> sort (ArrayList<String> bucket) {
      int size = bucket.size();
      for (int i = 0; i < size-1; i++) {
         for (int k = i+1; k > 0; k--) {
            System.out.println(bucket);
            if (bucket.get(k-1).compareTo(bucket.get(k)) < 0) {
               String temp = bucket.get(k);
               bucket.set(k, bucket.get(k-1));
               bucket.set(k-1, temp);
            }
         }
      }

      return bucket;
   }


   private static ArrayList<String> radix (ArrayList<String> base16) {
      ArrayList<ArrayList<String>> buckets = new ArrayList<ArrayList<String>>();

      for (int i = 0; i < 16; i++)
         buckets.add(new ArrayList<String>());

      int max = Cat.max_length(base16);
      int index = 1;
      int hex_len = 0;

      do {
         for (String hex: base16) {
            hex_len = hex.length();
            if (hex_len-index >= 0) {
               char val = hex.charAt(hex.length()-index);

               if (Character.isDigit(val)) {
                  buckets.get(Integer.parseInt(String.valueOf(val))).add(hex);
               } else {
                  switch (val) {
                     case 'a':
                        buckets.get(10).add(hex);
                        break;
                     case 'b':
                        buckets.get(11).add(hex);
                        break;
                     case 'c':
                        buckets.get(12).add(hex);
                        break;
                     case 'd':
                        buckets.get(13).add(hex);
                        break;
                     case 'e':
                        buckets.get(14).add(hex);
                        break;
                     case 'f':
                        buckets.get(15).add(hex);
                        break;
                  }
               }
            } else {
               buckets.get(0).add(hex);
            }
         }

         int temp_index = 0;
         for (ArrayList<String> bucket: buckets) {
            QuickSort.sort(bucket, 0, bucket.size()-1);
            //Collections.sort(bucket);
            for (String hex: bucket) {
               base16.set(temp_index, hex);
               temp_index++;
            }
            bucket.clear();
         }

         System.out.printf("%d/%d\r", index, max);
         index++;
      } while (max - index >= 0);

      return base16;
   }

   public static ArrayList<String> run (String[] array) {
      ArrayList<String> base16 = Cat.pack(Cat.dec2hex(Cat.str2dec(array)));
      ArrayList<String> result = new ArrayList<String>();

      base16 = Cat.radix(base16);

      for (ArrayList<Integer> dec: Cat.unpack(base16))
         result.add(Cat.dec2str(dec));

      return result;
   }
}
