package equipment.external;

import equipment.domain.entity.MovementEvent;
import equipment.domain.enums.DocumentType;

public interface IShipment {
  ShipmentRoute getShipment(String containerNumber, String documentReference, DocumentType documentType);
  void addMovement(MovementEvent movemenetEvent);
}
