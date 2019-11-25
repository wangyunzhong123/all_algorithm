package Netty.encodeTest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by yzwang on 2019/10/4.
 */
// 解码器
public class ChineseMessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        // 读取ID
        long id = in.readLong();
        // 读取Message长度
        int length = in.readInt();
        // 读取Message字符序列
        CharSequence charSequence = in.readCharSequence(length, StandardCharsets.UTF_8);
        ChineseMessage message = new ChineseMessage();
        message.setId(id);
        message.setMessage(charSequence.toString());
        out.add(message);
    }
}
