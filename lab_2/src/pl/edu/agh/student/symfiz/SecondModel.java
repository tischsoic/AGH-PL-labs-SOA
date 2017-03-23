package pl.edu.agh.student.symfiz;

import java.util.Random;

public class SecondModel {
    static public String getGameResponse() {
        Random r = new Random();
        int random = r.nextInt(2);
        switch (random) {
            case 0:
                return "paper";
            case 1:
                return "scissors";
            case 2:
                return "stone";
        }

        return null;
    }
}
