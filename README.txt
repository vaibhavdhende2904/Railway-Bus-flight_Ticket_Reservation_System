TICKET RESERVATION SYSTEM

TECH STACK:
- Frontend: HTML, CSS, JavaScript
- Backend: Spring Boot
- Database: MySQL

HOW TO RUN:

1. Install:
   - Java 17+
   - MySQL
   - Eclipse IDE
   - Maven

2. Create Database:
   Run schema.sql in MySQL.

3. Backend:
   - Open backend folder in Eclipse as Maven project
   - Update MySQL username/password in application.properties
   - Run TicketReservationApplication.java

4. Frontend:
   - Open frontend/index.html in browser
   OR use Live Server extension.

API ENDPOINTS:
POST /api/auth/register
POST /api/auth/login
GET /api/routes/search
POST /api/bookings

FEATURES:
- Dynamic route search
- Seat booking
- Unique PNR generation
- Prevent double booking
- Layered architecture
- MySQL integration