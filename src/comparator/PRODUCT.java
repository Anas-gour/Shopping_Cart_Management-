package comparator;

public class PRODUCT {
    int productId;
    String productName;
    double price;
    int Quantity;
    
    public PRODUCT(int productId, String productName,double price,int quantity){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.Quantity = Math.abs(quantity);
    }
    
    public String toString(){
        return "{"+"Id = "+productId+", "+" Product Name = "+productName+" Price = "+price+" Quantity =  "+Quantity+" }";
    }
}
