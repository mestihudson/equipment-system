package equipment.web.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import equipment.domain.objects.CheckedContainerNumber;
import equipment.utils.StringUtil;

@FacesConverter("checkedContainerNumberConverter")
public class CheckedContainerNumberConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String s) {
    if (StringUtil.isNullOrEmptyWithTrim(s)) {
      return null;
    }
    String[] numberAndCheckDigit = s.split(CheckedContainerNumber.DEFAULT_SEPERATOR);
    if (numberAndCheckDigit.length != 2) {
      return null;
    }
    return new CheckedContainerNumber(numberAndCheckDigit[0], numberAndCheckDigit[1].toCharArray()[0], true);
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object o) {
    if (o instanceof CheckedContainerNumber) {
      return ((CheckedContainerNumber) o).toString();
    }
    return null;
  }

}
