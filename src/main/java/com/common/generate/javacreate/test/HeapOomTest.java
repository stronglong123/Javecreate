package com.common.generate.javacreate.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xialei
 * @date 2023/6/1 16:40
 */
public class HeapOomTest {

    static class OOMObject{}

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
//        while (true){
//            list.add(new OOMObject());
//        }
    }

}
