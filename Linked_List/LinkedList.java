import java.util.*;
import java.io.*;

public class LinkedList{
	public class Node{
		private int data = 0;
		private Node next = null;
	
		Node(int data){
			this.data = data;
		}
	}

	private int size = 0;
	private Node head = null;
	private Node tail = null;

	public int get_size(){
		return this.size;
	}

	public boolean is_empty(){
		return this.size == 0 ? true : false;
	}

	public void display(){
		Node current_node = this.head;
		while(current_node != null){
			System.out.print(current_node.data + "-> ");
			current_node = current_node.next;
		}
		System.out.println();
	}

	//execption handling======================================================
	private void index_out_of_bound_inclusive(int idx) throws Exception{
		if(idx < 0 || idx > this.size)
			throw new Exception("Invalid Index : Index out of bound");
	}
	
	private void empty_exception() throws Exception{
		if(this.size == 0)
			throw new Exception("Empty Linked List");
	}
	
	private void index_out_of_bound_exclusive(int idx) throws Exception{
		if(idx < 0 || idx >= this.size)
			throw new Exception("Invalid Index : Index out of bound");
	}

	//get=====================================================================
	private Node first_node(){
		return this.head;
	}

	public int get_first() throws Exception{
		empty_exception();
		Node node = first_node();
		return node.data;
	}

	private Node last_node(){
		return this.tail;
	}

	public int get_last() throws Exception{
		empty_exception();
		Node node = last_node();
		return node.data;
	}	

	private Node node_at(int idx){
		if(idx == 0)
			return first_node();
		else if(idx == (this.size -1))
			return last_node();
		else{
			Node current_node = this.head;
			while(idx-- > 0)
				current_node = current_node.next;
			return current_node;
		}
	}
				

	public int get_node_at(int idx) throws Exception{
		index_out_of_bound_exclusive(idx);
		Node node = node_at(idx);
		return node.data;
	}		

	//set===================================================================
	private void set_node_first(Node node){
		if(this.head == null){
			this.head = node;
			this.tail = node;
		}else{
			node.next = this.head;
			this.head = node;
		}
		this.size ++;
	}

	public void set_at_first(int data){
		Node node = new Node(data);
		set_node_first(node);
	}

	private void set_node_last(Node node){
		if(this.head == null){
			this.head = node;
			this.tail = node;
		}else{
			this.tail.next = node;
			this.tail = node;
		}
		this.size ++;
	}

	public void set_at_last(int data){
		Node node = new Node(data);
		set_node_last(node);
	}

	private void set_node_at(Node node, int idx){
		if(idx == 0){
			set_node_first(node);
		}else if(idx == this.size){
			set_node_last(node);
		}else{
			Node previous_node = node_at(idx - 1);
			node.next = previous_node.next;
			previous_node.next = node;
			this.size ++;
		}
	}

	public void set_at(int data, int idx) throws Exception{
		index_out_of_bound_inclusive(idx);
		Node node = new Node(data);
		set_node_at(node,idx);
	}

	//remove=========================================================
	private Node remove_first_node(){
		Node node = this.head;
		if(this.size == 1){
			this.head = null;
			this.tail = null;
		}else {
			this.head = node.next;
			node.next = null;
		}
		this.size--;
		return node;
	}
		

	public void remove_first() throws Exception{
		empty_exception();
		Node node = remove_first_node();
	}

	private Node remove_last_node(){
		Node node = this.tail;
		if(this.size == 1){
			this.head = null;
			this.tail = null;
		}else {
			Node previous_node = node_at(this.size -2);
			previous_node.next = null;
			this.tail = previous_node;
		}
		this.size--;
		return node;
	}

	public void remove_last() throws Exception{
		empty_exception();
		Node node = remove_last_node();
	}

	private Node remove_node_at(int idx){
		Node node = node_at(idx);
		if(idx == 0)
			return remove_first_node();
		else if(idx == (this.size -1))
			return remove_last_node();
		else{
			Node previous_node = node_at(idx -1);
			previous_node.next = node.next;
			node.next = null;
			this.size--;
			return node;
		}
	}

	public void remove_at(int idx) throws Exception{
		index_out_of_bound_exclusive(idx);
		Node node = remove_node_at(idx);
	}
}