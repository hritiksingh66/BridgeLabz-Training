class TaskNode {
	int TaskID;
	String TaskName;
	int Priority;
	String DueDate;
	TaskNode next;
	TaskNode prev;

	TaskNode(int TaskID, String TaskName, int Priority, String DueDate) {
		this.TaskID = TaskID;
		this.TaskName = TaskName;
		this.Priority = Priority;
		this.DueDate = DueDate;
		this.next = null;
		this.prev = null;
	}
}

class TaskLinkedList {
	private TaskNode head;
	private TaskNode Current;

	public void Add(int TaskID, String TaskName, int Priority, String DueDate) {
		TaskNode tn = new TaskNode(TaskID, TaskName, Priority, DueDate);
		TaskNode temp = head;
		if (head == null) {
			head = tn;
			tn.next = head;
			if (Current == null) {
				Current = head;
			}
			return;
		}
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = tn;
		temp.next.next = head;
	}

	public void AddB(int TaskID, String TaskName, int Priority, String DueDate) {
		TaskNode tn = new TaskNode(TaskID, TaskName, Priority, DueDate);
		TaskNode temp = head;
		if (head == null) {
			head = tn;
			tn.next = head;
			Current = head;
			return;
		}
		tn.next = head;
		head = tn;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = head;
	}

	public void AddP(int pos, int TaskID, String TaskName, int Priority, String DueDate) {
		if (pos <= 1) {
			AddB(TaskID, TaskName, Priority, DueDate);
			return;
		}
		TaskNode tn = new TaskNode(TaskID, TaskName, Priority, DueDate);
		TaskNode temp = head;
		for (int i = 1; i < pos - 1; i++) {
			temp = temp.next;
		}
		if (temp.next == head) {
			Add(TaskID, TaskName, Priority, DueDate);
			return;
		} else {
			tn.next = temp.next;
			tn.prev = temp;
			temp.next = tn;
			tn.next.prev = tn;
		}
	}

	public void Delete(int TaskID) {
		TaskNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.TaskID == TaskID) {
			if (head.next == head) {
				head = null;
				return;
			}
			head = head.next;
			head.prev.next = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = head;
			return;
		}
		while (temp.next != head && temp.next.TaskID != TaskID) {
			temp = temp.next;
		}
		if (temp.next == head) {
			System.out.println("Task Not Found");
		} else {
			temp.next = temp.next.next;
			if (temp.next != head) {
				temp.next.prev = temp;
			} else {
				head.prev = temp;
			}
		}
	}

	public void Curr() {
		System.out.println("Current Task");
		if (Current != null) {
			System.out.println("Task ID: " + Current.TaskID + " | Name: " + Current.TaskName + " | Priority: "
					+ Current.Priority + " | Due Date: " + Current.DueDate);

			TaskNode temp = Current.next;

			while (temp != Current) {
				System.out.println("Next Task");
				System.out.println("Task ID: " + temp.TaskID + " | Name: " + temp.TaskName + " | Priority: " + temp.Priority
						+ " | Due Date: " + temp.DueDate);
				temp = temp.next;
			}
		}
	}

	public void Display() {
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}

		TaskNode temp = head;
		do {
			System.out.println("Task ID: " + temp.TaskID + " | Name: " + temp.TaskName + " | Priority: " + temp.Priority
					+ " | Due Date: " + temp.DueDate);
			temp = temp.next;
		} while (temp != head);
	}

	public void Search(int Priority) {
		TaskNode temp = head;
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.Priority == Priority) {
			System.out.println("Task ID: " + head.TaskID + " | Name: " + head.TaskName + " | Priority: " + head.Priority
					+ " | Due Date: " + head.DueDate);
			return;
		}
		while (temp.next != head && temp.next.Priority != Priority) {
			temp = temp.next;
		}
		if (temp.next == head) {
			System.out.println("Task with " + Priority + " not Found");
		} else {
			System.out.println("Task ID: " + temp.next.TaskID + " | Name: " + temp.next.TaskName + " | Priority: "
					+ temp.next.Priority + " | Due Date: " + temp.next.DueDate);
		}
	}
}

public class TaskScheduler {
	public static void main(String[] args) {
		TaskLinkedList scheduler = new TaskLinkedList();

		scheduler.Add(1, "Task 1", 3, "2025-07-06");
		scheduler.Add(2, "Task 2", 1, "2025-07-07");
		scheduler.Add(3, "Task 3", 2, "2025-07-08");

		System.out.println("Displaying All Tasks:");
		scheduler.Display();

		System.out.println("\nViewing Current Task:");
		scheduler.Curr();

		scheduler.AddB(4, "Task 4", 5, "2025-07-09");

		scheduler.AddP(2, 5, "Task 5", 4, "2025-07-10");

		System.out.println("\nUpdated Task List After Adding New Tasks:");
		scheduler.Display();

		System.out.println("\nSearching for Task with Priority 4:");
		scheduler.Search(4);

		System.out.println("\nDeleting Task with TaskID = 2:");
		scheduler.Delete(2);

		System.out.println("\nTask List After Deleting Task 2:");
		scheduler.Display();

		System.out.println("\nViewing Current Task After Deletion:");
		scheduler.Curr();
	}
}
