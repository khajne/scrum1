/**
 *
 * @param <Entity>
 */

public interface Repository<Entity> {

    boolean create(Entity entity);
    Entity get(int index);
    boolean delete(Entity entity);
    void deleteAll();
    Entity update(Entity entity);
    int count();


}
