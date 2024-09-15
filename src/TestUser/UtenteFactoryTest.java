package TestUser;

import User.Utente;
import User.UtenteFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtenteFactoryTest {

    @Test
    void testCreateCliente() {
        Utente cliente = UtenteFactory.createUtente("Simone", "Testa", "456", "cliente");
        assertTrue(cliente.isCliente());
        assertFalse(cliente.isGestore());
    }

    @Test
    void testCreateGestore() {
        Utente gestore = UtenteFactory.createUtente("Anna", "Croce", "987", "gestore");
        assertTrue(gestore.isGestore());
        assertFalse(gestore.isCliente());
    }

    @Test
    void testCreateUtenteInvalidRole() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UtenteFactory.createUtente("Ivan", "Drake", "619", "hacker");
        });
        assertEquals("Ruolo non valido", exception.getMessage());
    }
}