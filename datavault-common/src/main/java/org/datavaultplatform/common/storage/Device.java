package org.datavaultplatform.common.storage;

import org.datavaultplatform.common.model.FileInfo;
import org.datavaultplatform.common.io.Progress;
import java.util.List;
import java.util.Map;
import java.io.File;

// A generic storage Device/system

public abstract class Device {
    
    // Some public information about a device or storage system
    public String name;
    
    // Some private configuration properties
    protected Map<String,String> config;
    
    public Device(String name, Map<String,String> config) {
        this.name = name;
        this.config = config;
    }
    
    // List objects available under a given path
    public abstract List<FileInfo> list(String path);
    
    // Check if the passed path or resource key is allowed
    public abstract boolean valid(String path);
    
    // Check if an object exists at the specified path
    public abstract boolean exists(String path) throws Exception;
    
    // Get the size of an object (file/dir) in bytes
    public abstract long getSize(String path) throws Exception;
    
    // Get the name of an object
    public abstract String getName(String path) throws Exception;
    
    // Check if the passed path is a directory/container
    public abstract boolean isDirectory(String path) throws Exception;
    
    // How much space is available for storage (in bytes)
    public abstract long getUsableSpace() throws Exception;
    
    // Copy an object (file/dir) to the working space
    // Progress information should be updated for monitoring as the copy occurs
    public abstract void copyToWorkingSpace(String path, File working, Progress progress) throws Exception;
    
    // Copy an object (file/dir) from the working space
    // Progress information should be updated for monitoring as the copy occurs
    public abstract void copyFromWorkingSpace(String path, File working, Progress progress) throws Exception;
}
