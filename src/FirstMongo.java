import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import com.mongodb.MongoClient;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoCredential;
import com.mongodb.MongoSecurityException;
import com.mongodb.ServerAddress;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class FirstMongo {

	DB db;
	DBCollection testdbcollection;
	MongoClient mongoClient = null;

	@Test
	public void runMango() throws IOException {
		System.out.println("running mongo...");
		// createuser();
		try {
			myauth();
		} catch (MongoCommandException | MongoSecurityException e)

		{
			// TODO Auto-generated catch block
			System.out.println("cannot login");
			// e.getErrorMessage();
			// e.printStackTrace();
		}
		// System.exit(0);

		//testdbcollection = db.getCollection("mychannel.you.me");
		testdbcollection = db.getCollection("testdb");

		//testdbcollection.insert((DBObject) BasicDBObject.parse("{'First':'Record'}"));

		DBCursor dbcursor = testdbcollection.find();
		while (dbcursor.hasNext()) {
			System.out.println(dbcursor.next());
		}

		mongoClient.close();
	}


	public void myauth() {

		MongoCredential mongoCredential = MongoCredential.createMongoCRCredential("firstuser", "testdb",
				"first".toCharArray());
		// MongoCredential{mechanism=MONGODB-CR, userName='firstuser', source='testdb',
		// password=<hidden>, mechanismProperties={}}
		System.out.println("credential is: " + mongoCredential.toString());

		mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(mongoCredential));

		db = mongoClient.getDB("testdb");

		System.out.println("Status is " + db.getStats());
		System.out.println("collections name: " + db.getCollectionNames());
	}

	public void createuser() {
		System.out.println("Creating user...");
		db.addUser("firstuser", "first".toCharArray());
	}
}
