package com.nhnacademy.server.method.response.impl;

import com.nhnacademy.server.method.response.Response;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeResponse implements Response {

    private final static String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Override
    public String getMethod() {
        return "time";
    }

    @Override
    public String execute(String value) {
        //TODO#1 LocalDateTime을 이용해서 현재 시간을 설정하세요.
        LocalDateTime now = null;

        //TODO#2 value(date format) "" or null 이면 DEFAULT_DATETIME_FORMAT 으로 반환 합니다.


        //TODO#3  value(date format) 의해서 formatting 하는 과정에서 value의 형식이 잘못 되었 다면 DEFAULT_DATETIME_FORMAT 으로 반환 합니다.

        return null;
    }
}