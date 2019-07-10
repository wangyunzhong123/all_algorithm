package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by yzwang on 2019/7/8.
 */
public class CollectorsTest {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "1"));
        list.add(new Person(2, "2"));
        list.add(new Person(3, "3"));

        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(map);

        Map<Integer, Person> mapp = list.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(mapp);

    }

    private static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}

