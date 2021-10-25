package com.logicbig.example;

public class ConsoleHelper1 {
    private String lastLine = "";

    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private byte anim;

    public void animate(String line) {
        switch (anim) {
            case 1:
            case 3:
                print("[" +
                        "\n_________________________________________________" +
                        "\n                                                 " +
                        "\n                  HANG MAN                       " +
                        "\n                MOVIE & FROG               o     " +
                        "\n                  EDITION                 -I-         " +
                        "\n                                          / \\            " +
                        "\n_________________________________________________ " +
                        "\n ]" + line);
                break;
            default:
                anim = 0;
            case 2:
                print("[" +
                        "\n_________________________________________________" +
                        "\n                                           |       " +
                        "\n                  HANG MAN                 o       " +
                        "\n                MOVIE & FROG              -I-      " +
                        "\n                  EDITION                 / \\          " +
                        "\n                                                      " +
                        "\n_________________________________________________ " +
                        "\n ]" + line);
                break;
        }
            anim++;
        }


    public static void main(String[] args) throws InterruptedException {
        ConsoleHelper1 consoleHelper = new ConsoleHelper1();
        for (int i = 0; i < 20; i++) {
            consoleHelper.animate(i + "");
            //simulate a piece of task
            Thread.sleep(400);
        }
    }
}