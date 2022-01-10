package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class V3__categories_migration extends BaseJavaMigration {

    @Override
    public void migrate(Context context) {
        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("CREATE TABLE IF NOT EXISTS categories (\n" +
                        "code VARCHAR(255) PRIMARY KEY NULL,\n" +
                        "parentCode foreign key (parentCode) references categories(code) on delete cascade,\n" +
                        "name VARCHAR(255) NOT NULL,\n");
    }
}