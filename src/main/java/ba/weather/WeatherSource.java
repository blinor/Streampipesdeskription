package ba.weather;

import org.streampipes.container.declarer.EventStreamDeclarer;
import org.streampipes.container.declarer.SemanticEventProducerDeclarer;
import org.streampipes.model.impl.graph.SepDescription;
import org.streampipes.sdk.builder.DataSourceBuilder;

import java.util.Arrays;
import java.util.List;

public class WeatherSource implements SemanticEventProducerDeclarer {

    /*
        TUTORIAL:
        Here you can change the description of the event producer
     */
    @Override
    public SepDescription declareModel() {
        return DataSourceBuilder.create("air-weather-source", "Weather Stream", "A data  that " +
                "holds Weather and Air Data Produced by stations.")
                .build();

    }

    /*
        TUTORIAL:
        Here you have to register all the streams belonging to this source
        If you do not register the source here you can not see it in the web browser
     */
    @Override
    public List<EventStreamDeclarer> getEventStreams() {
        return Arrays.asList(new WeatherStream());
    }

}
