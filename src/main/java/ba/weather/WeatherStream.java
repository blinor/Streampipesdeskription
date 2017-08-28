package ba.weather;

import org.streampipes.model.impl.EventStream;
import org.streampipes.model.impl.graph.SepDescription;
import org.streampipes.model.vocabulary.Geo;
import org.streampipes.sdk.builder.DataStreamBuilder;
import org.streampipes.sdk.helpers.EpProperties;
import org.streampipes.sdk.helpers.Formats;
import org.streampipes.sdk.helpers.Protocols;
import org.streampipes.sources.AbstractAlreadyExistingStream;

public class WeatherStream extends AbstractAlreadyExistingStream {

    @Override
    public EventStream declareModel(SepDescription sepDescription) {
        return DataStreamBuilder.create("air-weather-stream", "Weather Stream", "A data  that " +
                "holds Weather and Air Data Produced by stations.")
                .property(EpProperties.timestampProperty("timestamp"))
                .property(EpProperties.timestampProperty("getRequestTimestamp"))
                .property(EpProperties.stringEp("station", "http://schema.org/name"))
                .property(EpProperties.doubleEp("latitude", Geo.lat))
                .property(EpProperties.doubleEp("longitude", Geo.lng))
                .property(EpProperties.doubleEp("heigth", Geo.alt))
//                http://www.qudt.org/qudt/owl/1.0.0/unit/Instances.html#Lux
                .property(EpProperties.integerEp("ozn", "http://schema.org/Integer"))
                .property(EpProperties.integerEp("lux", "http://schema.org/Integer"))
                .property(EpProperties.integerEp("no2", "http://schema.org/Integer"))
                .property(EpProperties.integerEp("so2", "http://schema.org/Integer"))
                .format(Formats.jsonFormat())
                .protocol(Protocols.kafka(WeatherConfig.INSTANCE.getKafkaHost(), WeatherConfig.INSTANCE.getKafkaPort(),
                        "my.weather.lubw"))
                .build();
    }
}
