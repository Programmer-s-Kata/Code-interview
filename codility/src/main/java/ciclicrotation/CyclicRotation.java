package ciclicrotation;

public class CyclicRotation {

    private static boolean checkShifts(int shifts) {
        return shifts >= 0 && shifts <= 100;
    }

    private static boolean checkArrayElement(int element) {
        return element >= -1000 && element <= 1000;
    }

    public int[] solution(int[] arr, int shifts) {
        int length = arr.length;
        int[] rotatedArr = new int[length];
        if (!checkShifts(shifts)) {
            return rotatedArr;
        }

        for (int index = 0; index < length; index++) {
            if (!checkArrayElement(arr[index])) {
                return new int[length];
            }
            //use mod
            int newPosition = (index + shifts) % length;
            rotatedArr[newPosition] = arr[index];
        }
        return rotatedArr;
    }
}
