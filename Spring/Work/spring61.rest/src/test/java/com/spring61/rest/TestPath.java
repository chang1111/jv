package com.spring61.rest;

import org.junit.*;

import java.io.File;

import java.io.IOException;
import java.net.*;

import org.junit.runners.MethodSorters;

//Sorts by method name
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPath {
    
    @Test
    public void testGetClassPath ( ) {

        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
            System.out.println(url.getFile());
        }
    }

    @Test
    public void testGetClassPath2( ) {

        String classpath = System.getProperty("java.class.path");
        String[] classpathEntries = classpath.split(File.pathSeparator);

        for(String url: classpathEntries){
            System.out.println( url );
        }
    }

    @Test
    public void testGetResourcePath( ) throws IOException {

        File inputXmlFile = new File(this.getClass().getResource("Configuration.xml").getFile());
        System.out.println(inputXmlFile.getAbsolutePath());

        ClassLoader classLoader = getClass().getClassLoader();
        String str = classLoader.getResource("java26/springboard/Configuration.xml").getFile();
        System.out.println( str );
    }        
}
