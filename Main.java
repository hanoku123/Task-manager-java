import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");


            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // IMPORTANT

            if (choice == 1) {
                System.out.print("Enter task: ");
                String title = sc.nextLine();
                try {
                    Connection con = DatabaseManager.connect();

                    String query = "INSERT INTO tasks(title, completed) VALUES (?, ?)";

                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setString(1, title);
                    ps.setBoolean(2, false);

                    ps.executeUpdate();

                    System.out.println("Task added to database!");

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Task added!");
            }

            else if (choice == 2) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        Task t = tasks.get(i);
                        if(t.isCompleted){
                            System.out.println((i + 1) + ". " + t.title + " [Completed]");
                        }else {
                            System.out.println((i + 1) + ". " + t.title + " [Pending]");
                        }

                    }
                }
            }

            else if (choice == 3) {

                System.out.print("Enter task ID to complete: ");
                int taskId = sc.nextInt();

                try {

                    Connection con = DatabaseManager.connect();

                    String query = "UPDATE tasks SET completed = true WHERE id = ?";

                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setInt(1, taskId);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Task marked as completed!");
                    } else {
                        System.out.println("Task not found.");
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (choice == 4) {

                System.out.print("Enter task ID to delete: ");
                int taskId = sc.nextInt();

                try {

                    Connection con = DatabaseManager.connect();

                    String query = "DELETE FROM tasks WHERE id = ?";

                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setInt(1, taskId);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Task deleted!");
                    } else {
                        System.out.println("Task not found.");
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (choice == 5)
            { System.out.println("Exiting...");
                break;
            }
            else
            { System.out.println("Invalid choice!");
            }
        }


    }

}
