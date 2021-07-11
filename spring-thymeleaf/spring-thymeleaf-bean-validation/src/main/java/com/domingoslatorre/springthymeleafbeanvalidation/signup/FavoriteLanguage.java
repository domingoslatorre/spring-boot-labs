package com.domingoslatorre.springthymeleafbeanvalidation.signup;

public enum FavoriteLanguage {
    JAVA("Java"),
    PYTHON("Python"),
    JAVASCRIPT("Javascript");

    private String value;

    FavoriteLanguage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
