package com.example;

public class WorkerThread extends Thread{
    private Data data;
    WorkerThread(Data d){
        data=d;
    }

    @Override
    public void run() {
        int sum=0;
        for (int i=0;i<data.n;i++){
            sum+=data.arrA[i]*data.arrB[i];
        }
//        System.out.println(sum);
        Main.ans[data.i][data.j]=sum;
    }
}
