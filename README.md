# ShardingSphere-example

Example for 1.x please see tags in `https://github.com/apache/incubator-shardingsphere/tree/${tag}/sharding-jdbc-example`

Example for 2.x or 3.x or 4.x please see tags in `https://github.com/apache/incubator-shardingsphere-example/tree/${tag}`

**Need attention**

- *Please do not use `dev` branch to run your example, example of `dev` branch is not released yet.*

- *The manual schema initial script is in `https://github.com/apache/incubator-shardingsphere-example/blob/dev/src/resources/manual_schema.sql`, please execute it before you first run the example.*

- *Please make sure master-slave data sync on MySQL is running correctly. Otherwise this example will query empty data from slave.*

## Before start the example if you want use `dev` branch

Please make sure some dependencies from [shardingsphere](https://github.com/apache/incubator-shardingsphere) and [shardingsphere-spi-impl](https://github.com/OpenSharding/shardingsphere-spi-impl) have been installed since some examples depend on that.
if you are a newbie for shardingsphere, you could prepare the dependencies as following: 

1.download and install [shardingsphere](https://github.com/apache/incubator-shardingsphere): 

```bash
## download the code of shardingsphere
git clone https://github.com/apache/incubator-shardingsphere.git

## checkout a specific version, example is 4.0.0-RC1
cd incubator-shardingsphere && git checkout 4.0.0-RC1

## install the dependencies
mvn clean install -Prelease
```

2.download and install [shardingsphere-spi-impl](https://github.com/OpenSharding/shardingsphere-spi-impl): 

```bash
## download the code of shardingsphere-spi-impl
git clone https://github.com/OpenSharding/shardingsphere-spi-impl.git

## checkout a specific version, example is 4.0.0-RC1
cd shardingsphere-spi-impl && git checkout 4.0.0-RC1

## install the dependencies
mvn clean install
```

## shardingsphere-example module design

### project structure

```
shardingsphere-example
  ├── example-core
  │   ├── config-utility
  │   ├── example-api
  │   ├── example-raw-jdbc
  │   ├── example-spring-jpa
  │   └── example-spring-mybatis
  ├── sharding-jdbc-example
  │   ├── sharding-example
  │   │   ├── sharding-raw-jdbc-example
  │   │   ├── sharding-spring-boot-jpa-example
  │   │   ├── sharding-spring-boot-mybatis-example
  │   │   ├── sharding-spring-namespace-jpa-example
  │   │   └── sharding-spring-namespace-mybatis-example
  │   ├── orchestration-example
  │   │   ├── orchestration-raw-jdbc-example
  │   │   ├── orchestration-spring-boot-example
  │   │   └── orchestration-spring-namespace-example
  │   ├── transaction-example
  │   │   ├── transaction-2pc-xa-example
  │   │   └──transaction-base-seata-example
  │   ├── other-feature-example
  │   │   ├── hint-example
  │   │   └── encrypt-example
  ├── sharding-proxy-example
  │   └── sharding-proxy-boot-mybatis-example
  └── src/resources
        └── manual_schema.sql
```

### Best practice for sharding data

* sharding databases
* sharding tables
* sharding databases and tables
* master-slave
* sharding & master-slave

You can get more detail from **[sharding-example](./sharding-jdbc-example/sharding-example)**

### Best practice for sharding + orchestration

* using local configuration file for zookeeper/etcd & sharding
* using register center(zookeeper/etcd)'s configuration for sharding

You can get more detail from **[orchestration-example](./sharding-jdbc-example/orchestration-example)**

### Best Practice for sharding + distribution-transaction

* 2pc-xa transaction
* base-seata transaction

You can get more detail from **[transaction-example](./sharding-jdbc-example/transaction-example)**

### Best Practice for hint routing

You can get more detail from **[hint-example](./sharding-jdbc-example/other-feature-example/hint-example)**

### Best Practice for data encrypt

You can get more detail from **[encrypt-example](./sharding-jdbc-example/other-feature-example/encrypt-example)**

### Best Practice for APM

We will add APM example recently.

### Best Practice for sharding-proxy.

We prefer to add a docker base example recently.

### [how to use docker to config sharding-jdbc & sharding-proxy](./docker/docker-compose.md) (Optional)
