package com.lenovo.sharkchao.hospital.data;

import com.lenovo.sharkchao.hospital.model.User;

import java.util.List;

/**
 * Created by SharkChao on 2017/1/11.
 */

public class MyData {
    private static List<User> userLists;

    public static List<User> getUserLists() {
        return userLists;
    }

    public static void setUserLists(List<User> userLists) {
        MyData.userLists = userLists;
    }
}
