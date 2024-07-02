package restaurant.dao;

import java.util.List;

abstract public class RestaurantDAO<EntityType, KeyType> {
    abstract public void insert(EntityType entity);
    abstract public void update(EntityType entity);
    abstract public void delete(KeyType id);
    abstract public EntityType getByID(KeyType id);
    abstract public List<EntityType> getAll();
    abstract protected List<EntityType> fetchByQuery(String sql, Object...args);
}