package Codeforces.AvitoChallenges2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class B_Farewell_Party {
    public static void main(String[] args) {
        InputReader input = new InputReader(System.in);

        int n = input.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = input.nextInt();
        }

        String result = solve(n, A);
        System.out.println(result);
    }

    private static String solve(int n, int[] A) {
        List<ArrayList<Integer>> array = new ArrayList<>();
        array.add(new ArrayList<>());

        for (int i : A) {
            array.add(new ArrayList<>());
        }

        for (int i = 0; i < A.length; i++) {
            array.get(n - A[i]).add(i);
        }

        boolean isPossible = true;
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < n + 1; i++) {
            if (array.get(i).size() % i != 0)
                isPossible = false;
        }

        int[] hats = new int[n];
        int hatKind = 1;
        if (isPossible) {
            result.append("Possible\n");
            for (int i = 1; i < n + 1; i++) {
                ArrayList<Integer> persons = array.get(i);
                for (int j = 0; j < persons.size(); j++) {
                    hats[persons.get(j)] = hatKind;

                    if ((j + 1) % i == 0) hatKind ++;
                }
            }

            for (int i : hats) {
                result.append(Integer.toString(i)).append(" ");
            }
        } else {
            result.append("Impossible");
        }

        return result.toString();
    }


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
