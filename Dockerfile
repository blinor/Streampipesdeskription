FROM anapsix/alpine-java

EXPOSE 8090
ENV CONSUL_LOCATION consul

ADD ./target/streampipes-templates-sources-0.41.0-SNAPSHOT.jar  /templates-sources.jar

ENTRYPOINT ["java", "-jar", "/templates-sources.jar"]
