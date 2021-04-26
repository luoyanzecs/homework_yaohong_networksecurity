package cn.luoyanze.web.pojo.vo;

import cn.luoyanze.utils.DesUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/26 10:30 下午
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String timeStamp;
    private String ctx;
    private String userId;

    public Message encryptWith(String key) {
        this.timeStamp = DesUtils.encrypt(timeStamp, key);
        this.ctx = DesUtils.encrypt(ctx, key);
        this.userId = DesUtils.encrypt(userId, key);
        return this;
    }

    public Message decryptWith(String key) {
        this.timeStamp = DesUtils.decrypt(timeStamp, key);
        this.ctx = DesUtils.decrypt(ctx, key);
        this.userId = DesUtils.decrypt(userId, key);
        return this;
    }


}
