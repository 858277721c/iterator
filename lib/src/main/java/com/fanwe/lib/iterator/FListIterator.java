package com.fanwe.lib.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * List遍历器
 */
public class FListIterator<T> implements FIterator<T>
{
    private List<T> mList;
    private List<T> mListCopy;

    private Iterator<T> mIterator;

    public FListIterator(List<T> list)
    {
        mList = list;
    }

    @Override
    public void prepare(Boolean positive)
    {
        if (positive == null)
        {
            mListCopy = null;
            mIterator = null;
            return;
        }

        if (positive)
        {
            mIterator = mList.iterator();
        } else
        {
            if (mListCopy == null)
            {
                mListCopy = new ArrayList<>(mList);
            } else
            {
                mListCopy.clear();
                mListCopy.addAll(mList);
            }

            Collections.reverse(mListCopy);
            mIterator = mListCopy.iterator();
        }
    }

    @Override
    public boolean hasNext()
    {
        return mIterator.hasNext();
    }

    @Override
    public T next()
    {
        return mIterator.next();
    }

    @Override
    public void remove()
    {
        mIterator.remove();
    }
}
