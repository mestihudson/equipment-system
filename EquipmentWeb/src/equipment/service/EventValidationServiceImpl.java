package equipment.service;

import org.springframework.stereotype.Service;

import equipment.domain.enums.ValidationType;
import equipment.validation.IncomingEvent;
import equipment.validation.ValidationResult;

@Service("eventValidationService")
public class EventValidationServiceImpl implements EventValidationService {

  @Override
  public ValidationResult validateEvent(IncomingEvent event, ValidationType validationType) {
    // TODO Auto-generated method stub
    return null;
  }

}
