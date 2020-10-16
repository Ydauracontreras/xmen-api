package ar.com.ada.api.xmen.services;

import org.springframework.stereotype.Service;

import ar.com.ada.api.xmen.entities.Mutant;
import ar.com.ada.utils.MatrixDNAIterator;

@Service
public class MutantService {

    public boolean isMutant(String[] dna) {

        MatrixDNAIterator iterator = new MatrixDNAIterator();

        Mutant mutant = new Mutant();
        int matches = 0;
        int matchesByRows = 0;
        int matchesByColumns = 0;
        int matchesByDiagonals = 0;

        matchesByRows = iterator.matchesByRows(mutant.getAdn());
        System.out.println("Matcheos por Rows " + matchesByRows);
        matchesByColumns = iterator.matchesByColumns(mutant.getAdn());
        System.out.println("Matcheos por Columns " + matchesByColumns);
        matchesByDiagonals = iterator.matchesByDiagonals(mutant.getAdn());
        System.out.println("Matcheos por Diagonals " + matchesByDiagonals);

        matches = matchesByRows + matchesByColumns + matchesByDiagonals;

        return matches > 1;

    }
}
