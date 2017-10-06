package ba.weather;

import org.streampipes.container.init.DeclarersSingleton;
import org.streampipes.container.standalone.init.StandaloneModelSubmitter;

/**
 * @author Michael Jahns
 * this is build on the template provided by StreamPipes
 * It will provide the data to add the source to StreamPipes
 */
public class WeatherSourcesInit extends StandaloneModelSubmitter {

	public static void main(String[] args) {

		DeclarersSingleton.getInstance().add(new WeatherSource());
		DeclarersSingleton.getInstance().setHostName(WeatherConfig.INSTANCE.getHost());
		DeclarersSingleton.getInstance().setPort(WeatherConfig.INSTANCE.getPort());
		new WeatherSourcesInit().init();
	}

}
