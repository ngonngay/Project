package vn.edu.vtc.persistance;

public class Product {
    private int productId;
    private String name;
    private Double price;
    private Double discounted=0.;
    private Integer amount;
    private String description;
    private Integer leftQuantity=0;
    private Integer isSelling=0;
    private Integer supplier_id=1;
    private String category;
    private Integer refundedInOrder=1;
    public Product() {
    }

    public Product(int productId, String name, Double price, Double discounted, Integer amount, String description, Integer leftQuantity, Integer isSelling, Integer supplier_id, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.discounted = discounted;
        this.amount = amount;
        this.description = description;
        this.leftQuantity = leftQuantity;
        this.isSelling = isSelling;
        this.supplier_id = supplier_id;
        this.category = category;
    }

    public Product(int product_id, String name, Double price, String description, Integer leftQuantity, Integer supplier_id, String category) {
        this.productId = product_id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.leftQuantity = leftQuantity;
        this.supplier_id = supplier_id;
        this.category = category;
    }

    public Product(int product_id, String name, Double price, Double discounted, Integer amount) {
        this.name = name;
        this.price = price;
        this.discounted = discounted;
        this.amount = amount;
        this.productId = product_id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int product_id) {
        this.productId = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscounted() {
        return discounted;
    }

    public void setDiscounted(Double discounted) {
        this.discounted = discounted;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLeftQuantity() {
        return leftQuantity;
    }

    public void setLeftQuantity(Integer leftQuantity) {
        this.leftQuantity = leftQuantity;
    }

    public Integer getIsSelling() {
        return isSelling;
    }

    public void setIsSelling(Integer isSelling) {
        this.isSelling = isSelling;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getRefundedInOrder() {
        return refundedInOrder;
    }

    public void setRefundedInOrder(Integer refundedInOrder) {
        this.refundedInOrder = refundedInOrder;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product){
            Product anotherProduct=(Product)obj;
            if ((anotherProduct.productId==(this.productId))){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return
                "\nName        : '" + name + "  " +
                        "Price       : " + price + "  " +
                        "Discounted  : " + discounted + "  " +
                        "Amount      : " + amount;
    }
    public Double Total(){
        Double total = (price - discounted) * amount;
        return total;
    }
}
