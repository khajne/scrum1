import java.util.List;

/**
 *
 * @param <Entity>
 */

public interface Repository<Entity> {

    boolean create(Entity entity);
    Entity getById(int id);
    List<Entity> getAll();
    boolean delete(Entity entity);
    void deleteAll();
    Entity update(Entity entity);
    int count();

}
