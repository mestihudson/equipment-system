package equipment.dao;

import org.springframework.stereotype.Repository;

import equipment.domain.entity.Container;

@Repository("containerDao")
public class ContainerDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return Container.class;
  }

}
