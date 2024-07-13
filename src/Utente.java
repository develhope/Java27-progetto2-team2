public class Utente {

    private String nome;
    private String cognome;
    private String id;
    private String password; // ID o password per avere utente univoco
    private Carrello carrelloUtente; // Carrello associato all'utente

    // Costruttore
    public Utente(String nome, String cognome, String id, String password, Magazzino magazzino) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.password = password;
        this.carrelloUtente = new Carrello(magazzino); // Passo il magazzino al carrello
    }


    // Getters e Setters -------------------------------------------------------------
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Carrello getCarrelloUtente() {
        return carrelloUtente;
    }

    public void setCarrelloUtente(Carrello carrelloUtente) {
        this.carrelloUtente = carrelloUtente;
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
}