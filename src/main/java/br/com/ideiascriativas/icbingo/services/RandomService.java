package br.com.ideiascriativas.icbingo.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class RandomService {

    private Random random;

    public RandomService() {
        this.random = new Random();
    }

    public int[] randomLine(int quantityPerLine, int rangeNumber, int minNumber) {
        int[] line = new int[quantityPerLine];
        int generate = 0;
        for (int i = 0; i < quantityPerLine; i++) {
            while (generate == 0 || isRepeat(line, generate, i)) {
                generate = randomBetween(rangeNumber, minNumber);
            }
            line[i] = generate;
            generate = 0;
        }
        orderCrescent(line);
        return line;
    }

    private int randomBetween(int rangeNumber, int min) {
        return this.random.nextInt(rangeNumber) + min;
    }

    private boolean isRepeat(int[] line, int numberGenerate, int size) {
        if (size == 0) return false;
        for (int i = 0; i < size; i++) {
            if (line[i] == numberGenerate){
                return true;
            }
        }
        return false;
    }

    private void orderCrescent(int[] line) {
        Arrays.sort(line);
    }
}
