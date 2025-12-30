class InventoryNode {
	String ItemName;
	int ItemID;
	int Quantity;
	int Price;
	InventoryNode next;

	InventoryNode(String ItemName, int ItemID, int Quantity, int Price) {
		this.ItemName = ItemName;
		this.ItemID = ItemID;
		this.Quantity = Quantity;
		this.Price = Price;
		this.next = null;
	}
}

class InventoryLinkedList {
	private InventoryNode head;

	public void Add(String ItemName, int ItemID, int Quantity, int Price) {
		InventoryNode in = new InventoryNode(ItemName, ItemID, Quantity, Price);
		InventoryNode temp = head;
		if (head == null) {
			head = in;
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = in;
		}
	}

	public void AddB(String ItemName, int ItemID, int Quantity, int Price) {
		InventoryNode in = new InventoryNode(ItemName, ItemID, Quantity, Price);
		if (head == null) {
			head = in;
		} else {
			in.next = head;
			head = in;
		}
	}

	public void AddP(int pos, String ItemName, int ItemID, int Quantity, int Price) {
		InventoryNode in = new InventoryNode(ItemName, ItemID, Quantity, Price);
		InventoryNode temp = head;
		if (pos <= 1) {
			AddB(ItemName, ItemID, Quantity, Price);
			return;
		}
		for (int i = 1; i < pos - 1; i++) {
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Index Out Of Bound");
			Add(ItemName, ItemID, Quantity, Price);
			return;
		}
		in.next = temp.next;
		temp.next = in;
	}

	public void Delete(int ItemID) {
		InventoryNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.ItemID == ItemID) {
			head = head.next;
			return;
		}
		while (temp.next != null && temp.next.ItemID != ItemID) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Item not Found");
		} else {
			temp.next = temp.next.next;
		}
	}

	public void Update(int ItemID, int Quantity) {
		InventoryNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.ItemID == ItemID) {
			head.Quantity = Quantity;
			return;
		}
		while (temp.next != null && temp.next.ItemID != ItemID) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Item not Found");
		} else {
			temp.next.Quantity = Quantity;
		}
	}

	public void SearchI(int ItemID) {
		InventoryNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.ItemID == ItemID) {
			System.out.println("Item ID: " + head.ItemID + " | Name: " + head.ItemName + " | Quantity: " + head.Quantity
					+ " | Price: " + head.Price);
			return;
		}
		while (temp.next != null && temp.next.ItemID != ItemID) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Item Not Found");
		} else {
			System.out.println("Item ID: " + temp.next.ItemID + " | Name: " + temp.next.ItemName + " | Quantity: "
					+ temp.next.Quantity + " | Price: " + temp.next.Price);
		}
	}

	public void SearchN(String ItemName) {
		InventoryNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.ItemName.equals(ItemName)) {
			System.out.println("Item ID: " + head.ItemID + " | Name: " + head.ItemName + " | Quantity: " + head.Quantity
					+ " | Price: " + head.Price);
			return;
		}
		while (temp.next != null && !temp.next.ItemName.equals(ItemName)) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Item Not Found");
		} else {
			System.out.println("Item ID: " + temp.next.ItemID + " | Name: " + temp.next.ItemName + " | Quantity: "
					+ temp.next.Quantity + " | Price: " + temp.next.Price);
		}
	}

	public void Total() {
		InventoryNode temp = head;
		while (temp != null) {
			System.out.println("The Total Value of " + temp.ItemName + " is: " + (temp.Price * temp.Quantity));
			temp = temp.next;
		}
	}
}

public class InventoryManagementSystem {
	public static void main(String[] args) {
		InventoryLinkedList inventory = new InventoryLinkedList();

		inventory.Add("Apple", 101, 50, 2);
		inventory.Add("Banana", 102, 30, 1);
		inventory.AddB("Mango", 103, 20, 3);
		inventory.AddP(2, "Orange", 104, 25, 2);

		System.out.println("=== Current Inventory ===");
		inventory.Total();

		System.out.println("\n=== Search by Item ID ===");
		inventory.SearchI(102);
		inventory.SearchI(999);

		System.out.println("\n=== Search by Item Name ===");
		inventory.SearchN("Mango");
		inventory.SearchN("Pineapple");

		System.out.println("\n=== Updating Quantity of Banana to 100 ===");
		inventory.Update(102, 100);
		inventory.SearchI(102);

		System.out.println("\n=== Deleting Mango ===");
		inventory.Delete(103);
		inventory.SearchI(103);

		System.out.println("\n=== Final Inventory ===");
		inventory.Total();
	}
}