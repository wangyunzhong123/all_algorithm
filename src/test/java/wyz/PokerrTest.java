package wyz;

import java.nio.charset.Charset;

import static org.junit.Assert.*;

/**
 * Created by tianxi on 12/30/16.
 */
public class PokerrTest {
    public static void main(String[] args) throws Exception {
        Pokerr poker = new Pokerr();
        poker.shuffle();                // 洗牌
        Pokerr.Card c1 = poker.deal(0);  // 发第一张牌
        // 对于非静态内部类Card
        // 只有通过其外部类Poker对象才能创建Card对象
        Pokerr.Card c2 = poker.new Card("红心", 1);    // 自己创建一张牌

        System.out.println(c1);    // 洗牌后的第一张
        System.out.println(c2);    // 打印: 红心A


        /*
        * 输出系统默认编码方式的对 很屌 的16进制编码字符
        * */
        System.out.println("######################");
        String str = "很屌";
        byte[] bs = str.getBytes("GBK");
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        int bit;
        for(int i = 0; i < bs.length; i++){
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);

        }
        System.out.println(sb.toString());
        System.out.println(byte2hex(bs));
        System.out.println(Charset.defaultCharset());
        System.out.println(System.getProperty("file.encoding"));
    }

    //字节码转换成16进制字符串
    public static String byte2hex(byte bytes[]){
        StringBuffer retString = new StringBuffer();
        for (int i = 0; i < bytes.length; ++i)
        {
            retString.append(Integer.toHexString(0x0100 + (bytes[i] & 0x00FF)).substring(1).toUpperCase());
        }
        return retString.toString();
    }


}