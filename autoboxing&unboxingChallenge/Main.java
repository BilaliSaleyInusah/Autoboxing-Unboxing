import java.util.Scanner;

public class Main{
    // private static Customer customer;
    // private static Branches branches;
    private static Bank bank = new Bank();
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
                    changeBranchName();
                    break;
                case 5:
                    changeCustomerName();
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
        System.out.print("Enter branch name : ");
        String branchName = scanner.nextLine();
        for (int i = 0; i < bank.brancheList.size(); i++) {
            if (bank.brancheList.get(i).getBranchName().equals(branchName)) {
                System.out.println(branchName + " branch allready exist under this bank");
                return;
            }
        }
        System.out.print("Enter the customer name : ");
        String cusName = scanner.nextLine();
        System.out.print("Enter customr's amount : ");
        double transaction = scanner.nextDouble();
        scanner.nextLine();
        bank.addBranche(new Branches(branchName, new Customer(cusName, transaction)));
    }

    public static void addCustomer(){
        System.out.print("Enter the branch name to add the customer to : ");
        String branchName = scanner.nextLine();
        for (int i = 0; i < bank.brancheList.size(); i++) {
            if (bank.brancheList.get(i).getBranchName().equals(branchName)) {
                System.out.print("Enter the customer name : ");
                String cusName = scanner.nextLine();
                for (int j = 0; j < bank.getBrancheList().get(i).customers.size(); j++) {
                    if (bank.getBrancheList().get(i).customers.get(j).getName().equals(cusName)) {
                        System.out.println("Customer named " + cusName + " already exist in this branch");
                        return;
                    }
                }
                System.out.print("Enter customr's amount : ");
                double transaction = scanner.nextDouble();
                bank.addCustomer(branchName, cusName, transaction);
                return;
            }
        }
        System.out.println(branchName + " branch does not exist under this bank");
    }


    public static void addCusTransaction(){
        System.out.print("Enter the branch name under which the customer is : ");
        String branchName = scanner.nextLine();
        for (int i = 0; i < bank.brancheList.size(); i++) {
            if (bank.brancheList.get(i).getBranchName().equals(branchName)) {
                System.out.print("Enter the customer's name  : ");
                String cusName = scanner.nextLine();
                for (int j = 0; j < bank.brancheList.get(i).getCustomers().size(); j++) {
                    if (bank.brancheList.get(i).getCustomers().get(j).getName().equals(cusName)) {
                        System.out.print("Enter customr's amount : ");
                        double transaction = scanner.nextDouble();
                        bank.brancheList.get(i).getCustomers().get(j).addCusTransaction(transaction);
                        return;
                    } 
                }
                System.out.println("There is no customer with the name, " + cusName + " in " + branchName + " branch");
                return;
            }
        }
        System.out.println("There is no branch called : " + branchName + " under this bank");
    }


    public static void  changeBranchName(){
        System.out.print("Enter the branch name to be modified : ");
        String branchName = scanner.nextLine();
        for (int i = 0; i < bank.brancheList.size(); i++) {
            if (bank.brancheList.get(i).getBranchName().equals(branchName)) {
                System.out.print("Enter the new branch name : ");
                String newBranchName = scanner.nextLine();
                for (int j = 0; j < bank.brancheList.size(); j++) {
                    if (bank.brancheList.get(j).getBranchName().equals(newBranchName)) {
                        System.out.println("There is a branch called " + newBranchName + " in this bank already");
                        return;
                    }
                }
                bank.brancheList.get(i).setBranchName(newBranchName);
                return;
            }
        }
        System.out.println("There is no branch called " + branchName + " under this bank");
    }

    public static void changeCustomerName(){
        System.out.print("Enter the branch name under which the customer is : ");
        String branchName = scanner.nextLine();
        for (int i = 0; i < bank.brancheList.size(); i++) {
            if (bank.brancheList.get(i).getBranchName().equals(branchName)) {
                System.out.print("Enter the customer's name to be change : ");
                String cusName = scanner.nextLine();
                for (int j = 0; j < bank.getBrancheList().get(i).customers.size(); j++) {
                    if (bank.getBrancheList().get(i).customers.get(j).getName().equals(cusName)) {
                       System.out.print("Enter the new name of the customer : ");
                       String newCusName = scanner.nextLine();
                       for (int k = 0; k < bank.getBrancheList().get(i).customers.size(); k++) {
                           if (bank.getBrancheList().get(i).customers.get(k).getName().equals(newCusName)) {
                               System.out.println("There is a customer called " + newCusName + " in the " + branchName + " already");
                               return;
                           }
                       }
                       bank.brancheList.get(i).getCustomers().get(j).setName(newCusName);
                       return;
                    }
                }
                System.out.println("There is no customer called " + cusName + " under " + branchName + " branch");
                return;
            }
        }
        System.out.println(branchName + " branch does not exist under this bank");
    }

    public static void printStructure(){
        System.out.println("Branches : " );
        for (int i = 0; i < bank.brancheList.size(); i++) {
            System.out.println("\t" + (i+1) + "--> " + bank.brancheList.get(i).getBranchName());
            System.out.println("\t Customers : ");
            for (int j = 0; j < bank.brancheList.get(i).customers.size(); j++) {
                System.out.println("\t\t " + (j+1) + " --> " + bank.brancheList.get(i).customers.get(j).getName());
                System.out.println("\t\t Transactions : ");
                double sum = 0.0;
                for (int k = 0; k < bank.brancheList.get(i).customers.get(j).transactions.size(); k++) {
                    System.out.println("\t\t\t " + (k+1) + " --> " + bank.brancheList.get(i).customers.get(j).transactions.get(k));
                    sum = sum + bank.brancheList.get(i).customers.get(j).transactions.get(k);
                }
                System.out.println("\t\t\t Total : " + sum);
            }
        }
    }
    
}