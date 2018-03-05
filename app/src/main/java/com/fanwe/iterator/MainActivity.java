package com.fanwe.iterator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.fanwe.lib.iterator.FIterator;
import com.fanwe.lib.iterator.FListIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++)
                {
                    doPositive(false);
                }
                Log.i(TAG, "time:" + (System.currentTimeMillis() - start));
            }
        });
    }

    private void fillList()
    {
        for (int i = 0; i < 20; i++)
        {
            mList.add(i);
        }
    }

    private void doNormal(boolean log)
    {
        for (int i = 0, count = mList.size(); i < count; i++)
        {
            Integer item = mList.get(i);
            if (log)
            {
                Log.i(TAG, String.valueOf(item));
            }
        }
    }

    private void doForeach(boolean log)
    {
        for (Integer item : mList)
        {
            if (log)
            {
                Log.i(TAG, String.valueOf(item));
            }
        }
    }

    /**
     * 正序遍历
     */
    private void doPositive(boolean log)
    {
        FIterator<Integer> it = new FListIterator<>(mList);
        it.prepare(true); //准备正序遍历
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
