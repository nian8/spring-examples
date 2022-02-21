package com.yee.sc.rabbit.producer.message;

/**
 * 示例 01 的 Message 消息
 */
public class EchoMessage {

    /**
     * 编号
     */
    private Integer id;

    public EchoMessage setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EchoMessage{" +
                "id=" + id +
                '}';
    }

}
