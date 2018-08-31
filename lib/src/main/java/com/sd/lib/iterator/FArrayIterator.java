package com.sd.lib.iterator;

/**
 * 数组遍历器
 */
public class FArrayIterator<T> implements FIterator<T>
{
    private T[] mData;
    private int mIndex;

    private boolean mIsPositive;

    public FArrayIterator(T[] data)
    {
        mData = data;
        prepare(true);
    }

    @Override
    public void prepare(boolean positive)
    {
        if (positive)
        {
            mIndex = -1;
        } else
        {
            mIndex = mData.length;
        }
        mIsPositive = positive;
    }

    @Override
    public boolean hasNext()
    {
        final int index = mIsPositive ? mIndex + 1 : mIndex - 1;
        return index >= 0 && index < mData.length;
    }

    @Override
    public T next()
    {
        mIndex = mIsPositive ? mIndex + 1 : mIndex - 1;
        return mData[mIndex];
    }

    @Override
    public void remove()
    {

    }
}
