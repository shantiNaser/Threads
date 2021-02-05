/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author MacBookPro
 */
public class binTree 
{
    private Node root;
    private int n;
 
    //  Constructor 
     public binTree()
     {
         root = null;
         n=0;
     }
     // Function to check if tree is empty 
     public boolean isEmpty()
     {
         return root == null;
     }
     // Functions to insert data 
     public void insert(int data)
     {
         root = insert(root, data);
     }
     // Function to insert data recursively 
     private Node insert(Node node, int data)
     {
         if (node == null)
         {
             node = new Node(data);
             this.setN(this.getN()+1);
         }
         
         else
         {
             if (node.getValue()<data)
                 node.setRight(insert(node.getRight(), data));
                 
             else if(node.getValue()>data)
                 node.setLeft(insert(node.getLeft(), data));
             else
                 return node;
         }
         return node;
     }     
    
     
     public String inorder()
     {
          return inorder(root ," ");
     }
     
     private String inorder(Node r,String con)
     {
         if (r != null)
         {
             con=inorder(r.getLeft(),con);
//             System.out.print(r.getValue() +" ");
             con=con+r.getValue()+" ,";
             con=inorder(r.getRight(),con);
         }
         return con;
     }
     

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }
    
    public void deleteKey(int key) 
    { 
        root = deleteRec(root, key); 
    } 
  
  
    private Node deleteRec(Node root, int key) 
    { 
       
        if (root == null)  
        {
            return root;
        } 
  
        
        if (key < root.getValue())
            root.setLeft(deleteRec(root.getLeft(), key));  
        else if (key > root.getValue())
            root.setRight(deleteRec(root.getRight(), key)); 
  
        
        else
        { 
          
            if (root.getLeft() == null) 
                return root.getRight(); 
            else if (root.getRight() == null) 
                return root.getLeft(); 
  
           
            root.setValue(minValue(root.getRight())); 
  
         
            root.setRight(deleteRec(root.getRight(), root.getValue())); 
        } 
  
        return root; 
    } 
    public int minValue()
    {
        return minValue(root);
    }
    private int minValue(Node root) 
    { 
        if (root==null)
        {
            return 9999999; 
        }
        int minv = root.getValue(); 
        while (root.getLeft() != null) 
        {
            minv = root.getLeft().getValue();
            root = root.getLeft(); 
        } 
        return minv; 
    }
    public int maxValue()
    {
        return maxValue(root);
    }
    private int maxValue(Node root) 
    { 
        if (root==null)
        {
            return 9999999; 
        }
        int max = root.getValue(); 
        while (root.getRight() != null) 
        { 
            max = root.getRight().getValue(); 
            root = root.getRight(); 
        }   
        return max; 
    }
}
