package app;


import app.ports.PersonPort;
import app.ports.PlacePort;

import java.util.Scanner;

public class Menu {

        public static void menu()
        {
            PersonPort personP = new PersonPort();
            PlacePort placeP = new PlacePort();
            Scanner scan = new Scanner(System.in);
            int option;
            boolean flag = true;

            while(flag)
            {
                System.out.println("-------- Menu -------- ");
                System.out.println("1- Check Persons");
                System.out.println("2- Check Places");
                System.out.println("3- Find person by DNI");
                System.out.println("4- Find Place by ID");
                System.out.println("5- Find person by Voted");
                System.out.println("6- Exit");
                option = scan.nextInt();
                switch(option) {
                    case 1:

                        personP.getPersons();

                        break;

                    case 2:

                       placeP.getPlaces();

                        break;
                    case 3:
                        String dni;
                        System.out.println("Enter DNI: ");
                        scan.nextLine();
                        dni = scan.nextLine();
                        personP.getPersonsByDni(dni);
                        break;
                    case 4:
                        Long id;
                        System.out.println("Enter ID: ");

                        id = scan.nextLong();
                        placeP.getPlaceById(id);
                        break;
                    case 5:
                        int opb;
                        System.out.println("1- Voted");
                        System.out.println("2- Not Voted");
                       opb = scan.nextInt();
                       if(opb == 1)
                           personP.findVoted(true);
                       else if(opb == 2)
                          personP.findVoted(false);

                        break;
                    case 6:
                        flag = false;
                        break;
                    default: System.out.println("Invalid Option");
                }
            }

        }
    }

