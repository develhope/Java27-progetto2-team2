public class DispositivoElettronico extends Prodotto{

    //Variabili
    private double dimDisplay;
    private String descrizioneDispositivo;
    private double dimArchivio;


    //Costruttore
    public DispositivoElettronico(String tipoProdotto, String produttore, String modello, int idProdotto, double prezzoVendita, double prezzoAcquisto) {
        super(tipoProdotto, produttore, modello, idProdotto, prezzoVendita, prezzoAcquisto);
        this.dimDisplay = dimDisplay;
        this.descrizioneDispositivo = descrizioneDispositivo;
        this.dimArchivio = dimArchivio;
    }



    //Getter
    public double getDimDisplay() {
        return dimDisplay;
    }

    public String getDescrizioneDispositivo() {
        return descrizioneDispositivo;
    }

    public double getDimArchivio() {
        return dimArchivio;
    }

}

