/*Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
        Организовать ввод и хранение данных пользователей. ФИО возраст и пол
        вывод в формате Фамилия И.О. возраст пол
        добавить возможность выхода или вывода списка отсортированного по возрасту!)
        *реализовать сортировку по возрасту с использованием индексов
        *реализовать сортировку по возрасту и полу с использованием индексов*/
import java.io.FileReader;
import java.util.ArrayList;

import java.util.Comparator;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        //Организовать ввод и хранение данных пользователей. ФИО возраст и пол вывод в формате Фамилия И.О. возраст пол
        String data = "";
        FileReader reader = new FileReader("C:\\Users\\kaval\\IdeaProjects\\Task4\\src\\data.sql");
        while (reader.ready()) {
            data += (char) reader.read();
        }
        reader.close();
        System.out.print("Data: " + data);

        System.out.println("");
        System.out.println("");

        //вывод в формате Фамилия И.О. возраст пол
        String[] lst = data.split("\r\n");

        ArrayList<String> people = new ArrayList<>();
        for (int i = 0; i < lst.length; i++) {
            people.add(lst[i]);
        }

        System.out.print("List of people: ");
        for (int i = 0; i < people.size(); i++) {
            String[] array = people.get(i).split(" ");
            System.out.print(array[0] + " " + array[1].toUpperCase().charAt(0) + "."
                    + array[2].toUpperCase().charAt(0) + ". " + array[3] + " " + array[4] + " ");
        }

        System.out.println("");
        System.out.println("");

        //добавить возможность выхода или вывода списка отсортированного по возрасту
        people.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.split(" ")[3]) - Integer.parseInt(o2.split(" ")[3]);
            }
        });
        System.out.println("Sorted list (on age): ");
        for (int i = 0; i < people.size(); i++) {
            String[] array = people.get(i).split(" ");
            System.out.println(array[0] + " " + array[1].toUpperCase().charAt(0) + "."
                    + array[2].toUpperCase().charAt(0) + ". " + array[3] + " " + array[4]);

        }
//        System.out.println(people.size());

        }
}