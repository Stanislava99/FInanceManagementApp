package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class V1__transaction_migration extends BaseJavaMigration {

    @Override
    public void migrate(Context context) {
        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("CREATE TABLE IF NOT EXISTS transaction (\n" +
                        "  id primary key  NOT NULL AUTO_INCREMENT,\n" +
                        "beneficiaryName varchar (255) ,\n" +
                        "date varchar (255) NOT NULL,\n" +
                        "direction varchar (1) NOT NULL,\n" +
                        "amount double NOT NULL,\n" +
                        "description varchar (255) NOT NULL,\n" +
                        "currency varchar (3) NOT NULL,\n" +
                        "mcc foreign key (mcc) references mcc_codes (code),\n" +
                        "kind varchar (3) NOT NULL");
    }
}