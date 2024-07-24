import java.util.ArrayList;
import java.util.List;

public class Magazzino {

    private List<Prodotto> listaProdotti;

    public Magazzino(){
        this.listaProdotti = new ArrayList<>();
    }

    public List<Prodotto> aggiungiProdotto(Prodotto prodotto){
        listaProdotti.add(prodotto);
        return listaProdotti;
    }

    /***
     * Ricerca per tipo ( es. Smartphone, Tablet, Notebook
     * @param tipologia prende in entrata una enumeratore.
     * @return ritorna la lista dei prodotti filtrata
     */
    public List<Prodotto> ricercaPerTipo(TipologiaDispositivoElettronico tipologia){
        return listaProdotti.stream().filter(prodotto -> prodotto.getTipoProdotto().equals(tipologia)).toList();
    }

    /***
     * Ricerca per produttore ( es. Apple )
     * @param produttore prende in entrata una Stringa.
     * @return ritorna la lista dei prodotti filtrata
     */
    public List<Prodotto> ricercaPerProduttore(String produttore){
        return listaProdotti.stream().filter(prodotto -> prodotto.getProduttore().equals(produttore)).toList();
    }

    /***
     * Ricerca per modello ( es. iPhone 15 )
     * @param modello prende in entrata una Stringa.
     * @return ritorna la lista dei prodotti filtrata
     */
    public List<Prodotto> ricercaPerModello(String modello){
        return listaProdotti.stream().filter(prodotto -> prodotto.getModello().equals(modello)).toList();
    }

    /***
     * Ricerca per range di prezzo ( es. 500, 1200 )
     * @param pinit Il prezzo iniziale del Range di ricerca (int)
     * @param pfinal Il prezzo finale del Range di ricerca (int)
     * @return ritorna la lista dei prodotti filtrata
     */
    public List<Prodotto> ricercaPerRangeDiPrezzo(int pinit, int pfinal){
        return listaProdotti.stream().filter(k -> k.getPrezzoVendita() >= pinit && k.getPrezzoVendita() <= pfinal ).toList();
    }

    /***
     * Ricerca per prezzo di Vendita ( es. 500 )
     * @param prezzo prende in entrata un valore di tipo int.
     * @return ritorna la lista dei prodotti filtrata
     */
    public List<Prodotto> ricercaPerPrezzoDiVendita(int prezzo){
        return listaProdotti.stream().filter(prodotto -> prodotto.getPrezzoVendita() == prezzo).toList();

    }

    /***
     * Ricerca per prezzo di Acquisto ( es. 1200 )
     * @param prezzo prende in entrata un valore di tipo int.
     * @return ritorna la lista dei prodotti filtrata
     */
    public List<Prodotto> ricercaPerPrezzoDiAcquisto(int prezzo){
        return listaProdotti.stream().filter(prodotto -> prodotto.getPrezzoAcquisto() == prezzo).toList();

    }

    public List<Prodotto> rimuoviProdotto(int id){
        listaProdotti.removeIf(prodotto -> prodotto.getIdProdotto() == id);
        return listaProdotti;
    }

    public List<Prodotto> getProdotti(){
        return new ArrayList<>(listaProdotti);
    }

    public boolean getProdottoById(int id){
        for(Prodotto prodotto: listaProdotti){
            if(prodotto.getIdProdotto() == id){
                return true;
            }
        }
        return false;
    }
}