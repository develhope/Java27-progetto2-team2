import java.util.ArrayList;

public class Magazzino {

    private List<Prodotto> listaProdotti;

    public Magazzino(){
        this.listaProdotti = new ArrayList<>();
    }

    public List<Prodotto> aggiungiProdotto(Prodotto prodotto){
        listaProdotti.add(prodotto);
        return listaProdotti;
    }

    public List<Prodotto> rimuoviProdotto(int id){
        listaProdotti.removeIf(prodotto -> prodotto.getIdProdotto(id));
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