


import java.io.IOException;

public class Device implements AutoCloseable{
    String header = null;
    public Device(String name) throws IOException{
        header = name;
        if("D2".equals(name)) throw new IOException("Unknown");
        System.out.println(header + " Opened");        
    }

    public String read() throws IOException{
        return "";
    }
    
    public void close(){
        System.out.println("Closing device "+header);
        throw new RuntimeException("RTE while closing "+header);
    }
    
    public static void main(String[] args) throws Exception {
        try(Device d1 = new Device("D1");
            Device d2 = new Device("D2")){
            throw new Exception("test");
        }
    }

    /*
        Identify the correct statements regarding the following program?

        a. It will end up with an Exception containing message "test".
        b. It will end up with a RuntimeException containing message "RTE while closing D1"
        c. It will end up with an IOException containing message "Unknown".
        d. It will end up with a RuntimeException containing message "RTE while closing D1" and a suppressed IOException containing message "Unknown".
        e. It will end up with an IOException containing message "Unknown" and a suppressed RuntimeException containing message "RTE while closing D1".

        Answer:

        e.

        The following output obtained after running the program explains what happens: 
        D1 Opened 
        Closing device D1 
        Exception in thread "main" java.io.IOException: Unknown
             at trywithresources.Device.<init>(Device.java:9)
              at trywithresources.Device.main(Device.java:24)
               Suppressed: java.lang.RuntimeException: RTE while closing D1 
                   at trywithresources.Device.close(Device.java:19)
                    at trywithresources.Device.main(Device.java:26) 
        Java Result: 1  

        Device D1 is created successfully but an IOException is thrown while creating Device D2. 
        Thus, the control never enters the try block and throw new Exception("test") is never executed. 
        Since one resource was created, its close method will be called (which prints Closing device D1).
        Any exception that is thrown while closing a resource is added to the list of suppressed 
        exceptions of the exception thrown while opening a resource (or thrown from the try block.)

    */


    
}