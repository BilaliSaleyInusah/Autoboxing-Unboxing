import java.beans.Customizer;
import java.util.ArrayList;

public class Branches {
    private String branchName;
    ArrayList<Customer> customers = new ArrayList<Customer>();
    
    

    public Branches(String branchName , Customer customer){  
        this.branchName = branchName;
        addCustomer(customer);
    }


    public String getBranchName() {
        return branchName;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // public void addCustomer(String name , double transaction){
    //     Customer customer = new Customer(name, transaction);
    //     customers.add(customer);
    // }

    public boolean addCustomer (Customer customer){
        customers.add(customer);
        return true;
    }


    public boolean addTransaction( String name, double amount ){
        for (int i = 0; i < getCustomers().size(); i++) {
            Customer existingCustomer = getCustomers().get(i);
            if (existingCustomer.getName().equals(name)) {
                existingCustomer.addCusTransaction(amount);
                return true;
            } 
        }
        return false;
    }



}
