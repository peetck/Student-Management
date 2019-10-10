import com.mongodb.*;

public class Main{
    public static void main(String[] args) {
        /* try{
            DBCollection coll = null;
            Mongo s = new Mongo("localhost", 27017);
            DB b = s.getDB("test");
            coll = b.getCollection("name");
            DBCursor curs = coll.find();
            while (curs.hasNext()){
                DBObject n = curs.next();
                System.out.println(n.get("name"));
                System.out.println(n.get("age"));
                System.out.println(n.get("test"));
            }
        }
        catch (Exception ex){

        } */
        System.out.println("Hello world!");
    }
}
