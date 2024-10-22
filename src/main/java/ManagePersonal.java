
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ManagePersonal {

    private MongoDatabase database;

    public ManagePersonal() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        this.database = mongoClient.getDatabase("sales_management");
    }

    public void createSalesMan(SalesMan salesMan) {
        MongoCollection<Document> collection = database.getCollection("salesmen");
        Document document = new Document("sid", salesMan.getSid())
                .append("name", salesMan.getName())
                .append("vorname", salesMan.getVorname());
        collection.insertOne(document);
    }

    public void addSocialPerformanceRecord(SocialPerformanceRecord record, SalesMan salesMan) {
        MongoCollection<Document> collection = database.getCollection("social_performance_records");
        Document document = new Document("sid", record.getSid())
                .append("year", record.getYear())
                .append("score", record.getScore())
                .append("feedback", record.getFeedback());
        collection.insertOne(document);
    }

    public SalesMan readSalesMan(int sid) {
        MongoCollection<Document> collection = database.getCollection("salesmen");
        Document query = new Document("sid", sid);
        Document result = collection.find(query).first();
        if (result != null) {
            return new SalesMan(result.getInteger("sid"), result.getString("name"), result.getString("vorname"));
        }
        return null;
    }

    public List<SalesMan> readAllSalesMen() {
        MongoCollection<Document> collection = database.getCollection("salesmen");
        List<SalesMan> salesMenList = new ArrayList<>();
        for (Document doc : collection.find()) {
            salesMenList.add(new SalesMan(doc.getInteger("sid"), doc.getString("name"), doc.getString("vorname")));
        }
        return salesMenList;
    }

    public List<SocialPerformanceRecord> readSocialPerformanceRecords(SalesMan salesMan, int year) {
        MongoCollection<Document> collection = database.getCollection("social_performance_records");
        List<SocialPerformanceRecord> recordList = new ArrayList<>();
        Document query = new Document("sid", salesMan.getSid()).append("year", year);
        for (Document doc : collection.find(query)) {
            recordList.add(new SocialPerformanceRecord(
                    doc.getInteger("sid"),
                    doc.getInteger("year"),
                    doc.getInteger("score"),
                    doc.getString("feedback")));
        }
        return recordList;
    }

    public void updateSalesMan(SalesMan salesMan) {
        MongoCollection<Document> collection = database.getCollection("salesmen");

        Document query = new Document("sid", salesMan.getSid());
        Document updatedDocument = new Document()
                .append("name", salesMan.getName())
                .append("vorname", salesMan.getVorname());

        collection.updateOne(query, new Document("$set", updatedDocument));
    }


    public void deleteSalesMan(int sid) {
        MongoCollection<Document> collection = database.getCollection("salesmen");
        Document query = new Document("sid", sid);
        collection.deleteOne(query);
    }
}
