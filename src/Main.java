import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String RESET = "\u001B[0m";
        String RED = "\u001B[31m"; // Work in Progress

        //Inizializzazione Classi
        Magazzino magazzino = new Magazzino();
        Gestore gestore = new Gestore("Domingo", "Flamingo", "1", "passwordsicuramentesicura");
        Cliente cliente = new Cliente("Saturnio", "Ramingo", "1", "passwordsegretissimamentesegreta");


        //Dispositivi
        DispositivoElettronico dispositivoElettronico1 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);
        DispositivoElettronico dispositivoElettronico2 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);

        //Aggiunta Dispositivi a Magazino
        magazzino.aggiungiProdotto(dispositivoElettronico1);
        magazzino.aggiungiProdotto(dispositivoElettronico2);

        //03.09 Aggiunta Dispositivi a Magazino tramite gestore
        gestore.aggiungiProdottoAlMagazzino(dispositivoElettronico1);
        gestore.aggiungiProdottoAlMagazzino(dispositivoElettronico2);

        cliente.aggiungiProdottoAlCarrello(dispositivoElettronico1);
        cliente.aggiungiProdottoAlCarrello(dispositivoElettronico2);

        //Menù di scelta
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "\nMenù principale (Utente): \n" +
                "\n1.    Visualizza prodotti da magazzino. " +
                "\n2.    Ricerca prodotti (-> Più opzioni) " +
                        RED +"\n3.    Gestisci carrello (-> Più opzioni) (WIP) " +
                "\n4.    Visualizza spesa media. (WIP) " +
                "\n5.    Gestisci magazzino (-> Più opzioni) (WIP) " +
                RESET +"\n6.    Termina operazione.\n" +
                "\nInerisci la tua scelta: \n");

        int scelta = scanner.nextInt();

        sceltaMenu(scelta, magazzino, scanner, cliente, gestore);


        scanner.close();
    }

    public static void sceltaMenu(int a, Magazzino m, Scanner scanner, Cliente cliente, Gestore gestore){
            switch (a){
                case 1->{
                    for(Prodotto prodotto : m.getProdotti()){
                        System.out.println(prodotto);
                    }
                }
                case 2->{
                    ricercaProdotto(m,scanner, cliente, gestore);
                }
                case 3->{

                }
                case 4->{

                }
                case 5->{

                }
                case 6-> {
                    main(null);
                }
            }

    }

    public static void gestisciMagazzino(Gestore gestore, Scanner scanner) {
        System.out.println("\nMenù gestione magazzino: \n" +
                "\n1.    Aggiungi prodotto. " +
                "\n2.    Rimuovi prodotto. " +
                "\n3.    Visualizza prodotti in magazzino. " +
                "\n4.    Termina operazione.\n" +
                "\nInserisci la tua scelta: \n");

        int scelta = scanner.nextInt();
        scanner.nextLine(); // Pulizia dello scanner

    }

    public static void ricercaProdotto(Magazzino m, Scanner scanner, Cliente cliente, Gestore gestore){
        System.out.println(
                "\nMenù ricerca prodotto: \n" +
                        "\n1.    Magazzino. " +
                        "\n2.    Carrello. " +
                        "\n3.    Termina operazione " +
                        "\nInerisci la tua scelta: \n");

        int choice = scanner.nextInt();

        switch (choice){
            case 1 -> ricercaProdottoNelMagazzino(scanner, m);
            case 2 -> ricercaProdottoNelCarrello(scanner, cliente);
            case 3 -> main(null);
        }
    }

    public static void ricercaProdottoNelMagazzino(Scanner scanner, Magazzino m){
        System.out.println(
                "\nMenù principale (Utente): \n" +
                        "\n1.    Ricerca per Tipo. " +
                        "\n2.    Ricerca per Produttore " +
                        "\n3.    Ricerca per Modello " +
                        "\n4.    Ricerca per Range di Prezzo. " +
                        "\u001B[33m" +"\n5.    Ricerca per id (FIX REQUIRED)" +
                        "\u001B[0m"+"\n6.    Termina operazione.\n" +
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
            case 3 ->{
                System.out.println("Inserisci il Modello:");
                String finderHandler = scanner.nextLine();
                System.out.println(m.ricercaPerModello(finderHandler));
            }
            case 4 ->{
                System.out.println("Inserisci il prezzo più basso ( es. 400.0) ");
                double initPrice = scanner.nextDouble();
                System.out.println("Inserisci il prezzo più alto (es. 2000.0) ");
                double finalPrice = scanner.nextDouble();
                System.out.println(m.ricercaPerRangeDiPrezzo(initPrice,finalPrice));
            }
            case 5 ->{
                System.out.println("Inserisci l'id del prodotto:");
                int finderHandler = scanner.nextInt();
                System.out.println(m.getProdottoById(finderHandler));
            }
            case 6 -> main(null);
        }
    }

    public static void ricercaProdottoNelCarrello(Scanner scanner, Cliente cliente){
        System.out.println(
                "\nMenù principale (Utente): \n" +
                        "\n1.    Contenuto Carrello. " +
                        "\n2.    Termina Operazione. " +
                        "\nInerisci la tua scelta: \n");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Serve a pulire la linea precedentemente creata da scanner.nextInt();

        switch (choice){
            case 1 -> System.out.println(cliente.getCarrelloUtente());
            case 2 -> main(null);
        }

    }

}