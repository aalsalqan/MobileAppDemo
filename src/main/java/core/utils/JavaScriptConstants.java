package core.utils;

public class JavaScriptConstants {

    private JavaScriptConstants(){}

    public static final String SCROLL_BY;
    public static final String GET_ELEMENT_BY_CLASS_NAME;
    public static final String CLICK_ON_ELEMENT;

    static
    {
        SCROLL_BY="window.scrollBy";
        GET_ELEMENT_BY_CLASS_NAME="document.getElementsByClassName";
        CLICK_ON_ELEMENT="arguments[0].click()";
    }
}
