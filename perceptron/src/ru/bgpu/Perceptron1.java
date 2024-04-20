package ru.bgpu;

public class Perceptron1 {
    double[] enters;
    double outer;
    double[] weights;

    double[][] patterns = {
            {0, 0, 0},
            {0, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
    };
    double[][] TestEnter = {
            {1, 1,0},
            {0, 0,0},
            {0, 1,0},
            {1, 0,0},
            {1, 1,0},
            {0, 0,0},
            {0, 1,0},
            {1, 0,0},
            {1, 1,0},
            {0, 0,0},
            {0, 1,0},
            {1, 0,0},

    };

    public Perceptron1() {
        enters = new double[2];
        weights = new double[enters.length];
        for (int i = 0; i < enters.length; i++) {
            weights[i] = Math.random() * 0.2 + 0.1;
        }
    }

    public void countOuter () {
        outer = 0;
        for (int i = 0; i < enters.length; i++) {
            outer += enters[i] * weights[i];
        }
        if (outer > 0.5) outer = 1; else outer = 0;
    }
    public int study () {
        double gError = 0;
        int iterations = 0;
        do{
            iterations++;
            gError = 0;
            for (int p = 0; p < patterns.length; p++) {
                enters = java.util.Arrays.copyOf(patterns[p], patterns[p].length - 1);
                countOuter();
                double error = patterns[p][2] - outer;
                gError += Math.abs(error);
                for (int i = 0; i < enters.length; i++) {
                    weights[i] += 0.1 * error * enters[i];
                }
            }
            System.out.println(iterations + " Итерация");
        }while (gError != 0);
        return iterations;
    }
    public void test() {
        study();
        System.out.println("Начало тестирования");
        for (int p = 0; p < TestEnter.length; p++) {
            enters = java.util.Arrays.copyOf(TestEnter[p], TestEnter[p].length - 1);
            countOuter();
            System.out.println(outer);
        }
        System.out.println("Конец тестирования");
    }
    public static void main(String[] args) {
        new Perceptron1().test();
    }
}




