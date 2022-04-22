package CodeSchool;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.print("Player1 Name: ");
        String player1Name = sc.nextLine();
        int card1[] = new int[9];

        System.out.print("Player2 Name: ");
        String player2Name = sc.nextLine();
        int card2[] = new int[9];

        creatCard(card1, player1Name);
        creatCard(card2, player2Name);
        System.out.println();

        //Creat Pocket, where the numbers are filled
        int pocket[] = new int[89];

        for (int i = 0; i < 89; i++) {
            pocket[i] = i + 1;
        }

        //Run
        for (int i = 0; i < 89; i++) {

            int number = rand.nextInt(1, 90);

            if (pocket[number - 1] != 0) {
                System.out.println("Number: " + number);
                if (card1[number / 10] == number) {
                    card1[number / 10] = 0;
                }
                if (card2[number / 10] == number) {
                    card2[number / 10] = 0;
                }

                pocket[number - 1] = 0;


                int s1 = 0;
                int s2 = 0;

                for (int j = 0; j < 9; j++) {
                    s1 += card1[j];
                    s2 += card2[j];

                    if (s1 > 0 && s2 > 0) {
                        break;
                    }
                }

                showCard(card1, player1Name);
                showCard(card2, player2Name);
                System.out.println();

                if (s1 == 0 || s2 == 0) {
                    if (s1 == 0) {
                        System.out.println(player1Name + " WIIIN!!");
                    }

                    if (s2 == 0) {
                        System.out.println(player2Name + " WIIIN!!");
                    }
                    break;
                }

            } else {
                i--;
            }
        }


    }


    //Creat Card method
    public static void creatCard(int card[], String playerName) {
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            int number = rand.nextInt(1, 90);

            if (card[number / 10] == 0) {
                card[number / 10] = number;
            } else {
                i--;
            }

        }

        showCard(card, playerName);
    }


    //Show card method
    public static void showCard(int card[], String playerName) {

        System.out.print(playerName + ": ");
        for (int i = 0; i < card.length; i++) {
            System.out.print(card[i] + "  ");
        }
        System.out.println();

    }
}
