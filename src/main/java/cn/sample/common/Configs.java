package cn.sample.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/3/29.
 * 配置属性列表
 */
public class Configs {
    /*
    * 阿里云key
    * */
    public static String accesskey;
    /*
    * 阿里云secret
    * */
    public static String secretKey;
    /*
    * 阿里云oss地址
    * */
    public static String osssrc;
    /*
    * 阿里云oss 文件夹
    * */
    public static String ossbucket;
    /*
   * 请求签名
   * */
    public static String apptoken;
    /*
   注册/重置密码短信模板
   * */
    public static String registcode;
    /*
    短信签名
    * */
    public static String smssign;

    /*
    推送appKey
    * */
    public static long appKey;
    /*
    * 推送环境
    * */
    public static String pushEv;
    /*
   * apns环境
   * */
    public static String apns;
    /*
    * 接口请求区域
    * */
    public static String regionId;

    public static Map<String, String> CityMap = new HashMap<String, String>();

    /**
     * face++
     */
    public static String FACE_APPKEY = "DD7TfA6qe2WJ4eD10ErAdiF1jroWl0cZ";
    public static String FACE_APPSecret = "lih8YUkeemi4T2bxDLCpb7EC_jb-6Dag";


    //联动短信配置
    public static String ld_url;
    public static String ld_authCode;
    public static String ld_spId;


    public static boolean jobFlag = false;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Configs.class.getClassLoader().getResourceAsStream("config.properties"));
            accesskey = properties.getProperty("accesskey");
            secretKey = properties.getProperty("secretKey");
            osssrc = properties.getProperty("osssrc");
            ossbucket = properties.getProperty("ossbucket");
            apptoken = properties.getProperty("apptoken");
            registcode = properties.getProperty("registcode");
            smssign = properties.getProperty("smssign");
            appKey = Long.parseLong(properties.getProperty("appKey"));
            pushEv = properties.getProperty("pushEv");
            apns= properties.getProperty("apns");
            regionId = properties.getProperty("regionId");



            ld_url =properties.getProperty("ld_url");
            ld_authCode =properties.getProperty("ld_authCode");
            ld_spId =properties.getProperty("ld_spId");

            jobFlag = Boolean.parseBoolean(properties.getProperty("job.flag"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
