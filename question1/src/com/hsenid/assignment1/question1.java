package com.hsenid.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question1 {
    private static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int arr[] = builder();
        arr = bubbleSort(arr);

        System.out.print("Choose your orientation to display the items(H=horizontal V=Vertical):");
        System.out.flush();
        String or = buf.readLine();
        if (!or.matches("^[hHvV]$"))
            System.out.println("Invalid orientation! Using default...");
        for (int i : arr) {
            switch (or) {
                case "h":
                case "H":
                    System.out.print(i + " ");
                    break;

                case "v":
                case "V":
                    System.out.println(i);
                    break;

                default:
                    System.out.print(i + " ");
            }

        }
    }

    private static int[] bubbleSort(int arr[]) {
        while (true) {
            boolean swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swapped = true;
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
            if (!swapped)
                break;
        }

        return arr;
    }

    private static int[] builder() throws IOException {
        StringBuffer input = new StringBuffer();

        cont_add:
        while (true) {
            System.out.print("Insert the numbers you need sorted, one at a time:");
            System.out.flush();
            String num = buf.readLine();
            if (!num.matches("^[+-]?\\d+$"))
                System.out.println("Invalid number detected!");

            else
                input.append(num);

            while (true) {
                System.out.print("Continue adding?(Y/N):");
                System.out.flush();
                String cont = buf.readLine();
                switch (cont) {
                    case "Y":
                    case "y":
                        input.append(",");
                        continue cont_add;

                    case "n":
                    case "N":
                        break cont_add;
                }
            }

        }

        String[] arr = input.toString().split(",");
        int toSort[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            toSort[i] = Integer.parseInt(arr[i]);

        return toSort;
    }
}
