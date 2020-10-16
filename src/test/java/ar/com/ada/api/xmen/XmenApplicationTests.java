package ar.com.ada.api.xmen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ada.api.xmen.services.MutantService;

@SpringBootTest
class XmenApplicationTests {

	@Autowired
	MutantService mutantService;

	@Test
	void contextLoads() {
	}

	@Test
	void ADN_isValid() {

	}

	@Test
	void ADN_isMutant() {
		String[] dnaMutant = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		// assertTrue(mutantService.isMutan(dnaMutant));
	}

	@Test
	void ADN_isHuman() {
		String[] dnaHuman = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		// assertTrue(mutantService.isMutan(dnaHuman));
	}

}
