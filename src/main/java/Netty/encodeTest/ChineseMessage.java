package Netty.encodeTest;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yzwang on 2019/10/4.
 */
// 实体
@Data
public class ChineseMessage implements Serializable {

    private long id;
    private String message;
}
