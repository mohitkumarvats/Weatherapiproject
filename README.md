#  Java Weather API Client

This Java project demonstrates how to consume a public REST API to fetch **real-time weather data** using **HTTP requests** and parse the **JSON response** using `org.json`.

---

##  Features

-  Connects to a public weather API
-  Fetches current weather data for a city
-  Parses JSON response using `org.json` library
-  Displays city, temperature, and weather condition in a clean format

---

##  Technologies Used

- Java (Core)
- HTTPURLConnection (Java Networking)
- JSON Parsing with `org.json` library

---

## Files Included

| File | Description |
|------|-------------|
| `WeatherAPIClient.java` | Main Java program that connects to the API and displays weather |
| `README.md` | Project documentation |

---

## 🔧 How to Run

### Step 1: Download Dependency
Download `json.jar` from [Maven Repository](https://mvnrepository.com/artifact/org.json/json)  
(Or use the version provided by your IDE if applicable)

### Step 2: Compile
```bash
javac -cp .;json.jar WeatherAPIClient.java

## Author
Mohit kumar software developer