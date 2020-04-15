package com.slawomirlasik.animalshelter.model;

import java.io.*;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class ExtensionClass implements Serializable {

    private static Map<Class, HashSet<Class>> extensionMap;
    private static final String DEFAULT_FILE_PATH = "data.adf";


    public ExtensionClass() {
        // load extension map from a file
        try {
            if (loadExtensionsFromFile()) {
                System.out.println("Loaded previous Shelter status successfully");
            } else {
                System.out.println("Loading previous Shelter status failed. Creating empty lists of animals...");
                Class extensionClassKey = this.getClass();
                HashSet extention = null;

                extensionMap = new Hashtable<>();
                if (extensionMap.containsKey(extensionClassKey)) {
                    // we have extension with this key and we retrieve it
                    extention = extensionMap.get(extensionClassKey);
                } else {
                    // we do not have this extension key and we have to create it
                    extention = new HashSet<>();
                    extensionMap.put(extensionClassKey, extention);
                }
                // we add current class to the extension
                extention.add(this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    // add method of getting extension (animal extension)
    public static HashSet getExtension(Class extentionClassKey) {
        return extensionMap.get(extentionClassKey);
    }

    public static void saveExtensionsToFile() throws IOException {
        saveExtensionsToFile(DEFAULT_FILE_PATH);
    }

    public static void saveExtensionsToFile(String filePath) throws IOException {
        // add some basic security for not getting null pointer exception
        if (filePath == null) filePath = DEFAULT_FILE_PATH;
        //Create Stream for writing to a file
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        // write object to a file and close a stream
        objectOutputStream.writeObject(extensionMap);
        objectOutputStream.close();
    }

    public static Boolean loadExtensionsFromFile() throws IOException, ClassNotFoundException {
        return loadExtensionsFromFile(DEFAULT_FILE_PATH);
    }

    public static Boolean loadExtensionsFromFile(String filePath) throws IOException, ClassNotFoundException {
        // ad some basic security for not getting null pointer exception
        if (filePath == null) filePath = DEFAULT_FILE_PATH;

        //create Stream for reading from a file
        File dataFile = new File(filePath);
        if(!dataFile.exists()) return false;
        FileInputStream fi = new FileInputStream(dataFile);
        ObjectInputStream oi = new ObjectInputStream(fi);
        return
                ((extensionMap = (Map<Class, HashSet<Class>>) oi.readObject()) != null ? true : false);
    }

    public static  <T> void printExtension(Class<T> classExtensionKey){
        HashSet<T> extension = getExtension(classExtensionKey);

        for(T extensionObject : extension){
            System.out.println(extensionObject);
        }
    }

}
