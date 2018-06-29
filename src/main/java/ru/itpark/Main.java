package ru.itpark;

import ru.itpark.domain.Buy;
import ru.itpark.repository.BuyRepository;

import ru.itpark.repository.ClientRepositoryImpl;
import ru.itpark.service.ClientServiceImpl;

public class Main {
    public static void main(String[] args) {

        ClientRepositoryImpl clientRepository = new ClientRepositoryImpl(
                "jdbc:mysql://localhost:3306/clientdb?verifyServerCertificate=false&useSSL=false&password=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC",
                "root", "password");

        BuyRepository buyRepository = new BuyRepository(
                "jdbc:mysql://localhost:3306/clientdb?verifyServerCertificate=false&useSSL=false&password=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC",
                "root", "password");

        ClientServiceImpl service = new ClientServiceImpl(clientRepository, buyRepository);



//        repository.add(
//                new Client(0,
//                        "vasya",
//                        1999,
//                        "89993273682",
//                        "qwer@mail.ru"
//                )
//        );
////
//        repository.update(
//                new Client(
//                        1,
//                        "petya",
//                        1999,
//                        "89273273682",
//                        "rewq@gmail.com"
//                )
//        );

//        repository.update(
//                new Client(
//                        1,
//                        "petya",
//                        1999,
//                        "89173273682",
//                        "test111@gmail.com"
//                )
//        );

//        repository.add(
//                new Client(
//                        2,
//                        "Masha",
//                        1991,
//                        "89991111111",
//                        "aaaaa@gmail.com"
//                )
//        );
//
//        repository.add(
//                new Client(
//                        3,
//                        "Olga",
//                        1970,
//                        "89602222222",
//                        "bbbbb@gmail.com"
//                )
//        );
//
//        repository.add(
//                new Client(
//                        4,
//                        "Руслан",
//                        2000,
//                        "89997777777",
//                        "7abc7@gmail.com"
//                )
//        );


//        System.out.println(repository.sortByYearASC());
//        System.out.println(repository.sortByYearDESC());
//        System.out.println(repository.findAll());

//        buyRepository.add(
//                new Buy(
//                        5,
//                        2,
//                        1000
//
//                )
//        );

//        buyRepository.add(
//                new Buy(
//                        0,
//                        3,
//                        200_000
//                )
//        );

//        buyRepository.add(
//                new Buy(
//                        2,
//                        3,
//                        10_000
//                )
//        );

//        System.out.println(buyRepository.findTotalByClientId(4));
//        System.out.println(buyRepository.findTotalByClientId(1));
//        buyRepository.clientStatus(1);

//        System.out.println(buyRepository.sortClientByTotal());
//        System.out.println(buyRepository.findTotalByClientId(1));
    }
}
