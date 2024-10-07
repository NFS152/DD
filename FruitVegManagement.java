  // Assignment: Fruit and Vegitable Management
// Author: Dhrubo Roy Partho
// Date: 21/04/2024
// Version: 1.0v

import java.util.ArrayList;
import java.util.Scanner;

class Item{
	private String name;
	private String type;
	private double price;

	// Constractor
	public Item(String name, String type, double price){
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public String getName() {return name;}

	public String getType(){
		return type;
	}

	public double getPrice(){
		return price;
	}
}

class Inventory{
	// Inventory item array list
	ArrayList<Item> itemList = new ArrayList<Item>();
	public void addItem(Item item){
		itemList.add(item);
	}
	public void displayItem(){
		for(Item item : itemList){
			System.out.print("Item name: ");
			System.out.println(item.getName());
			System.out.print("Item type: ");
			System.out.println(item.getType());
			System.out.print("Item price: ");
			System.out.println("$" + item.getPrice() + "\n");
		}
	}

//	public void displayByCatagory(){
//		System.out.println("Fruit list:\n-----------");
//		for(Item item : itemList){
//			if(item.getType().equals("fruit")){
//				System.out.print("Item name: ");
//				System.out.println(item.getName());
//				System.out.print("Item type: ");
//				System.out.println(item.getType());
//				System.out.print("Item price: ");
//				System.out.println("$" + item.getPrice() + "\n");
//			}
//		}
//	}
}


// Main class
class FruitVegManagement{
	public static void main(String[] args){
		// Scanner and Inventory object
		Scanner sc = new Scanner(System.in);
		Inventory inventory = new Inventory();

		// Input cycle number
		int n;

		System.out.print("How many fruit or veg do you want to enter: ");
		n = sc.nextInt();
		for(int i=1;i<=n;i++){
			System.out.print("Enter #" + i +" item name: ");
			String name = sc.next();
			System.out.print("Enter #" + i +" item type: ");
			String type = sc.next();
			System.out.print("Enter #" + i +" item price: ");
			//String price = sc.next();
			//double p = Double.parseDouble(price);
			double p = sc.nextDouble();
			Item newitem = new Item(name, type, p);
			inventory.addItem(newitem);
		}


		/*inventory.addItem(new Item("Apple", "fruit", 130.0));
		inventory.addItem(new Item("Coconut", "fruit", 110.0));
		inventory.addItem(new Item("Banana", "fruit", 30.5));

		inventory.addItem(new Item("Radish", "veg", 60.0));
		inventory.addItem(new Item("Capsicum", "veg", 90.0));
		inventory.addItem(new Item("Corn", "veg", 70.0)); */


		System.out.println("\nItems list:\n----------");
		inventory.displayItem();
	}
}