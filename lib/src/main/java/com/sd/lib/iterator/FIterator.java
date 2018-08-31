package com.sd.lib.iterator;

/**
 * 遍历器
 *
 * @param <T>
 */
public interface FIterator<T>
{
    /**
     * 准备遍历
     *
     * @param positive true-正序遍历，false-倒序遍历
     */
    void prepare(boolean positive);

    /**
     * 是否有下一个对象
     *
     * @return
     */
    boolean hasNext();

    /**
     * 返回下一个对象
     *
     * @return
     */
    T next();

    /**
     * 移除当前对象
     */
    void remove();
}
