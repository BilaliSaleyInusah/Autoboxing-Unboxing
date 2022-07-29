import java.util.ArrayList;

public class Branches {
    private String branchName;
    ArrayList<Customer> customers;
    
    

    public Branches(String branchName ){  
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }


    public String getBranchName() {
        return branchName;
    }
    
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // adding new customer 
    public boolean newCustomer(String name, double initialAmount){
        //checking if the name already exist using the findCustomer method
        if (findCustomer(name) == null) {
            // if the name does not exist then we are adding 
            this.customers.add(new Customer(name, initialAmount));
            return true;
        }
        return false;
        
    }

    // adding transaction to an existing customer 
    public boolean addCusTransaction( String name, double amount ){
        //first we are checking if the customer name exist using the findCustomer method
        // NB::: findCustomer method will be returning a customer of the type custumer class
        //       thus customer name and arrayList of transaction
        //  then we are asigning the return value of the findCustomer method to 
        //  existingCustomer variable of the type Customer 
        Customer exixtingCustomer = findCustomer(name);
        // checking if the value of existingCustomer is null or is a customer 
        if (exixtingCustomer != null) {
            // since the value is not null meaning it is a customer which implies that there 
            // is a cutomer with that name therefor we are adding the transaction
            exixtingCustomer.addCusTransaction(amount);
            return true;
        }
        return false;
    }

    // finally we are creating the method findCustomer which which will check if a customer exist 
    // using customer names 
    // if a customer exist it will return the customer(name and arrayList of the transaction)
    // else it will return null
    public Customer findCustomer(String name){
        for (int i = 0; i < customers.size(); i++) {
            Customer checkCustomer = customers.get(i);
            if (checkCustomer.getName().equals(name)) {
                return checkCustomer;
            }
        }
        return null;
    }



}
