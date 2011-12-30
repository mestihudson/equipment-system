package equipment.domain.bo;

import java.util.regex.Pattern;

import equipment.exceptions.ContainerConvertException;

public class ContainerNumberResolver {
  public static final String CONTAINER_NUMBER_PATTERN = "^([a-zA-Z]{4})([0-9]{6})";
  public final static String DEFAULT_SEPERATOR = "-";

  public static String formContainerNumber(String number, char checkDigit) throws ContainerConvertException {
    if (checkDigit < 48 || checkDigit > 58) {
      throw new ContainerConvertException(ContainerConvertException.OutputMessage.INVALID_CHECK_DIGIT);
    }
    if (number == null || number.length() != 10) {
      throw new ContainerConvertException(ContainerConvertException.OutputMessage.INVALID_CONTAINER_NUMBER_LENGTH);
    }
    if (!Pattern.compile(CONTAINER_NUMBER_PATTERN).matcher(number).matches()) {
      throw new ContainerConvertException(ContainerConvertException.OutputMessage.INVALID_CONTAINER_NUMBER_PREFIX);
    }
    return number.toUpperCase() + DEFAULT_SEPERATOR + checkDigit;
  }

  public static String resolveContainerNumber(String containerNumberWithCheckDigit) throws ContainerConvertException {
    String containerNumber = containerNumberWithCheckDigit.split("-")[0];
    if (!Pattern.compile(CONTAINER_NUMBER_PATTERN).matcher(containerNumber).matches()) {
      throw new ContainerConvertException(ContainerConvertException.OutputMessage.INVALID_CONTAINER_NUMBER_PREFIX);
    }
    return containerNumber.toUpperCase();
  }
  
  public static char resolveCheckDigit(String containerNumberWithCheckDigit) throws ContainerConvertException {
    String[] s = containerNumberWithCheckDigit.split("-");
    if(s.length != 2 || s[1] == null || s[1].length() > 1) {
      throw new ContainerConvertException(ContainerConvertException.OutputMessage.INVALID_CONTAINER_NUMBER_LENGTH);
    }
    if(s[1].charAt(0) < 48 || s[1].charAt(0) > 58) {
      throw new ContainerConvertException(ContainerConvertException.OutputMessage.INVALID_CHECK_DIGIT);
    }
    return s[1].charAt(0);
  }
}
