package com.patrick.gobang.view;

public interface InitializeComponent {


    default void init() {
        this.setInterface();
        this.addChildrenComponent();
        this.registerListener();
    }


    void setInterface();


    void addChildrenComponent();


    void registerListener();



}
