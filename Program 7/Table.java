public class Table {
   private TreeNode _root;
   
   public Table() {
      _root = null;
   }
   
   public int getSize() {
      int size = 0;
      return getSize(size, _root);
   }
   
   public int getSize(int size, TreeNode curr) {
      if(curr != null){
         if(curr.left != null) {
            size++;
            getSize(size, curr.left);
         }
         else if(curr.right != null) {
            size++;
            getSize(size, curr.right);
         }
      }
      return size;
   }
   
   public Keyed search(Keyed data) {
      return search(data, _root);
   }
   
   public Keyed search (Keyed data, TreeNode curr) {
      if(curr.data.keyCompare(data) == 0)
         return curr.data;
      else if( curr == null)
            return null;
      else {
         if(curr.data.keyCompare(data) == -1)
            search(data, curr.left);
         else if(curr.data.keyCompare(data) == 1)
            search(data, curr.left);
      }
      return null; //Compiler needs a return statement outside of if cases
   }
      
   public void insert(Keyed data) {
      insert(_root, data);
   }
   
   private void insert(TreeNode node, Keyed data) {
      if(node.data != null)   
         if(node.data.keyCompare(data) < 1)
            insert(node.left, data);
         else if(node.data.keyCompare(data) > 1)
            insert(node.right, data);
         else
            return;
      else {
         node.data = data;
      }
   }
   
   public int getHeight() {
      int height = 0;
      return getHeight(_root, height);
   }
   
   public int getHeight(TreeNode curr, int height) {
      if(curr != null) {
         if(curr.left != null) {
            height++;
            getHeight(curr.left, height);
         }
         else if(curr.right != null) {
            height++;
            getHeight(curr.right, height);
         }
      }
      return height;      
   }
   
   public String toString() {
      String s = "";
      return toString(s, _root);
   }
   
   public String toString(String s, TreeNode curr) {
      if(curr == null)
         return "";
      toString(s, curr.left);
      s += " ";
      toString(s, curr.right);               
      return curr.data.toString();
   }  
   
   public String showTree() {
      String s = "";
      return s;
   }
   
}   

class TreeNode {
   public TreeNode left;
   public TreeNode right;
   public Keyed data;
}

class NBAPlayerKey implements Keyed {
   private int _jersey;
   private String _team;
   
   public NBAPlayerKey(int jersey, String team) {
      _jersey = jersey;
      _team = team;
   }
   
   public String toStringKey() {
      String s = _jersey + " " + _team.substring(0,3);
      return s;
   }
   
   public String toString() {
      return " Team: " + _team + " Number: " + _jersey;
   }
   
   public int getJerseyNumber() {
      return _jersey;
   }
   
   public String getTeam() {
      return _team;
   }
   
   public int keyCompare(Keyed o) {
      if(o instanceof NBAPlayerKey) {
         NBAPlayerKey other = (NBAPlayerKey)o;
         if(_team.equals(other.getTeam())) {
            if(_jersey < other.getJerseyNumber())
               return -1;
            else if(_jersey > other.getJerseyNumber())
               return 1;
            else
               return 0;
         }
         else
            return (_team.compareTo(other.getTeam()));
      }
      else 
         return 0;
   }
}

class NBAPlayer extends NBAPlayerKey {
   private String _name;
   
   public NBAPlayer(String name, String team, int jersey) {
      super(jersey, team);
      _name = name;
   }

   public String getName(){
      return _name;
   }
   
   public String toString() {
      return super.toString() + "Name: " + _name;
   }
}

interface Keyed{
   public int keyCompare(Keyed other);
   public String toStringKey();
}

class KeyedNumber implements Keyed {
   int _number;
   
   public KeyedNumber(int number) {
      _number = number;
   }

   public int getNumber() {
      return _number;
   }

   public String toStringKey() {
      return "Integer";
   }
   
   public int keyCompare(Keyed o) {
      if(o instanceof KeyedNumber) {
         KeyedNumber other = (KeyedNumber)o;
         if(_number > other.getNumber())
            return 1;
         else if(_number < other.getNumber())
            return -1;
         else
            return 0;
      }
      else
         return 0;
   }
}