package TestUser;

import Product.DispositivoElettronico;
import Product.Prodotto;
import Product.TipologiaDispositivoElettronico;
import User.Gestore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GestoreTest {

    private Gestore gestore;

    @BeforeEach
    void setUp() {
        gestore = new Gestore("Luca", "Verdi", "password123");
    }

    @Test
    void testAggiungiProdottoAlMagazzino() {
        Prodotto dispositivoElettronico1 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);
        gestore.aggiungiProdottoAlMagazzino(dispositivoElettronico1);
        assertEquals(1, gestore.getMagazzino().getProdotti().size());
    }

    @Test
    void testRimuoviProdottoDalMagazzino() {
        Prodotto dispositivoElettronico1 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);
        gestore.aggiungiProdottoAlMagazzino(dispositivoElettronico1);
        gestore.rimuoviProdottoDalMagazzino(123);
        assertTrue(gestore.getMagazzino().getProdotti().isEmpty());
    }

    @Test
    void testRicercaProdottiPerTipo() {
        Prodotto dispositivoElettronico1 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);
        gestore.aggiungiProdottoAlMagazzino(dispositivoElettronico1);
        assertEquals(1, gestore.ricercaProdottiPerTipo(TipologiaDispositivoElettronico.SMARTPHONE).size());
    }
}
