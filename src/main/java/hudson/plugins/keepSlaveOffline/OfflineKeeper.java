package hudson.plugins.keepSlaveOffline;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;
import hudson.model.Node;
import hudson.model.Queue.FlyweightTask;
import hudson.model.Queue.Task;
import hudson.model.queue.CauseOfBlockage;
import hudson.slaves.NodeProperty;
import hudson.slaves.NodePropertyDescriptor;

public class OfflineKeeper extends NodeProperty<Node>{
	
	@DataBoundConstructor
	public OfflineKeeper(){
	}
	
	@Extension // this marker indicates Hudson that this is an implementation of an extension point.
    public static final class NodePropertyDescriptorImpl extends NodePropertyDescriptor {

        public static final NodePropertyDescriptorImpl DESCRIPTOR = new NodePropertyDescriptorImpl();
        
        public NodePropertyDescriptorImpl(){
        	super(OfflineKeeper.class);
        }
		
		/**
         * This human readable name is used in the configuration screen.
         */
        public String getDisplayName() {
            return "Keep this slave offline after Hudson restart";
        }

	}
}
