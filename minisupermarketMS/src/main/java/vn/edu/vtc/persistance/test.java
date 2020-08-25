package vn.edu.vtc.persistance;

public class test {
    public static void main(String[] args) {
        Double price=100000.;
        Double discounted = 10000.;
        int amount=1;
        Double total = (price - discounted) * amount;
        System.out.println(total);
    }
}