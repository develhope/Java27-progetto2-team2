package Product;

public abstract class Prodotto {

    //Variabili
    private String tipoProdotto;
    private String produttore;
    private String modello;
    private int idProdotto;
    private String descrizioneDispositivo;
    private double prezzoVendita;
    private double prezzoAcquisto;


    //Costruttore
    public Prodotto(String tipoProdotto, String produttore, String modello, int idProdotto, String descrizioneDispositivo, double prezzoVendita, double prezzoAcquisto){
        this.tipoProdotto = tipoProdotto;
        this.produttore = produttore;
        this.modello = modello;
        this.idProdotto = idProdotto;
        this.descrizioneDispositivo = descrizioneDispositivo;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
    }



    //Getter
    public String getTipoProdotto() {
        return this.tipoProdotto;
    }

    public String getProduttore() {
        return produttore;
    }

    public String getModello() {
        return modello;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public String getDescrizioneDispositivo() {
        return descrizioneDispositivo;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    //Setter
    public void setTipoProdotto(String tipoProdotto) {
        this.tipoProdotto = tipoProdotto;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public void setDescrizioneDispositivo(String descrizioneDispositivo) {
        this.descrizioneDispositivo = descrizioneDispositivo;
    }

    public void setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public void setPrezzoAcquisto(double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    @Override
    public String toString() {
        return "Product.Prodotto{" +
                "tipoProdotto='" + tipoProdotto + '\'' +
                ", produttore='" + produttore + '\'' +
                ", modello='" + modello + '\'' +
                ", idProdotto=" + idProdotto +
                ", descrizioneDispositivo='" + descrizioneDispositivo + '\'' +
                ", prezzoVendita=" + prezzoVendita +
                ", prezzoAcquisto=" + prezzoAcquisto +
                '}';
    }
}
