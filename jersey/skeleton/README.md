Created a simple spring boot project with jersey dependency
Further create a @Component to define the Jersey Configuration(Class registration)
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
    	register(UserController.class);
    }
}


After this we can use the jersey syntax