package br.com.setia.engage.sdk.engagesdk.enumerator;

public enum AttributeType {
    TEXT("string"),
    NUMERIC("numeric"),
    LIST("list"),
    BOOLEAN("boolean");

    private String attributeType;

    AttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getAttributeType() {
        return attributeType;
    }
}
