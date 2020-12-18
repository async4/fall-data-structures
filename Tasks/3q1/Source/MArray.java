public class MArray
{
   int size;
   String[] array;
   int index;

   public MArray(int size)
   {
      this.size = size;
      this.array = new String[this.size];
      this.index = 0;
   }

   public void Add(String el)
   {
      if (this.index < this.size)
      {
         this.array[index] = el;
         index++;
      } else {
         System.out.println("array is full");
      }
   }

   public int Search(String el)
   {
      for (int walk = 0; walk < this.index; walk++)
      {
         if (el.equals(this.array[walk]))
            return walk;
      }

      return -1;
   }

   public void Update(String who, String toWho)
   {
      int index = Search(who);

      if (index != -1)
         this.array[index] = toWho;
   }

   public void Remove(String who)
   {
      int index = Search(who);

      if (index != -1)
      {
         while (index < this.index-1)
         {
            this.array[index] = this.array[index+1];
            index++;
         }
         this.index--;
      }

   }

   public void Print()
   {
      for (int i = 0; i < this.index; i++) {
         System.out.print(this.array[i] + " ");
      }
   }

}
