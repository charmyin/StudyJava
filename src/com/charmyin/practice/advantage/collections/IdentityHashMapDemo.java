package com.charmyin.practice.advantage.collections;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IdentityHashMapDemo {

   public static void main(String args[]) {
      // Create a hash map
      //HashMap<Data,String> ihm = new HashMap<Data,String>();
	   IdentityHashMap<Data, String> ihm = new IdentityHashMap<Data, String>();
      // Put elements to the map
      Data dt1 = new Data("1");
      Data dt2 = new Data("1");
      Data dt3 = new Data("3");
      System.out.println(dt1.equals(dt2));
      ihm.put(dt1, "hello");
      ihm.put(dt2, "ok");
      ihm.put(dt3, "o33k");
      // Get a set of the entries
      Set set = ihm.entrySet();
      // Get an iterator
      Iterator i = set.iterator();
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      /*
      
      ihm.put("Zara", new Double(3434.34));
      ihm.put("Mahnaz", new Double(123.22));
      ihm.put("Ayan", new Double(1378.00));
      ihm.put("Daisy", new Double(99.22));
      ihm.put("Qadir", new Double(-19.08));
      ihm.put("Qadir", new Double(-49.08));
      
      // Get a set of the entries
      Set set = ihm.entrySet();
      // Get an iterator
      Iterator i = set.iterator();
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
      // Deposit 1000 into Zara's account
      double balance = ((Double)ihm.get("Zara")).doubleValue();
      ihm.put("Zara", new Double(balance + 1000));
      System.out.println("Zara's new balance: " + ihm.get("Zara"));*/
   }
   
   static class Data {
		String value;

		Data(String value) {
			this.value = value;
		}
		
		public boolean equals(Data data){
			
			if(this==data || this.value.equals(data.value)){
				return true;
			}else{
				return false;
			}
			
		}
	}
}