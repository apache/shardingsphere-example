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

import io.shardingsphere.transaction.saga.SagaSoftTransaction;

public class SagaTransactionDemo {
    
    /**
     * Demo of success.
     */
    public static void demoSuccess() {
        SagaSoftTransaction sagaSoftTransaction = new SagaSoftTransaction();
        sagaSoftTransaction.begin();
        sagaSoftTransaction.setSQLAndCompensation("INSERT INTO t_order (user_id, status) VALUES (10, 'INIT')", "DELETE FROM t_order where user_id=10");
        sagaSoftTransaction.setSQLAndCompensation("INSERT INTO t_order (user_id, status) VALUES (12, 'INIT')", "DELETE FROM t_order where user_id=12");
        sagaSoftTransaction.end();
    }
    
    /**
     * Demo of fail.
     */
    public static void demoFail() {
        SagaSoftTransaction sagaSoftTransaction = new SagaSoftTransaction();
        sagaSoftTransaction.begin();
        sagaSoftTransaction.setSQLAndCompensation("INSERT INTO t_order (user_id, status) VALUES (10, 'INIT')", "DELETE FROM t_order where user_id=10");
        sagaSoftTransaction.setSQLAndCompensation("INSERT INTO t_order (user_id, status) VALUES (12, 'INIT')xxx", "DELETE FROM t_order where user_id=12");
        sagaSoftTransaction.end();
    }
}
