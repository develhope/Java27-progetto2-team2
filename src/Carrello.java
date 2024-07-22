import Exceptions.ProductDoesntExistException;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Prodotto> prodotti;

    public Carrello() {
        this.prodotti = new ArrayList<>();
    }


    /**
     * Metodo per l'aggiunta di un prodotto al carrello.
     * @param prodotto prende in entrata un variabile di tipo Prodotto.
     * @return ritorna true/false in base al risultato del metodo:
     * (true) se il prodotto e stato aggiunto, (false) sei il prodotto non è stato aggiunto.
     *
     */
    public boolean aggiungiProdotto(Prodotto prodotto) {
        if(prodotti.stream().anyMatch( p -> p.getIdProdotto() == prodotto.getIdProdotto())){
            return false;
        }

        prodotti.add(prodotto);
        return true;
    }

    /**
     * Metodo per rimuovere un prodotto dal carrello
     * @param id prende come argomento un id (int).
     * @return  ritorna il prodotto rimosso.
     * @exception ProductDoesntExistException viene lanciata eccezione in caso il prodotto non esiste nel carrello
     * (false) se il prodotto non è stato rimosso.
     */
    public Prodotto rimuoviProdotto(int id) throws ProductDoesntExistException {
        for(Prodotto element: prodotti){
            if(element.getIdProdotto() == id){
                prodotti.remove(element);
                return element;
            }
        }
        throw new ProductDoesntExistException("Prodotto non trovato");
    }


    /**
     * Calcolo prezzo totale del Carrello
     * @return ritorna il prezzo totale del carrello
     */
    public double calcolaTotale() {
        double totale = 0.0;
        for (Prodotto p : prodotti) {
            totale += p.getPrezzoVendita();
        }
        return totale;
    }

    /**
     * @return ritorna la lista di prodotti nel carrello
     */
    public List<Prodotto> getContentCarrello(){
        return this.prodotti;
    }

    /**
     * Metodo per svuotare il carrello.
     */
    public void svuotaCarrello() {
        prodotti.clear();
    }

    @Override
    public String toString() {
        return "Carrello{" +
                "prodotti=" + prodotti +
                '}';
    }
}