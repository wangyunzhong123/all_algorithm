package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by yzwang on 2019/8/24.
 */
public class StreamTest {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(1, 2));
        list.add(new User(11, 21));

//        Map map = list.stream().collect(Collectors.toMap(User::getId, Function.identity()));
//        System.out.println(map);

    }

    static class User {
        int id;
        int age;

        public User(int id, int age) {
            this.id = id;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", age=" + age +
                    '}';
        }
    }
}
