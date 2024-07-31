public class DispositivoElettronico extends Prodotto{

    //Variabili
    private double dimDisplay;
    private double dimArchivio;
    private TipologiaDispositivoElettronico tipologia;


    //Costruttore
    public DispositivoElettronico(String tipoProdotto, String produttore, String modello, int idProdotto, double prezzoVendita, double prezzoAcquisto, double dimDisplay, double dimArchivio,  String descrizioneDispositivo, TipologiaDispositivoElettronico tipologia) {
        super(tipoProdotto, produttore, modello, idProdotto, descrizioneDispositivo, prezzoVendita, prezzoAcquisto);
        this.dimDisplay = dimDisplay;
        this.dimArchivio = dimArchivio;
        this.tipologia = tipologia;
    }


    //Getter
    public double getDimDisplay() {
        return dimDisplay;
    }

    public double getDimArchivio() {
        return dimArchivio;
    }
    public TipologiaDispositivoElettronico getTipologia() {
        return tipologia;
    }

    //Setter
    public void setDimDisplay(double dimDisplay) {
        this.dimDisplay = dimDisplay;
    }


    public void setDimArchivio(double dimArchivio) {
        this.dimArchivio = dimArchivio;
    }

    public void setTipologia(TipologiaDispositivoElettronico tipologia) {
        this.tipologia = tipologia;
    }

    @Override
    public String toString() {
        return super.toString() + "DispositivoElettronico{" +
                "dimDisplay=" + dimDisplay +
                ", dimArchivio=" + dimArchivio +
                ", tipologia=" + tipologia +
                '}';
    }
}
