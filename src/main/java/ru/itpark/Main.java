package ru.itpark;

import ru.itpark.repository.OrderRepository;

public class Main {
    public static void main(String[] args) {

        OrderRepository repository = new OrderRepository("jdbc:sqlite:db.sqlite3");

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
//                        "Ruslan",
//                        2000,
//                        "89997777777",
//                        "7abc7@gmail.com"
//                )
//        );


        System.out.println(repository.sortByYearASC());
        System.out.println(repository.sortByYearDESC());


    }
}
