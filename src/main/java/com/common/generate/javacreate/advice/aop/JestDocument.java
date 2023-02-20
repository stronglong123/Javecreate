package com.common.generate.javacreate.advice.aop;

//import io.searchbox.core.Delete;
//import io.searchbox.core.Index;
//import io.searchbox.core.Update;

public interface JestDocument {
//
//    default Index toIndex() {
//        return new Index.Builder(this).index(index()).type(type()).id(id()).build();
//    }
//
//    default Delete toDelete() {
//        return new Delete.Builder(id()).index(index()).type(type()).build();
//    }
//
//    default Update toUpdate() {
//        return new Update.Builder(this).index(index()).type(type()).id(id()).build();
//    }

    String id();

    String index();

    String type();

}
