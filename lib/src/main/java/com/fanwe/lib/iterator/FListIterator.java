package com.fanwe.lib.iterator;

import java.util.List;
import java.util.ListIterator;

/**
 * List遍历器
 */
public class FListIterator<T> implements FIterator<T>
{
    private List<T> mData;
    private ListIterator<T> mIterator;

    private boolean mIsPositive;

    public FListIterator(List<T> data)
    {
        mData = data;
        prepare(true);
    }

    @Override
    public void prepare(boolean positive)
    {
        if (positive)
        {
            mIterator = mData.listIterator();
        } else
        {
            mIterator = mData.listIterator(mData.size());
        }
        mIsPositive = positive;
    }

    @Override
    public boolean hasNext()
    {
        return mIsPositive ? mIterator.hasNext() : mIterator.hasPrevious();
    }

    @Override
    public T next()
    {
        return mIsPositive ? mIterator.next() : mIterator.previous();
    }

    @Override
    public void remove()
    {
        mIterator.remove();
    }
}
