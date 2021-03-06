package com.opensymphony.xwork2;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;

/**
 * Basic interface to access file on the File System and to monitor changes
 */
public interface FileManager {

    void setReloadingConfigs(boolean reloadingConfigs);

    boolean isReloadingConfigs();

    /**
     * Checks if given file changed and must be reloaded if {@link #isReloadingConfigs()} is true
     *
     * @param fileName to check
     * @return true if file changed
     */
    boolean fileNeedsReloading(String fileName);

    /**
     * Checks if file represented by provided URL should be reloaded
     *
     * @param fileUrl url to a file
     * @return true if file exists and should be reloaded, if url is null return false
     */
    boolean fileNeedsReloading(URL fileUrl);

    /**
     * Loads opens the named file and returns the InputStream
     *
     * @param fileUrl - the URL of the file to open
     * @return an InputStream of the file contents or null
     * @throws IllegalArgumentException if there is no file with the given file name
     */
    InputStream loadFile(URL fileUrl);

    /**
     * Adds file to list of monitored files if {@link #isReloadingConfigs()} is true
     *
     * @param fileUrl {@link URL} to file to be monitored
     */
    void monitorFile(URL fileUrl);

    /**
     * Convert URLs to URLs with "file" protocol
     * @param url URL to convert to a jar url
     * @return a URL to a file, or null if the URL external form cannot be parsed
     */
    URL normalizeToFileProtocol(URL url);

    /**
     * Indicate if given implementation supports current OS File System
     *
     * @return true if supports current OS File System
     */
    boolean support();

    Collection<? extends URL> getAllPhysicalUrls(URL url) throws IOException;
}
