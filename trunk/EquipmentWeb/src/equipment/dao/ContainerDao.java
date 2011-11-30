package equipment.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import equipment.domain.entity.Container;

@Repository("containerDao")
@Scope("singleton")
public class ContainerDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return Container.class;
  }

}
