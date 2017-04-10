/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.redhat.startrack;

import java.text.ParseException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(targetNamespace = "http://service.ws.startrack/")
@SOAPBinding(style = Style.RPC, use=Use.LITERAL)
public interface StartrackWS {

    @WebResult(name = "returnedStProductInfo", targetNamespace = "http://service.ws.startrack/")
    @RequestWrapper(localName = "getStProductInfoRequest",
                    targetNamespace = "http://service.ws.startrack/", 
                    className = "com.redhat.startrack.StProductQuery")
    @WebMethod(operationName="getStProductInfo")
    @ResponseWrapper(localName = "getStProductInfoResponse",
                     targetNamespace = "http://service.ws.startrack/", 
                     className = "com.redhat.startrack.StProductInfo")

    public StProductInfo[] getStProductInfo(
    		@WebParam(name = "getStProductInfo", targetNamespace = "http://service.ws.startrack/") 
    		StProductQuery query);
}
