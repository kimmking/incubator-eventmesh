/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.eventmesh.common.protocol.http.body.message;

import org.apache.eventmesh.common.Constants;
import org.apache.eventmesh.common.protocol.http.body.Body;
import org.apache.eventmesh.common.protocol.http.common.ProtocolKey;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.HashMap;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

public class SendMessageResponseBody extends Body {

    private Integer retCode;

    private String retMsg;

    private long resTime = System.currentTimeMillis();

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public long getResTime() {
        return resTime;
    }

    public void setResTime(long resTime) {
        this.resTime = resTime;
    }

    public static SendMessageResponseBody buildBody(Integer retCode, String retMsg) {
        SendMessageResponseBody sendMessageResponseBody = new SendMessageResponseBody();
        sendMessageResponseBody.setRetMsg(retMsg);
        sendMessageResponseBody.setResTime(System.currentTimeMillis());
        sendMessageResponseBody.setRetCode(retCode);
        return sendMessageResponseBody;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sendMessageResponseBody={")
            .append("retCode=").append(retCode).append(",")
            .append("retMsg=").append(retMsg).append(",")
            .append("resTime=").append(DateFormatUtils.format(resTime, Constants.DATE_FORMAT)).append("}");
        return sb.toString();
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(ProtocolKey.RETCODE, retCode);
        map.put(ProtocolKey.RETMSG, retMsg);
        map.put(ProtocolKey.RESTIME, resTime);
        return map;
    }

    @Data
    @Builder
    public static class ReplyMessage {
        public String              topic;
        public String              body;
        public Map<String, String> properties;
    }
}
