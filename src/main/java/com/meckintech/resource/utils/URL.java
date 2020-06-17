package com.meckintech.resource.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

    public static String decodeParam(final String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");

        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static List<Integer> decodeIntList(final String s) {
        final String[] vet = s.split(",");
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < vet.length; i++) {
            list.add(Integer.parseInt(vet[i]));
        }
        return list;
        // return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());

    }
}