import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;
    private double wallet;

    public Customer(String name, double wallet) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.wallet = wallet;
    }

    public Customer() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}
