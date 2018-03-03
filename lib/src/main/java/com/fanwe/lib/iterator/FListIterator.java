package com.fanwe.lib.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * List遍历器
 */
public class FListIterator<T> extends FAbstractIterator<T>
{
    private List<T> mList;
    private List<T> mListOriginal;

    public FListIterator(List<T> list)
    {
        mListOriginal = list;
        mList = new ArrayList<>(list);
    }

    @Override
    protected T get(int index)
    {
        return mList.get(index);
    }

    @Override
    protected void remove(int index)
    {
        mListOriginal.remove(get(index));
    }

    @Override
    protected int size()
    {
        return mList.size();
    }
}
