/*
 * Copyright (c) 2015 ZSL
 * Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.zsl.recyclerviewdemo.entity;

import java.io.Serializable;

/**
 * Created by zsl on 15/11/2.
 * User用户
 */
public class UserA extends User implements Serializable {
    int userId;
    String icon;
    boolean isMan;

    public UserA(String name, int userId, String icon, boolean isMan) {
        super(name);
        this.userId = userId;
        this.icon = icon;
        this.isMan = isMan;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setIsMan(boolean isMan) {
        this.isMan = isMan;
    }

    @Override
    public String toString() {
        return "UserA{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", isMan=" + isMan +
                '}';
    }
}
