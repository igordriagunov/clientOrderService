package ru.itpark;

import ru.itpark.repository.BuyRepository;
import ru.itpark.repository.ClientRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        ClientRepositoryImpl repository = new ClientRepositoryImpl("jdbc:sqlite:db.sqlite3");
        BuyRepository buyRepository = new BuyRepository("jdbc:sqlite:db.sqlite3");

//        ClientService service = new ClientServiceImpl(
//                new ClientRepositoryImpl("jdbc:sqlite:db.sqlite3")
//        );

//        repository.add(
//                new Client(
//                        1,
//                        "vasya",
//                        1999,
//                        "89993273682",
//                        "qwer@mail.ru"
//                )
//        );
//
//        repository.update(
//                new Client(
//                        1,
//                        "petya",
//                        1999,
//                        "89273273682",
//                        "rewq@gmail.com"
//                )
//        );
//
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
//                        1,
//                        2,
//                        999,
//                        "default"
//                )
//        );

//        buyRepository.add(
//                new Buy(
//                        3,
//                        4,
//                        200,
//                        "default"
//                )
//        );

//        buyRepository.add(
//                new Buy(
//                        4,
//                        2,
//                        101,
//                        "default"
//                )
//        );

        System.out.println(buyRepository.findTotalByClientId(4));
        System.out.println(buyRepository.findTotalByClientId(2));

    }
}
