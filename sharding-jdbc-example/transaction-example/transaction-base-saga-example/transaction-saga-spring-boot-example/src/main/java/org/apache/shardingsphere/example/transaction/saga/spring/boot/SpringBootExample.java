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

package org.apache.shardingsphere.example.transaction.saga.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"org.apache.shardingsphere.example"})
@EntityScan(basePackages = "org.apache.shardingsphere.example.common.jpa.entity")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class SpringBootExample {
    
    public static void main(final String[] args) {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootExample.class, args)) {
            processSagaTransaction(applicationContext);
        }
    }
    
    private static void processSagaTransaction(final ConfigurableApplicationContext applicationContext) {
        SagaTransactionalService transactionalService = applicationContext.getBean(SagaTransactionalService.class);
        transactionalService.processSuccess();
        try {
            transactionalService.processFailure();
        } catch (final Exception ex) {
            transactionalService.printData();
        }
    }
}
