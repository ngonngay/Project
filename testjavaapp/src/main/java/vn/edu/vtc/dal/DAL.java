package vn.edu.vtc.dal;

public interface DAL<E> {
        int insert(E e);
        E getById(int idE);
         int update(E e);

}
