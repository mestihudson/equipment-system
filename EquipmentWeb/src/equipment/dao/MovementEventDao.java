package equipment.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

  public Collection<MovementEvent> findByContainerNumber(String containerNumber) {
    Map<String, Object> nameValue = new HashMap<String, Object>();
    nameValue.put(CNTR_NUM, containerNumber);
    return findBy(nameValue);
  }
}
