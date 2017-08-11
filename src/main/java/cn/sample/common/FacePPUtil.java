package cn.sample.common;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;


/**
 * Created by think on 2017/4/5.
 */
public class FacePPUtil {
    private static final String API_URL = "https://api.faceid.com/faceid/v1/ocridcard";

    private static final Logger LOGGER = LoggerFactory.getLogger(FacePPUtil.class);


    public static FacePPIDCardInfo getIDCard(String imgUrl) throws Exception{

        HttpPost httpPost = new HttpPost(API_URL);
        httpPost.setHeader("User-Agent","SOHUWapRebot");
        httpPost.setHeader("Accept-Language","zh-cn,zh;q=0.5");
        httpPost.setHeader("Accept-Charset","GBK,utf-8;q=0.7,*;q=0.7");
        httpPost.setHeader("Connection","keep-alive");

        MultipartEntityBuilder multiEntity = MultipartEntityBuilder.create();
        URLConnection imgConn = new URL(imgUrl).openConnection();
        multiEntity.addPart("image", new InputStreamBody(imgConn.getInputStream(),"image"));
        multiEntity.addPart("api_key",new StringBody(Configs.FACE_APPKEY, ContentType.TEXT_PLAIN));
        multiEntity.addPart("api_secret",new StringBody(Configs.FACE_APPSecret, ContentType.TEXT_PLAIN));

        httpPost.setEntity(multiEntity.build());
        HttpResponse httpResponse = HttpClients.createDefault().execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        String content = EntityUtils.toString(httpEntity);
        LOGGER.debug("识别身份证："+content);
        ObjectMapper mapper = new ObjectMapper();
        //设置有属性不能映射成PO不报错
        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.readValue(content,FacePPIDCardInfo.class);


//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("User-Agent","SOHUWapRebot");
//        httpHeaders.set("Accept-Language","zh-cn,zh;q=0.5");
//        httpHeaders.set("Accept-Charset","GBK,utf-8;q=0.7,*;q=0.7");
//        httpHeaders.set("Connection","keep-alive");
//        httpHeaders.set("Content-Type","application/json");
//
//        RestTemplate restTemplate = new RestTemplate();
//        ObjectMapper mapper = new ObjectMapper();
//
//        MultiValueMap<String,Object> map = new LinkedMultiValueMap<>();
//        URLConnection imgConn = new URL(imgUrl).openConnection();
//        map.add("image",new InputStreamBody(imgConn.getInputStream(),"image"));
//        map.add("api_key",new StringBody(Configs.FACE_APPKEY, ContentType.TEXT_PLAIN));
//        map.add("api_secret",new StringBody(Configs.FACE_APPSecret, ContentType.TEXT_PLAIN));
//        HttpEntity httpEntity = new HttpEntity(map, httpHeaders);
//        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
//        String content = restTemplate.postForObject(API_URL, httpEntity, String.class);
//        return mapper.readValue(content,FacePPIDCardInfo.class);
    }

    public static class FacePPIDCardInfo {
        private int type;
        private String address;
        private String name;
        private String side;
        private String race;//民族
        private String gender;
        private String id_card_number;
        private JsonNode birthday;

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSide() {
            return side;
        }

        public void setSide(String side) {
            this.side = side;
        }

        public String getId_card_number() {
            return id_card_number;
        }

        public void setId_card_number(String id_card_number) {
            this.id_card_number = id_card_number;
        }

        public JsonNode getBirthday() {
            return birthday;
        }

        public void setBirthday(JsonNode birthday) {
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return "FacePPIDCardInfo{" +
                    "type=" + type +
                    ", address='" + address + '\'' +
                    ", name='" + name + '\'' +
                    ", side='" + side + '\'' +
                    ", id_card_number='" + id_card_number + '\'' +
                    '}';
        }
    }
}
