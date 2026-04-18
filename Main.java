import java.util.ArrayList;
import java.util.Scanner;

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
                tasks.add(new Task(title));
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

            else if (choice == 3){
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                }else {
                    System.out.println("Enter task number: ");
                    int tasknum = sc.nextInt();
                    if (tasknum > 0 && tasknum <= tasks.size()) {
                        Task t = tasks.get(tasknum - 1);
                        t.isCompleted = true;
                        System.out.println("task " + t.title + " completed!");
                    } else {
                        System.out.println("invalid");
                    }
                }
            }
            else if(choice == 4){
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                }else {
                    System.out.println("Enter task number: ");
                    int tasknum = sc.nextInt();
                    if (tasknum > 0 && tasknum <= tasks.size()) {
                        Task t = tasks.remove(tasknum - 1);

                        System.out.println("task " + t.title + " Deleted!");
                    } else {
                        System.out.println("invalid");
                    }
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