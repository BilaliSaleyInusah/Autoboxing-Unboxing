import java.util.Scanner;

public class Main{
    private static String bankName = "isBilTeq Bank";
    private static Bank bank = new Bank(bankName);
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quite = false;
        printOption();
        while (!quite) {
            
            System.out.println("");
            System.out.print("Enter your choice (0 -- menu) :  ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printOption();
                    break;
                case 1:
                    addBranche();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    addCusTransaction();
                    break;
                case 4:
                    // changeBranchName();
                    break;
                case 5:
                    // changeCustomerName();
                    break;
                case 6:
                    printStructure();
                    break;
                case 7:
                    quite = true;
                    break;
            }

        }

    }

    public static void printOption(){
            System.out.println("*******************");
            System.out.println("   " + bankName );
            System.out.println("*******************");
            System.out.println("Enter  \n" +
                                "\t 0 - to see the avaliable option \n" +
                                "\t 1 - to add new branch \n" +
                                "\t 2 - to add new customer \n" +
                                "\t 3 - to add a customer's transaction \n" +
                                "\t 4 - to change branch name \n" +
                                "\t 5 - to change customer name \n" +
                                "\t 6 - to see all braches plus custmers plus transaction \n" + 
                                "\t 7 - to quite" );
            
    }

    public static void addBranche(){
        System.out.print("Enter the branch name : ");
        String branchName = scanner.nextLine();
        if (bank.addBranche(branchName)) {
            System.out.println(branchName + " branch is successfully add to " + bankName  + " system");
        } else {
            System.out.println(branchName + " branch is already added to " + bankName  + " system");
        }
    }

    public static void addCustomer(){
        System.out.println("Enter the name of the branch to add the customer : ");
        String branchName = scanner.nextLine();
        Branches branche = bank.findBranche(branchName);
        if (branche != null) {
            System.out.println("Enter the customer : ");
            String cusName = scanner.nextLine();
            Customer customer = branche.findCustomer(cusName);
            if (customer == null) {
                System.out.print("Enter the initial transaction : ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                bank.addCustomer(branchName, cusName, amount);
            } else {
                System.out.println(cusName + " account is already in the system of " + branchName + " branch of " + bankName);
            }
        } else {
            System.out.println(branchName + " branch is not in " + bankName + " system");
        }
    }

    public static void addCusTransaction(){
        System.out.print("Enter the name of the branch to add the customer : ");
        String branchName = scanner.nextLine();
        Branches branche = bank.findBranche(branchName);
        if (branche != null) {
            System.out.println("Enter the customer : ");
            String cusName = scanner.nextLine();
            Customer customer = branche.findCustomer(cusName);
            if (customer == null) {
                System.out.print("Enter the initial transaction : ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                bank.addCusTransaction(branchName, cusName, amount);
            } else {
                System.out.println(cusName + " account is already in the system of " + branchName + " branch of " + bankName);
            }
        } else {
            System.out.println(branchName + " branch is not in " + bankName + " system");
        }
    }

    public static void printStructure(){
        System.out.print("Enter the branch name to view : " );
        String branchName = scanner.nextLine();
        System.out.print("Enter 'True' if you want to view the transactions or any to skip : ");
        String show = scanner.nextLine();
        if (show.toLowerCase() == "true") {
            bank.listCustomer(branchName, true);
        } else {
            bank.listCustomer(branchName, false);
        }

    }
    
}