package frontend;

import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.Map;
import org.ossie.component.QueryableUsesPort;
import FRONTEND.AnalogTunerOperations;
import FRONTEND.AnalogTunerHelper;
import FRONTEND.FrontendException;
import FRONTEND.BadParameterException;
import FRONTEND.NotSupportedException;

public class OutAnalogTunerPort extends QueryableUsesPort<AnalogTunerOperations> implements AnalogTunerOperations {

    /**
     * Map of connection Ids to port objects
     */
    protected Map<String, AnalogTunerOperations> outConnections = new HashMap<String, AnalogTunerOperations>();

    public OutAnalogTunerPort(String portName) 
    {
        super(portName);
        this.outConnections = new HashMap<String, AnalogTunerOperations>();
    }

    protected AnalogTunerOperations narrow(org.omg.CORBA.Object connection) 
    {
        AnalogTunerOperations ops = AnalogTunerHelper.narrow(connection);
        return ops; 
    }

    public void connectPort(final org.omg.CORBA.Object connection, final String connectionId) throws CF.PortPackage.InvalidPort, CF.PortPackage.OccupiedPort {
        try {
            synchronized (this.updatingPortsLock) {
                super.connectPort(connection, connectionId);
                final AnalogTunerOperations port = AnalogTunerHelper.narrow(connection);
                this.outConnections.put(connectionId, port);
                this.active = true;
            }
        } catch (final Throwable t) {
            t.printStackTrace();
        }

    }

    public void disconnectPort(final String connectionId) throws CF.PortPackage.InvalidPort {
        synchronized (this.updatingPortsLock) {
            super.disconnectPort(connectionId);
            this.outConnections.remove(connectionId);
            this.active = (this.outConnections.size() != 0);
        }
    }

    public String getTunerType(String id) throws FrontendException, BadParameterException, NotSupportedException {
        String retval = "";

        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    retval = p.getTunerType(id);
                }
            }
        }
        
        return retval;
    }
 
    public boolean getTunerDeviceControl(String id) throws FrontendException, BadParameterException, NotSupportedException {
        boolean retval = false;

        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    retval = p.getTunerDeviceControl(id);
                }
            }
        }
        
        return retval;
    }
 
    public String getTunerGroupId(String id) throws FrontendException, BadParameterException, NotSupportedException {
        String retval = "";

        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    retval = p.getTunerGroupId(id);
                }
            }
        }
        return retval;
    }
 
    public String getTunerRfFlowId(String id) throws FrontendException, BadParameterException, NotSupportedException {
        String retval = "";

        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    retval = p.getTunerRfFlowId(id);
                }
            }
        }
        return retval;
    }
 
    public CF.DataType[] getTunerStatus(String id) throws FrontendException, BadParameterException, NotSupportedException {
        CF.DataType[] retval = null;

        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    retval = p.getTunerStatus(id);
                }
            }
        }
        return retval;
    }
 
    public void setTunerCenterFrequency(String id, double freq) throws FrontendException, BadParameterException, NotSupportedException {
        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    p.setTunerCenterFrequency(id, freq);
                }
            }
        }
    }
 
    public double getTunerCenterFrequency(String id) throws FrontendException, BadParameterException, NotSupportedException {
        double retval = 0.0;

        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    retval = p.getTunerCenterFrequency(id);
                }
            }
        }
        return retval;
    }
 
    public void setTunerBandwidth(String id, double bw) throws FrontendException, BadParameterException, NotSupportedException {
        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    p.setTunerBandwidth(id, bw);
                }
            }
        }
    }
 
    public double getTunerBandwidth(String id) throws FrontendException, BadParameterException, NotSupportedException {
        double retval = 0.0;

        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    retval = p.getTunerBandwidth(id);
                }
            }
        }
        return retval;
    }
 
    public void setTunerAgcEnable(String id, boolean enable) throws FrontendException, BadParameterException, NotSupportedException {
        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    p.setTunerAgcEnable(id, enable);
                }
            }
        }
    }
 
    public boolean getTunerAgcEnable(String id) throws FrontendException, BadParameterException, NotSupportedException {
        boolean retval = false;

        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    retval = p.getTunerAgcEnable(id);
                }
            }
        }
        return retval;
    }
 
    public void setTunerGain(String id, float gain) throws FrontendException, BadParameterException, NotSupportedException {
        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    p.setTunerGain(id, gain);
                }
            }
        }
    }
 
    public float getTunerGain(String id) throws FrontendException, BadParameterException, NotSupportedException {
        float retval = 0.0F;

        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    retval = p.getTunerGain(id);
                }
            }
        }
        return retval;
    }
 
    public void setTunerReferenceSource(String id, int source) throws FrontendException, BadParameterException, NotSupportedException {
        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    p.setTunerReferenceSource(id, source);
                }
            }
        }
    }
 
    public int getTunerReferenceSource(String id) throws FrontendException, BadParameterException, NotSupportedException {
        int retval = 0;

        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    retval = p.getTunerReferenceSource(id);
                }
            }
        }
        return retval;
    }
 
    public void setTunerEnable(String id, boolean enable) throws FrontendException, BadParameterException, NotSupportedException {
        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    p.setTunerEnable(id, enable);
                }
            }
        }
    }
 
    public boolean getTunerEnable(String id) throws FrontendException, BadParameterException, NotSupportedException {
        boolean retval = false;

        synchronized(this.updatingPortsLock) {
            if (this.active) {
                for (AnalogTunerOperations p : this.outConnections.values()) {
                    retval = p.getTunerEnable(id);
                }
            }
        }
        return retval;
    }
 }
