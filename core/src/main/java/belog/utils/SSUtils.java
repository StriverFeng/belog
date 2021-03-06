package belog.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Beldon
 */
public class SSUtils {

    /**
     * 把骆驼命名法的变量，变为大写字母变小写且之前加下划线
     *
     * @param str
     * @return
     */
    public static String toUnderline(String str) {
        str = StringUtils.uncapitalize(str);
        char[] letters = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char letter : letters) {
            if (Character.isUpperCase(letter)) {
                sb.append("_" + letter + "");
            } else {
                sb.append(letter + "");
            }
        }
        return StringUtils.lowerCase(sb.toString());
    }

    /**
     * null to string
     *
     * @param object 目标
     * @param defaultValue 默认值
     * @return
     */
    public static String nullToString(Object object, String defaultValue) {
        return object == null ? defaultValue : object.toString();
    }

    /**
     * @param object 目标对象
     * @param defaultValue 默认值
     * @return
     */
    public static long nullToLong(Object object, long defaultValue) {
        long res = defaultValue;
        if (object != null) {
            try {
                res = Long.parseLong(object.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

}
