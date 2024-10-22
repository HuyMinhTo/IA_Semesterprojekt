
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ManagePersonalTest {

    private ManagePersonal managePersonal;

    @BeforeEach
    public void setup() {
        managePersonal = new ManagePersonal();
    }

    @Test
    public void testCreateAndReadSalesMan() {
        SalesMan salesMan = new SalesMan(1, "Mustermann", "Max");
        managePersonal.createSalesMan(salesMan);

        SalesMan result = managePersonal.readSalesMan(1);
        assertNotNull(result);
        assertEquals("Mustermann", result.getName());
        assertEquals("Max", result.getVorname());
    }

    @Test
    public void testAddSocialPerformanceRecord() {
        SalesMan salesMan = new SalesMan(2, "Mustermann", "Max");
        managePersonal.createSalesMan(salesMan);

        SocialPerformanceRecord record = new SocialPerformanceRecord(2, 2023, 85, "Super!");
        managePersonal.addSocialPerformanceRecord(record, salesMan);

        List<SocialPerformanceRecord> records = managePersonal.readSocialPerformanceRecords(salesMan, 2023);
        assertEquals(1, records.size());
        assertEquals(85, records.get(0).getScore());
    }

    @Test
    public void testUpdateSalesMan() {
        SalesMan salesMan = new SalesMan(3, "Mustermann", "Max");
        managePersonal.createSalesMan(salesMan);

        salesMan.setName("New");
        salesMan.setVorname("Name");
        managePersonal.updateSalesMan(salesMan);

        SalesMan updated = managePersonal.readSalesMan(3);
        assertEquals("New", updated.getName());
        assertEquals("Name", updated.getVorname());
    }

    @Test
    public void testDeleteSalesMan() {
        SalesMan salesMan = new SalesMan(4, "Delete", "Me");
        managePersonal.createSalesMan(salesMan);

        managePersonal.deleteSalesMan(4);
        SalesMan deleted = managePersonal.readSalesMan(4);
        assertNull(deleted);
    }
}
