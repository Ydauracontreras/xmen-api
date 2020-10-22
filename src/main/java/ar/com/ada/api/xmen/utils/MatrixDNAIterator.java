package ar.com.ada.api.xmen.utils;

import ar.com.ada.api.xmen.security.Crypto;

public class MatrixDNAIterator {

    public static boolean debugMode = false;
    private final static int MIN_SECUENCE = 4;

    public int matchesByRows(String[] dna) {
        char[][] m = toMatrix(dna);
        int matches = 0;

        // iteramos por fila
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (j + 4 >= m.length) {
                    break;
                }
                // SI A = B, y B = C, C = D, A = D?
                // A = B, A = C, A = D y B = D?
                if (m[i][j] == m[i][j + 1] && m[i][j] == m[i][j + 2] && m[i][j] == m[i][j + 3]) {
                    if (debugMode)
                        System.out.println("Secuencia Match Row: " + m[i][j] + m[i][j + 1] + m[i][j + 2] + m[i][j + 3]);
                    matches++;
                }
            }
        }

        return matches;

    }

    public int matchesByColumns(String[] dna) {
        char[][] m = toMatrix(dna);
        int matches = 0;

        // iteramos por columna
        for (int j = 0; j < m.length; j++) {
            for (int i = 0; i < m.length; i++) {

                if (i + 4 >= m.length) {
                    break;
                }
                // SI A = B, y B = C, C = D, A = D?
                // A = B, A = C, A = D y B = D?
                if (m[i][j] == m[i + 1][j] && m[i][j] == m[i + 2][j] && m[i][j] == m[i + 3][j]) {
                    if (debugMode)
                        System.out.println(
                                "Secuencia Match Column: " + m[i][j] + m[i + 1][j] + m[i + 2][j] + m[i + 3][j]);

                    matches++;
                }
            }
        }

        return matches;

    }

    public int matchesByDiagonals(String[] dna) {

        int matches = 0;
        if (debugMode)
            System.out.println("Secuencia Diagonal Izq a Derecha");

        matches = matchesByDiagonals(toMatrix(dna), false);

        if (debugMode)
            System.out.println("Secuencia Diagonal Derecha a izq");

        /*
         * if (matches > 1) //Descomentar para salir de una si no importa la cantidad de
         * matchs return matches;
         */

        matches += matchesByDiagonals(toMatrixInverted(dna), true);

        return matches;

    }

    private int matchesByDiagonals(char[][] m, boolean inverted) {

        int matches = 0;
        int matrixSize = m.length;

        if (debugMode) {
            System.out.println("Inverted Matrix: " + inverted);
            System.out.println(matrixToString(m));
        }

        // diagonales de izq a derecha
        for (int k = 0; k < m.length * 2; k++) {
            for (int j = 0; j <= k; j++) {
                int i = k - j;
                if (i < matrixSize && j < matrixSize) {
                    // Aca estoy en diagonal de izq a derecha.
                    if (debugMode)
                        System.out.println("i : " + i + " , j: " + j);
                    if (i + 1 - 4 < 0 || j + 4 - 1 >= matrixSize) {

                        if (debugMode) {
                            System.out.println("Sale");
                            System.out.println("i + 1 - 4 = " + (i + 1 - 4));
                            System.out.println("j + 4 - 1 = " + (j + 4));
                        }
                        continue;
                    }
                    // SI A = B, y B = C, C = D, A = D?
                    // A = B, A = C, A = D y B = D?
                    if (debugMode)
                        System.out.println(
                                "Secuencia Test: " + m[i][j] + m[i - 1][j + 1] + m[i - 2][j + 2] + m[i - 3][j + 3]);

                    if (m[i][j] == m[i - 1][j + 1] && m[i][j] == m[i - 2][j + 2] && m[i][j] == m[i - 3][j + 3]) {
                        if (debugMode)
                            System.out.println("Secuencia Match: " + m[i][j] + m[i - 1][j + 1] + m[i - 2][j + 2]
                                    + m[i - 3][j + 3]);

                        matches++;
                    }
                }
            }

        }

        return matches;
    }

    public static String matrixToString(char[][] matrix) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            sb.append("| ");
            for (int j = 0; j < matrix.length; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append(" |\n");
        }

        return sb.toString();

    }

    public boolean lettersOk(String[] dna) {
        for (String secuence : dna) {
            for (char letter : secuence.toCharArray()) {
                if (letter != 'A' && letter != 'T' && letter != 'C' && letter != 'G')
                    return false;
            }
        }

        return true;
    }

    public boolean isValid(String[] dna) {
        return this.dimensionIsOk(dna) && this.lettersOk(dna);

    }

    public char[][] toMatrix(String[] dna) {
        char[][] matrix = new char[dna.length][dna.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = dna[i].charAt(j);
            }
        }
        return matrix;
    }

    public boolean dimensionsIsOk(String[] dna) {
        Integer sequeceLenght = dna.length;
        if (sequeceLenght < 4)
            return false;
        for (String secuence : dna) {
            if (secuence == null || secuence.length() != sequeceLenght)
                return false;
        }
        return true;
    }

    public char[][] toMatrixInverted(String[] dna) {

        char[][] matrix = new char[dna.length][dna.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][matrix.length - j - 1] = dna[i].charAt(j);
            }
        }

        return matrix;
    }

    public String uniqueHash(String[] dna) {
        StringBuilder sb = new StringBuilder();
        for (String secuence : dna) {

            sb.append(secuence + "|");

        }
        String dnaToHash = sb.toString();

        String dnaHashed = Crypto.hash(dnaToHash, "Magneto Rulz");

        return dnaHashed;
    }

    public String[] encrypt(String[] dna) {

        String[] dnaEncrypted = new String[dna.length];
        for (int i = 0; i < dnaEncrypted.length; i++) {
            dnaEncrypted[i] = Crypto.encrypt(dna[i], "*");
        }
        return dnaEncrypted;
    }

    public String[] decrypt(String[] dna) {

        String[] dnaClear = new String[dna.length];
        for (int i = 0; i < dnaClear.length; i++) {
            dnaClear[i] = Crypto.decrypt(dna[i], "*");
        }
        return dnaClear;
    }

    public String toString(String[] dna) {
        StringBuilder sb = new StringBuilder();

        for (String secuence : dna) {
            sb.append("| ");
            sb.append(secuence);
            sb.append(" |\n");
        }
        return sb.toString();
    }

    private boolean dimensionIsOk(String[] dna) {
        // Tiene qeu ser NxN
        // String[] dnaMutant =
        // {"ATGCGAA","CAGTGCA","TTATGTA","AGAAGGA","CCCCTAA","TCACTGA","TCGAACT"};
        // String[] dnaMutant = {}
        int arrayLenghtSecuenceWord = dna.length;

        if (arrayLenghtSecuenceWord < MIN_SECUENCE)
            return false;

        for (String secuence : dna) {
            if (secuence == null || secuence.length() != arrayLenghtSecuenceWord)
                return false;
        }

        return true;
    }

}
