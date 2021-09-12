package com.A1;

import java.io.IOException;

public class Main {

    public static void main(String[] argv) {

        //System.out.println("Questão 1: Imprima os 15 primeiros dígitos de fibonacci");
        //fibonacci();
        //primes();
        //ASCII();
        //PI();
    }

    private static void fibonacci() {
        int x;
        int [] fibo = new int[15];

        // O primeiro e segundo termo na sequencia de fibonacci são iguais a 1
        fibo[0] = 1;
        fibo[1] = 1;

        for(x = 2; x < 15; x++) {
            fibo[x] = fibo[x-1] + fibo[x-2]; // Fibo: n = n-1 + n-2, para x > 1
        }

        System.out.println("Fibonacci Sequence:");
        for (x = 0; x < fibo.length; x++) {
            System.out.println(x+1+": "+fibo[x]);
        }
    }

    private static void primes() {
        int x, count = 1;
        boolean prime = false;
        System.out.println("Os números primos entre 1 e 100 são (2 e 3 não listados):");
        for (int i = 0; i < 100; i++) {
            /* O maior número que pode ser multiplicado
                para se encontrar um valor é a sua raiz,
                pois será o máximo multiplicável até se
                repetirem valores
                ex: múltiplos de 9

                    1x9
                    3x3
                    9x1

                Então, entende-se que após determinado valor, as múl-
                tiplicações se repetem, e esse valor é a raiz quadrada
                do número.
              */
            for (x = 2; x <= Math.sqrt(i); x++) { // Se for divisível por outro valor menor que a raiz, então não é primo
                if (i % x == 0) {
                    prime = false;
                    break;
                }
                prime = true;
            }
            if (prime) {
                System.out.println("Primo "+count+" - "+i);
                count++;
            }

        }
    }

    private static void ASCII() {
        int x;
        for(x=32; x<=255; x++) {
            char charX = (char) x;
            System.out.println("O valor "+x+" é equivalente a '"+charX+"' na tabela ASCII.");
        }
    }

    private static void PI() {
        /*
           Através da observação de Leibniz, a fórmula de formação
           do pi foi definida, sendo encontrado quando multiplicamos 4 por 1 menos
           a quantidade enésima de 1/n, sendo n ≥ 3 e sempre ímpar, ou seja,
           aumentando na proporção de n+2, infinitamente. Lembrando que o
           sinal também é trocado a cada nova iteração, iniciando com positivo.
        * */
        boolean signal = true;
        float pi = 0;
        //permitir o usuário escolher a qtd de iterações
        for(float cnt = 3; cnt < 1_000_000; cnt += 2) {
            if(signal) {
                pi = pi + 1 / cnt;
            } else {
                pi = pi - 1 / cnt;
            }
            signal = signal ? false : true;
        }
        pi = (float) 4 * (1-pi);
        System.out.println("O valor de pi, através da lei de Leibniz é "+pi);
    }
}