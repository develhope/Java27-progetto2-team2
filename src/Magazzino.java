import java.util.ArrayList;
import java.util.List;

public class Magazzino {

    private List<Prodotto> listaProdotti;

    public Magazzino(){
        this.listaProdotti = new ArrayList<>();
    }

    public void aggiungiProdotto(Prodotto prodotto){
        listaProdotti.add(prodotto);
        System.out.println("Il seguente prodotto " + prodotto + " è stato aggiunto!");
    }

    public void rimuoviProdotto(Prodotto prodotto){
        if(listaProdotti.contains(prodotto)){
            listaProdotti.remove(prodotto);
            System.out.println("Prodotto rimosso: " + prodotto);
        } else {
            System.out.println("Prodotto non rilevato: " + prodotto);
        }
    }

    public List<Prodotto> getProdotti(){
        return new ArrayList<>(listaProdotti);
    }

    public boolean getProdottoById(int id){
        for(Prodotto prodotto: listaProdotti){
            if(prodotto.getIdProdotto() == id){
                System.out.println("Id del prodotto: " + prodotto.getIdProdotto());
                return true;
            }
        }
        return false;
    }
}