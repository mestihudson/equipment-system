package equipment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import equipment.domain.entity.MovementEvent;

@Repository("movementEventDao")
public class MovementEventDao extends AbstractBaseDao {
  private final static String CNTR_NUM = "containerNumber";

  @Override
  public Class<?> getDomainClass() {
    return MovementEvent.class;
  }

  public List<MovementEvent> findByContainerNumber(String containerNumber) {
    Map<String, Object> nameValue = new HashMap<String, Object>();
    nameValue.put(CNTR_NUM, containerNumber);
    return findBy(nameValue);
  }
}
