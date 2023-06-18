package com.music.music_util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class MusicUtil {
    private MusicUtil() {
    }

    public static File convertMultipartFileToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
        multipart.transferTo(convFile);
        return convFile;
    }
}
