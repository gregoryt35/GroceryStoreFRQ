public class Product
{
    private String name;
    private int quantity;
    private double weight;

    public Product(String name, int quantity, double weight)
    {
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    /** Returns the name of the product */
    public String getName()
    {
        return name;
    }
    /** Returns the quantity of the product that is in stock
     * Postcondition: The value returned is greater than or equal to zero.
     */
    public int getQuantity()
    {
        return quantity;
    }

    public double getWeight()
    {
        return weight;
    }
}