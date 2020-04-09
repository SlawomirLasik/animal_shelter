package com.slawomirlasik.animalshelter.model;

import java.io.*;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class ExtensionClass implements Serializable {

    private static Map<Class, HashSet<Class>> extensionMap = new Hashtable<>();
    private static final String DEFAULT_FILE_PATH = "data.adf";


    public ExtensionClass() {
        Class extensionClassKey = this.getClass();
        HashSet extention = null;

        if(extensionMap.containsKey(extensionClassKey)){
            // we have extension with this key and we retrieve it
            extention = extensionMap.get(extensionClassKey);
        }else{
            // we do not have this extension key and we have to create it
            extention = new HashSet<>();
            extensionMap.put(extensionClassKey, extention);
        }
        // we add current class to the extension
        extention.add(this);
    }

    // add method of getting extension (animal extension)
    public static HashSet getExtension(Class extentionClassKey){
        return extensionMap.get(extentionClassKey);
    }

    public static void saveExtensionsToFile() throws IOException {
        saveExtensionsToFile(DEFAULT_FILE_PATH);
    }

    public static void saveExtensionsToFile(String filePath) throws IOException {
        // add some basic security for not getting null pointer exception
        if(filePath==null) filePath = DEFAULT_FILE_PATH;
        //Create Stream for writing to a file
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        // write object to a file and close a stream
        objectOutputStream.writeObject(extensionMap);
        objectOutputStream.close();
    }

    public static void loadExtensionsFromFile(String filePath) throws IOException, ClassNotFoundException {
        // ad some basic security for not getting null pointer exception
        if(filePath==null)filePath = DEFAULT_FILE_PATH;

        //create Stream for reading from a file
        FileInputStream fi = new FileInputStream(new File(filePath));
        ObjectInputStream oi = new ObjectInputStream(fi);
        extensionMap = (Map<Class, HashSet<Class>>) oi.readObject();
    }

}
