/*
 *  Generated Main Class. Most user won't have to modify it.
 */
package FirstSimgrid;
import org.simgrid.msg.Msg;
import org.simgrid.msg.NativeException;
 
public class FirstSimgridMain  {
    
    public static void main(String[] args) throws NativeException {    
        /* check usage error and initialize with defaults */
        if (args.length == 0){
            args = new String[2];
            System.out.print("** WARNING **\nusing default values:\n"+
                "FirstSimgrid_platform.xml FirstSimgrid_deployment.xml\n\n");
            args[0] = "FirstSimgrid_platform.xml";
            args[1] = "FirstSimgrid_deployment.xml";
        }else if(args.length != 2) {
            System.out.print("** ERROR **\n"+
                "Usage:\nplatform_file deployment_file\n");
            System.out.print("Example:\nFirstSimgrid_platform.xml FirstSimgrid_deployment.xml\n");
            System.exit(1);
        }	
	    /* initialize the MSG simulation. Must be done before anything else (even logging). */
        Msg.init(args);
        Msg.info("Simulation start...");
	    /* construct the platform and deploy the application */
        Msg.createEnvironment(args[0]);
        Msg.deployApplication(args[1]);
	    
	    /*  execute the simulation. */
        Msg.run();
        Msg.info("Simulation time:"+Msg.getClock());
    }
}
