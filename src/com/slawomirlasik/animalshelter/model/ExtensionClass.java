package com.slawomirlasik.animalshelter.model;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class ExtensionClass {

    private static Map<Class, HashSet<Class>> extensionMap = new Hashtable<>();


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


}
