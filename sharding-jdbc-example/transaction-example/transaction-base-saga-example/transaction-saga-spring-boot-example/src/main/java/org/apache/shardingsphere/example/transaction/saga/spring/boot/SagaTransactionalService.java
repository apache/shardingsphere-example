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

import org.apache.shardingsphere.example.common.jpa.service.JPACommonService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SagaTransactionalService {
    
    private final JPACommonService jpaCommonService;
    
    @Autowired
    public SagaTransactionalService(final JPACommonService jpaCommonService) {
        this.jpaCommonService = jpaCommonService;
    }
    
    /**
     * process success, XA transaction will be committed.
     */
    @ShardingTransactionType(TransactionType.BASE)
    @Transactional
    public void processSuccess() {
        jpaCommonService.processSuccess();
    }
    
    /**
     * process failure, XA transaction will be rollback.
     */
    @ShardingTransactionType(TransactionType.BASE)
    @Transactional
    public void processFailure() {
        jpaCommonService.processFailure();
    }
    
    public void printData() {
        jpaCommonService.printData();
    }
}
