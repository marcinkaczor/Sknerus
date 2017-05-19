import java.sql.Timestamp;

public class Dokument {

    private static int nextId = 1;

    private Timestamp timestamp;
    private int id;
    private String typeA;
    private String typeB;
    private String product;
    private int amount;
    private double value;
    private double tax;
    private int client;

    public Dokument(String typeA, String typeB, String product, int amount, double value, double tax, int client) {

        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.id = getNextId();
        this.typeA = typeA;
        this.typeB = typeB;
        this.product = product;
        this.amount = amount;
        this.value = value;
        this.tax = tax;
        this.client = client;
    }

    public static int getNextId() {

        int id = nextId;
        nextId ++;
        return id;
    }

    public int getAmount()
    {
        return amount;
    }

    public double getValue()
    {
        return value;
    }

    @Override
    public String toString() {

        return "" + timestamp + "," + id + "," + typeA + "," + typeB + "," + product + "," + amount + "," + value + "," + tax + "," + client;
    }

}
