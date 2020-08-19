package vn.edu.vtc.dal;

import vn.edu.vtc.persistance.Product;

import java.util.List;

public interface DAL<E> {
        int insert(E e);
        E getById(int idE);
         int update(E e);

}
