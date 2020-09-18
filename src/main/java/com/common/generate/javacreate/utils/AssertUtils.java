package com.common.generate.javacreate.utils;

import com.common.generate.javacreate.model.base.exception.DataValidateException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author xialei
 * @date 2020/9/18 16:29
 */
public class AssertUtils {

    /**
     * 私有.
     */
    private AssertUtils() {

    }

    /**
     * Assert a boolean expression, throwing {@code DataValidateException}
     * if the test result is {@code false}.
     * <pre class="code">AssertUtils.isTrue(i &gt; 0, "The value must be greater than zero");</pre>
     * @param expression a boolean expression
     * @param message the exception message to use if the assertion fails
     * @throws DataValidateException if expression is {@code false}
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            fail(message);
        }
    }

    /**
     * Assert a boolean expression, throwing {@code DataValidateException}
     * if the test result is {@code false}.
     * <pre class="code">AssertUtils.isTrue(i &gt; 0);</pre>
     * @param expression a boolean expression
     * @throws DataValidateException if expression is {@code false}
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "[断言失败] -这个表达式必须是true");
    }

    /**
     * Assert that an object is {@code null} .
     * <pre class="code">AssertUtils.isNull(value, "The value must be null");</pre>
     * @param object the object to check
     * @param message the exception message to use if the assertion fails
     * @throws DataValidateException if the object is not {@code null}
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            fail(message);
        }
    }

    /**
     * Assert that an object is {@code null} .
     * <pre class="code">AssertUtils.isNull(value);</pre>
     * @param object the object to check
     * @throws DataValidateException if the object is not {@code null}
     */
    public static void isNull(Object object) {
        isNull(object, "[断言失败] -对象参数必须为Null");
    }

    /**
     * Assert that an object is not {@code null} .
     * <pre class="code">AssertUtils.notNull(clazz, "The class must not be null");</pre>
     * @param object the object to check
     * @param message the exception message to use if the assertion fails
     * @throws DataValidateException if the object is {@code null}
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            fail(message);
        }
    }

    /**
     * Assert that an object is not {@code null} .
     * <pre class="code">AssertUtils.notNull(clazz);</pre>
     * @param object the object to check
     * @throws DataValidateException if the object is {@code null}
     */
    public static void notNull(Object object) {
        notNull(object, "[断言失败] -此参数是必需的；它不能为Null");
    }

    /**
     * Assert that the given String is not empty; that is,
     * it must not be {@code null} and not the empty String.
     * <pre class="code">AssertUtils.hasLength(name, "Name must not be empty");</pre>
     * @param text the String to check
     * @param message the exception message to use if the assertion fails
     * @see StringUtils#hasLength
     * @throws DataValidateException if the text is empty
     */
    public static void hasLength(String text, String message) {
        if (!StringUtils.hasLength(text)) {
            fail(message);
        }
    }

    /**
     * Assert that the given String is not empty; that is,
     * it must not be {@code null} and not the empty String.
     * <pre class="code">AssertUtils.hasLength(name);</pre>
     * @param text the String to check
     * @see StringUtils#hasLength
     * @throws DataValidateException if the text is empty
     */
    public static void hasLength(String text) {
        hasLength(text,
                "[断言失败] -此字符串参数必须有长度，它不能为Null或空");
    }

    /**
     * Assert that the given String has valid text content; that is, it must not
     * be {@code null} and must contain at least one non-whitespace character.
     * <pre class="code">AssertUtils.hasText(name, "'name' must not be empty");</pre>
     * @param text the String to check
     * @param message the exception message to use if the assertion fails
     * @see StringUtils#hasText
     * @throws DataValidateException if the text does not contain valid text content
     */
    public static void hasText(String text, String message) {
        if (!StringUtils.hasText(text)) {
            fail(message);
        }
    }

    /**
     * Assert that the given String has valid text content; that is, it must not
     * be {@code null} and must contain at least one non-whitespace character.
     * <pre class="code">AssertUtils.hasText(name, "'name' must not be empty");</pre>
     * @param text the String to check
     * @see StringUtils#hasText
     * @throws DataValidateException if the text does not contain valid text content
     */
    public static void hasText(String text) {
        hasText(text,
                "[断言失败] -此字符串参数必须有文本，它不能为Null或空");
    }

    /**
     * Assert that the given text does not contain the given substring.
     * <pre class="code">AssertUtils.doesNotContain(name, "rod", "Name must not contain 'rod'");</pre>
     * @param textToSearch the text to search
     * @param substring the substring to find within the text
     * @param message the exception message to use if the assertion fails
     * @throws DataValidateException if the text contains the substring
     */
    public static void doesNotContain(String textToSearch, String substring, String message) {
        if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) &&
                textToSearch.contains(substring)) {
            fail(message);
        }
    }

    /**
     * Assert that the given text does not contain the given substring.
     * <pre class="code">AssertUtils.doesNotContain(name, "rod");</pre>
     * @param textToSearch the text to search
     * @param substring the substring to find within the text
     * @throws DataValidateException if the text contains the substring
     */
    public static void doesNotContain(String textToSearch, String substring) {
        doesNotContain(textToSearch, substring,
                "[断言失败]这个字符串不能包含子字符串 [" + substring + "]");
    }

    /**
     * Assert that an array has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">AssertUtils.notEmpty(array, "The array must have elements");</pre>
     * @param array the array to check
     * @param message the exception message to use if the assertion fails
     * @throws DataValidateException if the object array is {@code null} or has no elements
     */
    public static void notEmpty(Object[] array, String message) {
        if (ObjectUtils.isEmpty(array)) {
            fail(message);
        }
    }

    /**
     * Assert that an array has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">AssertUtils.notEmpty(array);</pre>
     * @param array the array to check
     * @throws DataValidateException if the object array is {@code null} or has no elements
     */
    public static void notEmpty(Object[] array) {
        notEmpty(array, "[断言失败] -这个数组不能是空的：它必须包含至少1个元素");
    }

    /**
     * Assert that an array has no null elements.
     * Note: Does not complain if the array is empty!
     * <pre class="code">AssertUtils.noNullElements(array, "The array must have non-null elements");</pre>
     * @param array the array to check
     * @param message the exception message to use if the assertion fails
     * @throws DataValidateException if the object array contains a {@code null} element
     */
    public static void noNullElements(Object[] array, String message) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    fail(message);
                }
            }
        }
    }

    /**
     * Assert that an array has no null elements.
     * Note: Does not complain if the array is empty!
     * <pre class="code">AssertUtils.noNullElements(array);</pre>
     * @param array the array to check
     * @throws DataValidateException if the object array contains a {@code null} element
     */
    public static void noNullElements(Object[] array) {
        noNullElements(array, "[断言失败] -此数组必须不包含任何空元素");
    }

    /**
     * Assert that a collection has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">AssertUtils.notEmpty(collection, "Collection must have elements");</pre>
     * @param collection the collection to check
     * @param message the exception message to use if the assertion fails
     * @throws DataValidateException if the collection is {@code null} or has no elements
     */
    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            fail(message);
        }
    }

    /**
     * Assert that a collection has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">AssertUtils.notEmpty(collection, "Collection must have elements");</pre>
     * @param collection the collection to check
     * @throws DataValidateException if the collection is {@code null} or has no elements
     */
    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection,
                "[断言失败] -此集合必须不是空的：它必须包含至少1个元素");
    }

    /**
     * Assert that a Map has entries; that is, it must not be {@code null}
     * and must have at least one entry.
     * <pre class="code">AssertUtils.notEmpty(map, "Map must have entries");</pre>
     * @param map the map to check
     * @param message the exception message to use if the assertion fails
     * @throws DataValidateException if the map is {@code null} or has no entries
     */
    public static void notEmpty(Map<?, ?> map, String message) {
        if (CollectionUtils.isEmpty(map)) {
            fail(message);
        }
    }

    /**
     * Assert that a Map has entries; that is, it must not be {@code null}
     * and must have at least one entry.
     * <pre class="code">AssertUtils.notEmpty(map);</pre>
     * @param map the map to check
     * @throws DataValidateException if the map is {@code null} or has no entries
     */
    public static void notEmpty(Map<?, ?> map) {
        notEmpty(map, "[断言失败] -此映射不能为空，它必须至少包含一个entry");
    }

    /**
     * Assert that the provided object is an instance of the provided class.
     * <pre class="code">AssertUtils.instanceOf(Foo.class, foo);</pre>
     * @param clazz the required class
     * @param obj the object to check
     * @throws DataValidateException if the object is not an instance of clazz
     * @see Class#isInstance
     */
    public static void isInstanceOf(Class<?> clazz, Object obj) {
        isInstanceOf(clazz, obj, "");
    }

    /**
     * Assert that the provided object is an instance of the provided class.
     * <pre class="code">AssertUtils.instanceOf(Foo.class, foo);</pre>
     * @param type the type to check against
     * @param obj the object to check
     * @param message a message which will be prepended to the message produced by
     * the function itself, and which may be used to provide context. It should
     * normally end in ":" or "." so that the generated message looks OK when
     * appended to it.
     * @throws DataValidateException if the object is not an instance of clazz
     * @see Class#isInstance
     */
    public static void isInstanceOf(Class<?> type, Object obj, String message) {
        notNull(type, "类型必须不为Null");
        if (!type.isInstance(obj)) {
            fail(
                    (StringUtils.hasLength(message) ? message + " " : "") +
                            "Object of class [" + (obj != null ? obj.getClass().getName() : "null") +
                            "] must be an instance of " + type);
        }
    }

    /**
     * Assert that {@code superType.isAssignableFrom(subType)} is {@code true}.
     * <pre class="code">AssertUtils.isAssignable(Number.class, myClass);</pre>
     * @param superType the super type to check
     * @param subType the sub type to check
     * @throws DataValidateException if the classes are not assignable
     */
    public static void isAssignable(Class<?> superType, Class<?> subType) {
        isAssignable(superType, subType, "");
    }

    /**
     * Assert that {@code superType.isAssignableFrom(subType)} is {@code true}.
     * <pre class="code">AssertUtils.isAssignable(Number.class, myClass);</pre>
     * @param superType the super type to check against
     * @param subType the sub type to check
     * @param message a message which will be prepended to the message produced by
     * the function itself, and which may be used to provide context. It should
     * normally end in ":" or "." so that the generated message looks OK when
     * appended to it.
     * @throws DataValidateException if the classes are not assignable
     */
    public static void isAssignable(Class<?> superType, Class<?> subType, String message) {
        notNull(superType, "类型必须不为Null");
        if (subType == null || !superType.isAssignableFrom(subType)) {
            fail((StringUtils.hasLength(message) ? message + " " : "") +
                    subType + " is not assignable to " + superType);
        }
    }

    /**
     * Assert a boolean expression, throwing {@code DataValidateException}
     * if the test result is {@code false}. Call isTrue if you wish to
     * throw DataValidateException on an assertion failure.
     * <pre class="code">AssertUtils.state(id == null, "The id property must not already be initialized");</pre>
     * @param expression a boolean expression
     * @param message the exception message to use if the assertion fails
     * @throws DataValidateException if expression is {@code false}
     */
    public static void state(boolean expression, String message) {
        if (!expression) {
            fail(message);
        }
    }

    /**
     * Assert a boolean expression, throwing {@link DataValidateException}
     * if the test result is {@code false}.
     * <p>Call {@link #isTrue(boolean)} if you wish to
     * throw {@link DataValidateException} on an assertion failure.
     * <pre class="code">AssertUtils.state(id == null);</pre>
     * @param expression a boolean expression
     * @throws DataValidateException if the supplied expression is {@code false}
     */
    public static void state(boolean expression) {
        state(expression, "[断言失败] -这个状态不变必须是true");
    }

    /**
     * 抛出数据验证异常.
     * @param message 异常描述信息
     * @see DataValidateException
     */
    static public void fail(String message) {
        if (message == null) {
            throw new DataValidateException();
        }
        throw new DataValidateException(message);
    }
}
