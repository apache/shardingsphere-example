DROP SCHEMA IF EXISTS demo_ds;
DROP SCHEMA IF EXISTS demo_ds_0;
DROP SCHEMA IF EXISTS demo_ds_1;

DROP SCHEMA IF EXISTS demo_ds_master;
DROP SCHEMA IF EXISTS demo_ds_slave_0;
DROP SCHEMA IF EXISTS demo_ds_slave_1;

DROP SCHEMA IF EXISTS demo_ds_master_0;
DROP SCHEMA IF EXISTS demo_ds_master_0_slave_0;
DROP SCHEMA IF EXISTS demo_ds_master_0_slave_1;
DROP SCHEMA IF EXISTS demo_ds_master_1;
DROP SCHEMA IF EXISTS demo_ds_master_1_slave_0;
DROP SCHEMA IF EXISTS demo_ds_master_1_slave_1;

CREATE SCHEMA IF NOT EXISTS demo_ds;
CREATE SCHEMA IF NOT EXISTS demo_ds_0;
CREATE SCHEMA IF NOT EXISTS demo_ds_1;

CREATE SCHEMA IF NOT EXISTS demo_ds_master;
CREATE SCHEMA IF NOT EXISTS demo_ds_slave_0;
CREATE SCHEMA IF NOT EXISTS demo_ds_slave_1;

CREATE SCHEMA IF NOT EXISTS demo_ds_master_0;
CREATE SCHEMA IF NOT EXISTS demo_ds_master_0_slave_0;
CREATE SCHEMA IF NOT EXISTS demo_ds_master_0_slave_1;
CREATE SCHEMA IF NOT EXISTS demo_ds_master_1;
CREATE SCHEMA IF NOT EXISTS demo_ds_master_1_slave_0;
CREATE SCHEMA IF NOT EXISTS demo_ds_master_1_slave_1;

-- Should sync from master-salve automatically
-- CREATE TABLE IF NOT EXISTS demo_ds_slave_0.t_order (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_slave_1.t_order (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_slave_0.t_order_item (order_item_id BIGINT NOT NULL AUTO_INCREMENT, order_id BIGINT NOT NULL, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_slave_1.t_order_item (order_item_id BIGINT NOT NULL AUTO_INCREMENT, order_id BIGINT NOT NULL, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));

-- CREATE TABLE IF NOT EXISTS demo_ds_master_0_slave_0.t_order_0 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_0_slave_0.t_order_1 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_0_slave_1.t_order_0 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_0_slave_1.t_order_1 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_1_slave_0.t_order_0 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_1_slave_0.t_order_1 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_1_slave_1.t_order_0 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_1_slave_1.t_order_1 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_0_slave_0.t_order_item_0 (order_item_id BIGINT NOT NULL AUTO_INCREMENT, order_id BIGINT NOT NULL, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_0_slave_0.t_order_item_1 (order_item_id BIGINT NOT NULL AUTO_INCREMENT, order_id BIGINT NOT NULL, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_0_slave_1.t_order_item_0 (order_item_id BIGINT NOT NULL AUTO_INCREMENT, order_id BIGINT NOT NULL, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_0_slave_1.t_order_item_1 (order_item_id BIGINT NOT NULL AUTO_INCREMENT, order_id BIGINT NOT NULL, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_1_slave_0.t_order_item_0 (order_item_id BIGINT NOT NULL AUTO_INCREMENT, order_id BIGINT NOT NULL, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_1_slave_0.t_order_item_1 (order_item_id BIGINT NOT NULL AUTO_INCREMENT, order_id BIGINT NOT NULL, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_1_slave_1.t_order_item_0 (order_item_id BIGINT NOT NULL AUTO_INCREMENT, order_id BIGINT NOT NULL, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));
-- CREATE TABLE IF NOT EXISTS demo_ds_master_1_slave_1.t_order_item_1 (order_item_id BIGINT NOT NULL AUTO_INCREMENT, order_id BIGINT NOT NULL, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));
