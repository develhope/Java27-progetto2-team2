package TestUser;

import Product.DispositivoElettronico;
import Product.Prodotto;
import Product.TipologiaDispositivoElettronico;
import User.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Luca", "Nuovo", "345");
    }

    @Test
    void testAggiungiProdottoAlCarrello() {
        Prodotto dispositivoElettronico1 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);
        cliente.aggiungiProdottoAlCarrello(dispositivoElettronico1);
        assertEquals(1, cliente.getCarrelloUtente().size());
    }

    @Test
    void testRimuoviProdottoDalCarrello() {
        Prodotto dispositivoElettronico1 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);
        cliente.aggiungiProdottoAlCarrello(dispositivoElettronico1);
        cliente.rimuoviProdottoDalCarrello(123);
        assertTrue(cliente.getCarrelloUtente().isEmpty());
    }

    @Test
    void testCalcolaTotaleCarrello() {
        Prodotto dispositivoElettronico1 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);
        Prodotto dispositivoElettronico2 = new DispositivoElettronico("Smartphone","Apple","IPhone 13", 124, 1000.00,499.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);
        cliente.aggiungiProdottoAlCarrello(dispositivoElettronico1);
        cliente.aggiungiProdottoAlCarrello(dispositivoElettronico2);
        assertEquals(2499.99, cliente.calcolaTotaleCarrello());
    }

    @Test
    void testFinalizzaAcquisto() {
        cliente.finalizzaAcquisto();
        assertTrue(cliente.getCarrelloUtente().isEmpty());
    }
}