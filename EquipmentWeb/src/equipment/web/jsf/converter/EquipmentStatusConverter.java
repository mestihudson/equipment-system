package equipment.web.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("equipmentStatusConverter")
public class EquipmentStatusConverter implements Converter {

  private final static String STATUS_ACTIVE = "Active";
  private final static String STATUS_INACTIVE = "Inctive";

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String s) {
    if (s == null) {
      return null;
    } else if (s.equals(STATUS_ACTIVE)) {
      return true;
    } else if (s.equals(STATUS_INACTIVE)) {
      return false;
    } else {
      return null;
    }
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object o) {
    if (o == null) {
      return null;
    }
    Boolean status = (Boolean) o;
    return status ? STATUS_ACTIVE : STATUS_INACTIVE;
  }
}
