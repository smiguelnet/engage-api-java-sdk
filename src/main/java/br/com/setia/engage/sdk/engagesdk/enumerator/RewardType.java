package br.com.setia.engage.sdk.engagesdk.enumerator;

public enum RewardType {

    CREDIT("Credit", true, true),
    ASSET("Asset", false, false);

    private String name;
    private boolean computeSum;
    private boolean computeTotal;

    RewardType(String name, boolean computeSum, boolean computeTotal) {
        this.name = name;
        this.computeSum = computeSum;
        this.computeTotal = computeTotal;
    }

    public String getName() {
        return name;
    }

    public boolean isComputeSum() {
        return computeSum;
    }

    public boolean isComputeTotal() {
        return computeTotal;
    }
}
