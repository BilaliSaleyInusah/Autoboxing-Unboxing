import java.util.ArrayList;

public class Bank {
    private String name;
    ArrayList<Branches> brancheList;
    
    public Bank(String name){ 
        this.name = name;
        this.brancheList = new ArrayList<Branches>();
    }

    public boolean addBranche(String branchName){
        if (findBranche(branchName) == null) {
            this.brancheList.add(new Branches(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName , String cusName , double amount){
        Branches existingBranche = findBranche(branchName);
        if (existingBranche != null) {
           return existingBranche.newCustomer(cusName,amount);   
       }
       return false;
    }

    public boolean addCusTransaction(String branchName , String cusName , double amount){
        Branches existingBranche = findBranche(branchName);
        if (existingBranche != null) {
              return existingBranche.addCusTransaction(cusName, amount);
              
          }
       return false;
    }

    public Branches findBranche(String branchName){
        for (int i = 0; i < brancheList.size(); i++) {
            Branches existingBranche = brancheList.get(i);
            if (existingBranche.getBranchName().equals(branchName)) {
                return existingBranche;
            }
        }
        return null;
    }

    public boolean listCustomer(String branchName, boolean showTransaction){
        Branches branche = findBranche(branchName);
        if(branche != null){
            System.out.println("Customers details for branch " + branche.getBranchName());
            ArrayList<Customer> branchCustomers = branche.getCustomers();  
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer =  branchCustomers.get(i);
                System.out.println("Customer : " + branchCustomer.getName() + "[" + i + 1 + "]");
                if (showTransaction) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactons = branchCustomer.getTransactions();
                    for (int j = 0; j < transactons.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + transactons.get(j));
                        
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }


}
