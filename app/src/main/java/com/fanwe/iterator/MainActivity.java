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

    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillList();
        doNext(true);
        doPrevious(true);
    }

    private void fillList()
    {
        for (int i = 0; i < 5; i++)
        {
            mList.add(String.valueOf(i));
        }
    }

    /**
     * 正序遍历
     */
    private void doNext(boolean log)
    {
        FIterator<String> it = new FListIterator<>(mList);
        it.prepare(true); //准备正序遍历
        while (it.hasNext())
        {
            String item = it.next();
            if (log)
            {
                Log.i(TAG, item);
            }
        }
    }

    /**
     * 倒序遍历
     */
    private void doPrevious(boolean log)
    {
        FIterator<String> it = new FListIterator<>(mList);
        it.prepare(false); //准备倒序遍历
        while (it.hasNext())
        {
            String item = it.next();
            if (log)
            {
                Log.e(TAG, item);
            }
        }
    }
}
