# MovieAvailabilityAtTheatre
This project is basically a Spring Boot service which retrieves data from BookMyShow UI using selenium.
Selenium is running in headless mode to collect those theatre details and returns a response with the theatre names,address and showtimes for respective theatres if available for that day.

Endpoint Info:
GET/movies/{movieName}/theatres: retrieves the list of theatres as per input.

Path Parameters:-
1.movieName-> name of the movie

Request Parameters:-
1.location-> the location for which the user intends to search the movie for theatre booking
2.movieType-> the type of movie like 2D,3D etc.
3.movieLanguage-> the language of the movie
4.theatreName(Optional)->if the user tends to filter the result against a specific set of theatres like PVR, INOX etc.

This project is deployed in Heroku as well.The link for accessing the deployed application is https://movieavailabilitydetails.herokuapp.com

Example -
Performing a GET request on the below URL will result in the ouput provided below:-

https://movieavailabilitydetails.herokuapp.com/movies/Laal Singh Chaddha/theatres?location=Kolkata&movieType=2D&movieLanguage=Hindi&theatreName=PVR

Output:
[
    {
        "name": "PVR: Avani, Kolkata",
        "showTimes": [
            "04:00 PM",
            "07:30 PM",
            "09:30 PM",
            "10:00 PM",
            "11:00 PM"
        ]
    },
    {
        "name": "PVR: Diamond Plaza, Jessore Kolkata",
        "showTimes": [
            "02:55 PM",
            "04:00 PM",
            "07:30 PM",
            "09:55 PM",
            "11:00 PM"
        ]
    },
    {
        "name": "PVR: Mani Square Mall, Kolkata",
        "showTimes": [
            "04:00 PM",
            "06:30 PM",
            "07:30 PM",
            "10:00 PM",
            "11:00 PM"
        ]
    },
    {
        "name": "PVR: Uniworld Downtown Mall, New Town, Kolkata",
        "showTimes": [
            "04:00 PM",
            "07:30 PM",
            "08:00 PM",
            "11:00 PM"
        ]
    }
]
