package Pwater.Config;
    
import javax.sql.DataSource;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

@SingletonConfig
public class AppConfig implements Config {
    
    private static final AppConfig INSTANCE = new AppConfig();

    private final Dialect dialect;
    private final LocalTransactionDataSource dataSource;
    private final TransactionManager transactionManager;

    private AppConfig() {
        dialect = new MysqlDialect();
        dataSource = new LocalTransactionDataSource(
            "jdbc:mysql://localhost:3306/spring_webapp",
            "root",
            "admin"
        );
        transactionManager = new LocalTransactionManager(
            dataSource.getLocalTransaction(getJdbcLogger())
        );
    }
    
    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }
    
    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public static AppConfig singleton() {
        return INSTANCE;
    }
    
//      private DaoConfig() {
//         dialect = new MysqlDialect();
//         DriverManagerDataSource originalDataSource = new DriverManagerDataSource();
//         originalDataSource.setUrl("jdbc:mysql://localhost:3306/lampart_crm_demo");
//         originalDataSource.setUsername("springstudent");
//         originalDataSource.setPassword("springstudent");

//        DriverManagerDataSource originalDataSource = new DriverManagerDataSource();
//        originalDataSource.setUrl(environment.getProperty("spring.datasource.url"));
//        originalDataSource.setUsername(environment.getProperty("spring.datasource.username"));
//        originalDataSource.setPassword(environment.getProperty("spring.datasource.password"));

//        dataSource2 = new LocalTransactionDataSource(originalDataSource);

//        dataSource = new LocalTransactionDataSource(
//                "jdbc:mysql://localhost:3306/lampart_crm_demo", "springstudent", "springstudent");
//         transactionManager = new LocalTransactionManager(
//                 dataSource2.getLocalTransaction(getJdbcLogger()));
//     }
}
