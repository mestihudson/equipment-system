package equipment.utils;

import java.sql.Timestamp;

public class TimestampUtil {
  public static Timestamp now(){
    return new Timestamp(System.currentTimeMillis());
  }
}
