import Exceptions.ProductDoesntExistException;
import java.util.List;

public class Utente {
//inserisco final affinchè non vengano cambiati dopo creazione
    private final String nome;
    private final String cognome;
    private final String id;
    private String password; //password potrebbe essere l'unico dato modificabile con metodo apposito?
    private final Carrello carrelloUtente; // Carrello associato all'utente
    private final RuoloUtente ruolo;

// Costruttore
    public Utente(String nome, String cognome, String id, String password, RuoloUtente ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.password = password;
        this.carrelloUtente = new Carrello(); // Non è necessario passare il Magazzino
        this.ruolo = ruolo;
    }

// Controllo che non ci siano dati null o mancanti, altrimenti lancio eccezione
    private void controlloDati(String nome, String cognome, String id, String password) {
        if (nome == null || nome.trim().isEmpty() ||
                cognome == null || cognome.trim().isEmpty() ||
                id == null || id.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome, cognome, id e password non possono essere nulli o mancanti.");
        }
    }

// Getters e Setter (questo solo di password x aggiornarla) -------------------------------------------------------------
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getId() {
        return id;
    }

    //30.07 Modificato in modo che restituisca lista prodotti carrello dell'utente
    public List<Prodotto> getCarrelloUtente() {
        return carrelloUtente.getContentCarrello();
    }

// Gestione apposita per dato password
    // Non viene mostrata direttamente la password
    public boolean verificaPassword(String password) {
        return this.password.equals(password);
    }

    // Setter per per eventualmente aggiornare la password
    public void aggiornaPassword(String nuovaPassword) {
        if (nuovaPassword == null || nuovaPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("La nuova password non può essere nulla o vuota.");
        }
        this.password = nuovaPassword;
    }

//30.07 Metodi per controllare ruolo dell'utente ---------------------------------------------------
    public boolean isGestore() {
        return this.ruolo == RuoloUtente.GESTORE;
    }
    public boolean isCliente() {
        return this.ruolo == RuoloUtente.CLIENTE;
    }

// Metodi per la gestione del carrello -------------------------------------------------------------
//30.07 con controllo se Cliente
    /**
     * Aggiunge un prodotto al carrello dell'utente.
     * @param prodotto Prodotto da aggiungere
     */
    public void aggiungiProdottoAlCarrello(Prodotto prodotto) {
        if (isCliente()) {
            boolean aggiunto = carrelloUtente.aggiungiProdotto(prodotto);
            if (!aggiunto) {
                System.out.println("Il prodotto è già presente nel carrello.");
            } else {
                System.out.println("Prodotto aggiunto al carrello con successo.");
            }
        } else {
            System.out.println("Operazione non permessa. Solo i clienti possono aggiungere prodotti al carrello.");
        }
    }

    /**
     * Rimuove un prodotto dal carrello dell'utente.
     * @param idProdotto ID del prodotto da rimuovere
     */
    public void rimuoviProdottoDalCarrello(int idProdotto) {
        if (isCliente()) {
            try {
                Prodotto prodottoRimosso = carrelloUtente.rimuoviProdotto(idProdotto);
                System.out.println("Prodotto rimosso dal carrello: " + prodottoRimosso);
            } catch (ProductDoesntExistException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        } else {
            System.out.println("Operazione non permessa. Solo i clienti possono rimuovere prodotti dal carrello.");
        }
    }

    // Metodo per visualizzare il contenuto del carrello
    public void visualizzaCarrello() {
        if (isCliente()) {
            List<Prodotto> contenuto = carrelloUtente.getContentCarrello();
            if (contenuto.isEmpty()) {
                System.out.println("Il carrello è vuoto.");
            } else {
                contenuto.forEach(System.out::println);
            }
        } else {
            System.out.println("Operazione non permessa. Solo i clienti possono visualizzare il carrello.");
        }
    }

    /**
     * Calcola il totale del carrello.
     * @return Totale del carrello
     */
    public double calcolaTotaleCarrello() {
        if (isCliente()) {
            return carrelloUtente.calcolaTotale();
        } else {
            System.out.println("Operazione non permessa. Solo i clienti possono calcolare il totale del carrello.");
            return 0;
        }
    }

    // Metodo con messaggio di acquisto finalizzato e che svuoti il carrello
    public void finalizzaAcquisto() {
        if (isCliente()) {
            double totale = calcolaTotaleCarrello();
            if (totale > 0) {
                carrelloUtente.svuotaCarrello();
                System.out.println("Acquisto finalizzato con successo! Totale spesa: €" + totale + ". Grazie " + nome + " " + cognome + ".");
            } else {
                System.out.println("Il carrello è vuoto. Impossibile finalizzare l'acquisto.");
            }
        } else {
            System.out.println("Operazione non permessa. Solo i clienti possono finalizzare l'acquisto.");
        }
    }
}