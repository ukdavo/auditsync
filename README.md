# auditsync

Another abandoned project but quite a useful investigation into the following:

- Spring Boot
- UI
  - Thymeleaf
  - Forms authentication
  - Webjars
- REST
  - Basic Authentication
  - Long running thread
    - Stop, start
    - Thread-safe configuration

It was originally intended to provide a platform to sync data between the Alfresco audit & Elasticsearch but it soon became apparently that a single long running thread wasn't a good fit for this once you thought about how this would work within a clustered environment.

Consequently, it's back to the drawing board. The next approach will be based on Spring Boot, Camel and Hazlecast.