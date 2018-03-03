package com.fanwe.lib.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * List遍历器
 */
public class FListIterator<T> implements FIterator<T>
{
    private List<T> mList;
    private List<T> mListCopy = new ArrayList<>();

    private boolean mIsPositive;

    private int mIndex;
    private T mCurrent;

    public FListIterator(List<T> list)
    {
        mList = list;
    }

    @Override
    public void prepare(Boolean positive)
    {
        if (positive == null)
        {
            mListCopy.clear();
            mCurrent = null;
            return;
        }

        mListCopy.clear();
        mListCopy.addAll(mList);

        if (positive)
        {
            mIndex = -1;
        } else
        {
            mIndex = mList.size();
        }

        mIsPositive = positive;
    }

    @Override
    public boolean hasNext()
    {
        final int index = mIsPositive ? mIndex + 1 : mIndex - 1;
        final boolean hasNext = index >= 0 && index < mListCopy.size();
        if (!hasNext)
        {
            prepare(null);
        }
        return hasNext;
    }

    @Override
    public T next()
    {
        mIndex = mIsPositive ? mIndex + 1 : mIndex - 1;
        mCurrent = mListCopy.get(mIndex);
        return mCurrent;
    }

    @Override
    public void remove()
    {
        mList.remove(mCurrent);
    }
}
