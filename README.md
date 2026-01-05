# Project Management System

A comprehensive project management application built with Spring Boot that enables teams to collaborate, track issues, communicate in real-time, and manage project workflows efficiently.

## Features

### Core Functionality
- **User Authentication & Authorization**: Secure JWT-based authentication system
- **Project Management**: Create, update, delete, and search projects
- **Issue Tracking**: Create and manage issues with priorities, statuses, and due dates
- **Team Collaboration**: Invite team members via email, manage project teams
- **Real-time Chat**: Project-based messaging system for team communication
- **Comments System**: Add comments to issues for detailed discussions
- **Subscription Plans**: Free, Monthly, and Annual subscription tiers

### Technical Features
- RESTful API architecture
- JWT token-based security
- Email notifications for project invitations
- Razorpay payment integration for subscriptions
- Role-based access control
- MySQL database integration

## Tech Stack

- **Backend**: Spring Boot 3.x
- **Security**: Spring Security with JWT
- **Database**: MySQL
- **ORM**: Spring Data JPA with Hibernate
- **Email**: JavaMailSender (Gmail SMTP)
- **Payment Gateway**: Razorpay
- **Build Tool**: Maven
- **Java Version**: 17+

## Project Structure

```
src/main/java/com/mnrahman/
├── config/              # Security and JWT configuration
├── controller/          # REST API endpoints
├── dto/                 # Data Transfer Objects
├── entity/              # JPA entities
├── repository/          # Data access layer
├── request/             # Request models
├── response/            # Response models
└── service/             # Business logic layer
```

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Gmail account (for email notifications)
- Razorpay account (for payment processing)

## Environment Variables

Create a `.env` file or set the following environment variables:

```properties
# Application
SPRING_APPLICATION_NAME=project-management-system
SERVER_PORT=8080

# Database Configuration
DB_URL=jdbc:mysql://localhost:3306/project_management
DB_USERNAME=your_db_username
DB_PASSWORD=your_db_password

# Gmail SMTP Configuration
GMAIL_USERNAME=your_email@gmail.com
GMAIL_APP_PASSWORD=your_app_password

# Razorpay Configuration
RAZORPAY_API_KEY=your_razorpay_key
RAZORPAY_API_SECRET=your_razorpay_secret
```

## Installation & Setup

### 1. Clone the repository
```bash
git clone https://github.com/yourusername/project-management-system.git
cd project-management-system
```

### 2. Create MySQL Database
```sql
CREATE DATABASE project_management;
```

### 3. Configure Application Properties
Update `src/main/resources/application.properties` with your environment variables or use the properties file directly.

### 4. Build the Project
```bash
./mvnw clean install
```

### 5. Run the Application
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080` (or your configured port).

## API Endpoints

### Authentication
- `POST /auth/signup` - Register a new user
- `POST /auth/signin` - User login

### Projects
- `GET /api/projects` - Get all projects (with optional filters)
- `GET /api/projects/{projectId}` - Get project by ID
- `POST /api/projects` - Create new project
- `PATCH /api/projects/{projectId}` - Update project
- `DELETE /api/projects/{projectId}` - Delete project
- `GET /api/projects/search?keyword={keyword}` - Search projects
- `POST /api/projects/invite` - Invite user to project
- `GET /api/projects/accept_invitation?token={token}` - Accept invitation

### Issues
- `GET /api/issues/{issueId}` - Get issue by ID
- `GET /api/issues/project/{projectId}` - Get all issues for a project
- `POST /api/issues` - Create new issue
- `DELETE /api/issues/{issueId}` - Delete issue
- `PUT /api/issues/{issueId}/assignee/{userId}` - Assign user to issue
- `PUT /api/issues/{issueId}/status/{status}` - Update issue status

### Comments
- `POST /api/comments` - Create comment on issue
- `GET /api/comments/{issueId}` - Get all comments for an issue
- `DELETE /api/comments/{commentId}` - Delete comment

### Messages
- `POST /api/messages/send` - Send message in project chat
- `GET /api/messages/chat/{projectId}` - Get all messages for a project

### Subscriptions
- `GET /api/subscription/user` - Get user's subscription
- `PATCH /api/subscription/upgrade?planType={planType}` - Upgrade subscription

### Payments
- `POST /api/payment/{planType}` - Create payment link for subscription

### User
- `GET /api/users/profile` - Get user profile

## Security

All API endpoints under `/api/**` require authentication via JWT token. Include the JWT token in the Authorization header:

```
Authorization: Bearer <your-jwt-token>
```

## Subscription Plans

- **FREE**: Default plan for new users
- **MONTHLY**: ₹799/month
- **ANNUALLY**: ₹799/month × 12 × 0.7 (30% discount)

## Database Schema

The application uses the following main entities:
- **User**: User accounts and authentication
- **Project**: Project information and metadata
- **Issue**: Project tasks/issues
- **Comment**: Comments on issues
- **Chat**: Project chat rooms
- **Message**: Chat messages
- **Invitation**: Project invitations
- **Subscription**: User subscription plans

## Docker Support

A `docker-compose.yaml` file is included for containerized deployment.

```bash
docker-compose up -d
```

## Development

### Running Tests
```bash
./mvnw test
```

### Building for Production
```bash
./mvnw clean package -DskipTests
java -jar target/project-management-system-0.0.1-SNAPSHOT.jar
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

Md Noornawaz Rahman - noornawazrahman@gmail.com

Project Link: [https://github.com/NoornawazRahman/project-management-system-backend](https://github.com/NoornawazRahman/project-management-system-backend)

## Acknowledgments

- Spring Boot Documentation
- Spring Security
- Razorpay API Documentation
- MySQL Community
