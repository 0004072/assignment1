package com.hsenid.assignment1;

import com.sun.javafx.binding.StringFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2
{
    private static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

    public static void main( String[] args ) throws IOException
    {
        multTbl();
    }

    /**
     * Generates multiplication table based on the user's inputs.
     * @throws IOException if a problem occurred in I/O.
     */
    public static void multTbl() throws IOException{
        int span = 0, step = 0;
        String input = new String();
        while(true){
            System.out.print("Enter the span that your table should have:");
            System.out.flush();
            input = buf.readLine();
            if(input.matches("^\\d{1,2}")){
                span = Integer.parseInt(input);
                if(span <= +10 && span > 0)
                    break;
            }
            System.out.println("Invalid value! Should be in between 0 & +10!");
        }

        while(true){
            System.out.print("Enter the step size:");
            System.out.flush();
            input = buf.readLine();
            if(input.matches("^[+-]?\\d{1,2}")){
                step = Integer.parseInt(input);
                if(step <= +10 && step >= -10)
                    break;
            }
            System.out.println("Invalid value! Should be in between -10 & +10 except zero!");
        }

        System.out.println(span);
        for (int i = 0; i <= span; i++) {
            //System.out.print(String.format("%1$"+4+"s", String.format("%d|", i)));
            for (int j = 0; j <= span*step; j+=step) {
                String tmp = "";
                if (i == 0)
                    if (j == 0)
                        tmp += "x";
                    else
                        tmp = Integer.toString(j);
                else if (j == 0)
                    tmp = Integer.toString(i);
                else
                    tmp = Integer.toString(i * j);

                String val = String.format("%s", tmp);
                val = String.format("%1$" + 3 + "s", val);
                if(j == 0)
                    val = String.format("%s |", val);
                System.out.print(val);
            }

            if (i == 0) {
                System.out.println();
                for(int j = 0; j <= span*step; j+=step){
                    String str = "---";
                    if(j == 0)
                        str = "-----";
                    System.out.print(str);
                }
            }
            System.out.println();
        }
    }
}
