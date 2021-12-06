package ch.epai.ict.m226.gerons_nos_items_lsp_isp;

public class StringUtils {

    public static String emptyStringIfNull(String value) {
        if (value != null) {
            return value;
        }
        return "";
    }
}
