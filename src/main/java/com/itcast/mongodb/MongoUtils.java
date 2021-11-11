package com.itcast.mongodb;
/**
 * 操作mongodb数据库的工具类
 * 用于连接数据库
 */

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MongoUtils {
    private static Properties properties;
    private static MongoDatabase mongoDatabase;
    private static InputStream stream=null;
    private static String host;
    private static int port;
    private static String dbname;
//    创建静态代码块初始化工具类中的静态变量，
    static {
        if(properties==null){
            properties=new Properties();
        }

        try {
            stream=MongoUtils.class.getClassLoader().getResourceAsStream("mongodb.properties");
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        host=properties.getProperty("host");
        port=Integer.parseInt(properties.getProperty("port"));
        dbname=properties.getProperty("dbname");

    }
    public static MongoClient getMongoClient(){
        String addr="mongodb://"+host+":"+port;
//        获取MongoDB数据库服务
        MongoClient mongoClient= MongoClients.create(addr);
        return mongoClient;
    }
    public static MongoDatabase getMongoConn(){
        MongoClient mongoClient=getMongoClient();
//        连接dbname数据库
        mongoDatabase=mongoClient.getDatabase(dbname);
//        返回数据库对象
        return mongoDatabase;
    }
}
