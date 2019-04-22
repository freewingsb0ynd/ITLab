import java.util.StringJoiner;

public class Banana{
    private String name;
    private int weight;
    private int price;
    public Banana(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addWeightAndPrice(Banana other) {
        this.price +=other.getPrice();
        this.weight +=other.getWeight();
    }

    public boolean isType(String type){
        return type.equalsIgnoreCase(this.name);
    }

    @Override
    public String toString() {
        return (new StringJoiner(", ")).add(name).add(Integer.toString(weight)).
                add(Integer.toString(price)).toString();
    }

}
