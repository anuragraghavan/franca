/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.franca.core.ui.addons.contractviewer.util;

public class IntermediateFrancaGraphConnection {

	public String source;
	public String target;
	public String label;
	
	public IntermediateFrancaGraphConnection(String source, String target,
			String label) {
		super();
		this.source = source;
		this.target = target;
		this.label = label;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		else if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		else {
			IntermediateFrancaGraphConnection otherConn = (IntermediateFrancaGraphConnection) obj;
			return this.source.equals(otherConn.source) && 
				   this.target.equals(otherConn.target) && 
				   this.label.equals(otherConn.label);
		}
	}
	
	@Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 17 + this.source.hashCode();
        hash = hash * 31 + this.target.hashCode();
        hash = hash * 13 + this.label.hashCode();
        return hash;
    }
	
	@Override
	public String toString() {
		return source + "->" + target;
	}
}
