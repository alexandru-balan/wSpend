package wSpend;
public class Incomes {
    private String name;
    private double amount;
    private int idUsers;

    public Incomes(String name, String amount,int idUsers){
        this.name=name;
        this.amount = Double.parseDouble(amount);
        this.idUsers = idUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public int getIdUsers() {
    	return idUsers;
    }
    
    public void setIdUsers(int idUsers) {
    	this.idUsers = idUsers;
    }
}
