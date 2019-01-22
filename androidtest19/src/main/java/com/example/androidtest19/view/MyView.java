package com.example.androidtest19.view;

public interface MyView<T> {
    void Success(T data) ;
    void error(T error);
}
