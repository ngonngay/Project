package vn.edu.vtc.dal;

import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

public class DalFactory {
    private enum ValidDal {

        Account {
            @Override
            DAL<Account> make() {
                return new AccountDAL();
            }
        },
        Product {
            @Override
            DAL<Product> make() {
                return new ProductDAL();
            }
        },
        Order {
            @Override
            DAL<Order> make() {
                return new OrderDAL();
            }
        };

        abstract <T> DAL<T> make();
    }

    public static <T> DAL<T> getDAL(Class<T> classType) {
        if (classType == Account.class) {
            return ValidDal.Account.make();
        } else if (classType == Product.class) {
            return ValidDal.Product.make();
        } else if (classType == Order.class) {
            return ValidDal.Order.make();
        }
        return null;
    }
}