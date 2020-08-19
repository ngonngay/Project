package vn.edu.vtc.service;

public class tsahdbvhjasbdhasbh {
    //        AccountDAL accountDAL=new AccountDAL();
//        Account account= accountDAL.getAccount("staff1","123456");
//        System.out.println(account.toString());
//        ProductDAL productDAL=new ProductDAL();
//        Product product= productDAL.getProductById(1001);
//        System.out.println(product.toString());
//        Product p=new Product(1005,"my goi 5",10000.,"update from java app",10,1,"my goi");
//        System.out.println("insert "+productDAL.insertProduct(p));
//        Product product11=productDAL.getProductById(1005);
//        System.out.println(product11);
//        Product product15 = new Product(1002,"banh my",15000.,"update from java app",50,1,"my goi");
//        System.out.println("update : " +productDAL.updateProduct(product15));
//        Product product1 = new Product(1001,"my goi",10000.,0.,1);
//        Product product2 = new Product(1002,"my goi 2",10000.,0.,1);
//        List<Product> list= new ArrayList<Product>();
//        list.add(product1);
//        list.add(product2);
//        OrderDAL orderDAL=new OrderDAL();
//        Order order = new Order(list,account.getStaff_id());
//        Order newOrder=orderDAL.createOrder(order);
//        System.out.println(newOrder.toString());



    //PRoductDAL
    //    public Product getProductById(int productId){
//        Product product=null;
//        if (productId==-1){
//            return null;
//        }
//        try (Connection connection=DbUtil.getConnection();
//             PreparedStatement preparedStatement=connection.prepareStatement("select *from Products where product_id=?;")) {
//            preparedStatement.setInt(1,productId);
//            ResultSet resultSet=preparedStatement.executeQuery();
//            while (resultSet.next()){
//                product=getProduct(resultSet);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return product;
//    }
    //    public int insertProduct(Product newProduct){
//        try(Connection connection=DbUtil.getConnection();
//            Statement statement = connection.createStatement()) {
//            //check exist
//            if (getProductById(newProduct.getProductId())!=null){
//                return 0;
//            }
//            connection.setAutoCommit(false);
//            statement.execute("lock tables Products write,Invoices write,OrderDetail write,Stores write;");
//            try(PreparedStatement preparedStatement = connection.prepareStatement("insert into Products(product_id,product_name,product_Description,price,left_quantity,supplier_id)values(?,?,?,?,?,?);")){
//                preparedStatement.setInt(1,newProduct.getProductId());
//                preparedStatement.setString(2,newProduct.getName());
//                preparedStatement.setString(3,newProduct.getDescription());
//                preparedStatement.setDouble(4,newProduct.getPrice());
//                preparedStatement.setInt(5,newProduct.getLeftQuantity());
//                preparedStatement.setInt(6,newProduct.getSupplier_id());
//                if (preparedStatement.executeUpdate()!=1){
//                    connection.rollback();
//                    return 0;
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            statement.execute("unlock tables");
//            connection.setAutoCommit(true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return 1;
//    }
//    public Integer updateProduct(Product updatingProduct){
//
//        try(Connection connection=DbUtil.getConnection();
//            Statement statement=connection.createStatement()) {
//            //if updating was null, do not update
//            if (updatingProduct==null){
//                return 0;
//            }
//            //check exist
//            if (getProductById(updatingProduct.getProductId())==null){
//                return 0;
//            }
//            //update product
//            try(PreparedStatement preparedStatement=connection.prepareStatement("update Products set product_name=?,product_Description=?,price=?,left_quantity=? where product_id=?;")){
//                preparedStatement.setString(1,updatingProduct.getName());
//                preparedStatement.setString(2,updatingProduct.getDescription());
//                preparedStatement.setDouble(3,updatingProduct.getPrice());
//                preparedStatement.setInt(4,updatingProduct.getLeftQuantity());
//                preparedStatement.setInt(5,updatingProduct.getProductId());
//                if (preparedStatement.executeUpdate()!=1){
//                    return 0;
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 1;
//    }

}
