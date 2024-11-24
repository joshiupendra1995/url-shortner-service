# url-shortner-service

Build a scalable and efficient URL shortener system using Spring Boot. The system should:

Convert long URLs into short URLs.
Retrieve the original URL from a short URL.
Handle high traffic with reliability and efficiency.

Database Schema
Field	Type	Description
id	Auto-increment or UUID	Unique identifier for the URL pair.
short_url	String	The generated short URL (unique).
long_url	String	The original long URL.
created_at	Timestamp	Timestamp of creation.
expiry_date	Timestamp	(Optional) Expiry date for the URL.


Dependencies
Spring Boot Starter Web
Spring Boot Starter Data JPA
H2 Database (for simplicity, replace with MySQL/PostgreSQL for production)
Lombok (optional)
Redis (optional for caching)




