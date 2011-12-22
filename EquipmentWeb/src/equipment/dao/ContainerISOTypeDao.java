package equipment.dao;

import org.springframework.stereotype.Repository;

import equipment.domain.entity.ContainerISOType;
@Repository("containerDao")
public class ContainerISOTypeDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return ContainerISOType.class;
  }

}
