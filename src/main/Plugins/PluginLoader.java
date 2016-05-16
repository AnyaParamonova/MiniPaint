package main.Plugins;

import plugin_api.Plugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader {

    public static  ArrayList<Plugin> getPlugins(){
        ArrayList<Plugin> pluginsList = new ArrayList<>();
        File pluginDir = new File("./src/main/Plugins");
        File[] jars = pluginDir.listFiles(file -> file.isFile() && file.getName().endsWith(".jar"));

        for (File jar : jars) {
            try {
                URL jarURL = jar.toURI().toURL();
                URLClassLoader classLoader = new URLClassLoader(new  URL[] {jarURL});
                JarFile jarFile = new JarFile(jar);
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()){
                    String className = entries.nextElement().getName();
                    if(!className.endsWith(".class")) continue;
                    className = className.replaceAll("/", ".");
                    className = className.replaceAll(".class", "");

                    Class<?> plugCan = classLoader.loadClass(className);
                    Class<?>[] interfaces = plugCan.getInterfaces();
                    for(Class interf: interfaces){
                        if(interf.getName().endsWith(".Plugin")){
                            Class cl = classLoader.loadClass(plugCan.getName());
                            Object inst = cl.newInstance();
                            pluginsList.add((Plugin) inst);
                        }
                    }
                }
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
        return pluginsList;
    }

}
