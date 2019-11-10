package com.github.shoothzj.algorithm.leetcode.contest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class Q5183 {

    private static final Logger logger = LoggerFactory.getLogger(Q5183.class);

    private static final String[] auxArray = {"Dummy", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        int value = date.getDayOfWeek().getValue();
        return auxArray[value];
    }

}
