package equipment.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao {
  
  public void save(Object o);

  public void delete(Object o);

  public <T> List<T> findAll();

  public <T> T findById(Serializable o);
  
  public <T> T load(Serializable o);
}
