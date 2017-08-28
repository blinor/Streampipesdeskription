FROM anapsix/alpine-java

EXPOSE 8090
ENV CONSUL_LOCATION consul

ADD ./target/ba-weather-0.41.0-SNAPSHOT.jar  /weather-source.jar

ENTRYPOINT ["java", "-jar", "/weather-source.jar"]
