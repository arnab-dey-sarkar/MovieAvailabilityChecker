# MovieAvailabilityAtTheatre
This project is basically a Spring Boot service which retrieves data from BookMyShow and provides availability of theatres for a particular movie.
This project has selenium running in headless mode to collect those theatre details and return a response with the theatre names and address if available for that day.

Endpoint Info:
POST/getMovieAvailability: retrieves the list of specific theatres as per input like PVR in below example.

Request Body:
{ "location": "Kolkata", "movieName": "Laal Singh Chaddha", "theatreName": "PVR", "movieType": "2D", "movieLanguage": "Hindi" }

Output:
[
    {
        "availabilty": "PVR: Avani, Kolkata"
    },
    {
        "availabilty": "PVR: Diamond Plaza, Jessore Kolkata"
    },
    {
        "availabilty": "PVR: Mani Square Mall, Kolkata"
    },
    {
        "availabilty": "PVR: Uniworld Downtown Mall, New Town, Kolkata"
    }
]

POST/getAvailableTheatres: retrieves all the list of available theatres as per movie name,location and other input parameters

Request Body:
{ "location": "Kolkata", "movieName": "Laal Singh Chaddha", "movieType": "2D", "movieLanguage": "Hindi" }

Output:
[
    {
        "availabilty": "INOX: City Centre II, Rajarhat"
    },
    {
        "availabilty": "Miraj Cinemas: Newtown, Kolkata"
    },
    {
        "availabilty": "Bioscope: Axis Mall, Rajarhat"
    },
    {
        "availabilty": "Nazrultirtha Cinema: Kolkata"
    }
]
