package equipment.dao;

import org.springframework.stereotype.Repository;

import equipment.domain.entity.Pan;

@Repository("panDao")
public class PanDao extends AbstractBaseDao {


  @Override
  public Class<?> getDomainClass() {
    return Pan.class;
  }
  
}
