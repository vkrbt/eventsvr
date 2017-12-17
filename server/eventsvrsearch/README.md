## Getting started

* Install [elasticsearch](https://www.elastic.co/downloads/past-releases/elasticsearch-2-4-4)

* Set **cluster.name** in **config/elasticsearch.yml** to **eventsvr**

* Start elasticsearch

```
bash bin/elasticsearch
```

* Move to this dir

* Start test via Intellij Idea or mvn to add documents in elasticsearch

```
mvn test
```

* Start search service

```
mvn spring-boot:run
```
