1. Configure the project using maven with archetype as web.

2.Initially the errors will be there, Go to properties->Targetted runtime and select the server.
  The errors will go away

3.Now we need to configure our normal project into spring mvc project

4.For different tasks we will have different controllers. So when we send a request, who will be
  responsible. The answer is a front controller(Dispatcher Servelet). Depending on the request 
  it will redirect you to the particular controller.We need to define that in web.xml using the
  servlet and servlet mapping tag.
  
  <servlet>
  	<servlet-name>telusko</servlet-name>
  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>telusko</servlet-name>
  	<url-pattern>/</url-pattern>
  </servlet-mapping>
  

5.Now in order to use the Dispatcher Servlet, we need to add some libraries(Spring libraries)

6.In order to teach Dispatcher servelet that which file to call we need to create one more file 
  in WEB-INF i.e <servlet-name>-servlet.xml (anshul-servlet.xml) and create beans.
  
7.Now we need to add @Controller annotations on each controller. Controller should be added under
  the package within src/main/java only.We can call the view and pass data through the model.
  See AddController.view->display.jsp, model->index.jsp data, controller->AddController.
  
8.To display the data in the view, we can use request.getAttribute or we can set isELIgnored="false"
  in the page tag.Now we can use ${result} directly.See display.jsp
  This is Expression Language.
  
9.All the logics should be done under the service layer, not in the controller.

10.We can define the service layer by @Service which converts that to a bean.Now we can simply
   Autowire the service layer object instead of using new keyword.
   
   
   
Instead of xml file and servlet tag in web.xml, we can use annotation based configuration:

1. Create a @Configuration class and add @ScanComponent annotation.

2. Create a new class which extends AbstractAnnotationConfigDispatcherServeletInitialiser and 
   override its methods.(servlet mapping, config file specifications)
   
3. We can directly create the beans in configuration file now.