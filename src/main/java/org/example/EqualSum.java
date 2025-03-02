package org.example;

import java.util.*;


public class EqualSum {
    public static void main(String[] args) {
        EqualSum sum = new EqualSum();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(4);
        input.add(7);
        input.add(1);
        input.add(2);
        input.add(9);
        input.add(8);
        ArrayList<Integer> result = sum.equal(input);
        System.out.println(result);
    }


    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        int arraySize = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < arraySize; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                int key = A.get(i) + A.get(j);

                if (map.containsKey(key)) {
                    int[] pair = map.get(key);
                    int p1 = pair[0];
                    int p2 = pair[1];

                    if (p1 < i && p2 != i && p2 != j) {
                        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(p1, p2, i, j));
                        if (result.isEmpty() || isLexicographicallySmaller(temp, result)) {
                            result = temp;
                        }
                    }
                } else {
                    map.put(key, new int[]{i, j});
                }
            }
        }
        return result;
    }

    private boolean isLexicographicallySmaller(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return false;
    }
}

