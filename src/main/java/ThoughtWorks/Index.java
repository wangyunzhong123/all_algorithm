package ThoughtWorks;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yzwang on 2017/9/10.
 */
public class Index {

    private static int Weekday_1 = 30; // 9-12
    private static int Weekday_2 = 50; // 12-18
    private static int Weekday_3 = 80; // 18-20
    private static int Weekday_4 = 60; // 20-22

    private static int Weekendday_1 = 40; //9-12
    private static int Weekendday_2 = 50; //12-18
    private static int Weekendday_3 = 60; //18-22

    private static double Cancer_Weekday = 0.5;
    private static double Cancer_Weekend = 0.25;

    private static Map<String,Map<String,ArrayList<Book>>> map;

    private static class Book{

        public int flag;// 1, booking; 2, cancel
        public String date;
        public int start;//ex,19-22
        public int end;//ex,19-22
        public double money;
        public String uid;

        public Book(int a,String b,int c,int d,String f){
            flag = a;
            date = b;
            start = c;
            end = d;
            uid = f;
        }
        public Book(int a,String b,int c,int d,double e,String f){
            flag = a;
            date = b;
            start = c;
            end = d;
            money = e;
            uid = f;
        }

        @Override
        public String toString() {
            String result = "";
            if(flag ==1){

                result = date + " "+start+"~"+end +" "+money+"元";

            }else if(flag ==2)
                result = date + " "+start+"~"+end  + " 违约金 "+money+"元";

            return  result;
        }
    }




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        map = new HashMap<String, Map<String, ArrayList<Book>>>();

        try{
            while(true){
                String line = sc.nextLine();
                String[] result = line.split(" ");
                if(result.length ==4){

                    go_to_book(result);
                }else if(result.length == 5){

                    go_to_cancle(result);
                }
                else if("".equals(line.trim()))
                    show_result();
                else
                    printf_Error(2);
            }

//            show_result();
        }catch (Exception e){
            printf_Error(2);
        }

    }

    //预定
    public static void go_to_book(String[] line) throws Exception{

        String uid = line[0];
        String date = line[1];
        String time = line[2];
        int start  = Integer.valueOf(time.substring(0,2));
        int end  = Integer.valueOf(time.substring(6,8));
        if(start == end){
            printf_Error(2);
            return;
        }
        String which = line[3];

        Map<String,ArrayList<Book>> dada = map.get(which);
        //判断是否有该场馆记录
        if(dada == null){
            dada = new HashMap<String, ArrayList<Book>>();
        }
        ArrayList<Book> list = dada.get(date);
        if(list == null)
            list = new ArrayList();

        ReturnData result = getBookInList(list,new Book(1,date,start,end,uid));

        if(result.key == 1){
            printf_Error(3);
            return;
        }
        if(result.key == 2){
            double money = get_weekday_or_weekend(date,start,end);

            list.add(new Book(1,date,start,end,money,uid));
            dada.put(date,list);
            map.put(which,dada);
            printf_Error(1);
        }

    }

    //取消
    public static void go_to_cancle(String[] line) throws Exception{

        String uid = line[0];
        String date = line[1];
        String time = line[2];
        int start  = Integer.valueOf(time.substring(0,2));
        int end  = Integer.valueOf(time.substring(6,8));
        String which = line[3];
        String cancle = line[4];
        if(!cancle.equals("C")){
            printf_Error(2);
            return;
        }
        if(start == end){
            printf_Error(2);
            return;
        }

        Map<String,ArrayList<Book>> dada = map.get(which);
        //判断是否有该场馆记录
        if(dada == null){
            dada = new HashMap<String, ArrayList<Book>>();
        }
        List list = dada.get(date);
        if(list == null)
            list = new ArrayList();

        ReturnData result = getBookInList(list,new Book(2,date,start,end,uid));
        if(result.key == 3){
            printf_Error(4);
            return;
        }
        if(result.key == 4){
            double money = money_of_cancle(date,result.book.money);
            result.book.flag =2;
            result.book.money = money;
            printf_Error(1);
        }


    }

    //取消预定的费用
    public static double money_of_cancle(String data,double a) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(data));
        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }

        double money = 0;
        if(dayForWeek <= 5)
            money = a * (Cancer_Weekday);
        else
            money = a * (Cancer_Weekend);

        return money;

    }

    //从日期得到周几，定场地的费用
    public static double get_weekday_or_weekend(String data,int start,int end) throws Exception{

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(data));
        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }

        double money = 0;
        //周内
        if(dayForWeek <=5){
            if(start >= 9 && start <= 12){
                if(end <= 12)
                    money += Weekday_1 * (end - start);
                else if(end <=18){
                    money += Weekday_1 * (12 - start);
                    money += Weekday_2 * (end - 12);
                }
                else if(end <= 20){
                    money += Weekday_1 * (12 - start);
                    money += Weekday_2 * (18 - 12);
                    money += Weekday_3 * (20 - end);
                }
                else if(end <= 22){
                    money += Weekday_1 * (12 - start);
                    money += Weekday_2 * (18 - 12);
                    money += Weekday_3 * (20 - 18);
                    money += Weekday_4 * (end - 20);
                }
            }
            else if(start >=12 && start <= 18){
                if(end <=18){
                    money += Weekday_2 * (end - start);
                }
                else if(end <= 20){
                    money += Weekday_2 * (18 - start);
                    money += Weekday_3 * (end - 18);
                }
                else if(end <= 22){
                    money += Weekday_2 * (18 - start);
                    money += Weekday_3 * (20 - 18);
                    money += Weekday_4 * (end - 20);
                }
            }
            else if(start >=18 && start <= 20){
                if(end <= 20){
                    money += Weekday_3 * (end -start);
                }
                else if(end <=22){
                    money += Weekday_3 * (20 - start);
                    money += Weekday_4 * (end - 20);
                }
            }
            else if(start >= 20 && start <= 22){
                if(end <=22){
                    money += Weekday_4 * (end -start);
                }
            }

        }
        else {//周末
            if(start >= 9 && start <= 12){
                if(end <= 12)
                    money += Weekendday_1 * (end - start);
                else if(end <=18){
                    money += Weekendday_1 * (12 - start);
                    money += Weekendday_2 * (end - 12);
                }
                else if(end <= 22){
                    money += Weekendday_1 * (12 - start);
                    money += Weekendday_2 * (18 - 12);
                    money += Weekendday_3 * (end - 18);
                }

            }
            else if(start >=12 && start <= 18){
                if(end <=18){
                    money += Weekendday_2 * (end - start);
                }
                else if(end <= 22){
                    money += Weekendday_2 * (18 - start);
                    money += Weekendday_3 * (end - 18);
                }
            }
            else if(start >=18 && start <= 22){
                if(end <= 22){
                    money += Weekendday_3 * (end -start);
                }
            }
        }
        return money;

    }

    //判断List列表中是否有记录
    //1, 预定，返回已预定；2，预定，可预定；3，取消，不可取消，错误；4，可取消，返回原Book
    public static ReturnData getBookInList(List list,Book a){

        for (int i = 0; i < list.size(); i++) {
            Book book = (Book)list.get(i);
            //本已经预定了
            if(book.flag == 1 && a.flag == 1 && ((a.start > book.start && a.start < book.end) || (a.end > book.start && a.end < book.end))){

                return new ReturnData(1,null);
            }


            if(book.flag == 1 && a.flag == 2 && a.start == book.start && a.end == book.end && a.uid.equals(book.uid))
                return new ReturnData(4,book);

        }
        if(a.flag ==1)
            return new ReturnData(2,null);
        else if(a.flag == 2)
            return new ReturnData(3,null);
        return null;
    }

    private static class ReturnData{
        public int key;
        public Book book;
        public ReturnData(int a, Book b){
            key = a;
            book = b;
        }
    }

    //1, Success: the booking is accepted!
    //2, Error: the booking is invalid!
    //3,Error: the booking conflicts with existing bookings!
    public static void printf_Error(int a){

        if(a == 1)
            System.out.println("Success: the booking is accepted!");
        else if(a == 2)
            System.out.println("Error: the booking is invalid!");
        else if(a == 3)
            System.out.println("Error: the booking conflicts with existing bookings!");
        else if(a == 4)
            System.out.println("Error: the booking being cancelled does not exist!");

    }

    //显示收入

    public static void show_result(){
        System.out.println("收入汇总");
        System.out.println("---");

        double money = 0;

        System.out.println("场地:A");
        Map map_a = map.get("A");
        if(map_a != null)
            money += show(map_a);
        else
            System.out.println("小计："+0+"元");

        System.out.println();
        System.out.println("场地:B");
        map_a = map.get("B");
        if(map_a != null)
            money += show(map_a);
        else
            System.out.println("小计："+0+"元");

        System.out.println();
        System.out.println("场地:C");
        map_a = map.get("C");
        if(map_a != null)
            money += show(map_a);
        else
            System.out.println("小计："+0+"元");

        System.out.println();
        System.out.println("场地:D");
        map_a = map.get("D");
        if(map_a != null)
            money += show(map_a);
        else
            System.out.println("小计："+0+"元");

        System.out.println();
        System.out.println("总计："+money);


    }

    public static double show(Map map_a){
        double money_a = 0;
        for(Object object : map_a.values()){
            ArrayList<Book> list = (ArrayList<Book>) object;
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                money_a += list.get(i).money;
            }
        }
        System.out.println("小计："+money_a+"元");
        System.out.println();

        return money_a;
    }
}
