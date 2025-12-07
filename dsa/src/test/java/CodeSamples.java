import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CodeSamples {

    /**
     * Note: If an array is converted to list? The list operations like clear
     * and remove can not be performed on such a list.
     */
    public void removeRangeFromList(List list, int start, int end) {
        //list.removeAll(list.subList(start, end)); // concise way of doing what's been done down here
        Object[] arr = list.toArray();

        list.clear();
        for (int i = 0; i < arr.length; i++) {
            if (i >= (start - 1) && i < end) {
                continue;
            }
            list.add(arr[i]);
        }
    }

    @Test
    public void testRemoveRangeFromList() {
        List list = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        int startIndex = 5, endIndex = 7;
        System.out.println("Removing a range of values from this list ");
        list.forEach(System.out::print);
        removeRangeFromList(list, startIndex, endIndex);
        System.out.println("After removing from index : " + startIndex + " to " + endIndex);
        list.forEach(System.out::print);
    }

    /**
     * @param chessBoard
     * @return
     */
    public Map<String, Integer> missingChessPieces(String[][] chessBoard) {
        Map<String, Integer> chessPieces = new HashMap<>();
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] != null) {
                    if (chessPieces.containsKey(chessBoard[i][j])) {
                        chessPieces.put(chessBoard[i][j], chessPieces.get(chessBoard[i][j]) + 1);
                    } else {
                        chessPieces.put(chessBoard[i][j], 1);
                    }
                }
            }
        }
        return chessPieces;
    }

    @Test
    public void testMissingChessPieces() {
        String[][] chessBoard = {{null, "W_KI"}, {}, {}, {}, {}, {}, {}, {}};
        Map<String, Integer> map = missingChessPieces(chessBoard);
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s + ":" + map.get(s));
        }
    }

    @Test
    public void testSpiral() {
        int n = 4;

        // create n-by-n array of integers 1 through n
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = 1 + n * i + j;

        // print n-by-n array of integers 1 through n
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%2d ", a[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // spiral
        for (int i = n - 1, j = 0; i > 0; i--, j++) {
            for (int k = j; k < i; k++)
                System.out.println(a[j][k]);
            for (int k = j; k < i; k++)
                System.out.println(a[k][i]);
            for (int k = i; k > j; k--)
                System.out.println(a[i][k]);
            for (int k = i; k > j; k--)
                System.out.println(a[k][j]);
        }

        // special case for middle element if n is odd
        if (n % 2 != 0) System.out.println(a[(n - 1) / 2][(n - 1) / 2]);
    }
}