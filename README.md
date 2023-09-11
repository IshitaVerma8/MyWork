# MyWork
ishita verma's projects

Folder 1) Microservice Chaos Engineering Implementation

    Overview:
        In my project, I focused on fortifying the reliability of the Tax and Catalog microservices by applying Chaos Engineering principles and implementing Circuit Breaker patterns. 
        To facilitate testing, I created dummy microservices and intentionally shut down the Tax service to observe how Circuit Breaker patterns, including retry mechanisms, ensured 
        uninterrupted data retrieval. My tech stack included STS, Spring Boot, Maven, Java, RestTemplate, and H2 Database.
    
    Objectives:

        Resilience Enhancement: My primary goal was to improve the Tax and Catalog microservices' resilience in the face of faults and disruptions.
        
        Chaos Engineering: I proactively identified and mitigated vulnerabilities using Chaos Engineering practices.
        
        Circuit Breaker Patterns: I implemented Circuit Breaker patterns to prevent cascading failures, ensuring system stability.
        
        Tech Stack:
        
        STS: I used it for streamlined development and debugging.
        Spring Boot: It provided the foundation for robust microservices.
        Maven: I relied on it to manage dependencies and maintain project structure.
        Java: It served as my primary programming language.
        H2 Database: I utilized it for efficient data storage and management.
        RestTemplate: This tool was used for making HTTP requests and interacting with external services.

        
    Key Achievements:
    
      Improved Resilience: I successfully mitigated vulnerabilities, enhancing microservice resilience.
      
      Reduced Downtime: Circuit Breaker patterns, including retry mechanisms, minimized downtime when I intentionally shut down the Tax service.
      
      Enhanced Monitoring: I integrated monitoring and alerting systems, improving issue detection and response.
      
    
    Testing Scenario:
    During testing, I shut down the Tax microservice to validate the effectiveness of Circuit Breaker patterns, ensuring uninterrupted data retrieval from the Catalog microservice.
    
    Conclusion:
    My project successfully employed Chaos Engineering and Circuit Breaker patterns, reinforcing the resilience of Tax and Catalog microservices. Leveraging STS, Spring Boot, Maven, Java, and HTML, 
    I achieved my goals and enhanced the reliability and fault tolerance of our microservices architecture.
    



