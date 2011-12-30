package equipment.exceptions;

public class ContainerConvertException extends Throwable{
  private static final long serialVersionUID = -8395230210110839157L;
  private OutputMessage outputMessage;

  public ContainerConvertException(OutputMessage outputMessage) {
    this.outputMessage = outputMessage;
  }
  
  public String getSummaryMessage() {
    return this.outputMessage.getSummary();
  }
  
  public String getDetailMessage() {
    return this.outputMessage.getDetail();
  }
  
  public enum OutputMessage {
    INVALID_CHECK_DIGIT("Invalid check digit", "Check digit must be a numberic"),
    INVALID_CONTAINER_NUMBER_LENGTH("Invalid container number", "The length of container number is 10"),
    INVALID_CONTAINER_NUMBER_PREFIX("Invalid container number", "The prefix of container number is 4 letters");
    
    private String summary;
    private String detail;
    
    private OutputMessage(String summary, String detail) {
      this.summary = summary;
      this.detail = detail;
    }
    public String getSummary() {
      return summary;
    }
    public void setSummary(String summary) {
      this.summary = summary;
    }
    public String getDetail() {
      return detail;
    }
    public void setDetail(String detail) {
      this.detail = detail;
    }
  }
}
