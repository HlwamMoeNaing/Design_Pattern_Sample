
interface Logger{
    void log(String message);
}

class ConsoleLogger implements  Logger{

    @Override
    public void log(String message) {
        System.out.println("ConsoleLog > " + message);
    }
}

class XMLLogger implements Logger{

    @Override
    public void log(String message) {
        System.out.println("XMLLog > " + message);
    }
}

//Here start Factory classes
abstract class LoggerFactory {
    abstract Logger getLogger();
}
class ConsoleFactory extends LoggerFactory{
    @Override
    Logger getLogger() {
        return new ConsoleLogger();
    }
}

class XMLFactory extends LoggerFactory{

    @Override
    Logger getLogger() {
        return new XMLLogger();
    }
}




public class FactoryDesign {
    public static void main(String[] args) {
        LoggerFactory factory  = new ConsoleFactory();
        factory.getLogger().log("Message 1");
        factory = new XMLFactory();
        factory.getLogger().log("Message 2");

    }
}
