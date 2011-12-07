package equipment.utils;

public class StringUtil {
  public static boolean isNullOrEmptyWithTrim(String s) {
     return s==null || "".equals(s.trim());
  }
  
  public static boolean isNotNullAndNotEmptyWithTrim(String s) {
    return s!=null && !"".equals(s.trim());
 }
}