package binarygap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryGap {

    @SuppressWarnings("PMD.AvoidReassigningParameters")
    public int solution(int number) {
        var stack = new Stack<Integer>();
        List<Integer> binaryRepresentation = new ArrayList<>();
        while (number > 0) {
            stack.push(number % 2);
            number = number / 2;
        }

        while (!stack.isEmpty()) {
            binaryRepresentation.add(stack.pop());
        }

        int longestBinaryGap = 0;
        int currentBinaryGap = 0;
        for (Integer binaryNumber : binaryRepresentation) {
            int currentNumber = binaryNumber;
            if (currentNumber == 1) {
                if (currentBinaryGap > longestBinaryGap) {
                    longestBinaryGap = currentBinaryGap;
                }
                currentBinaryGap = 0;
            } else {
                currentBinaryGap++;
            }
        }

        return longestBinaryGap;
    }
}
