package Exercise_week2;

public class Product {
    private String code;
    private double cost;
    private int quantity;

    public Product()
    {
        code = " ";
        cost = 0.0;
        quantity = 0;
    }

    public Product(String code, double cost, int quantity)
    {
        this.code = code;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getCode()
    {
        return code;
    }

    public double getCost()
    {
        return cost;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
}
