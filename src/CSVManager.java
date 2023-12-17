import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVManager {
    void list_products() { // metode lai paradit produktus
         try {
            File myObj = new File("produkti.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
