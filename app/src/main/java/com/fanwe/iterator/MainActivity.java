package com.fanwe.iterator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fanwe.lib.iterator.FIterator;
import com.fanwe.lib.iterator.FListIterator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = MainActivity.class.getSimpleName();

    private List<Integer> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillList();
        doPositive(true);
        doReverse(true);
    }

    private void fillList()
    {
        for (int i = 0; i < 20; i++)
        {
            mList.add(i);
        }
    }

    /**
     * 正序遍历
     */
    private void doPositive(boolean log)
    {
        FIterator<Integer> it = new FListIterator<>(mList);
        while (it.hasNext())
        {
            Integer item = it.next();
            if (log)
            {
                Log.i(TAG, String.valueOf(item));
            }
        }
    }

    /**
     * 倒序遍历
     */
    private void doReverse(boolean log)
    {
        FIterator<Integer> it = new FListIterator<>(mList);
        it.prepare(false); //准备倒序遍历
        while (it.hasNext())
        {
            Integer item = it.next();
            if (log)
            {
                Log.e(TAG, String.valueOf(item));
            }
        }
    }
}
