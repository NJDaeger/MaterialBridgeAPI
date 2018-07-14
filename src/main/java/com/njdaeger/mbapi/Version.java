package com.njdaeger.mbapi;

public enum Version {
    
    PRETECHNICAL(112, "1.12.x & down"),
    TECHNICAL(113, "1.13.x & up");
    
    private final int versionNumber;
    private final String support;
    
    Version(int versionNumber, String support) {
        this.versionNumber = versionNumber;
        this.support = support;
    }
    
    public int getVersionNumber() {
        return versionNumber;
    }
    
    public String getSupport() {
        return support;
    }
    
    public static Version getVersionByNumber(int number) {
        return number <= 112 ? PRETECHNICAL : TECHNICAL;
    }
    
}
