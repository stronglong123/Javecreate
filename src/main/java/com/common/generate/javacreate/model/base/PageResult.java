package com.common.generate.javacreate.model.base;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.model.base.search.Pager;
import com.github.pagehelper.Page;
import org.springframework.core.task.AsyncTaskExecutor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class PageResult<E extends Serializable> extends Page<E> {
    public PageResult() {
    }

    public PageList<E> toPageList() {
        PageList<E> pageList = new PageList();
        pageList.setPager(this.getPager());
        pageList.setDataList(new ArrayList(this));
        return pageList;
    }

    public <T extends Serializable> PageList<T> toPageList(Function<List<E>, List<T>> convertFn) {
        PageList<T> pageList = new PageList();
        pageList.setPager(this.getPager());
        if (this.isEmpty()) {
            pageList.setDataList(Collections.emptyList());
            return pageList;
        } else {
            pageList.setDataList((List) convertFn.apply(new ArrayList(this)));
            return pageList;
        }
    }

    public <T extends Serializable> PageList<T> toPageListParallel(Function<E, T> convertFn) {
        PageList<T> pageList = new PageList();
        pageList.setPager(this.getPager());
        if (this.isEmpty()) {
            pageList.setDataList(Collections.emptyList());
            return pageList;
        } else {
            Map<E, T> resultMap = new ConcurrentHashMap(this.size());
            this.parallelStream().forEach((item) -> {
                Serializable var10000 = (Serializable) resultMap.put(item, convertFn.apply(item));
            });
            List<T> results = new ArrayList(this.size());
            this.forEach((item) -> {
                results.add(resultMap.get(item));
            });
            pageList.setDataList(results);
            return pageList;
        }
    }

    public <T extends Serializable> PageList<T> toPageListParallel(Function<E, T> convertFn, AsyncTaskExecutor taskExecutor) {
        return this.toPageListParallel(convertFn, taskExecutor, 3);
    }

    public <T extends Serializable> PageList<T> toPageListParallel(Function<E, T> convertFn, AsyncTaskExecutor taskExecutor, int timeoutSeconds) {
        PageList<T> pageList = new PageList();
        pageList.setPager(this.getPager());
        if (this.isEmpty()) {
            pageList.setDataList(Collections.emptyList());
            return pageList;
        } else {
            List<Future<T>> futureResults = new ArrayList(this.size());
            Iterator var6 = this.iterator();

            Future futureResult;
            while (var6.hasNext()) {
                E e = (E) var6.next();
                futureResult = taskExecutor.submit(() -> {
                    return (Serializable) convertFn.apply(e);
                });
                futureResults.add(futureResult);
            }

            ArrayList results = new ArrayList(this.size());

            try {
                Iterator var12 = futureResults.iterator();

                while (var12.hasNext()) {
                    futureResult = (Future) var12.next();
                    T result = (T) futureResult.get((long) timeoutSeconds, TimeUnit.SECONDS);
                    results.add(result);
                }
            } catch (Exception var10) {
                throw new RuntimeException(var10);
            }

            pageList.setDataList(results);
            return pageList;
        }
    }

    public Pager getPager() {
        Pager pager = new Pager();
        pager.setPageSize(this.getPageSize());
        pager.setCurrentPage(this.getPageNum());
        pager.setRecordCount(Math.toIntExact(this.getTotal()));
        pager.setTotalPage(this.getPages());
        return pager;
    }
}
