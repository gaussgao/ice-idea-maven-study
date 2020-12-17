
public class Server
{
    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());

        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
        {
            System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
            System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());

            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("SimplePrinterAdapter", "default -p 8089");

            com.zeroc.Ice.Object object = new PrinterI();
            System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());


            System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
            adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("SimplePrinter"));

            adapter.activate();
            System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());


            communicator.waitForShutdown();

        }

    }

}
