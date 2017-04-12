package com.company;


import java.util.Iterator;
import java.util.Map;

/**
 * Created by Di on 12.04.2017.
 */
public class PrintEvery_5Sec extends Thread
{


    @Override
    public void run() {

        while (!DigitalGenerator.isIsEndWork())
        {
            Map<Integer, Integer> storeNum = DigitalGenerator.getStoreNum();

            synchronized (storeNum)
            {
                Iterator<Integer> iterator = storeNum.keySet().iterator();
                while (iterator.hasNext())
                {
                    Integer key = iterator.next();
                    Integer value = storeNum.get(key);
                    System.out.println("key - " + key + " repeats - " + value);
                }
            }
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
