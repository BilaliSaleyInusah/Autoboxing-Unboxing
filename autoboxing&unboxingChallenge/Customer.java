import java.util.ArrayList;

import javax.sql.rowset.spi.TransactionalWriter;

public class Customer {
    private String name;
    ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name, double transaction){
        this.name = name;
        transactions.add(transaction);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public double getTransaction() {
    //     return transaction;
    // }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public boolean addCusTransaction( double transaction){
        transactions.add(transaction);
        return true;
    }



}
