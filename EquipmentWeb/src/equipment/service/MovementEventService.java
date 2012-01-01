package equipment.service;

import java.util.Date;
import java.util.List;

import equipment.domain.entity.MovementEvent;

public interface MovementEventService {
  List<MovementEvent> findByContainerNumber(String containerNumber);
  int deleteEvents(MovementEvent[] events);
  MovementEvent findLastEventBeforeDate(String containerNumber, Date date);
  int removeEvents(MovementEvent[] selectedEvents);
}