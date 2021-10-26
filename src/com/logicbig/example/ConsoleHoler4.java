package com.logicbig.example;
// https://www.logicbig.com/how-to/code-snippets/jcode-java-command-line-animation <- inspiration to whole class

public class ConsoleHoler4 {
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
               print("Press 1 -SAVE\n_________________________________________________\n");
                break;
            case 2:
                print("Press 3 - EXIT\n_________________________________________________\n");
                break;
            case 3:
                print("Please type a letter to guess:\n_________________________________________________\n");
                break;
            default:
                anim = 0;
                print("                                           ");
        }
        anim++;
    }

    public static void main() throws InterruptedException {
        ConsoleHoler4 consoleHelper1 = new ConsoleHoler4();
        for (int i = 0; i < 4; i++) {
            consoleHelper1.animate(   i + "");
            Thread.sleep(400);
            //simulate a piece of task
        }
    }
}


