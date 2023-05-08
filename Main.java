import java.io.*;

class Product implements Serializable {

  public String name;
  public double price;
  public int amount;

  public Product(String name, double price, int amount) {
    this.name = name;
    this.price = price;
    this.amount = amount;
  }

  public void save() {
    try {
      FileOutputStream fos = new FileOutputStream (
        Product.class.getName() + this.hashCode() + ".dat"
      );
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      oos.writeObject(this);

      oos.close();
    } catch (IOException exc) {
      exc.printStackTrace();
    }
  }

}

public class Main {
  
  public static void main(String[] args) {
    Product product = new Product("Phone", 19.0, 3);

    product.save();
  }
  
}
