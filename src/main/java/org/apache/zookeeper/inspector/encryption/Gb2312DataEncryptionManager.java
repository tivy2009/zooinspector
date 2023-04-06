package org.apache.zookeeper.inspector.encryption;
/**
 * @author Tivy.He
 * @version 1.0
 * @date 2023-04-06 10:47
 * @description
 **/
public class Gb2312DataEncryptionManager implements DataEncryptionManager{

    private final static String fileEncoding = "GB2312";

    @Override
    public byte[] encryptData(String data) throws Exception {
        if (data == null) {
            return new byte[0];
        }
        if(fileEncoding != null && !"".equals(fileEncoding)){
            return data.getBytes(fileEncoding);
        }
        return data.getBytes();
    }

    @Override
    public String decryptData(byte[] encrypted) throws Exception {
        if (encrypted == null) {
            return null;
        }
        if(fileEncoding != null && !"".equals(fileEncoding)){
            return new String(encrypted,fileEncoding);
        }
        return new String(encrypted);
    }
}
