/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.example.transaction.xa.raw.jdbc;

import org.apache.shardingsphere.example.common.entity.Order;
import org.apache.shardingsphere.example.common.jdbc.repository.OrderItemRepositoryImpl;
import org.apache.shardingsphere.example.common.jdbc.repository.OrderRepositoryImpl;
import org.apache.shardingsphere.example.common.jdbc.service.CommonServiceImpl;
import org.apache.shardingsphere.example.common.service.CommonService;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class YamlConfigurationTransactionExample {
    
    private static String configFile = "/META-INF/sharding-databases-tables.yaml";
    //    private static String configFile = "/META-INF/master-slave.yaml";
    
    public static void main(final String[] args) throws SQLException, IOException {
        DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(getFile(configFile));
        CommonService commonService = getCommonService(dataSource);
        commonService.initEnvironment();
        processXATransaction(dataSource, commonService);
        commonService.cleanEnvironment();
    }
    
    private static File getFile(final String fileName) {
        return new File(Thread.currentThread().getClass().getResource(fileName).getFile());
    }
    
    private static CommonService getCommonService(final DataSource dataSource) {
        return new CommonServiceImpl(new OrderRepositoryImpl(dataSource), new OrderItemRepositoryImpl(dataSource));
    }
    
    private static void processXATransaction(final DataSource dataSource, final CommonService commonService) throws SQLException {
        TransactionTypeHolder.set(TransactionType.XA);
        System.out.println("------ start succeed transaction ------");
        try (Connection connection = dataSource.getConnection()) {
            insertSuccess(connection, commonService);
            connection.commit();
            commonService.printData();
        }
        truncateTable(dataSource);
        System.out.println("------ end succeed transaction ------");
        System.out.println("------ start failure transaction ------");
        Connection connection = dataSource.getConnection();
        try {
            insertSuccess(connection, commonService);
            throw new SQLException("exception occur!");
        } catch (final SQLException ex) {
            connection.rollback();
        }
        commonService.printData();
        System.out.println("------ end failure transaction ------");
        truncateTable(dataSource);
    }
    
    private static void insertSuccess(final Connection connection, final CommonService commonService) throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId(i);
            order.setStatus("INIT");
            insertOrder(connection, order);
        }
        commonService.printData();
    }
    
    private static Long insertOrder(final Connection connection, final Order order) {
        String sql = "INSERT INTO t_order (user_id, status) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setString(2, order.getStatus());
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    order.setOrderId(resultSet.getLong(1));
                }
            }
        } catch (final SQLException ignored) {
        }
        return order.getOrderId();
    }
    
    private static void truncateTable(final DataSource dataSource) {
        OrderRepositoryImpl orderRepository = new OrderRepositoryImpl(dataSource);
        orderRepository.truncateTable();
    }
}
