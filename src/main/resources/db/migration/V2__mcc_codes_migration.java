package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class V2__mcc_codes_migration extends BaseJavaMigration {

    @Override
    public void migrate(Context context) {
        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("CREATE TABLE IF NOT EXISTS mcc_codes (\n" +
                        "code PRIMARY KEY VARCHAR(4) NOT NULL,\n" +
                        "merchantType varchar (255) NOT NULL");
    }
}