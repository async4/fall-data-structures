package Common.Graph;

public class Graph<T> {
   int length;
   int size;
   public GraphNode<T>[] graph;

   public Graph(int length) {
      this.length = length;
      graph = new GraphNode[this.length];
   }

   public void add(T p1, T p2) {
      int index = -1;

      for (int i = 0; i < this.size; i++) {
         if (graph[i] != null && graph[i].data == p1) {
            index = i;
            break;
         }
      }

      if (index != -1)
         graph[index].add(p2);
      else {
         graph[this.size] = new GraphNode<>(p1);
         graph[this.size].add(p2);
         this.size++;
      }
   }

   @Override
   public String toString() {
      String pack = "";

      for (GraphNode el : graph) {
         if (el != null)
            pack += el.toString() + " \n";
         else
            pack += " empty \n";
      }
      return pack;
   }
}
