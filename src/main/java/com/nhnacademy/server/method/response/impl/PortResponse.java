/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.server.method.response.impl;

import com.nhnacademy.server.method.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class PortResponse implements Response {
    private final static String METHOD = "port";

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public String execute(String value) {
        /* TODO#1 OS로부터 오픈되어 있는 Port를 조회후 반환 합니다.
         - value(port) 에 값이 존재 하지 않는다면 열려있는 모든 port를 반환 합니다.
         - value(port) 값이 존재 한다면 해당 port에 해당되는 값을 반환 합니다.
         - 다음과 같은 형식으로 반환 됩니다.
        TCP *:49742
        TCP *:49742
        TCP *:7000
        TCP *:7000
        TCP *:5000
        TCP *:5000
        TCP *:7797
        TCP *:7797
        TCP *:55920
        TCP 127.0.0.1:16105
        TCP 127.0.0.1:16115
        TCP 127.0.0.1:16107
        TCP 127.0.0.1:16117
        TCP *:19875
        TCP 127.0.0.1:19876
        TCP 127.0.0.1:63342
        TCP 127.0.0.1:52304
        TCP *:8888
        TCP 127.0.0.1:64120
        TCP 127.0.0.1:3376
        TCP 127.0.0.1:62451
        TCP 127.0.0.1:64913
        */

        StringBuilder sb = new StringBuilder();

        Process process = null;
        try {
            process = Runtime.getRuntime().exec("lsof -n -i");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String str = null;
        try {
            bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null){
                String[] strs = str.split(" +");
                String protocal = strs[7];
                String ip = strs[8];

                if(value.isBlank()){
                    //ip ㅇㅣㄴ자 없음
                    // 모두 출력
                    sb.append(protocal + " " + ip + "\n");
                }
                else{
                    //Ip 인자 있음
                    if(ip.charAt(0) == '*' || ip.contains(value)){
                        sb.append(protocal + " " + ip + "\n");
                    }
                }

            }

        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
