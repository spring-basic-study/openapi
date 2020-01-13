package com.example.openapi.service;

import org.springframework.beans.factory.annotation.Autowired;

public class test {
    @Autowired
    static NaverTemplate naverTemplate;

    public static void main(String[] args) {
        naverTemplate.print();
    }
}
