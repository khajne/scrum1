package repositories;

import java.util.List;

/**
 *
 * @param <Entity>
 */

public interface Repository<Entity> {

    //Entity getById(int id);
    List<Entity> getAll();
    boolean delete(Entity entity);
    void deleteAll();
    int count();
    boolean create(Entity entity);
    Entity update(Entity entity);


}
