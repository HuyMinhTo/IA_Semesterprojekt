import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
    public static void main( String[] args ) {

        String uri = "mongodb+srv://huy:jxUiHajjPiaXGRQS@cluster0.oyzan.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";


        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PerformanceManagement");
            MongoCollection<Document> collection = database.getCollection("Salesmen");

            Document doc = collection.find(eq("sid", 1)).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
}