package ru.makerov.main;

import ru.makerov.geometry.*;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    private Scanner scanner = new Scanner(System.in);

    private int readInt(String promt){
        System.out.print(promt);
        while(!scanner.hasNextInt()){
            System.out.print("Ошибка! Введите целое число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
        double result = Power.calculate(args[0], args[1]);
        System.out.println(result);

    }

    public void run(){

        int n = 10;
        while (n!=0){
            n  = readInt("Введите номер задачи (1-8), 0-выход:  ");
            switch (n){

                case 1:
                    System.out.println("=== Задание 1.9: Диапазон оценок ===\n");
                    Student vasya9 = new Student("Вася", 3, 4, 5, 4);
                    System.out.println(vasya9);

                    try {
                        Student stepan9 = new Student("Стёпа", null);
                        System.out.println(stepan9);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Нельзя создать студента с некорректными оценками: "
                                + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("=== Задание 2.4: Телефонный справочник ===\n");
                    YelowPages telBook = new YelowPages();


                    telBook.add("Саша", "+78822243456");
                    telBook.add("Алиса", "+78822343456");

                    System.out.println(telBook.toString());

                    System.out.println("===Добавление повторяющегося имени===");

                    System.out.println(telBook.add("Иван", "+79933333454"));
                    System.out.println(telBook.add("Иван", "+79933333333"));

                    System.out.println(telBook.toString() +"\n\n");


//                    System.out.println(telBook.add("Игорь", "+79933333333"));
//                    System.out.println(telBook.toString()); Выброс ошибки при одинаковом номере
                    System.out.println("===Удаление===");
                    System.out.println(telBook.toString() + "  ===Было===");
                    telBook.delete("Иван");
                    System.out.println(telBook.toString() + " ===Стало==\n\n");

                    System.out.println("===Получение контакта===");
                    System.out.println(telBook.toString());
                    System.out.println("Номер Саши: " + telBook.getNumber("Саша") + "\n\n");

                    System.out.println("===Получение всех пар===");
                    System.out.println(Arrays.toString(telBook.allPairs())+"\n");

                    System.out.println("===Получение всех телефонов===");
                    System.out.println(Arrays.toString(telBook.allNumbers()) +"\n");

                    System.out.println("===Получение всех имён===");
                    System.out.println(Arrays.toString(telBook.allNames())+"\n\n");

                    System.out.println("===Проверка есть ли имя в списке или номер===");
                    System.out.println("Есть ли человек с именем Алиса: " + telBook.checkName("Алиса") + "\n");
                    System.out.println("Есть ли человек с номером 9008433: " + telBook.checkNumber("9008433") + "\n\n");

                    System.out.println("===Текущее кол-во контаков===");
                    System.out.println("Всего в справочнике контактов: " + telBook.sizeContacts());
                    System.out.println(telBook.toString() + "\n\n");


                    System.out.println("===Массив всех имён по части имени===");
                    System.out.println("Введено 'C': " + Arrays.toString(telBook.findNamesStartingWith("С")) + "\n");
                    System.out.println("Введено 'Иго': " + Arrays.toString(telBook.findNamesStartingWith("Иго")) + "\n");
                    System.out.println("Весь справочник: " + telBook.toString() + "\n\n");
                    break;

                case 3:
                    System.out.println("Задание 3.3");
                    TreePoint pos = new TreePoint(1,2,3);
                    System.out.println("Точка с координатами: " + pos);
                    break;

                case 4:
                    System.out.println("Задание 4.4");
                    Figure[] figures = {
                            new Circle(new Point(0, 0), 5),
                            new Square(new Point(3,4), 5),
                            new Rectangle(new Point(0, 0), 4, 6),
                            new Triangle(
                                    new Point(0, 0),
                                    new Point(4, 0),
                                    new Point(0, 3)
                            )
                    };


                    for (Figure figure : figures) {
                        System.out.println("Площадь: " + figure.getArea());
                    }
                    break;

                case 5:
                    System.out.println("Задание 5.3");
                    Figure[] figures1 = {
                            new Circle(new Point(0, 0), 5),
                            new Square(new Point(3,5), 2),
                            new Square(new Point(6,5), 4),
                            new Square(new Point(3,0), 12),
                            new Circle(new Point(1, 2), 4),
                            new Circle(new Point(5, 5), 10)



                    };


                    System.out.println("Общая площадь: " + Figure.getTotalArea(figures1) + "\n\n");

                    break;

                case 6:
                    Square square = new Square(new Point(5, 3), 23);
                    Polyline polyline = square.getPolyline();

                    System.out.println("Длина замкнутой ломаной: " + polyline.getLength());
                    break;
                case 7:
                    System.out.println("Задание 6.2");
                    Point first = new Point(3, 5);
                    Point second = new Point(3, 5);

                    System.out.println(first.equals(second));
                    break;

                case 8:
                    System.out.println("Задание 8.4");
                    Point original = new Point(3, 4);
                    Point copy = original.clone();
                    System.out.println("оригинал: " + original + " копия: " + copy);


            }
        }
    }
}
