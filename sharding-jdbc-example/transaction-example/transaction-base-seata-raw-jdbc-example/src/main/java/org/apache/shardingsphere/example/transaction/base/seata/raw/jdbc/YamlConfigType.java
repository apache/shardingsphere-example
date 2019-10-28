package org.apache.shardingsphere.example.transaction.base.seata.raw.jdbc;

public enum YamlConfigType {
    SHARDING_DATABASE_TABLES("/META-INF/sharding-databases-tables.yaml"),
    MASTER_SLAVE("/META-INF/master-slave.yaml");
    private String yamlFilePath;

    YamlConfigType(final String yamlFilePath) {
        this.yamlFilePath = yamlFilePath;
    }

    public String getFilePath() {
        return yamlFilePath;
    }
}
