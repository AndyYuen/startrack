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


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;



@javax.jws.WebService(serviceName = "startrackWS", portName = "startrackWSPort",
                    targetNamespace = "http://service.ws.startrack/", 
                    endpointInterface = "com.redhat.startrack.StartrackWS")
public class StartrackWSImpl implements StartrackWS {

    private static final Logger LOG = Logger.getLogger(StartrackWSImpl.class.getName());


	@Override
	public StProductInfo[] getStProductInfo(StProductQuery query)  {
		LOG.info("query content:\n" + query);
		StProductInfo [] productInfo = new StProductInfo[query.getProductIds().length * 2];
		for (int i = 0; i < query.getProductIds().length; i++)
			try {
				{
					StProductInfo info1 = new StProductInfo();
					
					info1 = new StProductInfo();
					info1.setProductId(query.getProductIds()[i]);
					info1.setArrivalDate(new SimpleDateFormat( "yyyy-MM-dd" ).parse(query.getArrivalDate()));
					info1.setDayId("2");
					info1.setDayOfWeek("Tuesday");
					info1.setDescription("AM");
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(info1.getArrivalDate());
					cal.add(Calendar.DATE, -3);
					info1.setDispatchDate(cal.getTime());
					info1.setEndTime("11:00");
					info1.setStartTime("12:00");
					info1.setTsId("1");
					info1.setType("ATL");
					
					StProductInfo info = new StProductInfo();
					info.setArrivalDate(info1.getArrivalDate());
					info.setArrivalDayOfWeek(info1.getDayOfWeek());
					info.setDayId(info1.getDayId());
					info.setDayOfWeek(info1.getDayOfWeek());
					info.setDescription(info1.getDescription());
					info.setDispatchDate(info1.getDispatchDate());
					info.setEndTime(info1.getEndTime());
					info.setProductId(info1.getProductId());
					info.setStartTime(info1.getStartTime());
					info.setTsId(info1.getTsId());
					info.setType("IDOD");
					
					productInfo[i] = info1;
					productInfo[i + query.getProductIds().length] = info;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return productInfo;
	}

}
