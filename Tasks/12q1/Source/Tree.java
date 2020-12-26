public class Tree {

   private Node root;


   private int _height(Node proot) {
      return (proot == null) ? 1 : proot.height;
   }

   private int _bfactor(Node proot) {
      return (proot == null) ? 0 : _height(proot.left) - _height(proot.right);
   }

   private int _max(int h1, int h2) {
      return (h1 > h2) ? h1 : h2;
   }

   private Node _minNode(Node proot) {
      Node walk = proot;
      while (walk.left != null) {
         walk = walk.left;
      }

      return walk;
   }
   
   private Node _rotateToRight(Node proot) {
      Node temp = proot.left;
      Node leaf = temp.right;

      temp.right = proot;
      proot.left = leaf;

      proot.height = _max(_height(proot.left), _height(proot.right)) + 1;
      temp.height = _max(_height(temp.left), _height(temp.right)) + 1;

      return temp;
   }

   private Node _rotateToLeft(Node proot) {
      Node temp = proot.right;
      Node leaf = temp.left;

      temp.left = proot;
      proot.right= leaf;

      proot.height = _max(_height(proot.left), _height(proot.right)) + 1;
      temp.height = _max(_height(temp.left), _height(temp.right)) + 1;

      return temp;
   }


   private Node _add(Node proot, Node payload) {
      if (proot == null)
         return payload;
      else if (payload.data() < proot.data())
         proot.left = _add(proot.left, payload);
      else
         proot.right = _add(proot.right, payload);
      
      int lh = _height(proot.left);
      int rh = _height(proot.right);
      proot.height = _max(lh, rh) + 1;

      int bfactor = _bfactor(proot);

      if (bfactor > 1 && payload.data() < proot.left.data())
         return _rotateToRight(proot);

      if (bfactor < -1 && payload.data() > proot.right.data())
         return _rotateToLeft(proot);

      if (bfactor > 1 && payload.data() > proot.left.data()) {
         proot.left = _rotateToLeft(proot.left);
         return _rotateToRight(proot);
      }

      if (bfactor < -1 && payload.data() < proot.right.data()) {
         proot.right = _rotateToRight(proot.right);
         return _rotateToLeft(proot);
      }

      return proot;
   }

   private void _traverse(Node proot) {
      if (proot != null) {
         _traverse(proot.left);
         System.out.printf("\t\t %d %c %d = %d (%s)\n\n", proot.first, proot.operator, proot.second, proot.data(), proot.id);
         _traverse(proot.right);
      }
   }

   private Node _find(Node proot, String id) {
      if (proot != null) {
         String nodeId = proot.id.substring(0, 4);

         if (nodeId.equals(id))
            return proot;

         Node left = _find(proot.left, id);
         if (left != null)
            return left;

         Node right = _find(proot.right, id);
         if (right != null)
            return right;
      }
      return null;

   }

   private Node _delete(Node proot, Node payload) {
      if (proot == null)
         return proot;
      
      Node left = proot.left;

      return proot;
   }

   public void add(Node payload) {
      this.root = _add(this.root, payload);
      System.out.println(this.root.height);
   }

   public void traverse() {
      _traverse(this.root);
   }

   public Node find(String id) {
      return _find(this.root, id);
   }

   public void delete(Node payload) {
      this.root = _delete(this.root, payload);
   }

}
