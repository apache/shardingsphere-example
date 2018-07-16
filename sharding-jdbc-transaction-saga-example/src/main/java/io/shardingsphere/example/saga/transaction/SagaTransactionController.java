/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.example.saga.transaction;

import io.servicecomb.provider.rest.common.RestSchema;
import io.shardingsphere.core.exception.ShardingException;
import io.shardingsphere.example.saga.transaction.fixture.ShardingOnlyWithDatabasesAndTables;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("/")
@RestSchema(schemaId = "sagaTransactionExample")
public class SagaTransactionController {
    
    /**
     * Execute sql.
     * @param sql sql
     * @return status
     */
    @RequestMapping(value = "execute", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public boolean execute(@RequestAttribute final String sql) {
        System.out.println(sql);
        try (
            Connection connection = ShardingOnlyWithDatabasesAndTables.getDataSource().getConnection();
            Statement statement = connection.createStatement()) {
            return statement.execute(sql);
        } catch (final SQLException ex) {
            throw new ShardingException(ex);
        }
    }
}
