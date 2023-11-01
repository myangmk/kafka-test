
### run

* 카프카 실행
* `docker-compose up -d`

* 어플리케이션 인스턴스 실행
`./gradlew build`

`java -jar -Dserver.port=8111 build/libs/kafka-example-0.0.1-SNAPSHOT.jar`

### cli
토픽 확인
- docker-compose exec kafka-1 kafka-topics --describe --topic result --bootstrap-server kafka-1:29092
토픽 생성
- docker-compose exec kafka-1 kafka-topics --create --topic result --bootstrap-server kafka-1:29092 --replication-factor 3 --partitions 3
토픽 컨슈머그룹 확인 (lag 등)
- docker-compose exec kafka-1 kafka-consumer-groups --bootstrap-server kafka-1:9092 --group foo  --describe
토픽 리스트
- docker-compose exec kafka-1 kafka-topics --list --bootstrap-server kafka-1:9092
토픽 삭제
- docker-compose exec kafka-1 kafka-topics --delete --topic newnew --bootstrap-server kafka-1:9092


### perf test
`docker-compose exec kafka-1 kafka-producer-perf-test \
--topic newnew \
--record-size 104 \
--num-records 30000 \
--throughput -1 \
--producer-props \
bootstrap.servers=kafka-1:9092`


```
30000 records sent, 78947.368421 records/sec (7.83 MB/sec), 
101.67 ms avg latency, 163.00 ms max latency, 98 ms 50th, 134 ms 95th, 138 ms 99th, 138 ms 99.9th.

```
