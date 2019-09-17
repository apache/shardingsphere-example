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

package org.apache.shardingsphere.example.encrypt.table.spring.boot;

import org.apache.shardingsphere.example.core.api.ExampleExecuteTemplate;
import org.apache.shardingsphere.example.core.api.service.ExampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@ComponentScan("org.apache.shardingsphere.example.core.jpa")
@EntityScan(basePackages = "org.apache.shardingsphere.example.core.jpa.entity")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class ExampleMain {
    
    /**
     * The example can't work well.
     * Related issue #2884: https://github.com/apache/incubator-shardingsphere/issues/2884
     *
     * @throws SQLException SQL exception
     */
    @Deprecated
    public static void main(final String[] args) throws SQLException {
        // TODO: Because of assistedQueryColumns, we need to consider the DDL of encrypt module. Now JPA examples can not run well.
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(ExampleMain.class, args)) {
            ExampleExecuteTemplate.run(applicationContext.getBean("encrypt", ExampleService.class));
        }
    }
}
