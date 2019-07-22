package enums;

public enum TestTypes {

    AUT("AUT"),
    SUT("SUT"),
    UNCNOWN_TYPE("Unknown");

    private final String item;

    TestTypes(String item){
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
