import java.util.ArrayList;

public class Bank {
    ArrayList<Branches> brancheList = new ArrayList<Branches>();
    Branches branches;
    
    public Bank(){ // String name, Customer customer
        // branches = new Branches(name, customer);
        // addBranche(branches);
    }

    public void addBranche(Branches branches){
        brancheList.add(branches);
    }

    public ArrayList<Branches> getBrancheList() {
        return brancheList;
    };

    public boolean addCustomer(String branchName , String cusName , double amount){
        for (int i = 0; i < getBrancheList().size(); i++) {
            Branches existingBranches = getBrancheList().get(i);
            if(existingBranches.getBranchName().equals(branchName)){
                existingBranches.addCustomer(new Customer(cusName, amount));
                return true;
            }
        }
       return false;
    }


}
