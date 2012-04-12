package org.franca.examples.basic.generators

import org.franca.deploymodel.core.FDeployedProvider
import org.franca.examples.deployspecs.SampleDeploySpecProviderPropertyAccessor
import org.franca.examples.deployspecs.IPBasedIPCProviderPropertyAccessor$AccessControl
import org.franca.deploymodel.dsl.fDeploy.FDProvider

/**
 * This is an example code generator for the non-interface related part of 
 * Franca deployment models. It will generate a mimic configuration file
 * from the definitions of providers and interface instances in an *.fdepl file.
 * This class shows how to access the deployment information from the input model. 
 */
class ExampleRuntimeConfigGenerator {

	/**
	 * An instance of the ProviderPropertyAccessor for SampleDeploySpec-models
	 * (it has been generated automatically from SampleDeploySpec.fdepl).
	 */
	SampleDeploySpecProviderPropertyAccessor deploy

	/**
	 * This function is called from outside and generates code from a 
	 * Franca provider definition, which contains deployment information.
	 * The FDeployedProvider instance is a wrapper which is used to 
	 * instantiate a SampleDeploySpecProviderPropertyAccessor.
	 * This ProviderPropertyAccessor will be used to read the deployment
	 * information stored for this provider.
	 */
	def generateRuntimeConfig (FDeployedProvider deployed) {
		deploy = new SampleDeploySpecProviderPropertyAccessor(deployed)
		generateProvider(deployed.provider)	
	}


	/**
	 * This function generates the configuration file from a FDProvider
	 * definition. The PropertyAccessor ("deploy") is used for extracting
	 * the deployment information in a type-safe way easily. 
	 */
	def generateProvider (FDProvider it) '''
		RUNTIME CONFIGURATION FOR PROVIDER: �name�
		
		Process name: �deploy.getProcessName(it)�
		
		Provided interfaces:
		�FOR inst : instances�
		- instance of �inst.target.name�
		  - address: �deploy.getIPAddress(inst)�:�deploy.getPort(inst)�
		  - access:  �deploy.getAccessControl(inst).generate�
		�ENDFOR�
		
		--- generated by ExampleRuntimeConfigGenerator.
	'''
		
	
	// ***********************************************************************************
	// helper functions

	def generate (AccessControl ac) {
		switch (ac) {
			case AccessControl::local:  "local clients only"
			case AccessControl::subnet: "clients in same subnet only"
			case AccessControl::global: "all clients"
			default: "unknown"
		}
	}

}