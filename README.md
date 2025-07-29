# Email Sender App

This Java application is designed to automate email sending, utilizing data extracted from a CSV file. The system is modular, incorporating data reading, email configuration, and sending logic to ensure efficient and traceable operation.

### Features
* **CSV Data Reading**: Processes a CSV file (`notas_fiscais_test.csv`) to extract relevant information such as invoice number, issue date, operation type, company name, and recipient email list.
* **Email Sending**: Utilizes the Jakarta Mail API for programmatic email sending.
* **External Configuration**: Manages email settings (username, password, SMTP host, SMTP port) and the CSV file path through a properties file (`application.properties`).
* **Message Template**: Dynamically generates the email body, incorporating specific invoice data read from the CSV.

### Technologies Used
* **Java**: Primary programming language.
* **Gradle**: Build automation tool for dependency management and project compilation.
* **Jakarta Mail API**: Library for sending and receiving emails, integrated as a dependency in `build.gradle`.
* **Jakarta Activation**: Required for Jakarta Mail, also configured via `build.gradle`.

### Getting Started

To set up and run the application in your local environment, follow the instructions below:

#### Prerequisites
* Java Development Kit (JDK) 17 or higher.
* A code editor or IDE (IntelliJ IDEA, Eclipse, VS Code) with Gradle support.

#### Installation

1.  **Clone the repository:**
    ```bash
    git clone <REPOSITORY_URL>
    cd EmailSenderApp
    ```

2.  **Environment Configuration:**
    * Ensure that `JAVA_HOME` is correctly configured in your environment variables, pointing to your JDK installation.

3.  **Properties Configuration:**
    * Copy `src/main/resources/application-example.properties` to `src/main/resources/application.properties` and fill in your email credentials and SMTP settings.
    ```properties
    email.username=your_email@example.com
    email.password=your_password
    smtp.host=your_smtp_host
    smtp.port=your_smtp_port
    csv.file.path=src/notas_fiscais_test.csv
    ```
    * **Note**: For local testing, you can use `localhost` and port `1025` (e.g., with a test SMTP server like MailHog or GreenMail). For production, use your email provider's settings (e.g., `smtp.gmail.com` on port `587`).

#### Running the Application
* Open the project in your IDE (IntelliJ IDEA is suggested by the `.idea/misc.xml` file).
* Run the `Main.java` class.

Alternatively, via the command line (using the Gradle Wrapper):

```bash
# On Linux/macOS
./gradlew run

# On Windows
./gradlew.bat run


