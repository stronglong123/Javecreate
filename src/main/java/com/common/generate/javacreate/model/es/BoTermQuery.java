package com.common.generate.javacreate.model.es;

import javafx.util.Pair;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xialei
 * @date 2021/10/27 15:02
 */
@Data
public class BoTermQuery {
    /**
     * 简单条件
     */
    private List<Pair<String, ?>> termConditions = new ArrayList<>();
    /**
     * 范围条件
     */
    private Map<String, Pair<?, ?>> rangeConditions = new HashMap<>();
    /**
     * 查询条件
     */
    private List<Pair<?, String>> matchConditions = new ArrayList<>();
    /**
     * should 条件
     */
    private Should should;

    private BoTermQuery() {

    }

    /**
     * 添加简单条件
     *
     * @param field
     * @param condition list或者单个数据
     * @return
     */
    public BoTermQuery addTermCondition(String field, Object condition) {
        Pair<String, Object> pair = new Pair<>(field, condition);
        termConditions.add(pair);
        return this;
    }

    /**
     * 添加简单条件
     *
     * @param field
     * @param condition list或者单个数据
     * @return
     */
    public BoTermQuery addTermCondition(String field, Collection<?> condition) {
        Pair<String, Object> pair = new Pair<>(field, condition);
        termConditions.add(pair);
        return this;
    }

    /**
     * 一个值匹配多个字段
     *
     * @param condition
     * @param fields
     * @return
     */
    public BoTermQuery addMatchCondition(String condition, String... fields) {
        Pair<String[], String> pair = new Pair<>(fields, condition);
        matchConditions.add(pair);
        return this;
    }

    /**
     * 一个值匹配一个字段
     *
     * @param condition
     * @param field
     * @return
     */
    public BoTermQuery addMatchCondition(String field,String condition) {
        Pair<?, String> pair = new Pair<>(field, condition);
        matchConditions.add(pair);
        return this;
    }

    /**
     * 添加范围条件
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public BoTermQuery addRangeCondition(String field, Object min, Object max) {
        Pair<Object, Object> pair = new Pair<>(min, max);
        rangeConditions.put(field, pair);
        return this;
    }

    public BoTermQuery addShouldCondition(Should should) {
        this.should = should;
        return this;
    }

    public static BoTermQuery create() {
        return new BoTermQuery();
    }

    @Data
    public static class Should {
        /**
         * 最少匹配的个数
         */
        private int minimumNumberShouldMatch = 1;
        /**
         * 简单条件
         */
        private List<Pair<String, ?>> termConditions = new ArrayList<>();
        /**
         * 范围条件
         */
        private Map<String, Pair<?, ?>> rangeConditions = new HashMap<>();
        /**
         * 查询条件
         * key是field
         * value是值
         */
        private List<Pair<?, String>> matchConditions = new ArrayList<>();

        private Should(int minimumNumberShouldMatch) {
            this.minimumNumberShouldMatch = minimumNumberShouldMatch;
        }

        /**
         * 添加简单条件
         *
         * @param field
         * @param condition
         * @return
         */
        public Should addTermCondition(String field, Object condition) {
            Pair<String, Object> pair = new Pair<>(field, condition);
            termConditions.add(pair);
            return BoTermQuery.Should.this;
        }

        /**
         * 添加简单条件
         *
         * @param field
         * @param condition
         * @return
         */
        public Should addTermCondition(String field, Collection<?> condition) {
            Pair<String, Object> pair = new Pair<>(field, condition);
            termConditions.add(pair);
            return BoTermQuery.Should.this;
        }

        /**
         * 一个值匹配多个字段
         *
         * @param condition
         * @param fields
         * @return
         */
        public Should addMatchCondition(String condition, String... fields) {
            Pair<String[], String> pair = new Pair<>(fields, condition);
            matchConditions.add(pair);
            return this;
        }

        /**
         * 一个值匹配一个字段
         *
         * @param condition
         * @param field
         * @return
         */
        public Should addMatchCondition(String field,String condition) {
            Pair<?, String> pair = new Pair<>(field, condition);
            matchConditions.add(pair);
            return this;
        }

        /**
         * 添加范围条件
         *
         * @param field
         * @param min
         * @param max
         * @return
         */
        public Should addRangeCondition(String field, Object min, Object max) {
            Pair<Object, Object> pair = new Pair<>(min, max);
            rangeConditions.put(field, pair);
            return this;
        }

        public static Should create(int minimumNumberShouldMatch) {
            return new Should(minimumNumberShouldMatch);
        }

    }
}
