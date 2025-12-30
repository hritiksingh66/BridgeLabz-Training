class LibraryNode {
	String BookTitle;
	String Author;
	String Genre;
	int BookID;
	boolean AvailabilityStatus;
	LibraryNode next;
	LibraryNode prev;

	LibraryNode(String BookTitle, String Author, String Genre, int BookID, boolean AvailabilityStatus) {
		this.BookTitle = BookTitle;
		this.Author = Author;
		this.Genre = Genre;
		this.BookID = BookID;
		this.AvailabilityStatus = AvailabilityStatus;
		this.next = null;
		this.prev = null;
	}
}

class LibraryLinkedList {
	int c = 0;
	private LibraryNode head;

	public void Add(String BookTitle, String Author, String Genre, int BookID, boolean AvailabilityStatus) {
		LibraryNode temp = head;
		LibraryNode ln = new LibraryNode(BookTitle, Author, Genre, BookID, AvailabilityStatus);
		if (head == null) {
			head = ln;
			c++;
			return;
		}
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = ln;
		temp.next.prev = temp;
		c++;
	}

	public void AddB(String BookTitle, String Author, String Genre, int BookID, boolean AvailabilityStatus) {
		LibraryNode ln = new LibraryNode(BookTitle, Author, Genre, BookID, AvailabilityStatus);
		if (head == null) {
			head = ln;
			c++;
			return;
		}
		ln.next = head;
		head.prev = ln;
		head = ln;
		c++;
	}

	public void AddP(int pos, String BookTitle, String Author, String Genre, int BookID, boolean AvailabilityStatus) {
		if (pos <= 1) {
			AddB(BookTitle, Author, Genre, BookID, AvailabilityStatus);
			return;
		}
		LibraryNode temp = head;
		LibraryNode ln = new LibraryNode(BookTitle, Author, Genre, BookID, AvailabilityStatus);
		for (int i = 1; i < pos - 1; i++) {
			temp = temp.next;
		}
		if (temp.next == null) {
			Add(BookTitle, Author, Genre, BookID, AvailabilityStatus);
			return;
		}
		ln.next = temp.next;
		ln.prev = temp;
		temp.next = ln;
		ln.next.prev = ln;
		c++;
	}

	public void Delete(int BookID) {
		LibraryNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.BookID == BookID) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
			c--;
			return;
		}
		while (temp.next != null && temp.next.BookID != BookID) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Book Not Found");
		} else {
			temp.next = temp.next.next;
			if (temp.next != null) {
				temp.next.prev = temp;
			}
			c--;
		}
	}

	public void SearchT(String BookTitle) {
		LibraryNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.BookTitle.equals(BookTitle)) {
			System.out.println("Book Title: " + head.BookTitle + " | Author: " + head.Author + " | Genre: " + head.Genre
					+ " | ID: " + head.BookID + " | Availability Status: " + head.AvailabilityStatus);
			return;
		}
		while (temp.next != null && !temp.next.BookTitle.equals(BookTitle)) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Book Not Found");
		} else {
			System.out.println("Book Title: " + temp.next.BookTitle + " | Author: " + temp.next.Author + " | Genre: "
					+ temp.next.Genre + " | ID: " + temp.next.BookID + " | Availability Status: " + temp.next.AvailabilityStatus);
		}
	}

	public void SearchA(String Author) {
		LibraryNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.Author.equals(Author)) {
			System.out.println("Book Title: " + head.BookTitle + " | Author: " + head.Author + " | Genre: " + head.Genre
					+ " | ID: " + head.BookID + " | Availability Status: " + head.AvailabilityStatus);
			return;
		}
		while (temp.next != null && !temp.next.Author.equals(Author)) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Book Not Found");
		} else {
			System.out.println("Book Title: " + temp.next.BookTitle + " | Author: " + temp.next.Author + " | Genre: "
					+ temp.next.Genre + " | ID: " + temp.next.BookID + " | Availability Status: " + temp.next.AvailabilityStatus);
		}
	}

	public void Update(int BookID, boolean AvailabilityStatus) {
		LibraryNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.BookID == BookID) {
			head.AvailabilityStatus = AvailabilityStatus;
			return;
		}
		while (temp.next != null && temp.next.BookID != BookID) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Book Not Found");
		} else {
			temp.next.AvailabilityStatus = AvailabilityStatus;
		}
	}

	public void Count() {
		System.out.println("The Total No. of Books are: " + c);
	}

	public void DisplayF() {
		LibraryNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
		}
		while (temp != null) {
			System.out.println("Book Title: " + temp.BookTitle + " | Author: " + temp.Author + " | Genre: " + temp.Genre
					+ " | ID: " + temp.BookID + " | Availability Status: " + temp.AvailabilityStatus);
			temp = temp.next;
		}
	}

	public void DisplayR() {
		LibraryNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
		}
		while (temp.next != null) {
			temp = temp.next;
		}
		while (temp != null) {
			System.out.println("Book Title: " + temp.BookTitle + " | Author: " + temp.Author + " | Genre: " + temp.Genre
					+ " | ID: " + temp.BookID + " | Availability Status: " + temp.AvailabilityStatus);
			temp = temp.prev;
		}
	}
}

public class LibraryManagementSystem {
	public static void main(String[] args) {
		LibraryLinkedList library = new LibraryLinkedList();
		library.Add("The Hobbit", "J.R.R. Tolkien", "Fantasy", 101, true);
		library.Add("1984", "George Orwell", "Dystopian", 102, false);
		library.Add("To Kill a Mockingbird", "Harper Lee", "Classic", 103, true);
		library.AddB("Pride and Prejudice", "Jane Austen", "Romance", 100, true);
		library.AddP(3, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 104, true);

		System.out.println("----- Display Forward -----");
		library.DisplayF();

		System.out.println("\n----- Display Reverse -----");
		library.DisplayR();

		System.out.println("\n----- Book Count -----");
		library.Count();

		System.out.println("\n----- Search by Title: '1984' -----");
		library.SearchT("1984");

		System.out.println("\n----- Search by Author: 'Harper Lee' -----");
		library.SearchA("Harper Lee");

		System.out.println("\n----- Update Availability (BookID 102 -> true) -----");
		library.Update(102, true);
		library.SearchT("1984");

		System.out.println("\n----- Delete Book with ID 103 -----");
		library.Delete(103);
		library.DisplayF();

		System.out.println("\n----- Final Book Count -----");
		library.Count();
	}
}