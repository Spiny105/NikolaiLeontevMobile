package enums;

public enum TestPlatforms {

    IOS("iOS"),
    ANDROID("Android"),
    UNKNOWN("Unknown");

    private final String item;

    TestPlatforms(String item){
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}