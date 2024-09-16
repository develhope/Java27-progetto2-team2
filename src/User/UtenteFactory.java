package User;

public class UtenteFactory {
    public static Utente createUtente(String nome, String cognome, String password, String ruolo) {
        switch (ruolo.toLowerCase()) {
            case "cliente":
                return new Cliente(nome, cognome, password);
            case "gestore":
                return new Gestore(nome, cognome, password);
            default:
                throw new IllegalArgumentException("Ruolo non valido");
        }
    }
}