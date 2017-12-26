## Getting started

* Install [cassandra](http://cassandra.apache.org/download/)

* Start cassandra

```
bash bin/cassandra
```

* Open cqlsh

```
bash bin/sqlsh
```

* Create keyspace

```
CREATE KEYSPACE IF NOT EXISTS eventsvr WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};
```

* Create table

```
CREATE TABLE IF NOT EXISTS eventsvr.users (id UUID, login varchar, password varchar, email varchar, primary key(id));
CREATE INDEX login ON evnetsvr.users(login);
```

* Move to server dir

* Start microservices discover server

```
cd discover-server
mvn spring-boot:run
```

* Start login service

```
cd eventsvr-login
mvn spring-boot:run
```

## Login example

[Simple login service work example](https://asciinema.org/a/a08yI0znBHdBgXNFNvRcyhrPG)
