package equipment.dao;

import org.springframework.stereotype.Repository;

import equipment.domain.entity.MovementEvent;

@Repository("movementEventDao")
public class MovementEventDao extends AbstractBaseDao {
  public static final String CNTR_NUM = "containerNumber";
  public static final String EVENT_DT_LOC = "eventDateTime";
  public static final String EVENT_CRE_DT = "eventCreationDateTime";
  public static final String EVENT_TYPE = "eventType";

  @Override
  public Class<?> getDomainClass() {
    return MovementEvent.class;
  }
}
