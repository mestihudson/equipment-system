package equipment.service;

import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import equipment.domain.entity.MovementEvent;

@Service("movementEventService")
@Scope("singleton")
public class MovementEventServiceImpl implements MovementEventService {

  @Override
  public void deleteEvents(Collection<MovementEvent> events) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Collection<MovementEvent> findByContainerNumber(String containerNumber) {
    // TODO Auto-generated method stub
    return null;
  }
	
}
