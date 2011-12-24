package equipment.service;

import java.util.Collection;

import equipment.domain.entity.MovementEvent;

public interface MovementEventService {
  Collection<MovementEvent> findByContainerNumber(String containerNumber);
  void deleteEvents(Collection<MovementEvent> events);
}