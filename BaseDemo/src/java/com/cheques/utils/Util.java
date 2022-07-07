
package com.cheques.utils;


import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.model.SelectItem;


public class Util implements Serializable {

    private static final char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    
    public static String hash(String stringToHash) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(stringToHash.getBytes());
            StringBuilder sb = new StringBuilder(2 * bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                int low = (int) (bytes[i] & 0x0f);
                int high = (int) ((bytes[i] & 0xf0) >> 4);
                sb.append(HEXADECIMAL[high]);
                sb.append(HEXADECIMAL[low]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            //exception handling goes here
            return null;
        }
    }
    
    public static String cargarLinkConParametros(String link, String[] parametro) {
        ResourceBundle resource = ResourceBundle.getBundle("configuracion");
        MessageFormat format = new MessageFormat(resource.getString(link));
        return format.format(parametro);
    }
    public List<SelectItem> fillSelectItemFromList(List listaDB) {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        for (int i = 0; i < listaDB.size(); i++) {
            Object[] objetos = (Object[]) listaDB.get(i);
            lista.add(new SelectItem(objetos[0].toString(), objetos[1].toString()));
        }
        return lista;
    }
}
