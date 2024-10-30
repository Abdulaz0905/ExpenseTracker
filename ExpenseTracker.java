import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String name;
    private double amount;
    
    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
    
    public String getName() {
        return name;
    }
    
    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return name + " - $" + amount;
    }
}

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("Welcome to the Expense Tracker!");
        
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add an expense");
            System.out.println("2. View all expenses");
            System.out.println("3. Calculate total expenses");
            System.out.println("4. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    calculateTotal();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    private static void addExpense(Scanner scanner) {
        System.out.print("Enter expense name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        
        Expense expense = new Expense(name, amount);
        expenses.add(expense);
        
        System.out.println("Expense added successfully!");
    }
    
    private static void viewExpenses() {
        System.out.println("\nList of Expenses:");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }
    
    private static void calculateTotal() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        
        System.out.println("\nTotal Expense: $" + total);
    }
}
