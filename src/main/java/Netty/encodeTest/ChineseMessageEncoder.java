package Netty.encodeTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

/**
 * Created by yzwang on 2019/10/4.
 * https://juejin.im/post/5d954ab35188251e3a06b6d2?utm_source=gold_browser_extension
 */
// 编码器
public class ChineseMessageEncoder extends MessageToByteEncoder<ChineseMessage> {

    @Override
    protected void encode(ChannelHandlerContext ctx, ChineseMessage target, ByteBuf out) throws Exception {

        // 写入ID
        out.writeLong(target.getId());
        String message = target.getMessage();
        int length = message.length();
        // 写入Message长度
        out.writeInt(length);
        // 写入Message字符序列
        out.writeCharSequence(message, StandardCharsets.UTF_8);

//        out.writeLong(target.getId());
//        String message = target.getMessage();
//        int writerIndex = out.writerIndex();
//        out.writeInt(0);
//        int length = ByteBufUtil.writeUtf8(out, message);
//        out.setInt(writerIndex, length);
    }
}
