public class Product {
    private int id;
    private String name;
    private Double price;
    private String category;

    int getid() {
        return id;
    }

    String getname() {
        return name;
    }

    double getprice() {
        return price;
    }

    String getcategory() {
        return category;
    }

    // ----------------------------

    int setid(int id) {
        return this.id = id;
    }

    String setname(String name) {
        return this.name = name;
    }

    Double setprice(Double price) {
        return this.price = price;
    }

    String setcategory(String category) {
        return this.category = category;
    }
}
