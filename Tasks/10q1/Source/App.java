import java.util.ArrayList;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.time.LocalTime;

import Util.Cat;


public class App {

   public static void main (String[] args) {
      System.out.println("1) letters\n2) 24 words\n3) 1000 words\n4) 40000 words\n");

      int choice = new Scanner(System.in).nextInt();
      String file_name = String.format("Resources/data0%d.txt", choice);

      BufferedReader file = null;
      try {
         file = new BufferedReader(new FileReader(file_name));
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      ArrayList<String> data = new ArrayList<String>();
      String line;
      
      try {
         while((line = file.readLine()) != null) 
            data.add(line);
         file.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      String[] words = data.toArray(new String[]{});
      ArrayList<String> result = Cat.run(words);
      
      BufferedWriter wfile = null;

      try {
         wfile = new BufferedWriter(new FileWriter("output.log"));
      } catch (Exception e) {
         e.printStackTrace();
      }

      System.out.println("FINISH\n__________________________");
      for (String str: result) {
         System.out.println(str);
         try {
            wfile.write(str + "\n");
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      System.out.println("____________________________");

      try {
         System.out.println("Created output.log " + LocalTime.now());
         wfile.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
