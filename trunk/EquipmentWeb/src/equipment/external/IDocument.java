package equipment.external;

import equipment.domain.entity.MovementEvent;

public interface IDocument {
  TrackingGroup getTrackingGroup(String trackingGroupCode);
  void addMovement(MovementEvent movemenetEvent);
}
