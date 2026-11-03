package comparator;
import java.util.*;

public class productService {
    public static ArrayList list = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    
    public static void addProduct(){
        System.out.println("Enter Product Id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Price: ");
        double price = sc.nextDouble();
        System.out.println("Enter Product Quantity: ");
        int quantity = sc.nextInt();
        list.add(new PRODUCT(id,name,price,quantity));
        System.out.println("Add Successfully!!");
    }
    
    public static void removeProduct(){
        
        if (list.isEmpty()){
            System.out.println("List is Empty!");
            return;
        }
        Iterator cursor = list.iterator();
        System.out.println("Enter Id: ");
        int id = sc.nextInt();
        boolean found = false;
        while (cursor.hasNext()){
            PRODUCT element =(PRODUCT) cursor.next();
            if (element.productId==id){
                cursor.remove();
                found = true;
                System.out.println("Removed Successfully!!");
                break;
            }
            if (!found){
                System.out.println("Product not Found!");
            }
        }
    }


    public static void updateProduct(){
        Iterator cursor = list.iterator();
        if (list.isEmpty()){
            System.out.println("List is Empty!!");
        }
        else{
            System.out.println("Enter product Name: ");
            String name = sc.nextLine();
            while (cursor.hasNext()){
                PRODUCT element = (PRODUCT) cursor.next();
                if (element.productName.equals(name)){
                    System.out.println(element);
                    System.out.println("Change Name: ");
                    element.productName = sc.nextLine();
                    System.out.println("Change Id: ");
                    element.productId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Change Price: ");
                    element.price = sc.nextDouble();
                    System.out.println("Change Quantity: ");
                    element.Quantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println(element);
                    System.out.println("Update Successfully!!");
                    break;
                }
            }
        }
    }
    
    public static void TotalBill(){
        Iterator cursor = list.iterator();
        
        if (list.isEmpty()){
            System.out.println("List is Empty!!");
        }
        else {
            System.out.println("Enter Product Name: ");
            String name = sc.nextLine();
            while (cursor.hasNext()){
                PRODUCT element = (PRODUCT) cursor.next();
                if (element.productName.equals(name)){
                    System.out.println("Enter the Quantity purchased:");
                    int quantity = sc.nextInt();
                    if(quantity<=0){
                        System.out.println("Invalid Quantity!");
                    }
                    else if (quantity > element.Quantity){
                        System.out.println("Insufficient Stock!");
                    }
                    else{
                        double totalBill = element.price*quantity;
                        System.out.println(element.productName+" \t=\tTotal bill: "+totalBill);
                        element.Quantity -=quantity;
                    }
                }
                
            }
        }
    }
    private static Comparator idShorted = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            PRODUCT P1 = (PRODUCT) o1;
            PRODUCT P2 = (PRODUCT) o2;
            return P1.productId-P2.productId;
        }
    };
    
    private static Comparator<PRODUCT> priceShorted = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            PRODUCT P1 = (PRODUCT) o1;
            PRODUCT P2 = (PRODUCT) o2;
            return Double.compare(P2.price,P1.price);
        }
    };
    
    public static void displayAllProduct(){
        if (list.isEmpty()){
            System.out.println("List is Empty!!");
        }else{
            Collections.sort(list,idShorted );
            for (Object element:list){
                System.out.println(element);
            }

            System.out.println("===========================================");
            Collections.sort(list,priceShorted);
            for (Object element: list){
                System.out.println(element);
            }
        }
    }
}
