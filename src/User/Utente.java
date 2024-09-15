package User;

import java.util.UUID;

public abstract class Utente {

    private final String nome;
    private final String cognome;
    private final String id;
    private String password; //password unico dato modificabile con metodo apposito
    private final String ruolo;


    // Costruttore
    public Utente(String nome, String cognome, String password, String ruolo) {
        controlloDati(nome, cognome, password); //controllo validità parametri in input
        this.nome = nome;
        this.cognome = cognome;
        this.id = UUID.randomUUID().toString();
        this.password = password;
        this.ruolo = ruolo;
    }

    // Metodo comune a tutti gli utenti, controllo che non ci siano dati null o mancanti, altrimenti lancio eccezione
    private void controlloDati(String nome, String cognome,  String password) {
        if (nome == null || nome.trim().isEmpty() ||
                cognome == null || cognome.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome, cognome, id e password non possono essere nulli o mancanti.");
        }
    }

    // Getters e Setter
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getId() {
        return id;
    }

    public String getRuolo() {
        return ruolo;
    }

    public String getPassword() {
        return password;
    }

    // Gestione apposita per dato password, non viene mostrata direttamente la password
    public boolean verificaPassword(String password) {
        return this.password.equals(password);
    }

    // Setter per eventualmente aggiornare la password
    public void aggiornaPassword(String nuovaPassword) {
        if (nuovaPassword == null || nuovaPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("La nuova password non può essere nulla o vuota.");
        }
        this.password = nuovaPassword;
    }

    //Metodi per controllare ruolo dell'utente, saranno definiti nelle sottoclassi
    public abstract boolean isGestore();

    public abstract boolean isCliente();

}