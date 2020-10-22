package ar.com.ada.api.xmen.services;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import ar.com.ada.api.xmen.entities.Human;
import ar.com.ada.api.xmen.entities.Mutant;
import ar.com.ada.api.xmen.repositories.*;
import ar.com.ada.api.xmen.utils.MatrixDNAIterator;

@Service
public class MutantService {
    @Autowired
    MutantRepository mutantRepository;
    @Autowired
    HumanRepository humanRepository;

    public void create(Mutant mutant) {
        this.mutantRepository.save(mutant);
    }

    public void create(Human human) {
        this.humanRepository.save(human);
    }

    public boolean exists(String[] dna) {
        MatrixDNAIterator m = new MatrixDNAIterator();

        String uniqueHash = m.uniqueHash(dna);
        if (mutantRepository.findByUniqueHash(uniqueHash) != null)
            return true;

        if (humanRepository.findByUniqueHash(uniqueHash) != null)
            return true;

        return false;

    }

    public Mutant registerSample(String[] dna) {
        MatrixDNAIterator m = new MatrixDNAIterator();
        if (this.isMutant(dna)) {
            Mutant mutant = new Mutant();
            // Solo para mutantes lo encripto
            mutant.setDna(m.encrypt(dna));
            mutant.setUniqueHash(m.uniqueHash(dna));
            this.create(mutant);
            return mutant;
        } else {
            Human human = new Human();
            human.setDna(m.encrypt(dna));
            human.setUniqueHash(m.uniqueHash(dna));
            this.create(human);
            return null;
        }
    }

    public boolean isValid(String[] dna) {
        MatrixDNAIterator m = new MatrixDNAIterator();
        return m.isValid(dna);
    }

    public boolean isMutant(String[] dna) {

        MatrixDNAIterator iterator = new MatrixDNAIterator();
        System.out.println(dna.toString());

        int matches = 0;
        int matchesByRows = 0;
        int matchesByColumns = 0;
        int matchesByDiagonals = 0;

        matchesByRows = iterator.matchesByRows(dna);
        System.out.println("Matcheos por Rows " + matchesByRows);
        matchesByColumns = iterator.matchesByColumns(dna);
        System.out.println("Matcheos por Columns " + matchesByColumns);
        matchesByDiagonals = iterator.matchesByDiagonals(dna);
        System.out.println("Matcheos por Diagonals " + matchesByDiagonals);

        matches = matchesByRows + matchesByColumns + matchesByDiagonals;

        return matches > 1;

    }

    public long countMutants() {
        return mutantRepository.count();
    }

    public long countHumans() {

        return humanRepository.count();

    }

    public Long countAll() {
        System.out.println("Count ALL, Thread : " + Thread.currentThread().getId());
        return this.countMutants() + this.countHumans();

    }

    @Async
    public Future<Long> countMutantsAsync() {

        long resultado = mutantRepository.count();
        return new AsyncResult<Long>(resultado);

    }

    @Async
    public void imprimirComoVamos() {
        System.out.println("Creo que vamos bien...Empezando " + Thread.currentThread().getId());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Creo que vamos bien...Finalizado " + Thread.currentThread().getId());
    }

}