# weather-test
mvn spring-boot:run

retrieve the weather
http://localhost:3000/weather

First timw retrieve the data from darksky.
if the next retrieve is within 5 minutes, the weather data is retrieved from mongodb.

The data saved in mongodb that is 3 days old will be deleted .
The deleting task is sheduled at 1:50am everday.
