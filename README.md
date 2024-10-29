**Notes from books and other interesting things that I've read. Enjoy!**



#### Important Items effective java

https://github.com/singh-man/effective-java-summary-3rd-ed

- Item 19 : Create classes for inheritance or forbid it
- Item 20 : Interfaces are better than abstract classes
- Item 52 : Overloading
- Item 54 : Return empty collections or arrays instead of null
- Item 55 : Return of Optionals
- Item 57 : Minimize the scope of local variables
- Item 61 : Prefer primitives to boxed primitives
- Item 64 : Refer to objects by their interfaces
- Item 84 : Don't depend on the thread scheduler
- Item 88 : Write readObject methods defensively
- Item 89 : For instance control, prefer enum types to readResolve
- Item 90 : Serialization proxies



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class TableMigrationService {
    private static final int BATCH_SIZE = 1000; // Adjust batch size as needed
    private static final String SOURCE_TABLE = "old_table";
    private static final String DESTINATION_TABLE = "new_table";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method to start the migration process
    @Transactional
    public void migrateDataWithExtraColumn() {
        if (!tableExists(DESTINATION_TABLE)) {
            createDestinationTableWithExtraColumn();
        }

        int offset = 0;
        List<Map<String, Object>> rows;

        // Fetch and insert data in batches
        do {
            rows = fetchBatchFromSourceTable(offset);
            if (!rows.isEmpty()) {
                insertBatchIntoDestinationTable(rows);
            }
            offset += BATCH_SIZE;
        } while (!rows.isEmpty());

        System.out.println("Data migration completed successfully.");
    }

    // Check if the destination table exists
    private boolean tableExists(String tableName) {
        String query = "SELECT COUNT(*) FROM all_tables WHERE table_name = ?";
        Integer count = jdbcTemplate.queryForObject(query, Integer.class, tableName.toUpperCase());
        return count != null && count > 0;
    }

    // Create the destination table with an extra column
    private void createDestinationTableWithExtraColumn() {
        String createTableSQL = "CREATE TABLE " + DESTINATION_TABLE + " AS SELECT *, NULL AS migration_date FROM " + SOURCE_TABLE + " WHERE 1=0";
        jdbcTemplate.execute(createTableSQL);
        System.out.println("Destination table with additional column created successfully.");
    }

    // Fetch a batch of data from the source table
    private List<Map<String, Object>> fetchBatchFromSourceTable(int offset) {
        String query = "SELECT * FROM " + SOURCE_TABLE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        return jdbcTemplate.queryForList(query, offset, BATCH_SIZE);
    }

    // Insert a batch of data into the destination table with the additional column
    private void insertBatchIntoDestinationTable(List<Map<String, Object>> rows) {
        String insertSQL = "INSERT INTO " + DESTINATION_TABLE + " VALUES (?, ?, ?, ?, ?, ?, ?)"; // Adjust '?' for columns + 1 for extra column

        jdbcTemplate.batchUpdate(insertSQL, rows, BATCH_SIZE, (ps, row) -> {
            // Assume 6 columns in the source table, modify as necessary
            ps.setObject(1, row.get("COLUMN1"));
            ps.setObject(2, row.get("COLUMN2"));
            ps.setObject(3, row.get("COLUMN3"));
            ps.setObject(4, row.get("COLUMN4"));
            ps.setObject(5, row.get("COLUMN5"));
            ps.setObject(6, row.get("COLUMN6"));

            // Set additional column (e.g., current timestamp for `migration_date`)
            ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
        });

        System.out.println("Batch of " + rows.size() + " rows inserted.");
    }
}

