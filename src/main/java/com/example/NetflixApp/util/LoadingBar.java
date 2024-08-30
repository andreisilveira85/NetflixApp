package com.example.NetflixApp.util;

public class LoadingBar {

    public static void main(String[] args) {
        int totalSteps = 50;
        int sleepTime = 100;

        System.out.println("Loading...");

        for (int i = 0; i <= totalSteps; i++) {
            printLoadingBar(i, totalSteps);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nLoading Complete!");
    }

    public static void printLoadingBar(int currentStep, int totalSteps) {
        int barLength = 50;
        int progress = (currentStep * barLength) / totalSteps;

        StringBuilder bar = new StringBuilder();
        bar.append("\r[");
        for (int i = 0; i < barLength; i++) {
            if (i < progress) {
                bar.append("=");
            } else {
                bar.append(" ");
            }
        }
        bar.append("] ");
        bar.append(currentStep * 100 / totalSteps).append("%");

        System.out.print(bar.toString());
    }
}
