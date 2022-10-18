package com.main8.idea;

import java.util.Arrays;
import java.util.Collections;

public final class Sort extends ArrayPI2
{
    public static void main(String[] args)
    {
        Integer[] aa = CreateTable();
        Arrays.sort(aa);
        System.out.println(Arrays.toString(aa));
    }
}
