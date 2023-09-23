/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nable_quiz2;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Jake Marson Nable
 */
public class Nable_Quiz2 {
    
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
    while(true){
        menu();
        int oums = scan.nextInt();
            switch(oums){
                case 1:
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    System.out.println("ok, have a nice day!!");
                    return;
                default:
                    System.out.println("Invalid Input, Please Try Again!!");
                    break;
            }
        }
    }    
    //Main Menu
    public static void menu(){
        System.out.println("  Main Menu");
        System.out.println("==============");
        System.out.println("1. Question One.");
        System.out.println("2. Question Two.");
        System.out.println("3. EXIT.");
    }
    //Question One
    public static Node head;
    
    static class Node {
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public void insertionNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
        public Node searchNode(int target){
        Node current = head;
        while(current != null){
            if(current.data == target){
                return current;
        }
        current = current.next;
        }      
        return null;
    }
    
    public static void oneEnter(){
        System.out.println("Enter the element you want to Enter");
        int input = scan.nextInt();
        Elements.insertionNode(input);
    }
    public static void oneSearch() {
        System.out.println("Enter the elements you want to search.");
        int target = scan.nextInt();
            
        Node resultNode = Elements.searchNode(target);
        if(resultNode != null){
            System.out.println("The element "+ resultNode.data + " you searched is in the List: ");
        }else{
            System.out.println("The Element you search is not in the List");
        }
    }
    
    static Nable_Quiz2 Elements = new Nable_Quiz2();
    public static void oneMenu(){
        System.out.println("   Welcome to Question One Main Menu");
        System.out.println("=======================================\n");
        System.out.println("What do you want to do?\n 1. Enter Element\n 2. Search Element.");
        int oums = scan.nextInt();
        
        switch(oums){
            case 1:
                oneEnter();
                break;
            case 2:
                oneSearch();
                break;
        }
    }
        
    public static void one(){
        int loopO = 1;
        do{
            oneMenu();
            System.out.println("Do you want to have another Transaction?\n 1. YES.\n 2. NO.");
            int user = scan.nextInt();
            if(user == 2){ // .equalsIgnoreCase("y or n")
                System.out.println("Ok, Have a nice day");
                loopO++;
            }else{
                System.out.println("\nOk, Another Transcation");
            }      
        }while(loopO == 1); 
    }    
    //Question Two

        private class NodeTwo {
            int dataTwo;
            NodeTwo nextTwo;
        }
        
    private static NodeTwo headTwo, tail;
    private static int size;

    private NodeTwo createNewNode(int index) throws Exception {
        NodeTwo node = new NodeTwo();
    
        node.dataTwo = index;
        node.nextTwo = null;
    
        return node;
    
}

    private void insertion(int index, int position) throws Exception {
        if(position < 0 || position > size){
            throw new Exception("Index Invalid");
        } else if (position == 0){
            insertBeg(index);
        } else if (position == size){
            insertEnd(index);
        }else{
            NodeTwo node = createNewNode (index);
            NodeTwo prev = getNodeat(index -1);
            node.nextTwo = prev.nextTwo;
            prev.nextTwo = node;
            tail.nextTwo = headTwo;
            size++;
        }
    }
        
    private void insertBeg(int index)throws Exception{
        NodeTwo node = createNewNode(index);
    
        if (size == 0){
        headTwo = tail = node;
        }else{
            node.nextTwo = headTwo;
            headTwo = node;
        }
    
        tail.nextTwo = tail; 
        size++;
    }

    private void insertEnd (int index) throws Exception{
        NodeTwo node = createNewNode(index);
    
        if(size > 0){
            tail.nextTwo = node;
            tail = node;
        
        }else if (size == 0){
            headTwo = tail = node;
        }
        tail.nextTwo = headTwo;
        size++;
    }

    private void display() throws Exception {
        if (size == 0){
            throw new Exception ("List is empty");
        }
    
        NodeTwo temporary = headTwo;
    
        while(temporary != tail){
        System.out.println(temporary.dataTwo + "  ");
        temporary = temporary.nextTwo;
    }
        System.out.println(tail.dataTwo + "  ");   
    }

    private NodeTwo getNodeat (int position) throws Exception{
    
        if (size == 0){
            throw new Exception ("Linked list is empty");
        }else if (position < 0 || position > size ){
            throw new Exception("Invalid Position");
        }else {
            for (int i = 0; i < position; i++) {
                headTwo = headTwo.nextTwo;    
            }
        }
            return headTwo;
    }
    static Nable_Quiz2 List = new Nable_Quiz2 ();
    
    public static void twomenu() throws Exception{
        System.out.println("  Welcom to Question Two Main Menu");
        System.out.println("======================================\n");
        
        System.out.println("What do you want to do?\n 1. Enter Element\n 2. Display Elements");
        int oums = scan.nextInt();
        
        switch(oums){
            case 1:
                twoEnter();
                break;
            case 2:
                twoDisplay();
                break;
        }
    }
    public static void twoEnter(){
        
        int index,position =0;
        
        System.out.println("NOTE: Enter the FIRST Element in beginning!!\n");
        System.out.println("Please Enter Element");
        index = scan.nextInt();
        System.out.println("Enter Position.\n 1. Beginning.\n 2. End.");
        int input = scan.nextInt();
        if(input == 1){
            position = 1;
        }else if (input == 2){
            position = size;
        }
    }
    public static void twoDisplay() throws Exception{
        List.display();
    }
    public static void two() throws Exception{
        int loopT = 1;
        do{
            twomenu();
            System.out.println("Do you want to have another Transaction?\n 1. YES.\n 2. NO.");
            int user = scan.nextInt();
            if(user == 2){ // .equalsIgnoreCase("y or n")
                System.out.println("Ok, Have a nice day");
                loopT++;
            }else{
                System.out.println("\nOk, Another Transcation");
            }      
        }while(loopT == 1);     
    }
}

