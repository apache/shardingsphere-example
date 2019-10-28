package org.apache.shardingsphere.example.transaction.base.seata.raw.jdbc.factory;

import org.apache.shardingsphere.example.transaction.base.seata.raw.jdbc.YamlConfigType;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlMasterSlaveDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class YamlTransactionSeataDataSourceFactory {
    public static DataSource newInstance(final YamlConfigType type) throws IOException, SQLException {
        switch (type){
            case SHARDING_DATABASE_TABLES:
                return YamlShardingDataSourceFactory.createDataSource(getFile(type.getFilePath()));
            case MASTER_SLAVE:
                return YamlMasterSlaveDataSourceFactory.createDataSource(getFile(type.getFilePath()));
            default:
                throw new UnsupportedOperationException(type.name());
        }
    }
    private static File getFile(final String fileName) {
        return new File(Thread.currentThread().getClass().getResource(fileName).getFile());
    }
}
