package ThoughtWorks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

import static org.junit.Assert.*;

/**
 * Created by yzwang on 2017/9/10.
 */
public class IndexTest {


    @Test
    public void get_weekday_or_weekend() throws Exception {

//        String data = "2017-09-10";
//
//        System.out.println(Index.get_weekday_or_weekend(data,9,19));

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> ns = new ArrayList();
        do {
            String string = scanner.nextLine();
            if (string.equals("")) {
                break;
            }
            ns.add(Integer.valueOf(string));
        } while (true);

        System.out.println(ns);

        Object [] a = new Object[5];

        synchronized (a){

        }


    }

}