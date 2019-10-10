import java.util.*;
import com.mongodb.*;
public class Database{
    public DB connect(){
        try{
            Mongo mg = new Mongo("localhost", 27017);
            DB db = mg.getDB("test");
            /* DBCollection coll = db.getCollection("name");
            DBCursor curs = coll.find();
            while (curs.hasNext()){
                DBObject n = curs.next();
                System.out.println(n.get("name"));
                System.out.println(n.get("age"));
                System.out.println(n.get("test"));
            } */
            return db;
        }
        catch (Exception ex){
            System.out.println("Can't Connect to Database!");
        }
    }
}