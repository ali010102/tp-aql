package tp2.exo2;

public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

class TestService {
    public void call() throws ServiceException {
        throw new ServiceException("Erreur simulée !");
    }

    public static void main(String[] args) {
        TestService ts = new TestService();
        try {
            ts.call();
        } catch (ServiceException e) {
            System.out.println("Exception capturée : " + e.getMessage());
        }
    }
}

