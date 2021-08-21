# OpenAPI And Quarkus Bootstrap Archetype (Work In Progress)

Following a [Contract-First API Development Approach](https://bit.ly/contract-first-api)
can be daunting depending on the tools, languages, and frameworks you might like to use.
This [Maven Archetype](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html)
is a quick-start for building a new OpenAPI driven application in [Quarkus](https://quarkus.io/).

## Using This Archetype

```bash
mvn archetype:generate -DarchetypeGroupId=com.redhat.consulting \
                       -DarchetypeArtifactId=openapi-quarkus-archetype \
                       -DarchetypeVersion=1.0.5 \
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
  - See the custom template instructions [HERE](https://github.com/redhat-appdev-practice/openapi-generator-quarkus-templates)
- Allow you to choose between Hibernate and Hibernate Reactive
- Generates API Interfaces with JAX-RS annotations

## Forthcoming Features

- Allow you to choose between Panache ActiveRecord and Panache Repository
- Allow you to choose between RestEasy and RestEasy Reactive
- Add your idea to the GitHub issues!!!

## FAQ

- Why are there no OpenAPI/Swagger annotations in the generated code?
  - The current JAXRS-Spec+Quarkus generator uses `quarkus-smallrye-openapi` and thus it does not need Swagger/OpenAPI Annotations. It will reconcile the OpenAPI Spec file with the code to provide a unified view.
