package Netty.encodeTest;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * Created by yzwang on 2019/10/4.
 * 链接：https://juejin.im/post/5d954ab35188251e3a06b6d2
 */
public class ChineseNettyClient {

    public static void main(String[] args) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(workerGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.option(ChannelOption.TCP_NODELAY, Boolean.TRUE);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 4));
                    ch.pipeline().addLast(new LengthFieldPrepender(4));
                    ch.pipeline().addLast(new ChineseMessageEncoder());
                    ch.pipeline().addLast(new ChineseMessageDecoder());
                    ch.pipeline().addLast(new SimpleChannelInboundHandler<ChineseMessage>() {

                        @Override
                        protected void channelRead0(ChannelHandlerContext ctx, ChineseMessage message) throws Exception {
                            System.out.println("接收到服务端的响应:{}" + message);
                        }
                    });
                }
            });
            ChannelFuture future = bootstrap.connect("localhost", 9092).sync();
            System.out.println("客户端启动成功...");
            Channel channel = future.channel();
            ChineseMessage message = new ChineseMessage();
            message.setId(1L);
            message.setMessage("张大狗");
            channel.writeAndFlush(message);
            future.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
