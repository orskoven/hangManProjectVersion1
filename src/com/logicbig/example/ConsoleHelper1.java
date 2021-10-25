package com.logicbig.example;
// https://www.logicbig.com/how-to/code-snippets/jcode-java-command-line-animation <- inspiration to whole class
import java.nio.charset.StandardCharsets;

public class ConsoleHelper1 {
    private String lastLine = "";



    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (char i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private byte anim;
    private byte anima = 3;

    public void animate(String line) {
        switch (anim) {
            case 1:
                print("_________________________________________________\n");
                break;
            case 2:
                print("        GOOD-                              |\n");
                break;
            case 3:
                print("            BYE                            😢\n");
                break;
            case 4:
                print("                                          -I-        \n");
                break;
            case 5:
                print("                                          / \\         \n");
                break;
            case 6:
                print("_________________________________________________\n");
                break;
            default:
                anim = 0;
                print("                                           ");
        }
        anim++;
    }

    public static void main() throws InterruptedException {
        ConsoleHelper1 consoleHelper1 = new ConsoleHelper1();
        for (int i = 0; i < 8; i++) {
            consoleHelper1.animate(   i + "");
            Thread.sleep(400);
            //simulate a piece of task
        }
    }
}

