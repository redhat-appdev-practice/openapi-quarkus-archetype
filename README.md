# OpenAPI And Quarkus Bootstrap Archetype (Work In Progress)

Following a [Contract-First API Development Approach](https://bit.ly/contract-first-api)
can be daunting depending on the tools, languages, and frameworks you might like to use.
This [Maven Archetype](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html)
is a quick-start for building a new OpenAPI driven application in [Quarkus](https://quarkus.io/).

## Using This Archetype

```bash
git clone https://github.com/redhat-appdev-practice/openapi-quarkus-archetype.git
cd openapi-quarkus-archetype
mvn install
cd <workspace>
mvn archetype:generate -DarchetypeGroupId=com.redhat.runtimes \
                       -DarchetypeArtifactId=openapi-quarkus-archetype \
                       -DarchetypeVersion=1.0.0-SNAPSHOT \
                       -Dpackage=com.redhat.runtimes \
                       -DgroupId=com.redhat.runtimes.quarkus \
                       -DartifactId=quarkus-petstore \
                       -Dversion=0.0.1-SNAPSHOT \
                       -Dopenapi_app_contract_uri=https://petstore.swagger.io/v2/swagger.yaml \
                       -Dinteractive=false
```

## Options

* `package`
  * The Java package name to be used as the basis for code
* `groupId`
  * The Maven groupId for the generated project
* `artifactId`
  * The Maven artifactId for the generated project
* `version`
  * The Maven version for the generated project
* `openapi_app_contract_uri`
  * The Path or URL to an OpenAPI specification file in either YAML or JSON format
  * Examples:
    * https://petstore.swagger.io/v2/swagger.yaml
    * https://petstore.swagger.io/v2/swagger.json

## Current Status

- Integrates OpenAPI Generator via Maven Plugin
- Generates JPA Entity classes from the OpenAPI contract
- Generates API Interfaces with JAX-RS/RestEasy annotations

## Forthcoming Features

- Allow you to choose between Hibernate and Hibernate Reactive
- Allow you to choose between Panache ActiveRecord and Panache Repository
- Allow you to choose between RestEasy and RestEasy Reactive
- Add your idea to the GitHub issues!!!

## FAQ

- Whay are there no OpenAPI/Swagger annotations in the generated code?
  - I'm still working on getting a proper Quarkus generator in the upstream OpenAPI Generator, so in the meantime I have had to make compromises