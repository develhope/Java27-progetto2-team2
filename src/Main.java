import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Inizializzazione Classi
        Magazzino magazzino = new Magazzino();

        //Dispositivi
        DispositivoElettronico dispositivoElettronico1 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);

        //Aggiunta Dispositivi a Magazino
        magazzino.aggiungiProdotto(dispositivoElettronico1);

        //Menù di scelta
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "\nMenù principale (Utente): \n" +
                "\n1.    Visualizza prodotti da magazzino. " +
                "\n2.    Ricerca prodotti (-> Più opzioni) " +
                "\n3.    Gestisci carrello (-> Più opzioni) " +
                "\n4.    Visualizza spesa media. " +
                "\n5.    Gestisci magazzino (-> Più opzioni) " +
                "\n6.    Termina operazione.\n" +
                "\nInerisci la tua scelta: \n");

        int scelta = scanner.nextInt();

        sceltaMenu(scelta, magazzino);


        scanner.close();
    }

    public static void sceltaMenu(int a, Magazzino m){

        switch (a){
            case 1->{
                System.out.println(m.visualizzaProdottiMagazino());
            }
            case 2->{

            }
            case 3->{

            }
            case 4->{

            }
            case 5->{

            }
            case 6->{

            }
            case 7 -> System.out.println("Finito il case");
        }

    }

}