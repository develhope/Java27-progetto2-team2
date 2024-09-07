import Exceptions.ProductDoesntExistException;

import java.util.List;

// La classe `Cliente` estende `Utente` e implementa i metodi astratti in modo specifico per i clienti
public class Cliente extends Utente {
    private final Carrello carrelloUtente; //03.09 carrello direttamente in Cliente

    // Costruttore della classe `Cliente`
    public Cliente(String nome, String cognome, String id, String password) {
        super(nome, cognome, id, password);  // Richiama il costruttore della classe astratta `Utente`
        this.carrelloUtente = new Carrello(); //03.09 carrello direttamente in Cliente
    }

    @Override
    public boolean isGestore() {
        return false;  // Un cliente non è un gestore
    }

    @Override
    public boolean isCliente() {
        return true;  // Identifica che l'istanza è un cliente
    }

    public List<Prodotto> getCarrelloUtente() {
        return carrelloUtente.getContentCarrello();
    }

    public void aggiungiProdottoAlCarrello(Prodotto prodotto) {
        boolean aggiunto = carrelloUtente.aggiungiProdotto(prodotto);
        if (!aggiunto) {
            System.out.println("Il prodotto è già presente nel carrello.");
        } else {
            System.out.println("Prodotto aggiunto al carrello con successo.");
        }
    }

    public void rimuoviProdottoDalCarrello(int idProdotto) {
        try {
            Prodotto prodottoRimosso = carrelloUtente.rimuoviProdotto(idProdotto);
            System.out.println("Prodotto rimosso dal carrello: " + prodottoRimosso);
        } catch (ProductDoesntExistException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public void visualizzaCarrello() {
        List<Prodotto> contenuto = carrelloUtente.getContentCarrello();
        if (contenuto.isEmpty()) {
            System.out.println("Il carrello è vuoto.");
        } else {
            contenuto.forEach(System.out::println);
        }
    }

    public double calcolaTotaleCarrello() {
        return carrelloUtente.calcolaTotale();
    }

    public void finalizzaAcquisto() {
        double totale = calcolaTotaleCarrello();
        if (totale > 0) {
            carrelloUtente.svuotaCarrello();
            System.out.println("Acquisto finalizzato con successo! Totale spesa: €" + totale + ". Grazie " + getNome() + " " + getCognome() + ".");
        } else {
            System.out.println("Il carrello è vuoto. Impossibile finalizzare l'acquisto.");
        }
    }
}