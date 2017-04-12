package com.company;

import java.util.*;


public class DigitalGenerator extends Thread
{
    private static Map<Integer, Integer> storeNum = new HashMap<>(2000);

    private Random randomGenerator = new Random();

    private static boolean isEndWork = false;

    private final int END_WORK_REPEATS = 5;

    public DigitalGenerator()
    {

    }


    @Override
    public void run() {

        while (!isEndWork)
        {
            Integer random = randomGenerator.nextInt(99);

            synchronized (storeNum)
            {
                if (storeNum.containsKey(random))
                {
                    int repeat = storeNum.get(random);
                    repeat++;
                    storeNum.put(random, repeat);
                    if (repeat >= END_WORK_REPEATS)
                    {
                        isEndWork = true;
                        System.out.println("END WORK \n key - " + random + " repeats - " + repeat);
                    }
                }
                else
                {
                    storeNum.put(random, 0);
                }
            }

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }

        }


    }



    public static Map<Integer, Integer> getStoreNum()
    {
        synchronized (storeNum)
        {
            return storeNum;
        }
    }

    public static boolean isIsEndWork() {
        return isEndWork;
    }
}
