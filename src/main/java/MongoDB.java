import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
    public static void main(String[] args) {
        String uri = "mongodb+srv://huy:jxUiHajjPiaXGRQS@cluster0.oyzan.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";


        //CRUD Operactions


        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PerformanceManagement"); //Database fetchen
            MongoCollection<Document> collection = database.getCollection("Salesmen"); //Collection aus der Database fetchen

            //Create
            Document newSalesman = new Document("sid", 2)
                    .append("name", "John Doe")
                    .append("sales", 1000);


            /*Insert
            collection.insertOne(newSalesman);
            System.out.println("Document inserted successfully");*/


            //Read
            Document doc = collection.find(eq("sid", 2)).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");

            }

            /* Delete
            if (doc != null) {
                collection.deleteOne(eq("sid", 2)); // Lösche das Dokument mit sid = 2
                System.out.println("Document with sid 2 deleted successfully.");
            } else {
                System.out.println("No document to delete.");
            }*/
        }
    }
}