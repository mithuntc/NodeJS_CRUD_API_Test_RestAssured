# 🧪 NodeJS CRUD API Test Automation – Rest Assured + TestNG

This project is designed to automate API testing of a **Node.js CRUD backend** using **Rest Assured**, **TestNG**, and **Hamcrest** libraries.

---

## 🚀 Tools & Technologies Used

- **Java** (JDK 17+)
- **Rest Assured**
- **TestNG**
- **Hamcrest**
- **Eclipse IDE for Java Developers**

> ✅ *Eclipse IDE is recommended for smooth setup and execution.*

---

## ⚙️ Prerequisites

Before you begin, ensure the following are installed:

- [Java JDK 17 or higher](https://www.oracle.com/java/technologies/javase-downloads.html) (Latest Recommended I used 21.0.6)
- [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/)

---

## 📦 Dependencies Used

All dependencies are handled via the project’s configuration files:

- `rest-assured`
- `testng`
- `hamcrest`

These will be auto-resolved by Eclipse when the project is opened.

**Open the cloned project directly in Eclipse IDE (no need to create a new Maven project).

Once opened, Eclipse will automatically detect the pom.xml and download all required dependencies.
If dependencies aren't imported automatically, right-click the project → Maven → Update Project.**

---

## 📥 How to Run the Tests

1. **Clone the repository:**

   ```bash
   git clone https://github.com/mithuntc/NodeJS_CRUD_API_Test_RestAssured.git

2. Open the project in Eclipse IDE:

Go to File → Import → Existing Projects into Workspace

Select the cloned directory

Wait for Eclipse to auto-import dependencies

3. Run the tests:

Locate the **testng.xml** file

**Right-click on it → Run As → TestNG Suite**
----
✅ Features
Full CRUD Testing – Covers POST, GET, PUT, DELETE

Positive & Negative Scenarios handled

Option to run:

Full test suite via testNg.xml

Individual test classes as needed



Folder Strucrure


![Folder Structure](https://github.com/user-attachments/assets/5d604be1-5d96-442c-bfd3-d76e2e3e021e)



-----------------------------------------------------------------------------------------------------
**⚠️ Note:
To run these tests, you must first start the API server locally on http://localhost:3000.
Once the server is running, you can invoke the tests from Eclipse.
This setup is required for the tests to work properly.**

-----------------------------------------------------------------------------------------------------

🔗 Node.js API Repository
Repo: https://github.com/mithuntc/NodeJS_Login_CRUD_APIs.git

----------------------------------------------------------------------------------------------------
✅ Steps to Set Up the API Server (Important):
Clone the API repo:
git clone https://github.com/mithuntc/NodeJS_Login_CRUD_APIs.git

**Navigate into the project directory**.

Install dependencies:
**npm install**

Start the server:
**npm run dev**

The server should now be running at:
http://localhost:3000
------------------------------------------------------------------------------------------------------
Then we will be able to test the APIs using RestAssured.


