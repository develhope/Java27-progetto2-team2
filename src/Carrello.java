import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Prodotto> prodotti; // Prodotti nel carrello

    // Costruttore
    public Carrello() {
        this.prodotti = new ArrayList<>();
    }

    /**
     * Aggiunge prodotto al Carrello
     * @param prodotto
     */
    public void aggiungiProdotto(Prodotto prodotto) {
    }

    // Metodo per rimuovere un prodotto dal carrello
    public void rimuoviProdotto(Prodotto prodotto) {
    }

    /**
     * Calcolo totale Carrello
     * @return
     */
    public double calcolaTotale() {
        double totale = 0.0;

        for (Prodotto p : prodotti) {
            totale += p.getPrezzoVendita();
        }
        return totale;
    }

    // Metodo per ottenere il contenuto del carrello
    public List<Prodotto> getContentCarrello(){
        return this.prodotti;
    }

    // Metodo per svuotare il carrello
    public void svuotaCarrello() {
        prodotti.clear();
    }

}