package equipment.domain.objects;

import equipment.utils.StringUtil;

public class CheckedContainerNumber implements Comparable<CheckedContainerNumber> {
  public final static String DEFAULT_SEPERATOR = "-";
  private String containerNumber;
  private char checkDigit;
  private boolean checked;

  public CheckedContainerNumber(String containerNumber, char checkDigit) {
    this(containerNumber, checkDigit, false);
  }

  public CheckedContainerNumber(String containerNumber, char checkDigit, boolean checked) {
    this.containerNumber = containerNumber;
    this.checkDigit = checkDigit;
    this.checked = checked;
  }

  public String getOutputString() {
    StringBuffer sb = new StringBuffer(containerNumber.length() + DEFAULT_SEPERATOR.length() + 1);
    sb.append(this.containerNumber);
    sb.append(DEFAULT_SEPERATOR);
    sb.append(this.checkDigit);
    return sb.toString();
  }

  public String toString() {
    return getOutputString();
  }

  public String getContainerNumber() {
    return containerNumber;
  }

  public void setContainerNumber(String containerNumber) {
    this.containerNumber = containerNumber;
  }

  public char getCheckDigit() {
    return checkDigit;
  }

  public void setCheckDigit(char checkDigit) {
    this.checkDigit = checkDigit;
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  @Override
  public int compareTo(CheckedContainerNumber o) {
    return this.containerNumber.compareTo(o.containerNumber);
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof CheckedContainerNumber
        && o != null
        && StringUtil.isEquals(this.containerNumber, ((CheckedContainerNumber) o).containerNumber)
        && this.checkDigit == ((CheckedContainerNumber) o).checkDigit;
  }

}
