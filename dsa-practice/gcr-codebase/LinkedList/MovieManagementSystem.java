class MovieNode {
	String MovieTitle;
	String Director;
	int ReleaseYear;
	int Rating;
	MovieNode prev;
	MovieNode next;

	MovieNode(String MovieTitle, String Director, int ReleaseYear, int Rating) {
		this.MovieTitle = MovieTitle;
		this.Director = Director;
		this.ReleaseYear = ReleaseYear;
		this.Rating = Rating;
		this.prev = null;
		this.next = null;
	}
}

class MovieLinkedList {
	private MovieNode head;

	public void Add(String MovieTitle, String Director, int ReleaseYear, int Rating) {
		MovieNode md = new MovieNode(MovieTitle, Director, ReleaseYear, Rating);
		if (head == null) {
			head = md;
		} else {
			MovieNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = md;
			md.prev = temp;
		}
	}

	public void AddB(String MovieTitle, String Director, int ReleaseYear, int Rating) {
		MovieNode md = new MovieNode(MovieTitle, Director, ReleaseYear, Rating);
		if (head == null) {
			head = md;
		} else {
			md.next = head;
			head.prev = md;
			head = md;
		}
	}

	public void AddP(int pos, String MovieTitle, String Director, int ReleaseYear, int Rating) {
		MovieNode md = new MovieNode(MovieTitle, Director, ReleaseYear, Rating);
		MovieNode temp = head;
		if (pos <= 1) {
			AddB(MovieTitle, Director, ReleaseYear, Rating);
			return;
		}
		for (int i = 1; i < pos - 1 && temp != null; i++) {
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Index out of Bound");
			Add(MovieTitle, Director, ReleaseYear, Rating);
		}
		md.next = temp.next;
		md.prev = temp;
		if (temp.next != null) {
			temp.next.prev = md;
		}
		temp.next = md;
	}

	public void Delete(String MovieTitle) {
		MovieNode temp = head;
		if (head.MovieTitle.equals(MovieTitle)) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
		} else {
			while (temp != null && !temp.MovieTitle.equals(MovieTitle)) {
				temp = temp.next;
			}
			if (temp == null) {
				System.out.println("Movie Not Found");
			} else {
				temp.prev.next = temp.next;
				if (temp.next != null) {
					temp.next.prev = temp.prev;
				}
			}
		}
	}

	public void SearchD(String Director) {
		MovieNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.Director == Director) {
			System.out.println("Movie Title: " + head.MovieTitle + " Director: " + head.Director + " Release Year: "
					+ head.ReleaseYear + " Rating: " + head.Rating);
		}
		while (temp.next != null && temp.next.Director != Director) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Director not Found");
		} else {
			System.out.println("Movie Title: " + temp.next.MovieTitle + " Director: " + temp.next.Director + " Release Year: "
					+ temp.next.ReleaseYear + " Rating: " + temp.next.Rating);
		}
	}

	public void SearchR(int Rating) {
		MovieNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.Rating == Rating) {
			System.out.println("Movie Title: " + head.MovieTitle + " Director: " + head.Director + " Release Year: "
					+ head.ReleaseYear + " Rating: " + head.Rating);
		}
		while (temp.next != null && temp.next.Rating != Rating) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Rating not Found");
		} else {
			System.out.println("Movie Title: " + temp.next.MovieTitle + " Director: " + temp.next.Director + " Release Year: "
					+ temp.next.ReleaseYear + " Rating: " + temp.next.Rating);
		}
	}

	public void Update(int Rating, String MovieTitle) {
		MovieNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.MovieTitle == MovieTitle) {
			head.Rating = Rating;
		}
		while (temp.next != null && temp.next.MovieTitle != MovieTitle) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Movie not Found");
		} else {
			temp.next.Rating = Rating;
		}
	}

	public void DisplayF() {
		if (head == null) {
			System.out.println("List is Empty");
		}
		MovieNode temp = head;
		while (temp != null) {
			System.out.println("Movie Title: " + temp.MovieTitle + " Director: " + temp.Director + " Release Year: "
					+ temp.ReleaseYear + " Rating: " + temp.Rating);
			temp = temp.next;
		}
	}

	public void DisplayR() {
		MovieNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
		}
		while (temp.next != null) {
			temp = temp.next;
		}
		while (temp != null) {
			System.out.println("Movie Title: " + temp.MovieTitle + " Director: " + temp.Director + " Release Year: "
					+ temp.ReleaseYear + " Rating: " + temp.Rating);
			temp = temp.prev;
		}
	}
}

public class MovieManagementSystem {
	public static void main(String[] args) {
		MovieLinkedList movieList = new MovieLinkedList();
		movieList.Add("Inception", "Christopher Nolan", 2010, 9);
		movieList.Add("The Matrix", "The Wachowskis", 1999, 9);
		movieList.Add("Interstellar", "Christopher Nolan", 2014, 8);
		movieList.AddB("The Dark Knight", "Christopher Nolan", 2008, 9); // Adding at beginning
		movieList.AddP(3, "The Prestige", "Christopher Nolan", 2006, 8); // Adding at position 3

		System.out.println("---- Displaying Movies (Forward) ----");
		movieList.DisplayF();

		System.out.println("---- Displaying Movies (Reverse) ----");
		movieList.DisplayR();

		System.out.println("---- Searching for Movies by Director (Christopher Nolan) ----");
		movieList.SearchD("Christopher Nolan");

		System.out.println("---- Searching for Movies by Rating (9) ----");
		movieList.SearchR(9);

		System.out.println("---- Updating Rating of 'The Matrix' ----");
		movieList.Update(10, "The Matrix");

		System.out.println("---- Displaying Updated Movies (Forward) ----");
		movieList.DisplayF();

		System.out.println("---- Deleting 'Inception' ----");
		movieList.Delete("Inception");

		System.out.println("---- Displaying Movies After Deletion (Forward) ----");
		movieList.DisplayF();

		System.out.println("---- Searching for a Non-Existent Movie ('Avatar') ----");
		movieList.SearchD("James Cameron");
	}
}