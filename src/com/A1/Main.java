package com.A1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] argv) {

        //System.out.println("Questão 1: Imprima os 15 primeiros dígitos de fibonacci");
        //fibonacci();
        //primes();
        //ASCII();
        //PI();
        perfect();
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
        int x, cnt = 0;
        System.out.println("Os números primos entre 1 e 100 são:");
        for (int i = 2; i < 100; i++) {
            /* O maior número que pode ser multiplicado
                por outro para se encontrar um valor é a
                sua raiz, pois será o máximo multiplicá-
                vel até se repetirem valores novamente na
                ordem inversa.

                ex: múltiplos de 9

                    1x9
                    3x3
                    9x1

                Então, entende-se que após determinado valor, as múl-
                tiplicações se repetem. Se um número, dividido pelos
                valores que se sucedem a cada um até a sua raiz, re-
                tornar um mod == 0 para uma divisão, então esse núme-
                ro não é primo.
              */
            for (x = 1; x <= i; x++) {
                if(i % x == 0) {
                    cnt++;
                }
            }
            if(cnt == 2) {
                System.out.println(i+" é primo.");
            }
            cnt = 0;
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
            signal = !signal;
        }
        pi = (float) 4 * (1-pi);
        System.out.println("O valor de pi, através da lei de Leibniz com 1.000.000 iterações é "+pi);
    }

    private static void perfect(){
        // Um número perfeito é aquele que é a soma de todos os seus
        // divisores inteiros, sem contar com ele mesmo. A fórmula
        // usando os números primos de Mersenne é:
        // (2^p-1) * ((2^p)-1), sendo p um primo.

        int i = 0, cnt = 0;
        boolean prime = false;
        List<Double> list = new ArrayList<>();

        while(list.size() < 4) {
            i++;
            for (int x = 1; x <= i; x++) {
                if(i % x == 0) {
                    cnt++;
                }
            }

            if(cnt == 2) {
                list.add(Math.pow(2, i - 1) * (Math.pow(2, i) - 1));
            }
            cnt = 0;
        }
    System.out.println("Os primeiros 4 números perfeitos são: "+list);
    }
}