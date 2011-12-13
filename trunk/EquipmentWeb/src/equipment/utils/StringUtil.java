package equipment.utils;

public class StringUtil {
  public static boolean isNullOrEmptyWithTrim(String s) {
    return s == null || "".equals(s.trim());
  }

  public static boolean isNotNullAndNotEmptyWithTrim(String s) {
    return s != null && !"".equals(s.trim());
  }

  public static boolean isEquals(String s1, String s2) {
    return isEquals(s1, s2, false);
  }

  public static boolean isEquals(String s1, String s2, boolean withTrim) {
    if (s1 == null && s2 == null) {
      return true;
    }
    if (s1 == null || s2 == null) {
      return false;
    }
    return s1.trim().equals(s2.trim());
  }
}
