/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.franca.core.ui.addons.contractviewer.util;

import org.franca.core.dsl.ui.FrancaIDLExecutableExtensionFactory;
import org.franca.core.ui.addons.Activator;
import org.osgi.framework.Bundle;

public class ContractViewerExecutableExtensionFactory extends FrancaIDLExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}
}