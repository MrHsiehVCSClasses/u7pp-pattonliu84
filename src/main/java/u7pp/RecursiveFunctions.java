package u7pp;

public class RecursiveFunctions {
    
    public static double factorial(int n) {
        //Keeps multiplying n-1 until reaches 0. 
        if (n < 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static double pow(double base, int power) {
        if (power == 0) {
            return 1.0;
        } else {
        //keeps multiplying by the power
            return base * pow(base, power - 1);
        }
    }

    public static int fibonacci(int n){
        if (n <= 1)
            return n;
 
        return fibonacci(n - 1)
            + fibonacci(n - 2);
    }



    public static boolean isPalindrome(String string) {
        // If only 1 char, then true
        if (string.length() <= 1) {
            return true;
        }
        
        // Check if the first and last characters of the string are equal
        char f = string.charAt(0);
        char l = string.charAt(string.length() - 1);
        if (f != l) {
            return false;
        }
        
        String sub = string.substring(1, string.length() - 1);
        return isPalindrome(sub);
    }

    public static int nextIsDouble(int[] arr, int index) {
        // Last index of the array and there are no more pairs to check
        if (index == arr.length - 1 || (arr.length == 0)) {
            return 0;
        }
        
        // Check if the next element is double the current element
        if (arr[index] * 2 == arr[index + 1]) {
            // Add 1 to the count and recursively check the next pair
            return 1 + nextIsDouble(arr, index + 1);
        } else {
            return nextIsDouble(arr, index + 1);
        }
    }

    public static String getBinary(int num) {
        if (num == 0) {
            return "0";
        } else if (num == 1) {
            return "1";
        //Using my CSP poster I made earlier, converting numbers to binary. 
        } else {
            return getBinary(num / 2) + Integer.toString(num % 2);
        }
    }

    public static int binarySearch(int[] arr, int val, int start, int end) {
        if (start > end) {
            return -1; 
        }
        // binary searches for the midpoint. 
        int mid = (start + end) / 2;
        
        if (arr[mid] == val) {
            return mid;
        } else if (arr[mid] < val) {
            return binarySearch(arr, val, mid + 1, end); // search right half of array
        } else {
            return binarySearch(arr, val, start, mid - 1); // search left half of array
        }
    }

    public static boolean canFlowOffMap(int[][] map, int row, int col) {
        int numRows = map.length;
        int numCols = map[0].length;
    
        // Current cell is on the border of the map
        if (row == 0 || col == 0 || row == numRows - 1 || col == numCols - 1) {
            return true;
        }
    
        // In all four directions, check if there is a value lower than the one its on, 
        //Keeps doing this until it reaches edge of the board. 
        if (row > 0 && map[row - 1][col] < map[row][col] && canFlowOffMap(map, row - 1, col)) {
            return true;
        }
        if (col > 0 && map[row][col - 1] < map[row][col] && canFlowOffMap(map, row, col - 1)) {
            return true;
        }
        if (row < numRows - 1 && map[row + 1][col] < map[row][col] && canFlowOffMap(map, row + 1, col)) {
            return true;
        }
        if (col < numCols - 1 && map[row][col + 1] < map[row][col] && canFlowOffMap(map, row, col + 1)) {
            return true;
        }
        return false;
    }
}
