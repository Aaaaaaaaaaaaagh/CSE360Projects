/*
 * Author: Armaan Dodd
 * Class ID: 115
 * Assignment value: 2
 * Description: This is the class description of a simple list, which operates as a list that "pushes" values into the list,
 * and deletes values as they are mentioned by the remove function. A function also exists to find the index of a specific
 * variable. The code below is fairly straightforward, and is commented to explain what each line of code does. This code also
 * includes functions to increase and decrease in size as need be, as well as an append function.
 */


package cse360assign2;

import java.util.*;
import java.lang.Math; //uses math class for floor functions, as that is a fix for a bug I had.

public class SimpleList { //initialize class
	int[] list;
	int count;


public SimpleList() { 
	list = new int[10]; //starts up with int length of 10
	count = 0;
}

public void add(int val) { //
	int arraySize = list.length;
	if (count < arraySize) { //if the count is lower than the given array size
		count++; //increment it
	}
	else {
		int nextLength = (int) Math.floor(list.length * 1.5);//this function will make an array that is 1.5 times
															 //larger than the first, rounded down. EG, 10->14.
		arraySize = nextLength;
		int[] newList = Arrays.copyOf(list, arraySize);
		list = newList; //makes list a copy of the list we just made.
		count++;
	}
	
	for(int index = count - 1; index >= 0; index--) //goes through and moves the array over.
	{
		if (index != list.length-1) {
			list[index + 1] = list[index];
			
			
		}
		
	}
	
	list[0] = val; //adds the value at the first element of the array, now that everything's been shifted over.
}

public void remove(int val)
{
	int location = search(val); 
	
	if (location != -1)
	{ 
		count--;
		int index = location;
		while(index < list.length - 1)
		{
			list[index] = list[index+1];
			index++;
			
			
		}
		
	}
	
	list[count] = 0;
	//as something is being removed from the array, the last value has to be changed to 0.
	if (count <= ((int) Math.floor(list.length * 0.75))) { //resizes if more than 25% elements
		int[] newList = Arrays.copyOf(list, count); //copies array over.
		list = newList;
	}
}

public int count()
{
	return count;
}

public String toString() 
{
	String stringArray = "";
	
	for(int index = 0; index < list.length; index++) {
		stringArray += list[index] + " ";
	}
	
	return stringArray.trim(); //gets rid of extra spaces or values at the end. one space is always expected, so it needs to be trimmed.
}

public int search(int value)
{
	int location = -1;
	
	for (int index = 0; index < count; index++)
	{
		if (list[index] == value) {
			location = index;
		}
	}
	
	return location; //returns location of value in array
}


public void append(int val)
{
	if (count < list.length) 
	{ 
		list[count] = val; //actually puts in the value at count, which is always going to be the last value to be expected to be added to the array.
	}
	else 
	{
		int nextLength = (int) Math.floor(list.length * 1.5); // only casting to an int doesn't seem to work in my cases. using math library does.
		int[] newList = Arrays.copyOf(list, nextLength); //Arrays function to make a copy into the new array, as opposed to a loop that would try and copy things over one at a time.
		list = newList;
		list[count] = val;
	}
	count++;
}


public int first() //returns the first element in the array
{
	 if (list.length != 0)
	 {
		 return list[0];
	 }
	 else return -1;
}

public int last() //returns the last element in the array
{
	 if (list.length != 0)
	 {
		 return list[list.length-count];
	 }
	 else return -1;
}

public int size() //returns the number of elements in the array
{
	return (list.length-count);
}
}