package equipment.service;

import java.util.Collection;
import java.util.Date;

import equipment.domain.entity.MovementEvent;

public interface MovementEventService {
  Collection<MovementEvent> findByContainerNumber(String containerNumber);
  void deleteEvents(Collection<MovementEvent> events);
  MovementEvent findLastEventBeforeDate(String containerNumber, Date date);
  int removeEvents(MovementEvent[] selectedEvents);
}