import JsonHandler.JsonHandler;
import Magazzino.Magazzino;
import Product.DispositivoElettronico;
import Product.Prodotto;
import Product.TipologiaDispositivoElettronico;
import User.Cliente;
import User.Gestore;
import User.Utente;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        String RESET = "\u001B[0m";
        String RED = "\u001B[31m"; // Work in Progress

        //Inizializzazione Classi
        Magazzino magazzino = new Magazzino();
        Gestore gestore = new Gestore("Domingo", "Flamingo", "1", "passwordsicuramentesicura");
        Cliente cliente = new Cliente("Gianpaolo","Carrelli","2","passowrdnonsicura");

        //Dispositivi
        DispositivoElettronico dispositivoElettronico1 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);
        DispositivoElettronico dispositivoElettronico2 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);

        //Aggiunta Dispositivi a Magazino
        magazzino.aggiungiProdotto(dispositivoElettronico1);
        magazzino.aggiungiProdotto(dispositivoElettronico2);

        gestore.aggiungiProdottoAlMagazzino(dispositivoElettronico1);
        gestore.aggiungiProdottoAlMagazzino(dispositivoElettronico2);

        cliente.aggiungiProdottoAlCarrello(dispositivoElettronico1);
        cliente.aggiungiProdottoAlCarrello(dispositivoElettronico2);

        //Menù di scelta
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMenù principale (User.Utente): \n" +

                "\n1.    Registrati " +
                "\n2.    Accedi " +
                RESET +"\n6.    Termina operazione.\n" +
                "\nInerisci la tua scelta: \n"

        );

        int sceltaMenuRegisterLogin = scanner.nextInt();
        scanner.nextLine();

        try{
            registerOrLoginMenu(sceltaMenuRegisterLogin,scanner);

        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }

        System.out.println(
                "\nMenù principale (User.Utente): \n" +
                "\n1.    Visualizza prodotti da magazzino. " +
                "\n2.    Ricerca prodotti (-> Più opzioni) " +
                        "\n3.    Gestisci carrello (-> Più opzioni) (WIP) " +
                        RED + "\n4.    Gestisci magazzino (-> Più opzioni) (WIP) " +
                RESET +"\n5.    Termina operazione.\n" +
                "\nInerisci la tua scelta: \n");

        int scelta = scanner.nextInt();
        scanner.nextLine();

        sceltaMenu(scelta, magazzino, scanner, cliente, gestore);


        scanner.close();
    }

    public static void registerOrLoginMenu(int scelta, Scanner scanner) throws IOException {
        switch (scelta){
            case 1 -> register(scanner);
            case 2 -> {
                Cliente cliente = login(scanner);
            }
        }
    }

    public static void sceltaMenu(int a, Magazzino m, Scanner scanner, Cliente c, Gestore g){
            switch (a){
                case 1->{
                    for(Prodotto prodotto : m.getProdotti()){
                        System.out.println(prodotto);
                    }
                }
                case 2->{
                    ricercaProdotto(m,scanner,c ,g);
                }
                case 3->{
                    gestireCarello(scanner,c);
                }
                case 4->{
                    c.calcolaTotaleCarrello();
                }
                case 5->{
                    main(null);
                }

            }

    }

    public static void gestireCarello(Scanner scanner, Cliente cliente){


        boolean isInMenu = true;
        while(isInMenu){

            System.out.println("\nMenù carrello): \n" +
                    "\n1.    Visualizza prodotti nel carrello. " +
                    "\n2.    Aggiungi prodotto nel carrello " +
                    "\n3.   Rimuovi prodotto dal carrello " +
                    "\n4.    Visualizza totale carrello. " +
                    "\n5.    Termina operazione.\n" +
                    "\nInerisci la tua scelta: \n");
            int scelta = scanner.nextInt();
            scanner.nextLine();
            switch (scelta){
                case 1 -> cliente.visualizzaCarrello();
                case 2 -> cliente.aggiungiProdottoAlCarrello(sceltaProdotto(scanner, cliente));
                case 3 -> {
                    System.out.println("Inserisci l'id del prodotto da riumovere");
                    cliente.rimuoviProdottoDalCarrello(scanner.nextInt());
                }
                case 4 -> System.out.println("Spesa totale: " + cliente.calcolaTotaleCarrello());
                case 5 -> {
                    main(null);
                }
            }
        }

    }

    public static Prodotto sceltaProdotto(Scanner scanner, Cliente cliente){
        System.out.println("Quale prodotto vorresti aggiungere ?\n" +
                "\n1.    IPhone 15 Pro. " +
                "\n2.    Samsung Ultra " +
                "\n3.    Nokia 4300 \n");
        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta){
            case 1 -> {
                return new DispositivoElettronico("Smartphone","Apple", "IPhone 15 Pro", 15,1499.00,1199.00,14.00,256,"Bel Telefono",TipologiaDispositivoElettronico.SMARTPHONE);
            }
            case 2 -> {
                return new DispositivoElettronico("Smartphone","Samsung", "Samsung Ultra", 16,1199.00,999.00,14.00,256,"Bel Telefono",TipologiaDispositivoElettronico.SMARTPHONE);
            }
            case 3 ->{
                return new DispositivoElettronico("Smartphone","Nokia", "Nokia 4300", 17,899.00,500.00,14.00,256,"Bel Telefono",TipologiaDispositivoElettronico.SMARTPHONE);

            }
        }
        return null;
        }
        public static void removeProdotto(){

        }



    public static void ricercaProdotto(Magazzino m,Scanner scanner, Cliente c, Gestore g){
        System.out.println(
                "\nMenù ricerca prodotto: \n" +
                        "\n1.    Magazzino.Magazzino. " +
                        "\n2.    Carrello.Carrello. " +
                        "\n3.    Termina operazione " +
                        "\nInerisci la tua scelta: \n");

        int choice = scanner.nextInt();

        switch (choice){
            case 1 -> ricercaProdottoNelMagazzino(scanner, m);
            case 2 -> ricercaProdottoNelCarrello(scanner, c);
            case 3 -> main(null);
        }
    }


    public static void ricercaProdottoNelMagazzino(Scanner scanner, Magazzino m){
        System.out.println(
                "\nMenù principale (User.Utente): \n" +
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

    public static void ricercaProdottoNelCarrello(Scanner scanner, Cliente c){
        System.out.println(
                "\nMenù principale (User.Utente): \n" +
                        "\n1.    Contenuto Carrello.Carrello. " +
                        "\n2.    Termina Operazione. " +
                        "\nInerisci la tua scelta: \n");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Serve a pulire la linea precedentemente creata da scanner.nextInt();

        switch (choice){
            case 1 -> System.out.println(c.getCarrelloUtente());
            case 2 -> main(null);
        }

    }

    public static void register(Scanner scanner) throws IOException {
        System.out.println("Inserisci il nome:");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il cognome");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci la password");
        String password =scanner.nextLine();
        System.out.println("conferma password");
        String confirmPassword = scanner.nextLine();
        while (!password.equals(confirmPassword) ){
            System.out.println("Le password inserite non combaciano riprovare");
            System.out.println("Inserisci la password");
            password = scanner.nextLine();
            System.out.println("conferma password");
            confirmPassword = scanner.nextLine();
        }
        Type userListType = new TypeToken<List<Utente>>() {}.getType();
        JsonHandler jsonHandler = new JsonHandler();
        Cliente cliente = new Cliente(nome,cognome, "3" , MD5Converter(password));
        List<Utente> tmpList = new ArrayList<>();
        tmpList.add(cliente);
        jsonHandler.writeToJson("userdetails.json", tmpList);
    }

    public static Cliente login(Scanner scanner) throws IOException {
        System.out.println("Nome utente:");
        String nome = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();

        // Create a JsonHandler instance
        JsonHandler jsonHandler = new JsonHandler();

        // Read the single Utente object from the JSON file
        Cliente cliente = jsonHandler.readSingleFromJson("userdetails.json", Cliente.class);

        // Check if the input credentials match the ones in the JSON file
        if (cliente.getNome().equals(nome) && cliente.getPassword().equals(MD5Converter(password))) {
            System.out.println("Benvenuto " + cliente.getNome() + " " +cliente.getCognome());
            return cliente;
        }

        // If no match is found
        System.out.println("Login fallito: nessun utente trovato con questi dati");
        return null;
    }

    public static String MD5Converter(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("Md5");

            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for(byte b: hashBytes){
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }catch (NoSuchAlgorithmException e){
            e.getMessage();
            throw  new RuntimeException("Not found" + e.getMessage());
        }
    }
}