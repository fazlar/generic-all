package com.generic;

import java.util.ArrayList;
import java.util.List;

public class BoundType {

//	 private T t;          
//
//	    public void set(T t) {
//	        this.t = t;
//	    }
//
//	    public T get() {
//	        return t;
//	    }
//
//	    public <U extends String> void inspect(U u,int a){
//	        System.out.println("T: " + t.getClass().getName());
//	        System.out.println("U: " + u.getClass().getName());
//	    }
	    
	    static void processElements(List<? super Integer> a) {
	        for (Object element : a) {
	             System.out.println(element);
	        }
	    }
	    public static void main(String[] args) {
//	    	BoundType<Integer> integerBox = new BoundType<Integer>();
//	        integerBox.set(new Integer(10));
//	        integerBox.inspect("some text",1); // error: this is still String!
//		    =========================================================================================
		    
	   	 // ArrayList Containing Integers

	           List<Integer> a1 = new ArrayList<>();
	           a1.add(100);

	           a1.add(200);

	           a1.add(300);

//	           processElements(a1);

	           // ArrayList Containing Longs

	           List<Long> a2 = new ArrayList<>();

	           a2.add(100L);

	           a2.add(200L);

	           a2.add(300L);

//	           processElements(a2);

	            // Arraylist containing Doubles

	           List<Double> a3 = new ArrayList<>();

	           a3.add(21.35);

	           a3.add(56.47);

	           a3.add(78.12);

//	           processElements(a3);

	           // Arraylist containing Strings

	           List<String> a4 = new ArrayList<>();

	           a4.add("One");

	           a4.add("Two");

	           a4.add("Three");

	           // This will not work

//	           processElements(a4); // Compile time error
	        
	        
	    }


}
