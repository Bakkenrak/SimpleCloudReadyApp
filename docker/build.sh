#!/bin/sh
cp ../target/*.war SimpleCloudReadyApp.war
docker build --tag scra:latest .
