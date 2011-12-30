package equipment.dao;

import org.springframework.stereotype.Repository;

import equipment.domain.entity.Rejection;

@Repository
public class RejectionDao extends AbstractBaseDao {

  @Override
  public Class<?> getDomainClass() {
    return Rejection.class;
  }

}
