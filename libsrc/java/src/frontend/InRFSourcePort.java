/*
 * This file is protected by Copyright. Please refer to the COPYRIGHT file
 * distributed with this source distribution.
 *
 * This file is part of REDHAWK frontendInterfaces.
 *
 * REDHAWK frontendInterfaces is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * REDHAWK frontendInterfaces is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package frontend;

import FRONTEND.RFInfoPkt;
import FRONTEND.RFSourceHelper;
import frontend.RFSourceDelegate;
import org.ossie.component.PortBase;

public class InRFSourcePort extends FRONTEND.RFSourcePOA implements PortBase {

    protected String name;
 
    protected Object portAccess = null;

    protected RFSourceDelegate delegate = null;    

    public InRFSourcePort( String portName) {
        this(portName, null);
    }

    public InRFSourcePort( String portName,
                         RFSourceDelegate d) {
        this.name = portName;
        this.delegate = d;
        this.portAccess = new Object();
    }

    public RFInfoPkt[] available_rf_inputs() {
        synchronized(this.portAccess){
            try{
                if ( delegate != null ){ 
                    return delegate.get_available_rf_inputs(this.name);
                }
            }catch(Exception e){
                System.out.println("InRFSourcePort available_rf_inputs() exception " + e.getMessage());
            }
            return null;
        }
    }

    public void available_rf_inputs(RFInfoPkt[] data) {
        synchronized(this.portAccess){
            try{
                if ( delegate != null){ 
                    delegate.set_available_rf_inputs(this.name, data);
                }
            }catch(Exception e){
                System.out.println("InRFSourcePort available_rf_inputs(RFInfoPkt[] data) exception " + e.getMessage());
            }
        }
    }

    public RFInfoPkt current_rf_input() {
        synchronized(this.portAccess){
            try{
                if ( delegate != null){
                    return (delegate.get_current_rf_input(this.name));
                }
            }catch(Exception e){
                System.out.println("InRFSourcePort current_rf_input() exception " + e.getMessage());
            }
            return null;
        }
    }

    public void current_rf_input(RFInfoPkt data) {
        synchronized(this.portAccess){
            try{
                if ( delegate != null) {
                    delegate.set_current_rf_input(this.name, data);
                }
            }catch(Exception e){
                System.out.println("InRFSourcePort current_rf_input(RFInfoPkt data) exception " + e.getMessage());
            }
        }
    }

    public void setDelegate( RFSourceDelegate d ) {
        delegate = d;
    }

    public String getRepid() {
        return RFSourceHelper.id();
    }

    public String getDirection() {
        return "Provides";
    }
}
