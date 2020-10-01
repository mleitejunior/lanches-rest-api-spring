package com.mleitejunior.lanchesrestapispring.enums;

public enum SandwichBase {

    X_BACON ("bacon,hambúrguer,queijo"),
    X_BURGUER ("hambúrguer,queijo"),
    X_EGG ("ovo,hambúrguer,queijo"),
    X_EGG_BACON ("ovo,bacon,hambúrguer,queijo");

    private String ingredientsName;

    SandwichBase(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }
}
