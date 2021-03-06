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
 * @author kenshin
 */
package org.foxbpm.kernel.process.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.foxbpm.kernel.process.KernelBaseElement;
import org.foxbpm.kernel.process.KernelDIBounds;

public class KernelBaseElementImpl implements KernelBaseElement, KernelDIBounds {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String id;
	protected String name;
	protected KernelProcessDefinitionImpl processDefinition;
	protected Map<String, Object> properties;

	// 图形信息
	protected float x = -1;
	protected float y = -1;
	protected float width = -1;
	protected float height = -1;

	public KernelBaseElementImpl(String id, KernelProcessDefinitionImpl processDefinition) {
		this.id = id;
		this.processDefinition = processDefinition;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setProperty(String name, Object value) {
		if (properties == null) {
			properties = new HashMap<String, Object>();
		}
		properties.put(name, value);
	}

	public Object getProperty(String name) {
		if (properties == null) {
			return null;
		}
		return properties.get(name);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getProperties() {
		if (properties == null) {
			return Collections.EMPTY_MAP;
		}
		return properties;
	}

	// getters and setters
	// //////////////////////////////////////////////////////

	public String getId() {
		return id;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public KernelProcessDefinitionImpl getProcessDefinition() {
		return processDefinition;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
}
