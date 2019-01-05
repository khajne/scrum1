import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository <T extends IdSetGet> implements Repository<T> {

    private int nextFreeId = 0;

    private List<T> entityList= new ArrayList<>();

    public List<T> getEntityList() {
        return entityList;
    }

    @Override
    public boolean create(T t) {
        t.setId(nextFreeId++);
        return entityList.add(t);
    }

    @Override
    public T getById(int id) {
        T tEntityFromDB = entityList.stream()
                .filter(t1 -> t1.getId() == id)
                .findAny()
                .orElse(null);

        if (tEntityFromDB == null) {
            throw new IllegalArgumentException("Object doesn't exist");
        }
        return  tEntityFromDB;
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(entityList);
    }

    @Override
    public boolean delete(T t) {
        return entityList.remove(t);
    }

    @Override
    public void deleteAll() {
        entityList.clear();
    }

    @Override
    public T update(T t) {
        T tEntityFromDB = entityList.stream()
                .filter(t1 -> t1.getId() == t.getId())
                .findAny()
                .orElse(null);

        if (tEntityFromDB == null) {
            throw new IllegalArgumentException("Object doesn't exist");
        }
        entityList.remove(tEntityFromDB);
        entityList.add(t);

        return entityList.get(entityList.size()-1);
    }

    @Override
    public int count() {
        return entityList.size();
    }
}
