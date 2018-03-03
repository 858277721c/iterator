package com.fanwe.lib.iterator;

/**
 * 遍历器
 *
 * @param <T>
 */
public interface FIterator<T>
{
    /**
     * 准备正序遍历
     */
    FIterator<T> prepareNext();

    boolean hasNext();

    T next();

    /**
     * 准备倒序遍历
     */
    FIterator<T> preparePrevious();

    boolean hasPrevious();

    T previous();

    void remove();

    int index();
}
