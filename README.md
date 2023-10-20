### run
docker container exec -it kafka-example-kafka1-1 bash

docker-compose exec kafka1 kafka-topics --create --topic result --bootstrap-server kafka1:9091 --replication-factor 3 --partitions 3
docker-compose exec kafka1 kafka-topics --describe --topic result --bootstrap-server kafka1:9091
