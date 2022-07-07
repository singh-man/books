<!--Start Fragment-->
J2EE patterns
=====================

MVC
----

**Definition**: The Model/View/Controller(MVC) is an architecture design pattern. Model means data, View means representation and Controller works on data and representation. MVC focuses on decouple the triad relationships among data, representation and controller. 

**Where to use & benefits**

   - Application architecture design. 
   - Any data related design, including non-visual application. 
   - Decouple complex object to improve maintainability. 
   - Increase object reusability. 
   - Achieve design flexibility. 
   - Related patterns include 
      - Almost all patterns can be used with MVC. 

**History**

The Model/View/Controller(MVC) originates from Smalltalk, an OO programming language. 

**Core issue**

MVC consists of three kind of objects. The Model is an internal representation of the data, the View is the screen presentation of GUI, and the Controller coordinates changes between the Model and View. 

**SCJD project design**

To achieve the MVC architecture in your project, you have to decouple View and Model by Controller. Your GUI as View should be designed as a module. It can be launched separately. Your data related classes as Model should be treated as a module too. Your controller classes should response to any data change on the GUI. Such design will increase reusability and flexibility. 

Try to visualize that the user reacts with the GUI, a DataManager(Controller) listens to the GUI's call. If the user needs to load data, such request is sent to the DataManager, the DataManager starts loading, searching and extracting the requested data from the server and sends it back to the GUI. GUI is responsible to display data. 

Here the server acts as Model, the DataManager acts as Controller and GUI acts as View. The DataManager can be used for both remote and local modes (design two constructors for both modes), the GUI can be replaced with any design and the data related classes can be packaged together and put on local and server sides. All of the three objects can be reused for other projects with little code alteration. 

If you grasp such concept and skill, you will save a lot of time in designing and developing your projects in the future. This is the so-called OOA/OOD. 

  

##### Business Delegate

*Definition*

An intermediate class decouples between presentation-tier clients and business services. 

Where to use & benefits

   - Simplify the complicated relationship. 
   - Reduce coupling. 
   - Cache results and references to remote business services. 
   - Cut potentially costly round trips 
   - Hide the underlying implementation details of business service. 
   - Related patterns include 
      - Proxy combined to simplify the complexity.     

**Example**
Make a class deal with lookups and exception, acting as a representative of the client components 

 

##### Composite Entity

*Definition*

Use a coarse-grained interface to manage interactions between fine-grained or coarse-grained and dependent objects internally. The Composite Entity is a coarse-grained entity bean. It may be the coarse-grained object or hold a reference to the coarse-grained object. Also known as Aggregate Entity. 

Where to use & benefits

   - Combine coarse-grained object and its related dependent objects into a single entity bean. 
   - Multiple clients share persistent objects. 
   - Model a network of related business entities. 
   - In both local and distributed environment, use remote entity beans to model dependent business objects or fine-grained- objects. 
   - Improve performance by eliminating the parameter and return value serialization and data transmission costs. 
   - Eliminate inter-entity relationships 
   - Improve manageability by reducing entity beans. 
   - Improve network performance 
   - Reduce database schema dependency 
   - Increase object granularity 
   - Facilitate composite transfer object creation. 
   - Overhead of multi-level dependent object graphs. 
   - Related patterns include 
      - Transfer Object used to return to client and also used to serialize the coarse-grained and dependent objects tree, or part of the tree, as required. 
      - Session Facade used to manage the inter-entity-bean relationships. 

Example

  

##### Front Controller

*Definition*

Using a single component to process application requests. 

Where to use & benefits

   - JSP or Servlet. 
   - Design request handling component. 
   - Channel all requests through a single controller. 
   - Centralize request processing and view selection. 
   - Reduce business logic in a view 
   - Improve manageability of security 
   - Promote code reuse across requests 
   - Avoid code duplication 
   - Related patterns include 
      - Command combined with multiple requests. 
      - Intercepting Filter both centralize control of certain types of request processing. 
      - Page Controller -- an alternative way. 

Example

Design a servlet to deal with all the requests. 

 

##### Intercepting Filter

Definition

A pluggable component design to intercept incomming requests and outgoing responses, provide common services in a standard manner (independently) without changing core processing code. 

Where to use & benefits

   - Logging and authentication.
   - Enhance security.
   - Add additional function to existing web application.
   - Decorate main process.
   - Debug.
   - Pre-processing or post-processing for specific clients.
   - Uncompress incoming request.
   - Convert input encoding schema.
   - Being added or removed transparently or declaratively and triggered automatically
   - Improve reusability
   - Deployment-time composability
   - Each filter is loosely coupled
   - Inefficient for information sharing.
   - Related patterns include
      - Front Control better suited to handling core processing. 
      - Template good for template filter strategy
      - Decorator providing for dynamically pluggable wrappers.

Example

To create a basic filter, you need to: 

   - implement Filter interface
   - implement doFilter method
   - call doFilter from FilterChain object
   - register the filter with the appropriate servlets and JSP pages
   - Mapping the filter to specific pages
   - disable the invoker servlet

General skeleton program 
```java
import javax.servlet.*;
import javax.servlet.http.*;

public class MyFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse resonse, FilterChain chain)
            throws ServletException, IOException {
        // work on request and response
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        // work on config
    }

    public void destroy() {
        // work on clean up
    }
}
```
Register and filter mapping 

//in web.xml file
```xml
<web-app>

...

Before the servlet description

<filter>
    <filter-name>MyFilter</filter-name>
        <display-name>MyCoolFilter</display-name>
        <description>This is my cool filter</description>
    <filter-class>somePackage.MyFilter</filter-class>
    <init-param>
        <param-name>yyy</param-name>
        <param-value>/xxx/zzz</param-value>
    </init-param>
</filter>

<filter-mapping>
    <filter-name>MyFilter</filter-name>
    <url-pattern>/xxx.jsp</url-pattern>
</filter-mapping>
```


<!-- also apply to another servlet -->
```xml
<filter-mapping>
<filter-name>MyFilter</filter-name>
<servlet-name>xxx</servlet-name>
</filter-mapping>
...
</web-app>
```
You may use filter mapping and servlet mapping in web.xml file to diable the invoker servlet to apply the filter. 

  

##### Service Locator

Definition

Centralizing distributed service object lookups, providing a centralized point of control, acting as a cache that eliminates redundant lookups. 

Where to use & benefits

   - Lookup object in JNDI, RMI, JMS, etc. 
   - Encapsulate any vendor-specific features of lookup process 
   - Simplify the lookup process 
   - Improve the performance 
   - Related patterns include 
      - Singleton combined with service locator to make sure only one lookup object exists. 

Example

Use a container as cache to hold the lookup object. One application only lookups same object once. Doing so will dramatically improve performance. Make sure the container used is thread-safe. 

 

##### Transfer Object

Definition

Using a serializable class to act as data carrier, grouping related attributes, forming a composite value and working as a return type from remote business method. Also known as Value object. 

Where to use & benefits

   - Get related values from remote business method. 
   - Fetch multiple values in one trip. 
   - Decrease network traffic. 
   - Minimize latency and server resource usage. 
   - Related patterns include 
      - composite view 

Example

In the J2EE server, the client tier may make several calls to retrieve data from the enterprise bean. Even in the same machine, the every call from the client tier to the server tier is a remote method call. Think about use Transfer Object design pattern to retrieve related attributes and return a single object instead of each call just for retrieving a single attribute value. The transfer object is passed by value to the client. All calls to the transfer object instance are local calls to the client, so such design saves a lot of network traffic. 

Let's say that you have a remote banking system. If the user has five requests one time, you should design your system to give response once, not five times. You may need to group all return values from these five requests to an object carrier and then return to client just once. Once the client program receives the instance of this object, it invokes the accessors and gets value to display. The total network traffic for one user just once. 


##### Circuit Breaker Pattern

To be used for fault tolerant (not service down which means a slow service because it will hold the threads and threads timeout can not solve the issue completely).

AWS and other cloud providers use exponentianl back-off.

Its better to provide a healthcheck endpoint for microservice to aid in decision making.

In the case of fault tolrenat use multiple services.

#### Miscellaneous Pattern
  

**Representational State Transfer (REST)**

Definition

Representational State Transfer (REST) is a Web service design pattern. It is different from SOAP based web services. REST services do not require XML, SOAP or WSDL service-API definitions. The concept originally comes from a PhD's dissertation

Where to use & benefits

   - Can be used for any system design. 
   - Basic elements: Resources, URL and simple operations. 
   - Resources may be web site, an HTML page, an XML document, a web service, a physical device, etc. 
   - Any resource can be identified by URL. 
   - Simple operations via HTTP API (GET,POST,PUT,DELETE). 
   - Easy to understand each service does by examing the URL. 
   - No rules, no bottleneck, no central point of failure. 
   - Easy to implement. 

CRUD: 



GET = 'give me some info' (Retrieve)

POST = 'here's some update info' (Update)

PUT = 'here's some new info' (Create)

DELETE = 'delete some info' (Delete)



payload: form data

For details see http://www.xfront.com/files/rest.html 

Return to top


