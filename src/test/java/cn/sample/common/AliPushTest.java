package cn.sample.common;



import cn.itht.aliyun.AliPush;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/22.
 */
public class AliPushTest {

    /**
     * 群推
     */
    @Test
    public  void  TestAllPush() throws Exception
    {
        AliPush.pushGlobaMsg("dev",2,"群组","群组","群组");
    }

    /**
     * 单点
     */
    @Test
    public  void  TestSinglePush() throws Exception
    {
        AliPush.pushMsg("88_dev",3,"贷款通知__title","summary_______","body____________________");
    }
}
