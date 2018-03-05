package com.fanwe.lib.iterator;

import java.util.List;

/**
 * List遍历器
 */
public class FListIterator<T> implements FIterator<T>
{
    private List<T> mData;
    private Object[] mDataCopy;

    private boolean mIsPositive;

    private int mIndex;
    private T mCurrent;

    public FListIterator(List<T> data)
    {
        mData = data;
    }

    @Override
    public void prepare(boolean positive)
    {
        mDataCopy = mData.toArray();

        if (positive)
        {
            mIndex = -1;
        } else
        {
            mIndex = mData.size();
        }
        mIsPositive = positive;
    }

    @Override
    public boolean hasNext()
    {
        final int index = mIsPositive ? mIndex + 1 : mIndex - 1;
        final boolean hasNext = index >= 0 && index < mDataCopy.length;
        if (!hasNext)
        {
            reset();
        }
        return hasNext;
    }

    @Override
    public T next()
    {
        mIndex = mIsPositive ? mIndex + 1 : mIndex - 1;
        mCurrent = (T) mDataCopy[mIndex];
        return mCurrent;
    }

    @Override
    public void remove()
    {
        mData.remove(mCurrent);
    }

    @Override
    public void reset()
    {
        mDataCopy = null;
        mCurrent = null;
    }
}
