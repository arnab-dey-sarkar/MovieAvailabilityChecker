# MovieAvailabilityAtTheatre
 This project is basically a Spring Boot service which retrieves data from BookMyShow UI using selenium. Selenium is running in headless mode to collect those theatre details and returns a response with the theatre names, address, showtimes  and seat prices for respective theatres if available for that day.



Endpoint Info: GET/movies/{movieName}/theatres: retrieves the list of theatres as per input.



Path Parameters:- 

1.movieName-> name of the movie



Request Parameters:- 

1.location-> the location for which the user intends to search the movie for theatre booking 

2.movieType-> the type of movie like 2D,3D etc. 

3.movieLanguage-> the language of the movie 

4.theatreName(Optional)->if the user tends to filter the result against a specific set of theatres like PVR, INOX etc.



This project is deployed in Heroku as well. The link for accessing the deployed application is [https://lnkd.in/dKu6kbCS](https://movieavailabilitydetails.herokuapp.com)



Example - 



Performing a GET request on the below endpoint will result in the output provided below:-



GET/movies/Laal Singh Chaddha/theatres?location=Kolkata&movieType=2D&movieLanguage=Hindi&theatreName=Diamond Plaza



Output:-

[
    {
        "name": "PVR: Diamond Plaza, Jessore Kolkata",
        "showTimesWithPriceStats": {
            "09:55 PM": [
                {
                    "price": "240.00",
                    "desc": "CLASSIC",
                    "availabilityClass": "_available",
                    "availabilityText": "Available"
                },
                {
                    "price": "300.00",
                    "desc": "PRIME",
                    "availabilityClass": "_available",
                    "availabilityText": "Available"
                },
                {
                    "price": "470.00",
                    "desc": "RECLINER",
                    "availabilityClass": "_available",
                    "availabilityText": "Available"
                }
            ],
            "11:00 PM": [
                {
                    "price": "240.00",
                    "desc": "CLASSIC",
                    "availabilityClass": "_available",
                    "availabilityText": "Available"
                },
                {
                    "price": "300.00",
                    "desc": "PRIME",
                    "availabilityClass": "_available",
                    "availabilityText": "Available"
                },
                {
                    "price": "470.00",
                    "desc": "RECLINER",
                    "availabilityClass": "_available",
                    "availabilityText": "Available"
                }
            ]
        }
    }
]
