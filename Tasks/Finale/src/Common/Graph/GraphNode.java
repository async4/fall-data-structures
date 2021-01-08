package Common.Graph;

import Common.Person.FinalPerson;

public class GraphNode<T>
{
   public T data;
   public GraphNode next;

   public GraphNode(T data)
   {
      this.data = data;
   }

   public void add(T p)
   {
      GraphNode walk = this;
      while (walk.next != null)
         walk = walk.next;
      walk.next = new GraphNode(p);
   }

   @Override
   public String toString()
   {
      String pack = "";
      pack += data.toString() + " -> ";

      GraphNode walk = this.next;
      while (walk != null)
      {
         if (walk.data != null)
            pack += walk.data.toString() + " -> ";
         else
            pack += " ";
         walk = walk.next;
      }

      if (walk == null)
         pack += " NULL ";
      return pack;
   }

}
