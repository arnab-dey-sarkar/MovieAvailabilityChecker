# MovieAvailabilityAtTheatre
This project is basically a Spring Boot service which retrieves data from BookMyShow and provides availability of theatres for a particular movie.
This project has selenium running in headless mode to collect those theatre details and return a response with the theatre names and address if available for that day.

Endpoint Info:
POST/getMovieAvailability: retrieves the list of theatres as per Input
                     
Request Body:

{
    "location": "Kolkata",
    "movieName": "The Batman",
    "theatreName": "PVR",
    "movieType": "2D",
    "movieLanguage": "English"
}

POST/getAvailableTheatres: retrieves all the list of available theatres as per Input

Request Body:

{
"location": "Kolkata",
"movieName": "The Batman",
"movieType": "2D",
"movieLanguage": "English"
}
