import java.util.Arrays;

public class Startup {
    /**
     * Returns true if the given word length and its index are both odd or both even.
     * @param arr strings
     * @return array of booleans
     */
    public static boolean[] arrEvenOdd(String[] arr) {

        // declare vars
        String word;

        // this will be the returned list of booleans
        boolean[] parities = new boolean[arr.length];


        for (int i = 0; i < arr.length; i++) {
            word = arr[i];
            parities[i] = (word.length() % 2) == (i % 2);
        }

        return parities;
    }

    /**
     * Program "filters" the digits from a given string using ascii values.
     *
     * @param input any string
     * @return the string with all digits 1-9 removed
     */
    public static String removeDigits(String input) {

        // declare variables
        final int dig = 57;
        char currentChar;
        String filteredInput = "";

        // parse through the given input string
        for (int i = 0; i < input.length(); i++) {

            // get the current character
            currentChar = input.charAt(i);

            // only append non-digit strings to the returned string
            int ascii = currentChar;
            if (ascii > dig) {
                filteredInput += currentChar;
            }
        }
        return filteredInput;
    }

    /**
     * Program recursively calculates the mass of the given compound.
     *
     * @param compound any string
     * @return the mass (int) of the given compound
     */
    public static int compoundMass(String compound) {

        // declare variables
        char elem;
        int elemCount;
        int subcompoundMass;
        final int elemIndex = 0;
        final int elemCountIndex = 1;
        final int toMass = 64;
        final int nextSubcompound = 2;

        // if no remaining sub-compounds, terminate recursion and calculate total mass
        if (compound.isEmpty()) {
            return 0;
        }

        // otherwise:
        // get the first sub-compound's element and element count
        elem = compound.charAt(elemIndex);
        elemCount = Character.getNumericValue(compound.charAt(elemCountIndex));

        // get the ascii value of the element's character to find its mass
        int elemMass = elem;
        elemMass -= toMass;

        // find the mass of the sub-compound
        subcompoundMass = elemMass * elemCount;

        // repeat for remaining compounds
        return subcompoundMass + compoundMass(compound.substring(nextSubcompound));
    }

    /**
     * Swaps the cases of all chars in given string via ascii values.
     *
     * @param input any string
     * @return a new string with swapped cases
     */
    public static String swapCase(String input) {

        // declare variables
        char character;
        final int upperA = 65;
        final int upperZ = 90;
        final int lowerA = 97;
        final int lowerZ = 122;

        // make the return string
        StringBuilder inputSwappedCase = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            // get character and its ascii value
            character = input.charAt(i);
            int asciiValue = character;

            String swappedCase = String.valueOf(character);

            // if a lowercase character, make uppercase
            if (asciiValue >= lowerA && asciiValue <= lowerZ) {
                inputSwappedCase.append(swappedCase.toUpperCase());

                // else if an uppercase character, make lowercase
            } else if (asciiValue >= upperA && asciiValue <= upperZ) {
                inputSwappedCase.append(swappedCase.toLowerCase());

                // if not an alphabetic character, remain same
            } else {
                inputSwappedCase.append(swappedCase.toLowerCase());
            }
        }
        return inputSwappedCase.toString();
    }

    /**
     * Program finds the absolute minimum value in a 2D matrix.
     *
     * @param matrix any 2D matrix
     * @return the minimum value (double) of the matrix
     */
    private static double findMin(double[][] matrix) {

        //declare variables
        double min;
        final int firstNum = 0;
        final int firstRow = 0;

        // set first entry as the minimum
        min = matrix[firstRow][firstNum];

        // iteratively compare the current minimum to all other entries
        for (double[] row : matrix) {
            for (double entry : row) {

                // if given entry less than the minimum, re-assign minimum
                if (entry < min) {
                    min = entry;
                }
            }
        }
        return min;
    }

    /**
     * Program finds the absolute maximum value in a 2D matrix.
     *
     * @param matrix any 2D matrix
     * @return the maximum value (double) of the matrix
     */
    private static double findMax(double[][] matrix) {

        //declare variables
        double max;
        final int firstNum = 0;
        final int firstRow = 0;

        // set first entry as the minimum
        max = matrix[firstRow][firstNum];

        // iteratively compare the current minimum to all other entries
        for (double[] row : matrix) {
            for (double entry : row) {

                // if given entry less than the minimum, re-assign minimum
                if (entry > max) {
                    max = entry;
                }
            }
        }
        return max;
    }

    /**
     * Program finds the midrange of any 2D matrix by averaging the matrix's
     * absolute minimum and absolute maximum values.
     *
     * @param max any double
     * @param min any double
     * @return the midrange (double) of the matrix
     */
    private static double findMidRange(double max, double min) {

        // declare variables
        final int numValues = 2;

        // average max and min values
        return (max + min) / numValues;
    }

    /**
     * Program binarizes the given 2D matrix by first calculating its midrange.
     * Then, matrix elements smaller than the midrange are changed to 0.
     * All other elements are changed to 1.
     *
     * @param matrix any 2D matrix
     * @return the 2D binarized matrix of ints
     */
    public static int[][] binarizeMatrixByMidrange(double[][] matrix) {

        double min;
        double max;
        double midrange;
        double currNum;
        final int column = 0;

        // find the midrange
        min = findMin(matrix);
        max = findMax(matrix);
        midrange = findMidRange(max, min);

        // make empty matrix with same dimensions as input matrix
        int[][] binarizedMatrix = new int[matrix.length][matrix[column].length];

        for (int rowNum = 0; rowNum < matrix.length; rowNum++) {

            // get row and row length
            double[] row = matrix[rowNum];
            int numEntries = row.length;

            // parse through each entry
            for (int entry = 0; entry < numEntries; entry++) {

                // get current entry
                currNum = row[entry];

                // if current entry is greater than or equal to midrange, change entry to 1
                if (currNum >= midrange) {
                    binarizedMatrix[rowNum][entry] = 1;

                    // if current entry is less than midrange, change entry to 0
                } else if (currNum < midrange) {
                    binarizedMatrix[rowNum][entry] = 0;
                }
            }
        }
        return binarizedMatrix;
    }


    /**
     * Program returns true if set1 is a subset of set2 and returns false if otherwise.
     *
     * @param set1 any array of ints
     * @param set2 any array of ints
     * @return boolean t/f
     */
    public static boolean subsetChecker(int[] set1, int[] set2) {

        // convert arrays to strings for easier comparison
       for (int item: set1) {
        if (!Arrays.asList(set2).contains(item)) {
            return false;
        }
       }

        return true;
    }

    /**
     * Program averages entry values of any given 2D matrix.
     *
     * @param matrix any 2D matrix of doubles
     * @return average (int) of matrix entries
     */
    private static double findGrandAverage(double[][] matrix) {

        // declare variables
        double sum = 0;
        double numValues = 0;
        double grandAverage;

        // find sum of entries and number of entries
        for (double[] row: matrix) {
            for (double entry: row) {
                sum += entry;
                numValues += 1;
            }
        }
        grandAverage = sum / numValues;
        return grandAverage;
    }

    /**
     * Program averages entry values of any given array.
     *
     * @param row any 2D matrix of doubles
     * @return average (int) of row entries
     */
    private static double findAverage(double[] row) {

        // declare variables
        double sum = 0;
        double numValues = 0;
        double average;

        // find sum of entries and number of entries
        for (double entry: row) {
            sum += entry;
            numValues += 1;
        }
        average = sum / numValues;

        return average;
    }

    /**
     * Program counts the number of rows which have an average smaller than the
     * grand average of all numbers in the given data.
     *
     * @param data any 2D matrix of doubles
     * @return number (int) of rows with relatively smaller average
     */
    public static int countSmallRows(double[][] data) {

        // number of rows with avg smaller than grand avg initialized to 0
        int smallAverageRows = 0;

        // find grand average
        double grandAverage = findGrandAverage(data);

        // compare each row's average to the grand average
        for (double[] dataRow: data) {

            /* if the row's average is less than the grand average,
               increment smallAverageRows by 1 */
            if (findAverage(dataRow) < grandAverage) {
                smallAverageRows += 1;
            }
        }
        return smallAverageRows;
    }

    private static int findFamily(char digit, String[] families) {

        // declare variables
        int digitFamily = 0;

        for (int family = 0; family < families.length; family++) {
            if (families[family].contains(String.valueOf(digit))) {
                digitFamily = family;
                break;
            }
        }
        return digitFamily;
    }

    /**
     * Program checks that all digits in given number are in the same row or column
     * of a numpad where the rows and columns are as follows:
     *
     * row 1 contains digit 0
     * row 2 contains digits 1-3
     * row 3 contains digits 4-6
     * row 4 contains digits 7-9
     *
     * column 1 contains digits 0, 1, 4 and 7
     * column 2 contains digits 0, 2, 5 and 8
     * column 4 contains digits 0, 3, 6 and 9
     *
     * @param num any integer
     * @return true if all digits in num are in the same row or column and
     *         false if otherwise
     */
    public static boolean numpadSRC(int num) {

        // declare variables
        String numString;
        char digit;
        int digitRow;
        int digitColumn;
        char nextDigit;
        String remainingDigits;
        int nextDigitRow;
        int nextDigitColumn;
        final int next = 1;
        final String[] rows = {"0", "123", "456", "789"};
        final String[] columns = {"0147", "0258", "0369"};

        // convert the int into a string
        numString = String.valueOf(num);

        // get the first digit
        digit = numString.charAt(0);

        // get remaining digits
        remainingDigits = numString.substring(next);

        // find the first digit's position
        digitRow = findFamily(digit, rows);
        digitColumn = findFamily(digit, columns);


        for (int i = 0; i < remainingDigits.length(); i++) {

            // iteratively find the remaining digits' positions
            nextDigit = remainingDigits.charAt(i);
            nextDigitRow = findFamily(nextDigit, rows);
            nextDigitColumn = findFamily(nextDigit, columns);

            /* if any digit resides in a different row or column from the
               first digit, break the loop and return false */
            if (digitRow != nextDigitRow) {
                if (digitColumn != nextDigitColumn) {
                    return false;
                }

                // otherwise, continue checking the digits' positions
            } else {
                continue;
            }
        }

        // if all digits reside in the same row or column, return true
        return true;
    }

    public static void main(String[] args) {
        // test arrEvenOdd()
        String[] strings = {"odd", "even", "odd", "odd"};
        for (boolean parityIsSame:arrEvenOdd(strings)) {
            System.out.println(parityIsSame);
        }

        // test removeDigits()
        System.out.println(removeDigits("P1n3appl3391093890410380291s"));

        // test compoundMass()
        System.out.println(compoundMass("C1D2A3B4"));

        // test swapCase()
        System.out.println(swapCase("abcdefg, hijklmn, OPQRST, UVWXYZ!"));

        // test binarizeMatrixByMidrange()
        double[][] matrix = {{-1.8, -2.3}, {-7.4, -3.9}};
        int[][] binarizedMatrix = binarizeMatrixByMidrange(matrix);
        for (int[] row: binarizedMatrix) {
            for (int entry: row) {
                System.out.println(entry);
            }
        }

        // test subsetChecker()
        int[] set1 = {2, -3};
        int[] set2 = {1, -2, -3};
        System.out.println("subset:" + subsetChecker(set1, set2));

        // test countSmallRows()
        double[][] data = {{0.0, 0.0, 0.0}, {11.1, 22.2, 33.3}, {0.0, 0.0, 0.0}};
        System.out.println(countSmallRows(data));

        //test numPadSRC()
        System.out.println(numpadSRC(1000151));

        char test = 'a';
        int ascii = test;
        System.out.println(ascii);
    }
}
