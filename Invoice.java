import java.time.LocalDateTime;

public class Invoice {
    private String title;
    private double amount;
    private int id;
    private Customer customer;
    private LocalDateTime dateTime;

    public Invoice(String title, double amount, int id, Customer customer, LocalDateTime dateTime) {
        this.title = title;
        this.amount = amount;
        this.id = id;
        this.customer = customer;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}