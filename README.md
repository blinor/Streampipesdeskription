# Sourcedescription of the WeatherdataStream for Rest-Interfaces


	// 	Example event:
	    {
	    "no2":74,
	    "ozn":0,
	    "getRequestTimestamp":1504768155306,
	    "latitude":49.14595686859241,
	    "heigth":172,
	    "so2":0,
	    "station":"76446",
	    "pm10":0,
	    "lux":0,
	    "timestamp":1504771200000,
	    "longitude":9.225989162546554}
	```


## Deployment

	
You must define in the docker-compose.yml.//	
		
		weatherinput:
		    image: laus.fzi.de:8201/weatherba/weather_input
		    depends_on:
		      - "consul"
		      - "kafka"
		    ports:
		      - "8087:8087"
		    networks:
		      spnet:
