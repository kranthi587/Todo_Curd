import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TodoDAO dao = new TodoDAO();
        int choice;

        do {
            System.out.println("\n=== TODO APPLICATION ===");
            System.out.println("1. Add Todo");
            System.out.println("2. View Todos");
            System.out.println("3. Update Todo");
            System.out.println("4. Delete Todo");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    dao.addTodo(title, desc);
                    break;
                case 2:
                    dao.listTodos();
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("New description: ");
                    String newDesc = sc.nextLine();
                    dao.updateTodo(updateId, newTitle, newDesc);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteTodo(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}
