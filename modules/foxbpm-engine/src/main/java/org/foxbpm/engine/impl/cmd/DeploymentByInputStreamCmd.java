/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author ych
 */
package org.foxbpm.engine.impl.cmd;

import java.io.InputStream;
import java.util.Map;

import org.foxbpm.engine.impl.interceptor.Command;
import org.foxbpm.engine.impl.interceptor.CommandContext;
import org.foxbpm.engine.impl.util.ExceptionUtil;
import org.foxbpm.engine.repository.DeploymentBuilder;

public class DeploymentByInputStreamCmd  implements Command<String> {
	protected Map<String, InputStream>  inputStreamMap;
	protected DeploymentBuilder deploymentBuilder;
	public DeploymentByInputStreamCmd(DeploymentBuilder deploymentBuilder,Map<String, InputStream> inputStreamMap) {
		this.inputStreamMap = inputStreamMap;
		this.deploymentBuilder = deploymentBuilder;
	}

	public String execute(CommandContext commandContext) {
		if(inputStreamMap == null || inputStreamMap.size() == 0){
			throw ExceptionUtil.getException("10601003");
		}
		for(String resourceName : inputStreamMap.keySet()){
			deploymentBuilder.addInputStream(resourceName, inputStreamMap.get(resourceName));
		}
		return deploymentBuilder.deploy().getId();
	}

}
