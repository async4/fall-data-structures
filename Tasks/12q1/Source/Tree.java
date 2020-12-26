public class Tree {
   private Node root;

   private int _height(Node proot) {
      return (proot == null) ? 0 : proot.height;
   }

   private int _bfactor(Node proot) {
      return (proot == null) ? 0 : _height(proot.left) - _height(proot.right);
   }

   private int _max(int h1, int h2) {
      return (h1 > h2) ? h1 : h2;
   }

   private Node _rotateToRight(Node proot) {
      Node x = proot.left;
      Node t2 = x.right;

      x.right = proot;
      proot.left = t2;

      proot.height = _max(_height(proot.left), _height(proot.right)) + 1;
      x.height = _max(_height(x.left), _height(x.right)) + 1; 

      return x;
   }

   private Node _rotateToLeft(Node proot) {
      Node x = proot.right;
      Node t2 = x.left;

      x.left = proot;
      proot.right= t2;

      proot.height = _max(_height(proot.left), _height(proot.right)) + 1; 
      x.height = _max(_height(x.left), _height(x.right)) + 1;

      return x;
   }

   private Node _add(Node proot, int payload) {
      if (proot == null)
         return new Node(payload);
      else if (payload < proot.data)
         proot.left = _add(proot.left, payload);
      else
         proot.right = _add(proot.right, payload);

      int lh = _height(proot.left);
      int rh = _height(proot.right);
      proot.height = _max(lh, rh) + 1;

      int bfactor = _bfactor(proot);

      if (bfactor > 1 && payload < proot.left.data)
         return _rotateToRight(proot);

      if (bfactor < -1 && payload > proot.right.data)
         return _rotateToLeft(proot);

      if (bfactor > 1 && payload > proot.left.data) {
         proot.left = _rotateToLeft(proot.left);
         return _rotateToRight(proot);
      }

      if (bfactor < -1 && payload < proot.right.data) {
         proot.right = _rotateToRight(proot.right);
         return _rotateToLeft(proot);
      }

      return proot;
   }

   public void add(int payload) {
      this.root = _add(this.root, payload);
   }


   private void _traverse(Node proot) {
      if (proot == null)
         return;

      _traverse(proot.left);
      System.out.printf(" %d ", proot.data);
      _traverse(proot.right);
   }

   public void traverse() {
      _traverse(this.root);
   }
}
