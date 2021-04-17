package cn.gdcp.utils;


public final class StringUtil {


    /**
     * 处理字符串头尾的空格
     * @param string
     * @return
     */
    public static String strNotNullTrim(String string){
        String result = string == null ? null :string.trim();
        return result;
    }


}