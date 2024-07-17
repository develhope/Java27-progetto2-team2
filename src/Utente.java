public class Utente {

    private String nome;
    private String cognome;
    private String id;
    private String password; // ID o password per avere utente univoco

    // Costruttore
    public Utente(String nome, String cognome, String id, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.password = password;
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

}