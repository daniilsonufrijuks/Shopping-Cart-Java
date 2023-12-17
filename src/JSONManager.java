public class JSONManager {
    private String name;
    private String adress;
    private String good_name;
    private double good_counter;
    private double price;
    private double shipping_costs;
    private double all_costs;

    public JSONManager(String name, String adress, String good_name, double good_counter, double price, double shipping_costs, double all_costs) {
        this.name = name;
        this.adress = adress;
        this.good_name = good_name;
        this.good_counter = good_counter;
        this.price = price;
        this.shipping_costs = shipping_costs;
        this.all_costs = all_costs;
    }
}
