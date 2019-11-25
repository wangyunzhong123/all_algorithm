package Netty.encodeTest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * Created by yzwang on 2019/10/4.
 */
// 服务端
public class ChineseNettyServer {

    public static void main(String[] args) throws Exception {
        int port = 9092;
        ServerBootstrap bootstrap = new ServerBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 4));
                            ch.pipeline().addLast(new LengthFieldPrepender(4));
                            ch.pipeline().addLast(new ChineseMessageEncoder());
                            ch.pipeline().addLast(new ChineseMessageDecoder());
                            ch.pipeline().addLast(new SimpleChannelInboundHandler<ChineseMessage>() {

                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, ChineseMessage message) throws Exception {
                                    System.out.println("接收到客户端的请求:{}" + message);
                                    ChineseMessage chineseMessage = new ChineseMessage();
                                    chineseMessage.setId(message.getId() + 1L);
                                    chineseMessage.setMessage("张小狗");
                                    ctx.writeAndFlush(chineseMessage);
                                }
                            });
                        }
                    });
            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("启动Server成功...");
            future.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
