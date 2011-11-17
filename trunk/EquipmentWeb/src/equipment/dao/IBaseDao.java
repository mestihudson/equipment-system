package equipment.dao;

import org.hibernate.SessionFactory;

public interface IBaseDao {
  SessionFactory getSessionFactory();
}
