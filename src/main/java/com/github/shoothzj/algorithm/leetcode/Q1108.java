package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q1108 {

    private static final Logger logger = LoggerFactory.getLogger(Q1108.class);

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    @Test
    public void test() {
        String result = defangIPaddr("255.100.50.0");
        assertEquals("255[.]100[.]50[.]0", result);
    }

}
