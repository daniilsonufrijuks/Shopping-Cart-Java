import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*; 
import com.google.gson.GsonBuilder;
// import org.json.jsonarray;
// import org.json.jsonexception;
// import org.json.jsonobject;
// import org.json.jsonstring;
import com.google.gson.JsonElement;
import com.google.gson.Gson;

public class ShoppingCart {
    
    private static ArrayList<String> produkti_groza = new ArrayList<>();
    //private static ArrayList<String> produkti_groza2 = new ArrayList<String>();
    void addcart() {
        App.manager.list_products();

        Product product = new Product();

        System.out.println("Ievadiet produktu pilnu nosaukumu no failā lai ievietot to groza(pirma daļa no pilna nosaukuma(divi objekti), pec tam Enter un otra daļa no nosaukuma(divi objekti))");
        // String strp = """
        //     {
        //     Piemers:

        //     3, MSISP, 1000.79, PC (pieejams produkts)
        //     add
        //     3 MSISP(Enter)
        //     1000.79 PC(Enter)
        //     }
        //     """;

        Scanner myObj = new Scanner(System.in);
        System.out.println("Ievadiet produkta numuru un nosukumu");

        String str = ((Integer.toString(product.setid(myObj.nextInt()))) + "," + product.setname(myObj.nextLine()));
        System.out.println("Ievadiet produkta cenu un kategoriju");

        String str2 = ((Double.toString(product.setprice(myObj.nextDouble()))) + "," + product.setcategory(myObj.nextLine()));

        Collections.addAll(produkti_groza, str + ", " + str2 + "\n"); //+ "," + (Integer.toString(product.setprice(myObj.nextInt())))); //+ ", " + product.setcategory(myObj.nextLine()));
    }

    void cartstatus() {
        ColoredCMD color = new ColoredCMD();
        System.out.println();
        for (String i: produkti_groza) {
            System.out.println(color.ANSI_YELLOW + i + color.ANSI_RESET);
        }
    }

    void removeobjcart() {
        cartstatus();

        // System.out.println("Ievadiet produkta indeksu lai nodzest to no groza\n");
        // Scanner myObj = new Scanner(System.in);

        // int count = 0;
        // for (String i: produkti_groza) {
        //     System.out.println(count + ": " + i);
        //     count++;
        // }

        // produkti_groza.remove(myObj.nextInt());
        final ArrayList<String> cnt = new ArrayList<String>();
        try {
            System.out.println("Ievadiet produkta indeksu lai nodzest to no groza\n");
            Scanner myObj = new Scanner(System.in);

            int count = 0;
            for (String i: produkti_groza) {
                System.out.println(count + ": " + i);
                cnt.add(Integer.toString(count));
                count++;
            }
            String ievade = myObj.nextLine();
            for (String i: cnt) {
                if (ievade.equals(i)) {
                    produkti_groza.remove(Integer.parseInt(ievade));
                } else {
                    System.out.println("Ievadiet validu ineksu");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Ievadiet validu indeksu");
        }
    }
    void place_order() throws Exception {

        
        Scanner myObj_JSON = new Scanner(System.in);
        
        Double db = 0.0, num1, sum_num;
        for (String i: produkti_groza) {
            //str = str + i;
            Pattern p = Pattern.compile("(\\d+(?:\\.\\d+))");
            Matcher m = p.matcher(i);
            while(m.find()) {
                db = Double.parseDouble(m.group(1));
                //System.out.println(db);
            }
        }
        Double num_tmp = db;
        num1 = 0.21 * db;
        sum_num = num1 + num_tmp;

        ColoredCMD colors2 = new ColoredCMD();
        
        System.out.println(colors2.ANSI_GREEN + "Apstipriniet pasutijumu y/n :" + colors2.ANSI_RESET);
        Scanner myObj_ap_p = new Scanner(System.in);
        if (myObj_ap_p.nextLine().equals("y")) {
            System.out.println("Ievadiet klienta vardu, piegades adresi, preces noaukumu, preces daudzumu, cenu, piegades cenu, kopejo cenu: (Enter/)");
            // JSON
            // Klienta vārds un piegādes adrese.
            // Iepirkumu grozā esošās preces, tostarp preces nosaukums, daudzums un cena.
            // Piegādes izmaksas.
            // Pasūtījuma kopējās izmaksas.
        
            //Inserting key-value pairs into the json object
            JSONManager info = new JSONManager(myObj_JSON.nextLine(), myObj_JSON.nextLine(), myObj_JSON.nextLine(), myObj_JSON.nextDouble(), myObj_JSON.nextDouble(), num1, sum_num);
 
            try (PrintWriter out = new PrintWriter(new FileWriter("invoices.json", true))) {
                //Gson gson = new Gson();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonString = gson.toJson(info);
                out.write("[" + jsonString + "]" + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Meginaiet velreiz!!!");
        }
    }
}
