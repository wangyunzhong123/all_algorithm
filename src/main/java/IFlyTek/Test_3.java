package IFlyTek;

import java.util.*;

/**
 * Created by yzwang on 2017/9/16.
 */
public class Test_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        Map<Data,String> map = new HashMap<Data, String>();
        Map<Data,String> result = new TreeMap<Data, String>(
                new Comparator<Data>() {
                    public int compare(Data obj1, Data obj2) {
                        // 降序排序
                        return obj1.hashCode() - obj2.hashCode();
                    }
                });

        List<String> result_1 = new ArrayList();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            int day = Integer.valueOf(line.substring(0,1));
            int time = Integer.valueOf(line.substring(1,2));

            String name = line.substring(3,9);

//            System.out.println(day+" "+time+" "+name);

            Data temp = new Data(day,time);
            if(map.containsKey(temp)){
                if(result.containsKey(temp))
                    result.put(temp,result.get(temp)+" "+name);
                else
                    result.put(temp,map.get(temp)+" "+name);
//                result_1.add(temp+" "+map.get(temp)+" "+name);
            }
            else
                map.put(temp,name);
        }

//        if(result_1.size() == 0){
//            System.out.println("YES");
//            return;
//        }
//        for (int i = 0; i <result_1.size() ; i++) {
//            System.out.println(result_1.get(i));
//        }

        if(result.size()==0){
            System.out.println("YES");
            return;
        }
        //output
        Set<Data> keySet = result.keySet();
        Iterator<Data> iter = keySet.iterator();
        while (iter.hasNext()) {
            Data key = iter.next();
            System.out.println(key + " " + result.get(key));
        }

    }

    private static class Data{

        public int day;
        public int time;

        public Data(int day, int time) {
            this.day = day;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data = (Data) o;

            if (day != data.day) return false;
            return time == data.time;
        }

        @Override
        public int hashCode() {
            int result = day;
            result = 31 * result + time;
            return result;
        }

        @Override
        public String toString() {
            return ""+day+""+time+"";
        }
    }
}
