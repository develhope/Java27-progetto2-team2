import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Prodotto> prodotti; // Prodotti nel carrello
    private Magazzino magazzino; // Riferimento al magazzino

    // Costruttore
    public Carrello(Magazzino magazzino) {
        this.prodotti = new ArrayList<>();
        this.magazzino = magazzino;
    }

    // Metodo per aggiungere un prodotto al carrello
    public void aggiungiProdotto(Prodotto prodotto) {
        // Controllo se il prodotto esiste nel magazzino tramite l'ID del prodotto
        if(magazzino.getProdottoById(prodotto.getIdProdotto())) {
            // Se il prodotto è presente, rimuovo dal magazzino e aggiungo al carrello
            System.out.println("Prodotto con ID " + prodotto.getIdProdotto() + " aggiunto al carrello con successo!");
            magazzino.rimuoviProdotto(prodotto);
            prodotti.add(prodotto);
        } else {
            // Se il prodotto non è presente nel magazzino, viene mostrato un messaggio di errore
            System.out.println("Errore: Prodotto con ID " + prodotto.getIdProdotto() + " non trovato.");
        }
    }

    // Metodo per rimuovere un prodotto dal carrello
    public void rimuoviProdotto(Prodotto prodotto) {
        // Cerco il prodotto nel carrello
        for (Prodotto p : prodotti) {
            if (p.getIdProdotto() == prodotto.getIdProdotto()) {
                // Se c'è, lo aggiungo nuovamente al magazzino e lo rimuovo dal carrello
                magazzino.aggiungiProdotto(p);
                prodotti.remove(p);
                System.out.println("Prodotto rimosso dal carrello con successo!");
                break;
            } else {
                // Se non c'è nel carrello, viene mostrato un messaggio di errore
                System.out.println("Errore: Prodotto con ID " + prodotto.getIdProdotto() + " non trovato nel carrello.");
            }
        }
    }

    // Metodo per stampare il contenuto del carrello
    public void stampaCarrello() {
        for (Prodotto p : prodotti) {
            System.out.println(p);
        }
    }

    // Metodo per calcolare il totale del carrello
    public double calcolaTotale() {
        double totale = 0.0;
        // Sommo il prezzo di vendita di ciascun prodotto presente nel carrello
        for (Prodotto p : prodotti) {
            totale += p.getPrezzoVendita();
        }
        return totale;
    }

    // Metodo per ottenere il contenuto del carrello
    public List<Prodotto> getContentCarrello(){
        return new ArrayList<>(prodotti);
    }

    // Metodo per svuotare il carrello
    public void svuotaCarrello() {
        prodotti.clear();
    }

}