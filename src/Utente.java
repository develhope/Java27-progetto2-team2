public abstract class Utente {  //08.29 modificata in classe astratta
    //inserisco final affinchè non vengano cambiati dopo creazione
    private final String nome;
    private final String cognome;
    private final String id;
    private String password; //password potrebbe essere l'unico dato modificabile con metodo apposito?

    // Costruttore
    public Utente(String nome, String cognome, String id, String password) {
        controlloDati(nome, cognome, id, password); //08.29 invoco metodo controllo validità parametri in input
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.password = password;
    }

    // Metodo comune a tutti gli utenti, controllo che non ci siano dati null o mancanti, altrimenti lancio eccezione
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


// 29.08 rimosso da utente perchè serve solo a Cliente ora?!?!
    //30.07 Modificato in modo che restituisca lista prodotti carrello dell'utente

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

    //30.07 Metodi per controllare ruolo dell'utente // 29.08 saranno definiti nelle sottoclassi
    public abstract boolean isGestore();

    public abstract boolean isCliente();

}