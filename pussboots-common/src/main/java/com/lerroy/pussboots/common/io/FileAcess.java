/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.common.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chunhong.pch on 17/7/31.
 */
public class FileAcess {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("/Users/lerroy/Downloads/1"));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/Users/lerroy/Downloads/2"));

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        String s = null;
        while ((s = bufferedReader1.readLine())!=null){
            //list1.add(s);
            System.out.println(String.format("ids.add(%s);",s));
        }

        // while ((s = bufferedReader2.readLine())!=null){
        //     list2.add(s);
        // }
        //
        // for(String ss : list1){
        //     if(!list2.contains(ss)){
        //         System.out.println(ss);
        //     }
        // }
        //
        //
        // System.out.println("----------------");
        //
        // for(String ss : list2){
        //     if(!list1.contains(ss)){
        //         System.out.println(ss);
        //     }
        // }

    }
}