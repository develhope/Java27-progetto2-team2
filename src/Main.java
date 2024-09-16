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
        Gestore gestore = new Gestore("Domingo", "Flamingo",  "passwordsicuramentesicura");
        Cliente cliente = new Cliente("Gianpaolo","Carrelli","passowrdnonsicura");

        //Dispositivi
        DispositivoElettronico dispositivoElettronico1 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);
        DispositivoElettronico dispositivoElettronico2 = new DispositivoElettronico("Smartphone","Apple","IPhone 15 pro", 123, 1499.99,999.99,6.1,256.00,"Telefono Apple", TipologiaDispositivoElettronico.SMARTPHONE);

        //Aggiunta Dispositivi a Magazino
        magazzino.aggiungiProdotto(dispositivoElettronico1);
        magazzino.aggiungiProdotto(dispositivoElettronico2);

        //Menù di scelta
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMenù principale (User.Utente): \n" +

                "\n1.    Registrati " +
                "\n2.    Accedi " +
                "\nInerisci la tua scelta: \n"

        );

        int sceltaMenuRegisterLogin = scanner.nextInt();
        scanner.nextLine();

        try{
            registerOrLoginMenu(sceltaMenuRegisterLogin,scanner,magazzino);

        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static void menuCliente(Scanner scanner,Utente utente) throws InterruptedException {
        System.out.println(
                "\nMenù principale (Cliente): \n" +
                        "\n1.    Gestisci carrello (-> Più opzioni) " +
                        "\n2.    Termina operazione.\n" +
                        "\nInerisci la tua scelta: \n");

        int scelta = scanner.nextInt();
        scanner.nextLine();

        gestireCarello(scanner, (Cliente)utente);


        scanner.close();
    }

    public static void registerOrLoginMenu(int scelta, Scanner scanner, Magazzino magazzino) throws IOException, InterruptedException {
        switch (scelta){
            case 1 -> register(scanner);
            case 2 -> {
                Utente utente = login(scanner);
                if(utente.getRuolo().equals("Gestore")){
                    menuGestore(scanner,utente, magazzino);
                }
                else if (utente.getRuolo().equals("Cliente")){
                    menuCliente(scanner, utente);
                }
            }
        }
    }

    public static void menuGestore(Scanner scanner, Utente utente, Magazzino magazzino){
        System.out.println(
                "\nMenù principale (Gestore): \n" +
                        "\n1.    Visualizza prodotti in magazzino. " +
                        "\n2.    Ricerca prodotti (-> Più opzioni) " +
                        "\n3.    Rimuovi prodotto per ID da magazzino" +
                        "\n4.    Termina operazione.\n" +
                        "\nInerisci la tua scelta: \n");

        int scelta = scanner.nextInt();
        scanner.nextLine();

        sceltaMenuGestore(scelta,scanner,utente,magazzino);
    }



  public static void sceltaMenuGestore(int a, Scanner scanner, Utente utente, Magazzino m){

            switch (a){
                case 1->{
                    for(Prodotto prodotto : m.getProdotti()){
                        System.out.println(prodotto);
                    }
                }
                case 2->{
                    ricercaProdottoNelMagazzino(scanner,m);
                }
                case 3->{
                    System.out.println("Inserisci l'id del prodotto che vuoi rimuovere dal magazzino");
                    int sceltaProdottoDaRimuovere = scanner.nextInt();
                    m.rimuoviProdotto(sceltaProdottoDaRimuovere);
                    System.out.println("Prodotto con id: " + sceltaProdottoDaRimuovere + " è stato rimosso");
                }
                case 4->{
                    menuGestore(scanner,utente,m);
                }
            }

    }


    public static void gestireCarello(Scanner scanner, Cliente cliente) throws InterruptedException {


        boolean isInMenu = true;
        while(isInMenu){

            System.out.println("\nMenù carrello: \n" +
                    "\n1.    Visualizza prodotti nel carrello. " +
                    "\n2.    Aggiungi prodotto nel carrello " +
                    "\n3.    Rimuovi prodotto dal carrello " +
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
                    Thread.sleep(1000);
                    System.out.println("Prodotti nel carrello:");
                    Thread.sleep(50);
                    cliente.visualizzaCarrello();
                    Thread.sleep(1000);
                    System.out.println("");
                    System.out.println("Prezzo totale: " + cliente.calcolaTotaleCarrello());
                    Thread.sleep(1000);
                    System.out.println("");
                    System.out.println("Acquisto Completato! Grazie!");
                    cliente.svuotaCarrello();
                    Thread.sleep(1000);
                    menuCliente(scanner,cliente);
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





    public static void gestisciMagazzino(Scanner scanner, Utente utente){
        System.out.println("In scope");
    }

    public static void ricercaProdottoNelMagazzino(Scanner scanner, Magazzino m){
        System.out.println(
                "\nMenù principale (User.Utente): \n" +
                        "\n1.    Ricerca per Tipo. " +
                        "\n2.    Ricerca per Produttore " +
                        "\n3.    Ricerca per Modello " +
                        "\n4.    Ricerca per Range di Prezzo. " +
                        "\n5.    Ricerca per id" +
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
                m.getProdottoById(finderHandler);
            }
            case 6 -> main(null);
        }
    }


    public static void register(Scanner scanner) throws IOException {
        System.out.println("Inserisci il nome:");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il cognome");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci la password");
        String password = scanner.nextLine();
        System.out.println("Conferma password");
        String confirmPassword = scanner.nextLine();

        // Verifica che le password corrispondano
        while (!password.equals(confirmPassword)) {
            System.out.println("Le password inserite non combaciano. Riprovare.");
            System.out.println("Inserisci la password");
            password = scanner.nextLine();
            System.out.println("Conferma password");
            confirmPassword = scanner.nextLine();
        }

        // Richiedi il ruolo
        System.out.println("Inserisci il ruolo (cliente/gestore):");
        String ruolo = scanner.nextLine();

        // Creazione dell'utente in base al ruolo
        Utente utente;
        switch (ruolo.toLowerCase()) {
            case "cliente":
                utente = new Cliente(nome, cognome,  MD5Converter(password));
                break;
            case "gestore":
                utente = new Gestore(nome, cognome,  MD5Converter(password));
                break;
            default:
                throw new IllegalArgumentException("Ruolo non valido. Utilizzare 'cliente' o 'gestore'.");
        }

        // Scrittura dell'utente nel file JSON
        List<Utente> utentiEsistenti = new ArrayList<>();
        JsonHandler jsonHandler = new JsonHandler();

        // Leggi gli utenti esistenti dal file
        try {
            utentiEsistenti = jsonHandler.readFromJson("userdetails.json", new TypeToken<List<Utente>>() {}.getType());
        } catch (IOException e) {
            // Il file potrebbe non esistere ancora, il che è accettabile
        }

        // Aggiungi il nuovo utente alla lista
        if(utentiEsistenti == null){
            utentiEsistenti = new ArrayList<>();

        }else {
            System.out.println("Impossibile aggiungere l'utente, la lista è null!");
        }
         utentiEsistenti.add(utente);

        // Scrivi di nuovo la lista nel file JSON
        jsonHandler.writeToJson("userdetails.json", utentiEsistenti);

        System.out.println("Registrazione completata con successo!");
    }

    public static Utente login(Scanner scanner) throws IOException {

        boolean isLogged = false;

        while(!isLogged){
            System.out.println("Nome utente:");
            String nome = scanner.nextLine();
            System.out.println("Password:");
            String password = scanner.nextLine();

            JsonHandler jsonHandler = new JsonHandler();

            List<Utente> utentiEsistenti = jsonHandler.readFromJson("userdetails.json", new TypeToken<List<Utente>>() {}.getType());

            for (Utente utente : utentiEsistenti) {
                if (utente instanceof Cliente cliente) {
                    if (cliente.getNome().equals(nome) && cliente.getPassword().equals(MD5Converter(password))) {
                        System.out.println("Benvenuto " + cliente.getNome() + " " + cliente.getCognome() + " ruolo(" + cliente.getRuolo() + ")" );
                        return cliente;
                    }
                }
                if(utente instanceof Gestore gestore){
                    if(gestore.getNome().equals(nome) && gestore.getPassword().equals(MD5Converter(password))){
                        System.out.println("Benvenuto " + gestore.getNome() + " " + gestore.getCognome() + " ruolo(" + gestore.getRuolo() + ")" );
                        return gestore;
                    }
                }
            }


        }
        System.out.println("Login fallito: nessun utente trovato con questi dati\n");
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