/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class OrderList {
    private Node first;
    
    private boolean isEmpty() {
        return first == null;
    }
    
    public void clear() {
        first = null;
    }

    
    public boolean add(Orders orders) {
        Node node = new Node(orders);
        if (isEmpty()) {
            first = node;
        } else {
            Node lastNode = first;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
        return true;

    }

   
    public int size() {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    
    public int search(Orders orders) {
        Node node = new Node(orders);
        int index = 0;
        Node temp = first;
        while (temp != null) {
            if (temp.order.getOrderIds().equals(orders.getOrderIds()) || temp.order.getMobileNumber().equals(orders.getMobileNumber())) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

  
    public void add(int index, Orders orders) {
        Node node = new Node(orders);
        Node temp = first;
        int count = 0;
        if (index == 0) {
            node.next = temp;
            first = node;
        } else {
            while (count++ < index - 1) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }

    }

   
    public Orders get(int index) {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            if (count == index) {
                return temp.order;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }
    
   
    public void set(int index, Orders orders) {
        Node node=new Node(orders);
		Node temp=first;
		int count=0;
		if(index==0){			
			node.next=temp;
			first=node;			
		}else{		
			while(count++<index-1){
				temp=temp.next;
			}
			node.next=temp.next;
			temp.next=node;
		}
	}

   
    public boolean contains(Orders orders) {
       return search(orders)!=-1;
    }

  
    public Orders[] toArray() {
        Orders[] tempOrderArray = new Orders[size()];
        Node temp = first;
        for (int i = 0; i < tempOrderArray.length; i++) {
            tempOrderArray[i] = temp.order;
            temp = temp.next;
        }
        return tempOrderArray;
    }

    
    public boolean remove(int index) {
        int count = 0;
        Node temp = first;
        if (index == 0) {
            first = first.next;
        } else {
            while (count++ < index - 1) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return true;
    }
    
    class Node{
	private  Orders order;
	private Node next;
		
	Node(Orders order){
            this.order=order;
	} 
    }
    
}
