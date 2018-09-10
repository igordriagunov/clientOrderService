package ru.itpark;

import ru.itpark.domain.Buy;
import ru.itpark.domain.Client;
import ru.itpark.service.ClientService;
import ru.itpark.service.ClientServiceImpl;

public class Main {
    public static void main(String[] args) {

        ClientService service = new ClientServiceImpl();

//        System.out.println(service.findAllClients());
//        System.out.println(service.sortByYearASC());

//        service.add(
//                new Client(
//                        0,
//                        "Oleg",
//                        2002,
//                        "89273245698",
//                        "andy777@gmail.com"
//                )
//        );


    }
}
