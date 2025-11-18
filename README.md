# Blog Website using Maven Build Tool

This project demonstrates a blog website built with HTML, CSS, and Java, using Maven for build automation and dependency management.

## Project Structure

```
3-Blog-Website-Maven/
├── pom.xml                          # Maven configuration file
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── blog/
│   │   │           ├── App.java          # Main application class
│   │   │           ├── BlogService.java  # Blog service class
│   │   │           └── BlogPost.java     # Blog post model class
│   │   └── webapp/
│   │       ├── index.html          # Home page
│   │       ├── posts.html          # All posts page
│   │       └── styles.css          # CSS stylesheet
│   └── test/
│       └── java/
│           └── com/
│               └── blog/
│                   ├── AppTest.java          # Unit tests for App
│                   └── BlogServiceTest.java  # Unit tests for BlogService
└── README.md                       # This file
```

## Prerequisites

- Java JDK 8 or higher (already installed on lab computer)
- Maven 3.6 or higher (already installed on lab computer)
- Git is installed (usually pre-installed)
- GitHub account access

## Step-by-Step Instructions

### Step 1: Verify Java and Maven Installation

Open Windows Command Prompt (cmd) and verify installations:

**Check Java version:**
```cmd
java -version
```

**Expected output:** Should show Java version (e.g., "java version 1.8.0_xxx" or higher)

**Check Java compiler:**
```cmd
javac -version
```

**Expected output:** Should show javac version

**Check Maven version:**
```cmd
mvn --version
```

**Expected output:** Should show Maven version and Java version

**If any command fails:**
- Ask your lab instructor - Java and Maven should be pre-installed

### Step 2: Clone or Download the Project from GitHub

**Option A: If you have the repository URL, clone it:**
```cmd
git clone https://github.com/yourusername/blog-website-maven.git
cd blog-website-maven
```

**Option B: If you need to create the repository first:**
1. Go to GitHub.com and sign in
2. Click the "+" icon in the top right corner
3. Select "New repository"
4. Name it: `blog-website-maven`
5. Click "Create repository"
6. Then clone it:
```cmd
git clone https://github.com/yourusername/blog-website-maven.git
cd blog-website-maven
```

### Step 3: Verify Project Structure

After cloning, verify the project structure is correct:

**Navigate to project folder:**
```cmd
cd blog-website-maven
```

**Check if pom.xml exists:**
```cmd
dir pom.xml
```

**Check project structure:**
```cmd
dir /s /b
```

**Verify key files exist:**
```cmd
dir src\main\java\com\blog\*.java
dir src\main\webapp\*.html
dir src\test\java\com\blog\*.java
```

### Step 5: Fix pom.xml (If Needed)

**Check pom.xml for the name tag:**
```cmd
type pom.xml | findstr /n "name"
```

**If you see `<n>` instead of `<name>` on line 13:**
1. Open pom.xml in notepad:
   ```cmd
   notepad pom.xml
   ```
2. Find line 13: `<n>Tech Blog Website</n>`
3. Change it to: `<name>Tech Blog Website</name>`
4. Save and close

### Step 6: Push Project to GitHub

**Initialize Git (if not already initialized):**
```cmd
git init
```

**Check current status:**
```cmd
git status
```

**Add all files to staging:**
```cmd
git add .
```

**Verify files are added:**
```cmd
git status
```

**Commit the files:**
```cmd
git commit -m "Initial commit: Blog website with Maven"
```

**Add GitHub repository as remote (replace YOUR_USERNAME with your actual GitHub username):**
```cmd
git remote add origin https://github.com/YOUR_USERNAME/blog-website-maven.git
```

**If remote already exists, remove it first:**
```cmd
git remote remove origin
git remote add origin https://github.com/YOUR_USERNAME/blog-website-maven.git
```

**Push to GitHub:**
```cmd
git branch -M main
git push -u origin main
```

**Note:** You will be prompted for your GitHub username and password (or personal access token). Enter them when prompted.

**Verify push was successful:**
- Go to your GitHub repository in a web browser
- You should see all the files including pom.xml and src folder

### Step 7: Clean Previous Builds (If Any)

**Clean any previous build artifacts:**
```cmd
mvn clean
```

**Expected output:** Should show "BUILD SUCCESS"

### Step 8: Compile the Project

**Compile Java source code:**
```cmd
mvn compile
```

**What this does:**
- Downloads Maven dependencies (JUnit) if needed
- Compiles all Java files in src/main/java
- Creates compiled .class files in target/classes

**Expected output:**
```
[INFO] Scanning for projects...
[INFO] Building Blog Website 1.0.0
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ blog-website ---
[INFO] Changes detected - recompiling the module
[INFO] Compiling 3 source files to target\classes
[INFO] BUILD SUCCESS
```

**If compilation fails:**
- Check error messages
- Verify Java files are in correct location
- Check pom.xml for errors

### Step 9: Run Unit Tests

**Run all unit tests:**
```cmd
mvn test
```

**What this does:**
- Compiles test code
- Runs all test classes (AppTest, BlogServiceTest)
- Shows test results

**Expected output:**
```
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ blog-website ---
[INFO] Running com.blog.AppTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.blog.BlogServiceTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

**If tests fail:**
- Review error messages
- Check test files are correct
- Verify source code matches test expectations

### Step 10: Build the WAR Package

**Build the complete package:**
```cmd
mvn clean package
```

**What this does:**
- Cleans previous builds
- Compiles source code
- Runs tests
- Packages everything into a WAR file

**Expected output:**
```
[INFO] --- maven-war-plugin:3.2.3:war (default-war) @ blog-website ---
[INFO] Packaging webapp
[INFO] Building war: D:\...\blog-website-maven\target\blog-website.war
[INFO] BUILD SUCCESS
```

**Verify WAR file was created:**
```cmd
dir target\*.war
```

**Expected output:** Should show "blog-website.war"

### Step 11: Verify Build Output

**Check target directory structure:**
```cmd
dir target /s
```

**You should see:**
- target/classes/ - Compiled Java classes
- target/test-classes/ - Compiled test classes
- target/blog-website.war - The WAR package file

**View WAR file details:**
```cmd
dir target\blog-website.war
```

### Step 12: Run the Application

**Option A: Run using Maven exec plugin:**
```cmd
mvn compile exec:java -Dexec.mainClass="com.blog.App"
```

**Expected output:**
```
========================================
Tech Blog Application
========================================
Application started successfully!
Web application is ready to serve.
Access the website at: http://localhost:8080/blog
========================================
```

**Option B: Run compiled class directly:**
```cmd
java -cp target\classes com.blog.App
```

**Expected output:** Same as above

### Step 13: View HTML Files (Optional)

Since this is a static website, you can also view the HTML files directly:

**Open index.html in browser:**
```cmd
start src\main\webapp\index.html
```

**Or navigate manually:**
- Open File Explorer
- Go to: `blog-website-maven\src\main\webapp\`
- Double-click `index.html` or `posts.html`

## Common Maven Commands Reference (Windows CMD)

```cmd
REM Clean previous builds
mvn clean

REM Compile source code
mvn compile

REM Run tests
mvn test

REM Package the project (creates WAR file)
mvn package

REM Clean, compile, test, and package
mvn clean install

REM Skip tests during build
mvn clean package -DskipTests

REM Run specific test class
mvn test -Dtest=AppTest

REM Display dependency tree
mvn dependency:tree

REM Validate project structure
mvn validate

REM Display project information
mvn help:effective-pom
```

## Project Configuration Details

### Maven Configuration (pom.xml)

- **Group ID**: `com.blog`
- **Artifact ID**: `blog-website`
- **Version**: `1.0.0`
- **Packaging**: `war` (Web Application Archive)
- **Java Version**: 1.8

### Dependencies

- **JUnit 4.13.2**: For unit testing

### Plugins

- **maven-compiler-plugin**: Compiles Java source code
- **maven-war-plugin**: Packages web application as WAR file
- **maven-surefire-plugin**: Runs unit tests

## Troubleshooting

**Problem: "mvn: command not found"**
- Solution: Maven is not in PATH. Ask your lab instructor.

**Problem: "javac: command not found"**
- Solution: Java JDK is not installed or not in PATH. Ask your lab instructor.

**Problem: XML parsing error in pom.xml**
- Solution: 
  1. Open pom.xml: `notepad pom.xml`
  2. Check line 13 for `<n>` tag
  3. Change `<n>Tech Blog Website</n>` to `<name>Tech Blog Website</name>`
  4. Save and try again

**Problem: "BUILD FAILURE" during compile**
- Solution:
  - Check error messages in output
  - Verify Java files are in correct location: `src\main\java\com\blog\`
  - Check for syntax errors in Java files
  - Verify pom.xml is correct

**Problem: Tests fail**
- Solution:
  - Review test output for specific failures
  - Check test files: `src\test\java\com\blog\`
  - Verify source code matches test expectations
  - Run with verbose output: `mvn test -X`

**Problem: WAR file not created**
- Solution:
  - Check for errors in build output
  - Verify pom.xml has maven-war-plugin configured
  - Make sure packaging is set to "war" in pom.xml
  - Check target directory: `dir target`

**Problem: "Could not find or load main class"**
- Solution:
  - Make sure you compiled first: `mvn compile`
  - Check classpath: `java -cp target\classes com.blog.App`
  - Verify class files exist: `dir target\classes\com\blog\*.class`

**Problem: Dependencies not downloading**
- Solution:
  - Check internet connection
  - Maven needs internet to download JUnit
  - Try: `mvn dependency:resolve`
  - Check Maven settings if behind proxy

**Problem: Port 8080 already in use (if deploying)**
- Solution: This is just for viewing HTML files directly. The WAR file can be deployed to any available port on a web server.

## Verification Checklist

- [ ] Java is installed and accessible
- [ ] Maven is installed and accessible
- [ ] Project structure is correct
- [ ] pom.xml is valid (name tag fixed if needed)
- [ ] Project files are in GitHub repository
- [ ] Project compiles successfully (`mvn compile`)
- [ ] All tests pass (`mvn test`)
- [ ] WAR file is created (`mvn package`)
- [ ] Application runs successfully
- [ ] HTML files can be viewed in browser

## Notes

- Java and Maven are assumed to be already installed on the lab computer
- The project uses standard Maven directory structure
- Java source files are in `src/main/java`
- Web resources (HTML, CSS) are in `src/main/webapp`
- Test files are in `src/test/java`
- The WAR file can be deployed to any Java servlet container (Tomcat, Jetty, etc.)
- For deployment, copy the WAR file to the web server's webapps directory
- The HTML files can be viewed directly in a browser without a web server
