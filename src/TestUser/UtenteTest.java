package TestUser;

import User.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtenteTest {

    @Test
    void testUtenteCreationSuccess() {
        Cliente cliente = new Cliente("Luigi", "Ricci", "999");
        assertEquals("Luigi", cliente.getNome());
        assertEquals("Ricci", cliente.getCognome());
        assertNotNull(cliente.getId());
        assertEquals("Cliente", cliente.getRuolo());
    }

    @Test
    void testControlloDatiInvalidi() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente(null, "Ricci", "678");
        });
        assertEquals("Nome, cognome, id e password non possono essere nulli o mancanti.", exception.getMessage());
    }

    @Test
    void testAggiornaPassword() {
        Cliente cliente = new Cliente("Luigi", "Ricci", "1234");
        cliente.aggiornaPassword("newPassword");
        assertTrue(cliente.verificaPassword("newPassword"));
    }

    @Test
    void testAggiornaPasswordNonValida() {
        Cliente cliente = new Cliente("Luigi", "Ricci", "1234");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cliente.aggiornaPassword("");
        });
        assertEquals("La nuova password non può essere nulla o vuota.", exception.getMessage());
    }
}