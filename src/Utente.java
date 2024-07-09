public class Utente {

    private String nome;
    private String cognome;
    private String idOppurePassword; // ID o password per avere utente univoco
    private Carrello carrelloUtente; // Carrello associato all'utente

    // Costruttore
    public Utente(String nome, String cognome, String idOppurePassword, Magazzino magazzino) {
        this.nome = nome;
        this.cognome = cognome;
        this.idOppurePassword = idOppurePassword;
        this.carrelloUtente = new Carrello(magazzino); // Passo il magazzino al carrello
    }

    // Metodi per la gestione del carrello -------------------------------------------------------------
    // Metodo per aggiungere prodotto al carrello
    public void aggiungiProdottoAlCarrello(Prodotto prodotto) {
        carrelloUtente.aggiungiProdotto(prodotto);
    }

    // Metodo per rimuovere prodotto dal carrello
    public void rimuoviProdottoDalCarrello(Prodotto prodotto) {
        carrelloUtente.rimuoviProdotto(prodotto);
    }

    // Metodo per visualizzare il contenuto del carrello
    public void visualizzaCarrello() {
        carrelloUtente.stampaCarrello();
    }

    // Metodo per calcolare il totale del carrello
    public double calcolaTotaleCarrello() {
        return carrelloUtente.calcolaTotale();
    }

    // Metodo con messaggio di acquisto finalizzato e che svuoti il carrello
    public void finalizzaAcquisto() {
        carrelloUtente.svuotaCarrello();
        System.out.println("Acquisto finalizzato con successo! Grazie " + nome + " " + cognome + ".");
    }

    // Metodi di ricerca nel magazzino (non dovrebbe stare in Magazzino?)-------------------------
    // Metodo per la ricerca per tipo di dispositivo
    public void ricercaPerTipo(String tipo, Magazzino magazzino) {
        for (Prodotto prodotto : magazzino.getProdotti()) {
            if (prodotto.getTipoProdotto().equalsIgnoreCase(tipo)) {
                System.out.println(prodotto);
            }
        }
    }

    // Metodo per la ricerca per produttore
    public void ricercaPerProduttore(String produttore, Magazzino magazzino) {
        for (Prodotto prodotto : magazzino.getProdotti()) {
            if (prodotto.getProduttore().equalsIgnoreCase(produttore)) {
                System.out.println(prodotto);
            }
        }
    }

    // Metodo per la ricerca per modello
    public void ricercaPerModello(String modello, Magazzino magazzino) {
        for (Prodotto prodotto : magazzino.getProdotti()) {
            if (prodotto.getModello().equalsIgnoreCase(modello)) {
                System.out.println(prodotto);
            }
        }
    }

    // Metodo per la ricerca per prezzo di vendita
    public void ricercaPerPrezzoVendita(double prezzoMinimo, double prezzoMassimo, Magazzino magazzino) {
        for (Prodotto prodotto : magazzino.getProdotti()) {
            if (prodotto.getPrezzoVendita() >= prezzoMinimo && prodotto.getPrezzoVendita() <= prezzoMassimo) {
                System.out.println(prodotto);
            }
        }
    }

    // Metodo per la ricerca per prezzo di acquisto
    public void ricercaPerPrezzoAcquisto(double prezzoMinimo, double prezzoMassimo, Magazzino magazzino) {
        for (Prodotto prodotto : magazzino.getProdotti()) {
            if (prodotto.getPrezzoAcquisto() >= prezzoMinimo && prodotto.getPrezzoAcquisto() <= prezzoMassimo) {
                System.out.println(prodotto);
            }
        }
    }
}