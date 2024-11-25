package arrlistlen;

public class ArrListLen {

    public int solution(int[] A) {
        int length = 0;  // To store the length of the linked list
        int currentIndex = 0;  // Start from the first node (index 0)

        // Traverse the linked list until we encounter -1 (end of the list)
        while (A[currentIndex] != -1) {
            length++;  // Increment the length as we move to the next node
            currentIndex = A[currentIndex];  // Move to the next node in the list
        }

        // Count the last node, which is at index 'currentIndex' and has value -1
        length++;  // Add the last node to the count
        return length;  // Return the length of the linked list
    }

}
