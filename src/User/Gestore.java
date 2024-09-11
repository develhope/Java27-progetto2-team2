package User;

import Product.Prodotto;
import Product.TipologiaDispositivoElettronico;
import Magazzino.Magazzino;
import java.util.List;

public class Gestore extends Utente {
    private Magazzino magazzino;

    public Gestore(String nome, String cognome, String password) {
        super(nome, cognome, password, "Gestore");
        this.magazzino = new Magazzino();
    }


    @Override
    public boolean isGestore() {
        return true;
    }

    @Override
    public boolean isCliente() {
        return false;
    }
    // Metodi per la gestione del magazzino
    public void aggiungiProdottoAlMagazzino(Prodotto prodotto) {
        magazzino.aggiungiProdotto(prodotto);
        System.out.println("Prodotto aggiunto al magazzino: " + prodotto);
    }

    public void rimuoviProdottoDalMagazzino(int idProdotto) {
        magazzino.rimuoviProdotto(idProdotto);
        System.out.println("Prodotto rimosso dal magazzino con ID: " + idProdotto);
    }

    public void visualizzaProdottiMagazzino() {
        List<Prodotto> prodotti = magazzino.getProdotti();
        if (prodotti.isEmpty()) {
            System.out.println("Il magazzino è vuoto.");
        } else {
            prodotti.forEach(System.out::println);
        }
    }

    public List<Prodotto> ricercaProdottiPerTipo(TipologiaDispositivoElettronico tipo) {
        return magazzino.ricercaPerTipo(tipo);
    }

    //04.09 Mancano altri metodi di gestione? controllare
}