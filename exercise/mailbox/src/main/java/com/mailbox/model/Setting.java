package com.mailbox.model;

public class Setting {
    private String language;
    private int size;
    private boolean spamFilter;
    private String signature;

    public Setting (){
    }

    public Setting(String language, int size, boolean spamFilter, String signature) {
        this.language = language;
        this.size = size;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "language: " + language + ", size: " + size + ", spamFilter: " + spamFilter + ", signature: " + signature;
    }
}
