#!/bin/sh

docker run --name scra --rm --env MYSQL_ADDRESS=172.17.0.2 --env MYSQL_PORT=3306 --env MYSQL_USER=root --env MYSQL_PASSWORD=root scra:latest
