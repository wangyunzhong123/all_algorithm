package Netty.Websocket.server.netty;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.function.Predicate;

/**
 * Created by yzwang on 2019/7/10.
 */
public class NettyConfig {

    //存储每一个客户端接入进来时的channel对象
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    Predicate p;

}
