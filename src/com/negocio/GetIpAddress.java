/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio;

import java.net.InetAddress;

/**
 *
 * @author Administrator
 */
public class GetIpAddress {
    
    public static void main(String [] args) {
        try {
            InetAddress thisIp =InetAddress.getLocalHost();
            System.out.println("IP:"+thisIp.getHostAddress());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
