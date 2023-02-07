# MovieAvailabilityChecker
 This project is basically a Spring Boot service which retrieves data from BookMyShow UI using selenium. Selenium is running in headless mode to collect those theatre details and returns a response with the theatre names, address, showtimes  and seat prices for respective theatres if available for that day.This project also has Security implementation.There is one endpoint for generating JWT Token and then inorder to access the other endpoints we need to provide an Authorization Header with the value as Bearer {token}.



Endpoint Info: 
GET/movies : Retrieves the list of movies as per given location.

Query Parameters:- 

1.location-> location of the theatres where the movie can be seen

Output->

[
    {
        "movieName": "Daagdi Chaawl 2",
        "language": "Marathi"
    },
    {
        "movieName": "Karthikeya 2",
        "language": "Telugu, Hindi, Kannada, Tamil, Malayalam"
    },
    {
        "movieName": "Laal Singh Chaddha",
        "language": "Hindi, Tamil, Telugu"
    },
    {
        "movieName": "Dobaaraa",
        "language": "Hindi"
    }
]

GET/movies/{movieName}/theatres: Retrieves the list of theatres as per input.

Path Parameters:- 

1.movieName-> name of the movie



Query Parameters:- 

1.location-> location of the theatres where the movie can be seen

2.movieType-> the type of movie like 2D,3D etc. 

3.movieLanguage-> the language of the movie 

4.theatreName(Optional)->if the user tends to filter the result against a specific set of theatres like PVR, INOX etc.







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
