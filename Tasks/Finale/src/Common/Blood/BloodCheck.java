package Common.Blood;

import Common.Graph.Graph;
import Common.Graph.GraphNode;

public class BloodCheck {

   public static boolean check(Graph<BloodType> bloodRelationGraph, BloodType p1, BloodType p2) {
      for (int i = 0; i < bloodRelationGraph.graph.length; i++) {
         if (bloodRelationGraph.graph[i].data.toString().equals(p1.toString())) {
            GraphNode walk = bloodRelationGraph.graph[i].next;
            while (walk != null) {
               if (walk.data.toString().equals(p2.toString()))
                  return true;
               walk = walk.next;
            }
         }
      }
      return false;
   }
}
