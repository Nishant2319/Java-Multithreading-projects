package com.example;

import java.util.Scanner;

public class Main {
    public static int ans[][]=new int[100][100];

    public static void main(String arge[]){
        Scanner sc=new Scanner(System.in);
        int rowA, rowB,colmA, colmB;
        int[][] A, B, TransB;
        A = new int[1000][1000];
        B = new int[1000][1000];
        TransB = new int[1000][1000];

        System.out.println("enter the no. row of first matrix");
        rowA=sc.nextInt();

        System.out.println("enter the no. column of first matrix");
        colmA=sc.nextInt();

        System.out.println("enter the elements for first matrix");
        for (int i=0;i<rowA;i++){
            for (int j=0;j<colmA;j++){
                A[i][j]=sc.nextInt();
            }
        }

        System.out.println("enter the no. row of second matrix");
        rowB=sc.nextInt();

        System.out.println("enter the no. column of second matrix");
        colmB=sc.nextInt();

        System.out.println("enter the elements for second matrix");
        for (int i=0;i<rowB;i++){
            for (int j=0;j<colmB;j++){
                B[i][j]=sc.nextInt();
            }
        }


        for (int i = 0; i < rowB; i++) {
            for (int j = 0; j < colmB; j++) {
                TransB[j][i] = B[i][j];
            }
        }

        Data.n=colmA;

        WorkerThread[] t=new WorkerThread[rowA*colmB];
        int n=0;
        for (int i=0;i<rowA;i++){
            for (int j=0;j<colmB;j++){
                Data d=new Data(i,j,A[i],TransB[j]);
                t[n]=new WorkerThread(d);
                t[n].start();
                n++;
            }
        }

        try {
            for (int i=0;i<rowA*colmB;i++)
                t[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("result matrix is ");
        for (int i=0;i<rowA;i++){
            for (int j=0;j<colmB;j++){
                System.out.print(ans[i][j]+"   ");
            }
            System.out.println();
        }

    }
}
