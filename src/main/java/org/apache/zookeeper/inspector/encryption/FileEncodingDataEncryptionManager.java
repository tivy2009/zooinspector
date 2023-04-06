package org.apache.zookeeper.inspector.encryption;
/**
 * @author Tivy.He
 * @version 1.0
 * @date 2023-04-06 10:47
 * @description
 **/
public class FileEncodingDataEncryptionManager implements DataEncryptionManager{

    @Override
    public byte[] encryptData(String data) throws Exception {
        if (data == null) {
            return new byte[0];
        }
        String fileEncoding = System.getProperty("file.encoding");
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
        String fileEncoding = System.getProperty("file.encoding");
        if(fileEncoding != null && !"".equals(fileEncoding)){
            return new String(encrypted,fileEncoding);
        }
        return new String(encrypted);
    }
}
