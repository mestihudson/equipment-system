package equipment.dao;

import org.springframework.stereotype.Repository;

import equipment.domain.entity.MovementEvent;

@Repository("movementEventDao")
public class MovementEventDao extends AbstractBaseDao {
  public final static String CNTR_NUM = "containerNumber";
  public final static String EVENT_DT_LOC = "eventDateTime";
  public final static String EVENT_CRE_DT = "eventCreationDateTime";

  @Override
  public Class<?> getDomainClass() {
    return MovementEvent.class;
  }
}
