package comyee.sca.nacos;

import com.yee.sca.nacos.DemoApplication;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class JasyptTest {

    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void encode() {
        // 第一个加密
        String password = "yee-cloud";
        // jlU9jZeb61nKDeDL89x2WTiPAfyZ1ocfMSC57mg+23A=
        System.out.println(encryptor.encrypt(password));

        // 第二个加密
        password = "yee-security";
        // KNrhemmJW22gtcrI+Pk31GXqnmHmD4xkwvxUXx3S9TM=
        System.out.println(encryptor.encrypt(password));
    }

    @Value("${order.secret-key:}")
    private String secretKey;

    @Test
    public void print() {
        System.out.println(secretKey);
    }

}
