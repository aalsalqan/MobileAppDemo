package core.common;

public enum Drivers {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IOS("ios"),
    ANDROID("android");


    private final String value;

    Drivers(String value) {
        this.value = value;
    }
}

class EnumParsers {

    public static Drivers parseBrowsers(String browser) {
        switch (browser.toUpperCase()) {
            case "CHROME":
                return Drivers.CHROME;
            case "FIREFOX":
                return Drivers.FIREFOX;
            case "IOS":
                return Drivers.IOS;
            case "ANDROID":
                return Drivers.ANDROID;
            default:
                throw new IllegalArgumentException("Driver Not Supported");
        }
    }
}