/*
 * Programmer: Nicholas Sanchez
 * File Name: MyLinkedList
 * Purpose: To provide a generic implementation of a linked list
 */
package MyLinkedList;

/**
 * A class that implements a generic linked list
 */
public class TheList<E> {
    
    private Node head ; // The head or start of the list
    private int size = 0; // The size of the list
    
    /**
     * Appends new nodes to the end of the list
     * @param newInfo the information for the info portion of the new node
     */
    public void append (E newInfo)
    {
        Node newNode = new Node(newInfo) ; // the new node being appended 
        
        if (head == null) //If the list is empty create a new list
        {
            head = newNode ; //new node becomes head of the list
        } else //append new node to the end of the list
        {
            Node last = findLast() ; //Find the last node in the list
            /*while(findLast.next != null) //While the last node is not found
            {
                findLast = findLast.next ;// Go to next node
            }*/
            
            last.next = newNode ; //append new node to end of list
        }
        size++ ; //increase size of list
    }
    
    public Node findLast()
    {
        Node findLast = head ; //Find the last node in the list
            while(findLast.next != null) //While the last node is not found
            {
                findLast = findLast.next ;// Go to next node
            }
            return findLast ;
    }
    
    /**
     * Adds an object to the list at a specific position
     * @param position the position the object is being added to
     * @param newInfo the new object being added
     */
    public void add (int position, E newInfo)
    {
        Node newNode = new Node(newInfo) ; // The new node being added to list
        int counter ; // The current position in the list
        Node temp ; //A temporary node used to travel through the list
                
        if(head == null) //If the list is empty
        {
            head = newNode ; //Create a new list where head is the new node
        } else if(position == 1) // If the new node is to be the new head
        {
            newNode = new Node(newInfo) ;
            newNode.next = head ;
            head = newNode ;
        } else // find the position in the list and add the new node
        {
            temp = head ;
            counter = 1 ;
            
            //a loop that finds the position before the desired position
            while(counter < position - 1) 
            {
                temp = temp.next ;
                counter++ ;
            }
            
            //assigne new node to the desired position in the list
            newNode.next = temp.next ;
            temp.next = newNode ;
            
        }
        size++ ; //increase the size of the list
    }
    
    /**
     * Deletes an object at a specific position on the list
     * @param position the position of the object being deleted 
     */
    public void delete (int position)
    {
        int counter ; // the current position on the list
        Node leader ; // the current node
        Node trailer ; // the previous node
        if(position == 1) // The head of the list is deleted 
        {
            head = head.next ; // The next node becomes the new head
        } else // find the node at the desired position
        {
            counter = 1 ; //beginning of the list
            leader = head ;
            trailer = leader ;
            while(counter != position) //while the position has not been found
            {
                trailer = leader ; // iterate through the list
                leader = leader.next ;
                counter++ ;
            }
       
            trailer.next = leader.next ; //delete the desired node
        }
        size--; //dectement size of the list
    }
    
    /**
     * Swaps the position of two objects in the list
     * @param position The position of the first object
     * @param positionTwo The position of the second object
     */
    public void swap (int position, int positionTwo)
    {
        if(position == positionTwo) // If the positions are the same 
        {
            //do nothing 
        } else 
        {
            if(position == 1) // If one desired node is the head
            {
                swapHead(positionTwo) ;
            } else if(positionTwo - position != 1)//if the positions are more 
            {//than one position apart 
                swapFar(position, positionTwo) ;        
            } else // the nodes to be swapped are next to each other
            {
                swapClose(position) ;
            }
        }
    }
    
    /*
     A utility method that swaps the head of the list with another node on the 
     list
    */
    private void swapHead(int positionTwo)
    {
        
        int counter = 1 ; // current position on the list
        Node first = head ; // the first node to be swapped
        Node temp = head ; // used to iterate through the list
        Node trailTwo = head ; //the node before the second node being swapped
        Node second ; // the second node to be swapped
        
        while(counter != positionTwo) // while position is not found
        {
            trailTwo = temp ; //increment both trailer and leader to next node
            temp = temp.next ;
            counter++ ;
        }
        
        // Switch the first and second nodes and assign the new head
        second = temp ; 
        trailTwo.next = second.next;
        second.next = first.next ;
        first.next = trailTwo.next ;
        head = second ; 
        trailTwo.next = first ;
    }
    
    /*
     A utility method that swaps two nodes that are more than one position away
     from each other
    */
    private void swapFar(int position, int positionTwo)
    {
        int counter = 1 ; // current position on the list
        Node temp = head ; // used to iterate through the list
        Node trailOne = head ; //the node before the first node being swapped
        Node trailTwo = head ; // the node before the second node being swapped
        Node first ; // the first node being swapped
        Node second ; // the second node being swapped 
        
        while(counter != position) //while the first node has not been found
        {
            trailOne = temp ;// move the trailer and leader to the next nodes
            temp = temp.next ;
            counter++ ;
        }
        first = temp ; //the first node being swapped
        
        while(counter != positionTwo) //while the second node has not been found
        {
            trailTwo = temp ; //move the trailer and leader to next nodes
            temp = temp.next ;
            counter ++ ;
        }
        //Switch the first and second nodes with each other
        second = temp ;
        trailTwo.next = second.next ;
        second.next = first.next ;
        trailOne.next = second ;
        first.next = trailTwo.next ;
        trailTwo.next = first ;
    }
    
    /*
     A utility method that swaps two nodes that are next to each other
    */
    private void swapClose(int position)
    {
        int counter = 1 ; //The current position on the list
        Node temp = head ; //Used to iterate through the list
        Node trailOne = head ; //The node before the first node being swapped
        Node first ; //The first node being switched
        Node second ; //The second node being switched 
        
        while(counter != position) //While the first node has not been found
        {
            trailOne = temp ; //move the trailer and leader to the next node
            temp = temp.next ;
            counter ++ ;
        }
        
        // switch the first and the second nodes
        first = temp ;
        second = temp.next ;
        trailOne.next = second ;
        first.next = second.next ;
        second.next = first ;
    }
    
    /**
     * Reverse the order of the list
     */
    public void reverse()
    {
        int firstPosition = 1 ; //the position of head
        int secondPosition = size ; //the position of the last node
        
        if(head == null) //If the list is empty
        {
            System.out.println("Sorry the list is empty!");
        } else //Start switching nodes
        {
            while(firstPosition < secondPosition)//While nodes left unswapped
            {
                swap(firstPosition, secondPosition); //swap em
                firstPosition++ ; //move to next node
                secondPosition-- ;//move to previous node
            }
        }
    }
     /**
      * Clears the list of all nodes
      */
    public void clear()
    {
        head = null ;
    }
    
    /**
     * Returns the list in the Order in which they appear
     * @return All objects on the list in the order in which they appear as a 
     * String
     */
    public String toString()
    {
        String out = "" ;
        Node temp = head ;
        
        if(head == null)
        {
            return "List is empty\n" ;
        }
        while(temp != null) //while nodes are left
        {
            out += temp.info + " "; //add info of node to string
            temp = temp.next ;
        }
        return out + "\n"; //return string
    }
    
    /**
     * Inner class that represents a node on the linked list
     */
    class Node 
    {
        E info;    //the info portion of the node 
        Node next; //the next node on the list
        
        /**
         * Constructs a new node object
         * @param newObject the object to be added to the info portion of the 
         * node
         */
        Node(E info) 
        {
            this.info = info;       
        }
    } // end of node class declaration 
} // end of TheList class declaration 
