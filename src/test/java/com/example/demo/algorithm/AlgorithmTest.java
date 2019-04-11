package com.example.demo.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class AlgorithmTest {

    @Test
    public void euclidean() {
        int a = 147, b = 79;
        log.info("a:{},b:{} gcd:{}", a, b, gcd(a, b));
        System.out.println(Double.NaN);
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        int r = a % b;
        return gcd(b, r);
    }

    @Test
    public void binarySearch(){
    }
}
