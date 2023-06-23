/*Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
        Организовать ввод и хранение данных пользователей. ФИО возраст и пол
        вывод в формате Фамилия И.О. возраст пол
        добавить возможность выхода или вывода списка отсортированного по возрасту!)
        *реализовать сортировку по возрасту с использованием индексов
        *реализовать сортировку по возрасту и полу с использованием индексов*/

import java.io.FileReader;
import java.sql.Array;
import java.util.*;
import java.io.IOException;

public class Task4_1 {
        public static void main(String[] args) throws IOException {
            ArrayList<String> lastName = new ArrayList<>();
            ArrayList<String> firstName = new ArrayList<>();
            ArrayList<String> patronym = new ArrayList<>();
            ArrayList<Integer> age = new ArrayList<>();
            ArrayList<String> gender = new ArrayList<>();
            LinkedList<Integer> index = new LinkedList<>();

            String data = "";
            FileReader reader = new FileReader("C:\\Users\\kaval\\IdeaProjects\\Task4\\src\\data.sql");
            while (reader.ready()) {
                data += (char) reader.read();
            }
            reader.close();

            String[] lst = data.split("\r\n");

            ArrayList<String> people1 = new ArrayList<>();
            for (int i = 0; i < lst.length; i++) {
                people1.add(lst[i]);
                String [] sb = lst[i].split(" ");
                lastName.add(sb[0]);
                firstName.add(sb[1]);
                patronym.add(sb[2]);
                age.add(Integer.valueOf(sb[3]));
                gender.add(sb[4]);
                index.add(i);

            }
            Collections.sort(index, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {

                    return age.get(o1) - age.get(o2);
                }

            });

            System.out.println("Sorted indexes: " + index);
            System.out.println("Unsorted ages: " + age);




            }
        }

