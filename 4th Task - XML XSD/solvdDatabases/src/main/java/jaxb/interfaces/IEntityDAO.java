package jaxb.interfaces;


public interface IEntityDAO<T> {

    void save(T entity);
    void update(T entity);
    void delete(T entity);

}
