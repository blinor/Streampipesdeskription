package org.streampipes.templates.sources;

import org.streampipes.container.init.DeclarersSingleton;
import org.streampipes.container.standalone.init.StandaloneModelSubmitter;
import org.streampipes.templates.sources.template.TemplateSource;

/*
    TUTORIAL:
    This is the main class of the examples sources project.
    Here you must register all the event producers. A producer is a collection of different streams.
    The main method starts a web server that provides all the descriptions of the registered
    producers and their streams.
 */
public class ExampleSourcesInit extends StandaloneModelSubmitter {

    public static void main(String[] args) {

        /*
            TOTORIAL:
            Add the newly created event producer to the declarer singleton
         */
        DeclarersSingleton.getInstance()
                .add(new TemplateSource());
        /*
            TOTORIAL:
            First a port for the service is set and then the server is started
         */
        DeclarersSingleton.getInstance().setHostName("10.0.75.1");
//        DeclarersSingleton.getInstance().setHostName(TemplateConfig.INSTANCE.getHost());
        
        DeclarersSingleton.getInstance().setPort(TemplateConfig.INSTANCE.getPort());
        new ExampleSourcesInit().init();
    }

}
