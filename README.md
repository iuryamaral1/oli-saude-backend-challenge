![Oli Saúde|100x397,20%](https://hs-7708371.f.hubspotfree.net/hub/7708371/hubfs/logo-olisaude.png?upscale=true&width=288&upscale=true&name=logo-olisaude.png)

# ✨Oli Saúde Backend Challenge✨

[![.github/workflows/main.yml](https://github.com/iuryamaral1/oli-saude-backend-challenge/actions/workflows/main.yml/badge.svg)](https://github.com/iuryamaral1/oli-saude-backend-challenge/actions/workflows/main.yml)
[![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=iuryamaral1_oli-saude-backend-challenge&metric=alert_status)](https://sonarcloud.io/project/overview?id=iuryamaral1_oli-saude-backend-challenge)
[![Code Coverage](https://sonarcloud.io/api/project_badges/measure?project=iuryamaral1_oli-saude-backend-challenge&metric=coverage)](https://sonarcloud.io/component_measures?metric=coverage&id=iuryamaral1_oli-saude-backend-challenge)
[![Reliability](https://sonarcloud.io/api/project_badges/measure?project=iuryamaral1_oli-saude-backend-challenge&metric=reliability_rating)](https://sonarcloud.io/component_measures?metric=reliability_rating&id=iuryamaral1_oli-saude-backend-challenge)
[![Security](https://sonarcloud.io/api/project_badges/measure?project=iuryamaral1_oli-saude-backend-challenge&metric=security_rating)](https://sonarcloud.io/component_measures?metric=security_rating&id=iuryamaral1_oli-saude-backend-challenge)
[![Maintainability](https://sonarcloud.io/api/project_badges/measure?project=iuryamaral1_oli-saude-backend-challenge&metric=sqale_rating)](https://sonarcloud.io/component_measures?metric=sqale_rating&id=iuryamaral1_oli-saude-backend-challenge)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=iuryamaral1_oli-saude-backend-challenge&metric=duplicated_lines_density)](https://sonarcloud.io/component_measures?metric=duplicated_lines_density&id=iuryamaral1_oli-saude-backend-challenge)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=iuryamaral1_oli-saude-backend-challenge&metric=ncloc)](https://sonarcloud.io/component_measures?metric=ncloc&id=iuryamaral1_oli-saude-backend-challenge)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=iuryamaral1_oli-saude-backend-challenge&metric=sqale_index)](https://sonarcloud.io/component_measures?metric=sqale_index&id=iuryamaral1_oli-saude-backend-challenge)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=iuryamaral1_oli-saude-backend-challenge&metric=vulnerabilities)](https://sonarcloud.io/component_measures?metric=vulnerabilities&id=iuryamaral1_oli-saude-backend-challenge)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=iuryamaral1_oli-saude-backend-challenge&metric=bugs)](https://sonarcloud.io/component_measures?metric=bugs&id=iuryamaral1_oli-saude-backend-challenge)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=iuryamaral1_oli-saude-backend-challenge&metric=code_smells)](https://sonarcloud.io/component_measures?metric=code_smells&id=iuryamaral1_oli-saude-backend-challenge)

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## 📖 <ins>Table of Contents</ins>

- [📌 Description](#-description)
- [🔥 Business Requisites](#-business-requisites)
- [🏢 Architecture](#-architecture)
- [💎 Package Structure](#-package-structure)
- [💻 Technologies](#-technologies)
- [🚀 How to run](#-how-to-run)
- [📝 Documentation](#-documentation)
- [📈 SonarCloud](#-sonarcloud)
- [👲 CI/CD](#-cicd)
- [📝 Further documentation](#-further-documentation)
- [👨 Author](#-author)
- [📱 Contact](#-contact)

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)
### 📌 <ins>Description</ins>
The aim of this repository is to implement Oli Saúde Backend Challenge using the best practices for study purposes.

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

### 🔥 <ins>Business Requisites</ins>
To better understand the business requisites of this challenge, please visit [this link](https://github.com/olisaude/teste-dev-backend).

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

### 🏢 <ins>Architecture</ins>

The application is built using the Clean Architecture, which is an architecture that aims to separate the business logic from the outside world, making the application more testable and maintainable.
For more information about the Clean Architecture, you can read [this article](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) by Uncle Bob.

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

### 💎 <ins>Package Structure</ins>

```text
./src/main/kotlin/com/oli/saude/challenge
├── application.usecases
│   └── clients
│   └── health_problems
├── domain
│   └── exception
│   └── models
│   └── repository
├── gateways
│   └── persistence
│   └── web
```

- `application.usecases` contains the use cases of the application, which are the business logic of the application.
- `domain` contains the domain models, the domain exceptions and the domain repository interfaces.
- `gateways` contains the interfaces that are used to communicate with the outside world, like the database and the web.

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

### 💻 <ins>Technologies</ins>

<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin Badge"/> <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot Badge"/> <img src="https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring-data-jpa&logoColor=white" alt="Spring Data JPA Badge"/> <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker Badge"/> <img src="https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL Badge"/> <img src="https://img.shields.io/badge/Docker_Compose-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker Compose Badge"/> <img src="https://img.shields.io/badge/Testcontainers-000000?style=for-the-badge&logo=testcontainers&logoColor=white" alt="Testcontainers Badge"/> <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=white" alt="Swagger Badge"/> <img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white" alt="Gradle Badge"/> <img src="https://img.shields.io/badge/SonarCloud-4E9BCD?style=for-the-badge&logo=sonarcloud&logoColor=white" alt="SonarCloud Badge"/> <img src="https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white" alt="GitHub Actions Badge"/>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

### 🚀 <ins>How to run</ins>

```./gradlew bootRun``` - Runs the application

```./gradlew test``` - Runs the tests

```./gradlew build``` - Builds the application

```docker-compose up``` - Runs the application with Docker Compose

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

### 🐳 <ins>How to run with Docker Compose</ins>

```shell
$ docker-compose up -d
```
![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

### 📝 <ins>Documentation</ins>

When application is started, then you may go to: http://localhost:8080/swagger-ui/index.html/

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

### 📈 <ins>SonarCloud</ins>

This project is integrated with SonarCloud. You can check the status of the project [here](https://sonarcloud.io/project/overview?id=iuryamaral1_oli-saude-backend-challenge).

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

### 👲 <ins>CI/CD</ins>

This project is integrated with GitHub Actions. You can check the status of the project [here](https://github.com/iuryamaral1/oli-saude-backend-challenge/actions/workflows/main.yml).

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

### 📝 Further documentation

- [Uncle Bob](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Docker](https://www.docker.com/)
- [PostgreSQL](https://www.postgresql.org/)
- [Testcontainers](https://www.testcontainers.org/)
- [Swagger](https://swagger.io/)
- [Gradle](https://gradle.org/)
- [SonarCloud](https://sonarcloud.io/)

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

### 📱<ins>Contact</ins>

<a href="https://www.linkedin.com/in/iury-amaral-8a6294130/">
    <img src="https://img.shields.io/badge/LinkedIn-blue?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn Badge"/>
</a>
<a href="mailto:iurydrayton@gmail.com">
    <img src="https://img.shields.io/badge/iurydrayton@gmail.com-Gmail-red?style=for-the-badge&logo=gmail&logoColor=white" alt="Gmail Badge"/>
</a>
