import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Inizializzazione Classi
        Magazzino magazzino = new Magazzino();

        //Dispositivi
        DispositivoElettronico dispositivoElettronico1 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);
        DispositivoElettronico dispositivoElettronico2 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);

        //Aggiunta Dispositivi a Magazino
        magazzino.aggiungiProdotto(dispositivoElettronico1);
        magazzino.aggiungiProdotto(dispositivoElettronico2);

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

        sceltaMenu(scelta, magazzino, scanner);


        scanner.close();
    }

    public static void sceltaMenu(int a, Magazzino m, Scanner scanner){
            switch (a){
                case 1->{
                    for(Prodotto prodotto : m.getProdotti()){
                        System.out.println(prodotto);
                    }
                }
                case 2->{
                    ricercaProdotto(m,scanner);
                }
                case 3->{

                }
                case 4->{

                }
                case 5->{

                }
                case 6-> {
                    System.out.println("Uscito dal menù");
                }
            }

    }

    public static void ricercaProdotto(Magazzino m,Scanner scanner){
        System.out.println(
                "\nMenù ricerca prodotto: \n" +
                        "\n1.    Magazzino. " +
                        "\n2.    Carrello (WIP) " +
                        "\n3.    Termina operazione " +
                        "\nInerisci la tua scelta: \n");

        int choice = scanner.nextInt();

        switch (choice){
            case 1 -> ricercaProdottoNelMagazzino(scanner, m);
            case 2 -> ricercaProdottoNelCarrello(scanner); //WIP
            case 3 -> main(null);
        }
    }

    public static void ricercaProdottoNelMagazzino(Scanner scanner, Magazzino m){
        System.out.println(
                "\nMenù principale (Utente): \n" +
                        "\n1.    Ricerca per Tipo. " +
                        "\n2.    Ricerca per Produttore " +
                        "\n3.    Ricerca per Modello (WIP) " +
                        "\n4.    Ricerca per Range di Prezzo. (WIP) " +
                        "\n5.    Ricerca per id (WIP) " +
                        "\n6.    Termina operazione.\n" +
                        "\nInerisci la tua scelta: \n");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Serve a pulire la linea precedentemente creata da scanner.nextInt();

        switch (choice){
            case 1 -> {
                System.out.println("Inserisci il tipo di dispositivo ( es. Smartphone, Tablet, Notebook. )");
                String finderHandler = scanner.nextLine();
                System.out.println(m.ricercaPerTipo(TipologiaDispositivoElettronico.valueOf(finderHandler.toUpperCase())));

            }
            case 2 -> {
                System.out.println("Inserisci il produttore (es. Apple, Samsung) ");
                String finderHandler = scanner.nextLine();
                System.out.println(m.ricercaPerProduttore(finderHandler));
            }
        }
    }

    public static void ricercaProdottoNelCarrello(Scanner scanner){

    }

}