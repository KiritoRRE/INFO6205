package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFClient {

    public static int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n, true);
        Random rand = new Random();
        int connections = 0;

        while (uf.components() > 1) {
            int p = rand.nextInt(n);
            int q = rand.nextInt(n);
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
            connections++;
        }
        return connections;
    }

    public static void main(String[] args) {
        int n = 0;
        int trials = 3;

        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
                if (args.length > 1) {
                    trials = Integer.parseInt(args[1]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Arguments must be integers.");
                System.exit(1);
            }
            runMultipleTrials(n, trials);
        } else {
            int[] testValues = {1, 10, 25, 40, 80, 100, 250, 300, 587, 790, 900, 1024};
            for (int testValue : testValues) {
                runMultipleTrials(testValue, trials);
            }
        }
    }

    private static void runMultipleTrials(int n, int trials) {
        System.out.printf("Running %d trials for n = %d...\n", trials, n);
        for (int i = 0; i < trials; i++) {
            int connections = count(n);
            System.out.printf("Trial %d: Number of connections generated: %d\n", (i + 1), connections);
        }
    }
}
