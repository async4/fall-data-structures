public class Tree {

   private Node root;

   private int height(Node proot) {
      return (proot == null) ? 1 : proot.height;
   }

   private void updateHeight(Node proot) {
      proot.height = 1 + Math.max(height(proot.left), height(proot.right));
   }

   private int bfactor(Node proot) {
      return (proot == null) ? 0 : height(proot.left) - height(proot.right);
   }

   private Node minNode(Node proot) {
      Node walk = proot;
      while (walk.left != null) {
         walk = walk.left;
      }

      return walk;
   }

   private Node rotateToRight(Node proot) {
      Node temp = proot.left;
      Node leaf = temp.right;

      temp.right = proot;
      proot.left = leaf;

      updateHeight(proot);
      updateHeight(temp);

      return temp;
   }

   private Node rotateToLeft(Node proot) {
      Node temp = proot.right;
      Node leaf = temp.left;

      temp.left = proot;
      proot.right= leaf;

      updateHeight(proot);
      updateHeight(temp);

      return temp;
   }

   private Node balance(Node proot) {
      updateHeight(proot);
      int bfactor = bfactor(proot);

      if (bfactor > 1) {
         if (height(proot.right.right) > height(proot.right.left)) {
            proot = rotateToLeft(proot);
         } else {
            proot.right = rotateToRight(proot.right);
            proot = rotateToLeft(proot);
         }
      } else if (bfactor < -1) {
         if (height(proot.left.left) > height(proot.left.right)) {
            proot = rotateToRight(proot);
         } else {
            proot.left = rotateToLeft(proot.left);
            proot = rotateToRight(proot);
         }
      }

      return proot;
   }

   public void add(Node payload) {
      this.root = add(this.root, payload);
   }

   private Node add(Node proot, Node payload) {
      if (proot == null)
         return payload;
      else if (payload.data < proot.data)
         proot.left = add(proot.left, payload);
      else
         proot.right = add(proot.right, payload);

      updateHeight(proot);
      int bfactor = bfactor(proot);

      if (bfactor > 1 && payload.data < proot.left.data)
         return rotateToRight(proot);

      if (bfactor < -1 && payload.data > proot.right.data)
         return rotateToLeft(proot);

      if (bfactor > 1 && payload.data > proot.left.data) {
         proot.left = rotateToLeft(proot.left);
         return rotateToRight(proot);
      }

      if (bfactor < -1 && payload.data < proot.right.data) {
         proot.right = rotateToRight(proot.right);
         return rotateToLeft(proot);
      }

      return proot;
   }

   public void traverse() {
      traverse(this.root);
   }

   private void traverse(Node proot) {
      if (proot != null) {
         traverse(proot.left);
         System.out.printf("\t\t %d %c %d = %d\n\n", proot.first, proot.operator, proot.second, proot.data);
         traverse(proot.right);
      }
   }

   public Node find(int payload) {
      return find(this.root, payload);
   }

   private Node find(Node proot, int payload) {
      if (proot != null) {
         if (proot.data == payload)
            return proot;

         Node left = find(proot.left, payload);
         if (left != null)
            return left;

         Node right = find(proot.right, payload);
         if (right != null)
            return right;
      }

      return null;
   }

   public void delete(int payload) {
      this.root = delete(this.root, payload);
   }

   private Node delete(Node proot, int payload) {
      if (proot == null)
         return proot;

      if (payload < proot.data)
         proot.left = delete(proot.left, payload);
      else if (payload > proot.data)
         proot.right = delete(proot.right, payload);
      else {
         if (proot.left == null || proot.right == null) {
            Node temp = null;
            if (temp == proot.left)
               temp = proot.right;
            else
               temp = proot.left;

            if (temp == null) {
               temp = proot;
               proot = null;
            } else 
               proot = temp;
            
         } else {
            Node temp = minNode(proot.right);
            proot.operator = temp.operator;
            proot.first = temp.first;
            proot.second = temp.second;
            proot.data = temp.data;
            proot.right = delete(proot.right, temp.data);
         }
      }

      if (proot == null)
         return proot;

      updateHeight(proot);
      int bfactor = bfactor(proot);

      if (bfactor > 1 && bfactor(proot.left) >= 0)
         return rotateToRight(proot);

      if (bfactor > 1 && bfactor(proot.left) < 0) {
         proot.left = rotateToLeft(proot.left);
         return rotateToRight(proot);
      }

      if (bfactor < -1 && bfactor(proot.right) <= 0)
         return rotateToLeft(proot);

      if (bfactor < -1 && bfactor(proot.right) > 0) {
         proot.right = rotateToRight(proot.right);
         return rotateToLeft(proot);
      }

      return proot;
   }

}
