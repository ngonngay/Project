package vn.edu.vtc.persistance;

public class Product {
    private Integer product_id;
    private String name;
    private Double price;
    private Double discounted;
    private Integer amount;
    private String description;
    private Integer leftQuantity;
    private short isSelling;
    private Integer supplier_id;
    private String category;
    private Integer refundedInOrder=1;
    public Product() {
    }

    public Product(Integer product_id, String name, Double price, Double discounted, Integer amount, String description, Integer leftQuantity, short isSelling, Integer supplier_id, String category) {
        this.product_id = product_id;
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

    public Product(Integer product_id, String name, Double price, String description, Integer leftQuantity, Integer supplier_id, String category) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.leftQuantity = leftQuantity;
        this.supplier_id = supplier_id;
        this.category = category;
    }

    public Product(Integer product_id, String name, Double price, Double discounted, Integer amount) {
        this.name = name;
        this.price = price;
        this.discounted = discounted;
        this.amount = amount;
        this.product_id = product_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
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

    public short getIsSelling() {
        return isSelling;
    }

    public void setIsSelling(short isSelling) {
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
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discounted=" + discounted +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", leftQuantity=" + leftQuantity +
                ", isSelling=" + isSelling +
                ", supplier_id=" + supplier_id +
                ", category='" + category + '\'' +
                '}';
    }
}
