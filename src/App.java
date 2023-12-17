// Daniils Onufrijuks DP 2-1   

import java.util.Scanner;
 
public class App {
    private static ShoppingCart cart = new ShoppingCart();
    public static CSVManager manager = new CSVManager();
    public static void main(String[] args) throws Exception { 
        boolean exit = true;
        do {
            Scanner myObjcom = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter command(add | store | show | remove | place order |  exit): "); // lai noteikt kadu komandu ievadit
            String userinput = String.valueOf(myObjcom.nextLine()); // lasam ievaditu komandu

            String test = userinput;

            if (test.matches("@#<>?")) { // parbaudam vai ir pareizi ievadīts
                System.out.println("Nepareizi! Ievadiet velreiz!"); // ja nepareizi ievadits (piemeram - #)
            } else {
                switch(userinput){ // ja pareizi ievadīts (piemeram: show)
                    case "exit": // exit 
                        System.out.println("Izejam no programmas");
                        exit = false;
                        break;
                    case "add":
                        cart.addcart();
                        break;
                    case "remove": 
                        // file reading and removing
                        cart.removeobjcart();
                        break;
                    case "show":
                        cart.cartstatus();
                        break;
                    case "store":
                        manager.list_products();
                        break;
                    case "place order":
                        cart.place_order(); 
                        break;
                }
            }
        }
        while (exit); // lidz bridim ja exit ir false, exit bus false tikai ja bus komanda 'exit'
        
    }
}
