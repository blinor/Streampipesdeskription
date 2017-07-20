FROM anapsix/alpine-java

EXPOSE 8085

ADD ./target/streampipes-templates-sources-0.41.0-SNAPSHOT.jar  /templates-sources.jar

ENTRYPOINT ["java", "-jar", "/templates-sources.jar"]
