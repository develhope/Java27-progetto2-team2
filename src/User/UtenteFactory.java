package User;

public class UtenteFactory {
    public static Utente createUtente(String nome, String cognome, String id, String password, String ruolo) {
        switch (ruolo.toLowerCase()) {
            case "cliente":
                return new Cliente(nome, cognome, id, password);
            case "gestore":
                return new Gestore(nome, cognome, id, password);
            default:
                throw new IllegalArgumentException("Ruolo non valido");
        }
    }
}