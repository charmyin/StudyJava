package com.charmyin.practice.advantage.collections;


import java.util.*;

/**
   This program sorts a set of items by comparing
   their descriptions.
*/
public class TreeSetTest
{  
   public static void main(String[] args)
   {  
      SortedSet<Item> parts = new TreeSet<Item>();
      parts.add(new Item("Toaster", 1234));
      parts.add(new Item("Widget", 4562));
      parts.add(new Item("Modem", 9912));
      parts.add(new Item("bbb", 1912));
      System.out.println(parts);

      SortedSet<Item> sortByDescription = new TreeSet<Item>(new
         Comparator<Item>()
         {  
            public int compare(Item a, Item b)
            {  
               Integer descrA = a.getPartNumber();
               Integer descrB = b.getPartNumber();
               return descrA.compareTo(descrB);
            }
         });

      sortByDescription.addAll(parts);
      System.out.println(sortByDescription);
   }
}

/**
   An item with a description and a part number.
*/
class Item implements Comparable<Item>
{ 
   /**
      Constructs an item.
      @param aDescription the item's description
      @param aPartNumber the item's part number
   */
   public Item(String aDescription, int aPartNumber)
   {  
      description = aDescription;
      partNumber = aPartNumber;
   }

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

/**
      Gets the description of this item.
      @return the description
   */
   public String getDescription()
   {  
      return description;
   }

   public String toString()
   {  
      return "[description=" + description
         + ", partNumber=" + partNumber + "]";
   }

   public boolean equals(Object otherObject)
   {  
      if (this == otherObject) return true;
      if (otherObject == null) return false;
      if (getClass() != otherObject.getClass()) return false;
      Item other = (Item) otherObject;
      return description.equals(other.description)
         && partNumber == other.partNumber;
   }

   public int hashCode()
   {  
      return 13 * description.hashCode() + 17 * partNumber;
   }

   public int compareTo(Item other)
   {  
      return partNumber - other.partNumber;
   }

   private String description;
   private int partNumber;
}
