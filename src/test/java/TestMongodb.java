/**
 * 测试类
 */

import com.itcast.mongodb.MongoUtils;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.junit.Test;

public class TestMongodb {
    private static MongoDatabase mongoDatabase;

    public static void main(String[] args) {
//        mongodb工具类初始化
        mongoDatabase= MongoUtils.getMongoConn();
    }
//    查看数据库
    @Test
    public void getDBs(){
//        获取mongodb数据库服务
        MongoClient mongoClient=MongoUtils.getMongoClient();

        MongoIterable<String> databaseNames=mongoClient.listDatabaseNames();
        for (String databaseNmae:
             databaseNames) {
            System.out.println(databaseNmae);
        }
    }
//    查看数据库中的集合
    @Test
    public void getCollection(){
        mongoDatabase=MongoUtils.getMongoConn();
//        获取数据库成员列表

        MongoIterable<String> listCollectionNames=mongoDatabase.listCollectionNames();
        for (String collectionName:
             listCollectionNames) {
            System.out.println(collectionName.toString());
        }
    }
//    创建集合
    @Test
    public void createColloection(){
        mongoDatabase=MongoUtils.getMongoConn();
        mongoDatabase.createCollection("itcast");
    }
}
