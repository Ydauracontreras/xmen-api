package ar.com.ada.utils;

public class MatrixDNAIterator {

    public boolean lettersOk(String[] dna) {
        for (String secuence : dna) {
            for (char letter : secuence.toCharArray()) {
                if (letter != 'A' && letter != 'T' && letter != 'C' && letter != 'G')
                    return false;
            }
        }

        return true;
    }

    public boolean isValid() {

        return true;
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
                matrix[j][i] = dna[i].charAt(j);
            }
        }

        return matrix;
    }

    public int matchesByRows(String[] dna) {
        char[][] m = toMatrix(dna);
        int matches = 0;
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                if (j + 4 >= dna.length) {
                    break;
                }
                // SI A = B, y B = C, C = D, A = D?
                // A = B, A = C, A = D y B = D?
                if (m[i][j] == m[i][j + 1] && m[i][j] == m[i][j + 2] && m[i][j] == m[i][j + 3]) {
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
                    matches++;
                }
            }
        }

        return matches;

    }

    public int matchesByDiagonals(String[] dna) {

        int matches = 0;
        matches = matchesByDiagonals(toMatrix(dna));

        /*
         * if (matches > 1) return matches;
         */

        matches += matchesByDiagonals(toMatrixInverted(dna));

        return matches;

    }

    private int matchesByDiagonals(char[][] m) {

        int matches = 0;
        int matrixSize = m.length;

        // diagonales de izq a derecha
        for (int k = 0; k < m.length * 2; k++) {
            for (int j = 0; j <= k; j++) {
                int i = k - j;
                if (i < matrixSize && j < matrixSize) {
                    // Aca estoy en diagonal de izq a derecha.

                    if (i - 4 < 0 || j + 4 >= matrixSize) {
                        continue;
                    }
                    // SI A = B, y B = C, C = D, A = D?
                    // A = B, A = C, A = D y B = D?
                    if (m[i][j] == m[i - 1][j + 1] && m[i][j] == m[i - 2][j + 2] && m[i][j] == m[i - 3][j + 3]) {
                        matches++;
                    }
                }
            }

        }

        return matches;
    }

}