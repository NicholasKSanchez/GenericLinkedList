/*
 * Programmer: Nicholas Sanchez
 * File Name: LinkedListTest
 * Purpose: To test my implementation of a linked list
 */
package MyLinkedList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * A class to test an implementation of a Linked List 
 */
public class LinkedListTest {
    
    public static void main(String args[]) throws IOException
    {
        TheList<Integer> list = new TheList<Integer>() ; //Linked List Object
        
        //Scanner Object reading inputs from the file list-ops.txt
        Scanner inputs = new Scanner(new File("list-ops.txt")) ;
        String operation ; //The current operation to be exectured on the lsit
        int operandOne ; //The first operand in the operation
        int operandTwo ; //The second operand in the operation
        
        while(inputs.hasNext()) //while not eof
        {
            operation = inputs.next() ; //receive next operation
            if(operation.equals("APPEND"))//if append operation
            {
                operandOne = inputs.nextInt() ;
                list.append(operandOne);
                System.out.println(operation + " " + operandOne 
                                   + " has been executed."
                                   + " \nHere is the new List: " 
                                   + list.toString());
            } else if(operation.equals("ADD"))//if add operation
            {
                operandOne = inputs.nextInt() ;
                operandTwo = inputs.nextInt() ;
                list.add(operandOne, operandTwo);
                System.out.println(operation + " " + operandOne 
                                   + " " + operandTwo 
                                   + " has been executed." 
                                   + " \nHere is the new List: "
                                   + list.toString());
            } else if(operation.equals("DELETE"))//if delete operation
            {
                operandOne = inputs.nextInt() ;
                list.delete(operandOne);
                System.out.println(operation + " " + operandOne  
                                   + " has been executed."
                                   + " \nHere is the new List: "
                                   + list.toString());
            } else if(operation.equals("SWAP"))//if swap operation
            {
                operandOne = inputs.nextInt() ;
                operandTwo = inputs.nextInt() ;
                list.swap(operandOne, operandTwo);
                System.out.println(operation + " " + operandOne 
                                   + " " + operandTwo
                                   + " has been executed."
                                   + " \nHere is the new List: "
                                   + list.toString());
            } else if(operation.equals("REVERSE"))//if reverse operation
            {
                list.reverse();
                System.out.println(operation + " has been executed."
                                   + " \nHere is the new list: "
                                   + list.toString());
            } else//its a clear 
            {
                list.clear();
                System.out.println(operation + " has been executed. "
                                   + " \nHere is the new list: "
                                   + list.toString());
            }
        }
    }
}
